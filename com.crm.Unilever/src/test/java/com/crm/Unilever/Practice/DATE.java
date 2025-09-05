package com.crm.Unilever.Practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DATE {
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date d = cal.getTime();
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY hh-mm-ss");
		String value = sdf.format(d);
		System.out.println(value);
	}

}
