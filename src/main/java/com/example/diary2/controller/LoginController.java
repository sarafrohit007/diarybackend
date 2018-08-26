package com.example.diary2.controller;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.http.entity.mime.FormBodyPart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;
import org.telegram.telegrambots.generics.WebhookBot;

import com.example.diary2.dto.request.CommentRequest;
import com.example.diary2.dto.request.DiaryEntryRequest;
import com.example.diary2.dto.request.FollowRequest;
import com.example.diary2.dto.request.HomePageRequest;
import com.example.diary2.dto.request.LoginRequest;
import com.example.diary2.dto.response.CommentResponse;
import com.example.diary2.dto.response.DiaryEntryResponse;
import com.example.diary2.dto.response.FileUploadResponse;
import com.example.diary2.dto.response.FollowResponse;
import com.example.diary2.dto.response.HomePageResponse;
import com.example.diary2.dto.response.LoginResponse;
import com.example.diary2.dto.response.MainPageResponse;
import com.example.diary2.service.CommentService;
import com.example.diary2.service.DiaryEntryService;
import com.example.diary2.service.FollowService;
import com.example.diary2.service.HomePageService;
import com.example.diary2.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
/*import com.pengrad.telegrambot.model.Update;*/
//import com.pengrad.telegrambot.model.Update;

@Controller
@RequestMapping("/api")
public class LoginController {

	public static final ObjectMapper mapper = new ObjectMapper();
	
	private static ConcurrentHashMap<String, WebhookBot> callbacks = new ConcurrentHashMap<>();
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	FollowService followService;
	
	@Autowired
	DiaryEntryService diaryEntryService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	HomePageService homePageService;
	
	
	
	public void registerCallback(WebhookBot callback, String tokenValue) {
		if (!callbacks.containsKey(callback.getBotPath())) {
			callbacks.put(tokenValue, callback);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<LoginResponse> createNewScheme(@Valid @RequestBody LoginRequest request) {
		return ResponseEntity.ok().body(loginService.loginRequest(request));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/homeContent")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<MainPageResponse> getLoginContent() {
		return ResponseEntity.ok().body(homePageService.getHomeContent());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/follow")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<FollowResponse> followUser(@Valid @RequestBody FollowRequest request) {
		return ResponseEntity.ok().body(followService.followRequest(request));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/submitDiary")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<DiaryEntryResponse> submitDiary(@Valid @RequestBody DiaryEntryRequest request) {
		return ResponseEntity.ok().body(diaryEntryService.submitEntry(request));
		//return null;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/submitComment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<CommentResponse> submitComment(@Valid @RequestBody CommentRequest request) {
		return ResponseEntity.ok().body(commentService.submitComment(request));
		//return null;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/home")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<HomePageResponse> getHomePage(@Valid @RequestBody HomePageRequest request) {
		return ResponseEntity.ok().body(homePageService.getHomeComment(request));
		//return null;
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/uploadContentFile")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<FileUploadResponse> uploadContentfile(@RequestParam("File") MultipartFile[] files){
		//for(BodyPart bodyPart: body.getPa)
		FileUploadResponse fileUploadResponse = new FileUploadResponse();
		if(files.length>0) {
			fileUploadResponse.setTotalNumberOfFiles(files.length);
			fileUploadResponse = diaryEntryService.uploadContentFiles(files);
		}else {
			fileUploadResponse.setTotalNumberOfFiles(0);
			fileUploadResponse.setNumberOfFilesUpload(0);
		}
		return ResponseEntity.ok().body(fileUploadResponse);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/uploadCommentFile")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<FileUploadResponse> uploadCommentfile(@RequestParam("File") MultipartFile[] files){
		//for(BodyPart bodyPart: body.getPa)
		FileUploadResponse fileUploadResponse = new FileUploadResponse();
		if(files.length>0) {
			fileUploadResponse.setTotalNumberOfFiles(files.length);
			//fileUploadResponse = diaryEntryService.uploadContentFiles(files);
			fileUploadResponse = commentService.uploadCommentFiles(files);
		}else {
			fileUploadResponse.setTotalNumberOfFiles(0);
			fileUploadResponse.setNumberOfFilesUpload(0);
		}
		return ResponseEntity.ok().body(fileUploadResponse);
	}
	
	/*@RequestMapping(method = RequestMethod.POST, value = "/telegram")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<LoginResponse> telegramBot(@Valid @RequestBody LoginRequest request) {
		System.out.println("Creating Telegram bot Api");
		return ResponseEntity.ok().body(loginService.loginRequest(request));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/telegramcert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<LoginResponse> telegramHttps(Update request) {
		System.out.println("Creating Telegram bot Api");
		System.out.println("Printing Update Object "+request.toString());
		System.out.println("Printing message "+ request.getMessage().getText());
		System.out.println("Printing UpdateObject "+ request.getUpdateId() + request.getCallbackQuery()+ request.getChannelPost()+request.getEditedMessage());
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String testingHTTPSCall() {
		return "Hello User"+" "+new Date();
	}*/
	
}
