package com.crm.Unilever.GenericLibrary;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getrandom(int num) {
		Random r=new Random();
		int random = r.nextInt(num);
		return random;
	}

	
	public String getDateAndTime() {
		Calendar cal = Calendar.getInstance();
		Date d = cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY hh-mm-ss");
		String value = sdf.format(d);
		return value;
	}
}
