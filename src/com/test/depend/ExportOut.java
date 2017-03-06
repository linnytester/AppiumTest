package com.test.depend;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The expected results and encapsulate the output results
 */
public class ExportOut {	
	public static void output(String name){
		System.out.println(getCurrentDateTime() + " output result£º " + name);		
	}
	
	public static void expect(String Name){
		System.out.println(getCurrentDateTime() + " expect result£º " + Name);	
	}
	
  	 private static String getCurrentDateTime(){
  	   SimpleDateFormat df = new SimpleDateFormat("yyyy_MMdd_HHmmss");//Set the date format
  	   return df.format(new Date());
  	}
}
