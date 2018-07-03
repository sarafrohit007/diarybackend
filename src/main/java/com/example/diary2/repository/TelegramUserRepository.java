package com.example.diary2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diary2.model.TelegramUser;

public interface TelegramUserRepository extends JpaRepository<TelegramUser, Integer>,TelegramUserRepositoryCustom {

	
}
