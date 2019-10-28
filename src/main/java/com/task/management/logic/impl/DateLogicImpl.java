package com.task.management.logic.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.task.management.logic.DateLogic;

@Service
public class DateLogicImpl implements DateLogic {

	@Override
	public Date getPeriodeDate(String dateYear, String dateMonth, String dateDay) {
		Date periodeDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			periodeDate = sdf.parse(dateYear + "/" + dateMonth + "/" + dateDay + " 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return periodeDate;
	}

	@Override
	public Date getToday() {
		Date today = new Date();
		return today;
	}

}
