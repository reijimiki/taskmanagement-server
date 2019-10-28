package com.task.management.logic;

import java.util.Date;

public interface DateLogic {
	Date getPeriodeDate(String dateYear, String dateMonth, String dateDay);
	Date getToday();
}
