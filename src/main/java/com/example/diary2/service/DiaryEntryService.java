package com.example.diary2.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.diary2.dto.request.DiaryContent;
import com.example.diary2.dto.request.DiaryEntryRequest;
import com.example.diary2.dto.response.DiaryEntryResponse;
import com.example.diary2.dto.response.FileUploadResponse;
import com.example.diary2.model.ContentInfo;
import com.example.diary2.model.DiaryEntry;
import com.example.diary2.model.UserInfo;
import com.example.diary2.repository.ContenetInfoRepository;
import com.example.diary2.repository.DiaryEntryRepository;
import com.example.diary2.repository.UserInfoRepository;
import com.example.diary2.util.ApplicationConstants;

@Service
public class DiaryEntryService {
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	ContenetInfoRepository contentInfoRepository;
	
	@Autowired
	DiaryEntryRepository diaryEntryReository;
	
	@PersistenceContext 
	EntityManager em;

	public DiaryEntryResponse submitEntry(DiaryEntryRequest request) {
		// TODO Auto-generated method stub
		String email = request.getEmail();
		DiaryEntryResponse diaryEntryResponse = new DiaryEntryResponse();
		UserInfo user = userInfoRepository.getUserInfoByEmailId(email);
		if(user!=null) {
			try {
				ContentInfo  content = null;
				DiaryEntry diaryEntry = new DiaryEntry();
				diaryEntry.setPostTime(new Date());
				diaryEntry.setNumberOfLikes(ApplicationConstants.INITIAL_LIKES_COUNT);
				diaryEntry.setNumberOfComments(ApplicationConstants.INITIAL_COMMENTS_COUNT);
				diaryEntry.setUser(user);
				if(request.getFileUploadId() == ApplicationConstants.FILE_FAILURE_UPLOAD_STATUS) {
					content = makeContent(request.getDiaryContent());
					diaryEntry.setContent(content);
				}else {
					content = contentInfoRepository.getContentInfoById(request.getFileUploadId());
					content.setContent(request.getDiaryContent()!=null?request.getDiaryContent().getContent()!=null?request.getDiaryContent().getContent():"":"");
				}
				content.setUploadStatus(ApplicationConstants.CONTENT_UPLOAD_STATUS_COMPLETE);
				em.persist(content);
				em.persist(diaryEntry);
				diaryEntryResponse.setResponse(true);
				diaryEntryResponse.setStatus(ApplicationConstants.DIARY_ENTRY_SUCCESS_RESPONSE);
			}catch(Exception e) {
				e.printStackTrace();
				diaryEntryResponse.setResponse(false);
				diaryEntryResponse.setStatus(ApplicationConstants.DIARY_ENTRY_FAILURE_RESPONSE);
			}
		}else {
			diaryEntryResponse.setResponse(false);
			diaryEntryResponse.setStatus(ApplicationConstants.USER_NOT_ALLOWED_TO_WRITE_DIARY);
		}
		return diaryEntryResponse;
	}

	private ContentInfo makeContent(DiaryContent diaryContent) {
		// TODO Auto-generated method stub
		ContentInfo contentObject = new ContentInfo();
		contentObject.setContent(diaryContent.getContent());
		return contentObject;
	}

	public FileUploadResponse uploadContentFiles(MultipartFile[] files) {
		// TODO Auto-generated method stub
		FileUploadResponse fileUploadResponse = new FileUploadResponse();
		int totalNumberOfFileUploaded = 0;
		//DiaryEntry diaryEntry = new DiaryEntry();
		ContentInfo contentInfo = null;
		Set<String> fileInload = new HashSet<String>();
		fileUploadResponse.setTotalNumberOfFiles(files.length);
			for(int i =0;i<files.length;i++) {
				try {
					if(!files[i].isEmpty()) {
						byte[] bytes = files[i].getBytes();
						File storedFile = new File("/home/rohitsaraf/Downloads/fileuploadexample/"+files[i].getOriginalFilename()); // Add time constraint to identify uniqueness
						BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(storedFile));
						stream.write(bytes);
						stream.close();
						fileInload.add(storedFile.getAbsolutePath());
						totalNumberOfFileUploaded++;
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		if(fileInload.size()>0) {
			contentInfo = makeContentEntryInDatabase(fileInload);
			if(contentInfo==null) {
				fileUploadResponse.setContentUploadId(-1);
				fileUploadResponse.setNumberOfFilesUpload(0);
			}else {
				try {
					em.persist(contentInfo);
				}catch(Exception e) {
					e.printStackTrace();
					fileUploadResponse.setContentUploadId(-1);
					fileUploadResponse.setNumberOfFilesUpload(0);
					return fileUploadResponse;
				}
				fileUploadResponse.setContentUploadId(contentInfo.getId());
				fileUploadResponse.setNumberOfFilesUpload(totalNumberOfFileUploaded);
			}
		}
		return fileUploadResponse;
	}

	private ContentInfo makeContentEntryInDatabase(Set<String> fileInload) {
		// TODO Auto-generated method stub
		try {
			ContentInfo contentInfo = new ContentInfo();
			contentInfo.setImageUrls(fileInload);
			contentInfo.setUploadStatus(ApplicationConstants.CONTENT_UPLOAD_STATUS_INCOMPLETE);
			return contentInfo;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
