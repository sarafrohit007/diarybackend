package com.example.diary2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.diary2.model.UserFollowingInformation;

@Repository
public interface UserFollowingInformationRepository extends JpaRepository<UserFollowingInformation,Integer>,UserFollowingInformationRepositoryCustom{

}
