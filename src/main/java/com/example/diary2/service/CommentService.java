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

import com.example.diary2.dto.request.CommentRequest;
import com.example.diary2.dto.response.CommentResponse;
import com.example.diary2.dto.response.FileUploadResponse;
import com.example.diary2.model.CommentInfo;
import com.example.diary2.model.UserInfo;
import com.example.diary2.repository.UserInfoRepository;
import com.example.diary2.util.ApplicationConstants;

@Service
public class CommentService {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Transactional
	public CommentResponse submitComment(CommentRequest request) {
		// TODO Auto-generated method stub
		CommentResponse commentResponse = new CommentResponse();
		String email = request.getEmailId();
		UserInfo user = userInfoRepository.getUserInfoByEmailId(email);
		if(user!=null) {
			CommentInfo commentInfo = new CommentInfo();
			
		}else {
			commentResponse.setResponse(false);
			commentResponse.setStatus(ApplicationConstants.USER_NOT_ALLOWED_TO_WRITE_COMMENT);
		}
		
//		String comment =  request.getComment();
//		String result = EmojiParser.parseToUnicode(comment);
//		System.out.println("Printing Result "+ result);
		return null;
	}
	
	


	public FileUploadResponse uploadCommentFiles(MultipartFile[] files) {
		// TODO Auto-generated method stub
		FileUploadResponse fileUploadResponse = new FileUploadResponse();
		int totalNumberOfFilesUpload= 0;
		CommentInfo  commentInfo = null;
		Set<String> fileUpload =  new HashSet<String>();
		fileUploadResponse.setTotalNumberOfFiles(files!=null?files.length:0);
		for(int i =0;i<files.length;i++) {
			try {
				if(!files[i].isEmpty()) {
					byte[] bytes =  files[i].getBytes();
					String fileName = files[i].getOriginalFilename().trim().replaceAll(" ", "");
					int  index = fileName.lastIndexOf(".");
					String timeString = getTimeInString();
					File storedFile = new File("/home/rohitsaraf/Downloads/fileuploadexample/"+fileName.substring(0, index)+"_"+timeString+"."+fileName.substring(index+1,fileName.length())); // Add time constraint to identify uniqueness
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(storedFile));
					stream.write(bytes);
					stream.close();
					fileUpload.add(storedFile.getAbsolutePath());
					totalNumberOfFilesUpload++;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(fileUpload.size()>0) {
			commentInfo =  makeCommentEntryInDatabase(fileUpload);
			if(commentInfo==null) {
				fileUploadResponse.setContentUploadId(-1);
				fileUploadResponse.setNumberOfFilesUpload(0);
			}else {
				try {
					insertIntoDatabase(commentInfo);
				}catch(Exception e) {
					e.printStackTrace();
					fileUploadResponse.setContentUploadId(-1);
					fileUploadResponse.setNumberOfFilesUpload(0);
				}
				fileUploadResponse.setContentUploadId(commentInfo.getId());
				fileUploadResponse.setNumberOfFilesUpload(totalNumberOfFilesUpload);
			}
		}else {
			fileUploadResponse.setContentUploadId(-1);
			fileUploadResponse.setNumberOfFilesUpload(0);
		}
		return fileUploadResponse;
	}


	private void insertIntoDatabase(CommentInfo commentInfo) {
		// TODO Auto-generated method stub
		em.persist(commentInfo);
	}


	private CommentInfo makeCommentEntryInDatabase(Set<String> fileUpload) {
		// TODO Auto-generated method stub
		CommentInfo commentInfo = new CommentInfo();
		try {
			commentInfo.setImageurls(fileUpload);
			commentInfo.setUploadStatus(ApplicationConstants.COMMENT_UPLOAD_STATUS_INCOMPLETE);
			return commentInfo;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
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
	
}
