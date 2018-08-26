package com.example.diary2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diary2.model.CommentEntry;

public interface CommentEntryRepository extends JpaRepository<CommentEntry, Integer>,CommentEntryRepositoryCustom{

}
