package com.example.diary2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diary2.model.CommentInfo;

public interface CommentInfoRepository extends JpaRepository<CommentInfo,Integer>,CommentInfoRepositoryCustom{

}
