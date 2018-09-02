package com.example.diary2.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static Integer getYearFromDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Integer year = cal.get(Calendar.YEAR);
		return year;
	}
	
	public static String getDiaryEntryDateInString(Date date) {
		DateFormat df = new SimpleDateFormat("dd MMMM,yyyy");
		String result = df.format(date);
		return result;
	}

	public static Date getStatrtDateOfTheYear(Integer year) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,0);
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		return cal.getTime();
	}

	public static Date getEndDateOfTheYear(Integer year) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,11);
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY,23);
		cal.set(Calendar.MINUTE,59);
		cal.set(Calendar.SECOND,59);
		cal.set(Calendar.MILLISECOND,999);
		return cal.getTime();
	}

}
