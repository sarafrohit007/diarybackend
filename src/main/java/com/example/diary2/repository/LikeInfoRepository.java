package com.example.diary2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.diary2.model.LikeInfo;

@Repository
public interface LikeInfoRepository extends JpaRepository<LikeInfo,Integer>,LikeInfoRepositoryCustom{

}
