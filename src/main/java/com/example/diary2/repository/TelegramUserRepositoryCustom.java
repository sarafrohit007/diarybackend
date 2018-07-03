package com.example.diary2.repository;

import com.example.diary2.model.TelegramUser;

public interface TelegramUserRepositoryCustom  {

		public TelegramUser getTelegramUserByNumber(Long chatId);
		
		public TelegramUser getTelegramUserByChatId(Long chatId);
}
