package com.test.opertion;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.depend.PrintScreen;

import io.appium.java_client.android.AndroidDriver;

public class MainTest extends PrintScreen{
/**
 *  decare variables
 */
	private AndroidDriver<WebElement> driver;
    private LoginTest login;
	
 /**
  * configuration
  */
	@BeforeTest
	public void setup(){
	    File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/apps");
        File app = new File(appDir, "iBiliPlayer-bili.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","127.0.0.1:6555");//Devices
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True"); 
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "tv.danmaku.bili");
        capabilities.setCapability("appActivity", "tv.danmaku.bili.ui.splash.SplashActivity");
			try {
				driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 	        
        expect("Install App");
        
        /**
         * The declaration of variables instantiation
         */
        login = new LoginTest(driver);
	}

/**
 * Perform the test case
 */
	@Test
	public void test(){
		login.test();
	}
	
/**
 * Finish
 */
	@AfterTest
	public void finish(){
//		driver.quit();
	}
}
