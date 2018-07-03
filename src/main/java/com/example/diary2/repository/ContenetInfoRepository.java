package com.example.diary2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.diary2.model.ContentInfo;

@Repository
public interface ContenetInfoRepository extends JpaRepository<ContentInfo, Integer>,ContentInfoRepositoryCustom{

}
