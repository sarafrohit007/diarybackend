package com.example.diary2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary2.impl.TelegramUserRepositoryImpl;
import com.example.diary2.model.TelegramUser;

@Service
public class TelegramService {
	
	@Autowired
	TelegramUserRepositoryImpl telegramUserRepositoryImpl;
	
/*	TelegramUserRepositoryImpl telegramUserRepositoryImpl = new TelegramUserRepositoryImpl();*/
	
	public TelegramUser getTelegramUserByNumber(Long mobileNumber) {
		return telegramUserRepositoryImpl.getTelegramUserByNumber(mobileNumber);
	} 
	
	public TelegramUser getTelegramUserByChatId(Long chatId) {
		return telegramUserRepositoryImpl.getTelegramUserByChatId(chatId);
	}
	
}
