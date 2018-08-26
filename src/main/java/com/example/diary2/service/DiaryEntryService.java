package com.example.diary2.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	@Transactional
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
				diaryEntry.setCommentInfoList(null);
				diaryEntry.setLikeInfoList(null);
				diaryEntry.setUser(user);
				if(request.getFileUploadId() == ApplicationConstants.FILE_FAILURE_UPLOAD_STATUS) {
					content = new ContentInfo();
					String contentInString = request.getDiaryContent().getContent();
					byte b[] = contentInString!=null&&!contentInString.equals("")?contentInString.getBytes():null;
					content.setContentInBytes(b);
					diaryEntry.setContent(content);
				}else {
					content = contentInfoRepository.getContentInfoById(request.getFileUploadId());
					if(content==null) {
						diaryEntryResponse.setResponse(false);
						diaryEntryResponse.setStatus(ApplicationConstants.DIARY_ENTRY_FAILURE_RESPONSE);
						return diaryEntryResponse;
					}
					String contentInString = request.getDiaryContent().getContent();
					byte b[] = contentInString!=null&&!contentInString.equals("")?contentInString.getBytes():null;
					content.setContentInBytes(b);
					diaryEntry.setContent(content);
				}
				content.setUploadStatus(ApplicationConstants.CONTENT_UPLOAD_STATUS_COMPLETE);
				em.persist(content);
				//user.setNumberOfPosts(user.getNumberOfPosts()+1);
				em.persist(diaryEntry);
				Set<DiaryEntry> diaryEntrySet = user.getDiaryEntryList();
				if(diaryEntrySet==null) {
					diaryEntrySet = new HashSet<DiaryEntry>();
					diaryEntrySet.add(diaryEntry);
				}else {
					diaryEntrySet.add(diaryEntry);
				}
				user.setDiaryEntryList(diaryEntrySet);
				em.persist(user);
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

	@Transactional
	public FileUploadResponse uploadContentFiles(MultipartFile[] files) {
		// TODO Auto-generated method stub
		FileUploadResponse fileUploadResponse = new FileUploadResponse();
		int totalNumberOfFileUploaded = 0;
		ContentInfo contentInfo = null;
		Set<String> fileInload = new HashSet<String>();
		fileUploadResponse.setTotalNumberOfFiles(files.length);
			for(int i =0;i<files.length;i++) {
				try {
					if(!files[i].isEmpty()) {
						byte[] bytes = files[i].getBytes();
						String fileName = files[i].getOriginalFilename().trim().replaceAll(" ", "");
						int  index = fileName.lastIndexOf(".");
						String timeString = getTimeInString();
						File storedFile = new File("/home/rohitsaraf/Downloads/fileuploadexample/"+fileName.substring(0, index)+"_"+timeString+"."+fileName.substring(index+1,fileName.length())); // Add time constraint to identify uniqueness
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
					insertInDatabase(contentInfo);
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

	@Transactional
	public void insertInDatabase(ContentInfo contentInfo) {
		em.persist(contentInfo);
	}

	private String getTimeInString() {
		// TODO Auto-generated method stub
		
		String time = "";
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
		time = df.format(date);
		return time;
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
