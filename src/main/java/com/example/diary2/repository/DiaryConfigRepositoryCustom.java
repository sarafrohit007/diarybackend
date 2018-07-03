package com.example.diary2.repository;

import org.springframework.stereotype.Repository;

import com.example.diary2.model.DiaryConfig;

@Repository
public interface DiaryConfigRepositoryCustom {
	
	public DiaryConfig getDiaryConfigById(Integer id);

}
