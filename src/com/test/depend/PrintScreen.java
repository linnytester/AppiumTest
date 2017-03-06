package com.test.depend;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * The screenshots encapsulate operation
 * The output of the enclosing class
 */
public class PrintScreen extends ExportOut{

	private static String report = "D:\\AppiumScreen\\";


  	public static void TakeScreen(AndroidDriver<WebElement> driver,String Name){
  		screen(driver, report+getCurrentDateTime()+Name+".jpg");
  		output("Screenshot of success");
  	} 	
  	
	private static void screen(AndroidDriver<WebElement> driver,String fileName){
//	System.out.println(fileName);
	
   	 File file = null;
   	try {
		file = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(fileName));
	} catch (Exception e) {
		e.printStackTrace();
	}	
	}
	
	
   	 private static String getCurrentDateTime(){
    	   SimpleDateFormat df = new SimpleDateFormat("yyyy_MMdd_HHmmss");//Set the date format
    	   return df.format(new Date());
    	}
} 
