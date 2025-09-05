package com.crm.Unilever.Practice;

import java.util.Random;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Unilever.GenericLibrary.BaseClass;
import com.crm.Unilever.GenericLibrary.ListenerImplementation;
@Listeners(ListenerImplementation.class)
public class Demo  {

	@Test
	public void create() {
		Random r=new Random();
		int ran = r.nextInt(10);
		System.out.println(ran);
	}
	
}
