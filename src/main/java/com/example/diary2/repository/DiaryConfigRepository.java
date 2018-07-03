package com.example.diary2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.diary2.model.DiaryConfig;


@Repository
public interface DiaryConfigRepository extends JpaRepository<DiaryConfig, Integer>, DiaryConfigRepositoryCustom{

	//public UserInfo getUserInfoById(Integer id);
	
	
}
