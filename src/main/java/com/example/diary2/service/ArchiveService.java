package com.example.diary2.service;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary2.dto.request.ArchiveDiaryResult;
import com.example.diary2.dto.request.ArchiveRequest;
import com.example.diary2.dto.response.ArchiveResponse;
import com.example.diary2.dto.response.ArchiveResponseEntries;
import com.example.diary2.model.DiaryEntry;
import com.example.diary2.model.UserInfo;
import com.example.diary2.repository.DiaryEntryRepository;
import com.example.diary2.repository.UserInfoRepository;
import com.example.diary2.util.DateUtils;

@Service
public class ArchiveService {

	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	DiaryEntryRepository diaryEntryRepository;
	
	public ArchiveResponse loadArchiveEntry(ArchiveRequest request) {
		// TODO Auto-generated method stub
		System.out.println("Inside loadArchiveEntry Function....");
		ArchiveResponse archiveResponse = new ArchiveResponse();
		Calendar cal = Calendar.getInstance();
		try {
			String email = request.getEmailID();
			UserInfo user = userInfoRepository.getUserInfoByEmailId(email);
			if(user!=null) {
				Integer year = getJoiningYear(user);
				Integer currentYear = cal.get(Calendar.YEAR);
				List<ArchiveResponseEntries> archiveResponseEntryList = new ArrayList<ArchiveResponseEntries>();
				for(int i = year;i<=currentYear;i++) {
					try {
						List<DiaryEntry> diaryEntries = diaryEntryRepository.getArchieveDiaryEntriesByUser(user.getId(), year);
						ArchiveResponseEntries archiveResponseEntry = new ArchiveResponseEntries();
						archiveResponseEntry.setYear(year);
						List<ArchiveDiaryResult> diaryEntryList = parseDiaryEntries(diaryEntries);
						archiveResponseEntry.setDiaryEntryList(diaryEntryList);
						archiveResponseEntryList.add(archiveResponseEntry);
					}catch(Exception  e) {
						e.printStackTrace();
					}
				}
				archiveResponse.setArchiveEntries(archiveResponseEntryList);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return archiveResponse;
	}

	private List<ArchiveDiaryResult> parseDiaryEntries(List<DiaryEntry> diaryEntries) {
		// TODO Auto-generated method stub
		List<ArchiveDiaryResult> diaryResult = new ArrayList<ArchiveDiaryResult>();
		for(DiaryEntry diary : diaryEntries) {
			ArchiveDiaryResult diaryArchive = new ArchiveDiaryResult();
			String date = DateUtils.getDiaryEntryDateInString(diary.getPostTime());
			diaryArchive.setDate(date);
			try {
				diaryArchive.setContent(diary.getContent()!=null?diary.getContent().getContentInBytes()!=null?new String(diary.getContent().getContentInBytes(),"UTF-8"):"":"");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				diaryArchive.setContent("");
				e.printStackTrace();
			}
			diaryResult.add(diaryArchive);
		}
		return diaryResult;
	}

	private Integer getJoiningYear(UserInfo user) {
		// TODO Auto-generated method stub
		Date joiningDate = user.getCreationDate();
		Integer year = DateUtils.getYearFromDate(joiningDate);
		return year;
	}

	
}
