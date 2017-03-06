package com.test.opertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.depend.PrintScreen;

import io.appium.java_client.android.AndroidDriver;

public class LoginTest extends PrintScreen{
	private AndroidDriver<WebElement> driver;
	
	public LoginTest(AndroidDriver<WebElement> driver){
		this.driver = driver;
	}
	
	public void test() {
		try {
			expect("Determine whether have to log in");
			WebElement lg =  driver.findElementById("tv.danmaku.bili:id/nick_name");
			String s = lg.getText();
			output(s);
			TakeScreen(driver, "Home page");
			if ("未登录".equals(s) == true) {
				expect("Click on image to log in");
				driver.findElement(By.id("tv.danmaku.bili:id/navigation")).click();
				
				driver.findElementById("tv.danmaku.bili:id/user_nick_text").click();
				output("Open the login page");
				
				expect("Enter the user name and password");				
				try {
					WebElement username =  driver.findElementById("tv.danmaku.bili:id/username");
					username.click();
					username.clear();
					username.sendKeys("132********");
					username.click();
					
					WebElement pd = driver.findElementById("tv.danmaku.bili:id/userpwd");
					pd.click();
					pd.clear();
					pd.sendKeys("******");
					
					expect("Click login");
					driver.findElement(By.id("tv.danmaku.bili:id/btn_login")).click();
					
					WebElement ud = driver.findElementById("tv.danmaku.bili:id/user_nick_text");
					String nd = ud.getText();
					TakeScreen(driver, "Login to complete");
					if ("点击头像登录".equals(nd) == false) {
						output("Login success");
					}else {
					output("Login fail");
					}
					expect("Enter the personal home page");
					try {
						driver.findElementByXPath("//android.widget.RelativeLayout[@resource-id=\"tv.danmaku.bili:id/drawer_profile_layout\"]/android.widget.FrameLayout[1]/android.widget.ImageView[1]").click();
						TakeScreen(driver, "The personal home page");
						expect("Back homepage");
						driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"转到上一层级\"]").click();
						driver.tap(1, 600, 800, 800);
					} catch (Exception e) {
						output("Enter fail");
						TakeScreen(driver, "Enter fail");
					}
				} catch (Exception e) {
					output("Perform the login operation fails");
					TakeScreen(driver, "Perform the login operation fails");
				}
			}else {
				output("User is logged in");
			}
			
		} catch (Exception e) {
			output("Execute test cases failed");
			TakeScreen(driver, "Test cases fail");
		}
	}
}
