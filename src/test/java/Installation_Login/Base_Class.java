package Installation_Login;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class Base_Class {
	AndroidDriver<AndroidElement> driver;
	
	@org.testng.annotations.BeforeSuite
	public void BeforeSuite() {
			System.out.println("Before Suite");
	}
	
	@org.testng.annotations.BeforeClass
	public  AndroidDriver<AndroidElement> BeforeClass() throws Throwable {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME , "Android Emulator");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<AndroidElement>(url,dc);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		System.out.println("Before class");
		return driver;
	}
	
	@AfterClass
	public void AfterClass() {
		((AndroidDriver) driver).navigate().back();
		System.out.println("AfterClass");
	}
	
	@org.testng.annotations.AfterSuite
	public void AfterSuite() {
		//driver.quit();
		System.out.println("After suite");
	}
	
	
}
