package com.example.diary2.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary2.dto.request.CommentRequest;
import com.example.diary2.dto.response.CommentResponse;
import com.example.diary2.model.CommentInfo;
import com.vdurmont.emoji.EmojiParser;

@Service
public class CommentService {

	@PersistenceContext
	EntityManager em;
	

	public CommentResponse submitComment(CommentRequest request) {
		// TODO Auto-generated method stub
		String comment =  request.getComment();
		
		String result = EmojiParser.parseToUnicode(comment);
		System.out.println("Printing Result "+ result);
		return null;
	}
	
	
	
	
	
}
