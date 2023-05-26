package com.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class login {
	AndroidDriver<AndroidElement> driver;
	public login(AndroidDriver<AndroidElement> rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//Locating VoicesofMPN® -Q
	@FindBy(xpath = "//android.widget.TextView[@text = 'VoicesofMPN® -Q']")
	 public WebElement MPNApp;
	
	//Locating Skip button
	@FindBy(id = "com.incyte.ent.qa:id/textSkip")
	 public WebElement textSkip2;
	
	//Locating login button 
	@FindBy(id = "com.incyte.ent.qa:id/btLogIn")
	 public  WebElement btLogIn;
	
	//Enter Email adress
	@FindBy(id = "com.incyte.ent.qa:id/etEmailAddress")
	 public WebElement etEmailAddress;
	
	public void etEmailAddress() {
		etEmailAddress.sendKeys("pkalal+q269@alopasoft.com");
	}
	
	public  void ScrollUp() {
		TouchAction action = new TouchAction(driver);
		int startY = (int) (driver.manage().window().getSize().height * 0.8);
		int endY = (int) (driver.manage().window().getSize().height * 0.2);
		int startX = driver.manage().window().getSize().width / 2;
		action.press(PointOption.point(startX, startY))
		      .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		      .moveTo(PointOption.point(startX, endY))
		      .release()
		      .perform();
	}
	
	@FindBy(id = "com.incyte.ent.qa:id/textSkip")
	 public WebElement textSkip;
	
	public void textSkipbtn() {
		textSkip.click();
	}
	 
	@FindBy(id = "com.incyte.ent.qa:id/btnLogin")
	 public  WebElement btnLogin;
	
	public void loginbtn() {
		btnLogin.click();
	}
	 
	@FindBy(id = "com.incyte.ent.qa:id/etLoginPin")
	 public  WebElement etLoginPin;
	
	public void etLoginPin() {
		etLoginPin.sendKeys("0000");
	}
	
	@FindBy(id = "com.incyte.ent.qa:id/fabTrack")
	 public  WebElement fabTrack;
	
	@FindBy(id = "com.incyte.ent.qa:id/tvSymptoms")
	 public  WebElement tvSymptoms;
	
	@FindBy(id = "com.incyte.ent.qa:id/confirm_button")
	 public  WebElement confirm_button;
	
	//Selecting on symptom name check box 
	@FindBy(className = "android.widget.CheckBox")
	 public List<WebElement> CheckBox;
	
	//Locatiting Synptom names 
	@FindBy(xpath = "//android.widget.CheckBox/../android.widget.TextView")
	public  List<WebElement> SelectCheckTextlist;
	
	//Click On Next button 
	@FindBy(id = "com.incyte.ent.qa:id/btnNext")
	 public  WebElement btnNext;
	
	//Continue to activities button 
	@FindBy(id = "com.incyte.ent.qa:id/btnContinueToActivities")
	 public  WebElement btnContinueToActivities;
	
	//Close button on symptom summary page 
	@FindBy(className = "android.widget.ImageButton")
	 public WebElement closeButton;
	
	//Home button 
	@FindBy(id = "com.incyte.ent.qa:id/btHome")
	 public  WebElement btHome;

	//Symtom summary page
	
	//selecting symptom name 
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.incyte.ent.qa:id/tvSymptomName']")
	public  List<WebElement> tvSymptomName;
	
	//Selecting severity name 
	@FindBy(className = "android.widget.Button")
	 public List<WebElement> severity_name;
	
	//No activity Selected 
	@FindBy(id = "com.incyte.ent.qa:id/tvNoActivitiesAvailable")
	 public  WebElement tvNoActivitiesAvailable;
	
	//Activity Name 
	@FindBy(id = "com.incyte.ent.qa:id/tvActivityName")
	 public  List<WebElement> tvActivityName;
	
	//Submit button 
	@FindBy(id = "com.incyte.ent.qa:id/tvSaveSymptom")
	 public  WebElement tvSaveSymptom;
	
	//History button 
	@FindBy(id = "com.incyte.ent.qa:id/btHistory")
	 public  WebElement btHistory;
	
	//First symptom from the list 
	@FindBy(xpath = "//android.widget.ImageView/..")
	public  List<WebElement> Symptoms_Tracked;
	
	//Alternane path for the above since stale poin exception 
	@FindBy(xpath = "(//android.widget.ImageView/..)[1]")
	public  WebElement Symptoms_Tracked1;
	
	//Edit symptoms on edit symptom page 
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.incyte.ent.qa:id/ivEditSymptoms']")
	 public  WebElement ivEditSymptoms;
	
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.incyte.ent.qa:id/ivEditActivities']")
	 public  WebElement ivEditActivities;
	
	//Selected Check Box 
	@FindBy(xpath = "//android.widget.CheckBox[@checked='true']")
	public  List<WebElement> SelectedCheckBox;
	
	//Delete Button 
	@FindBy(id = "com.incyte.ent.qa:id/btnDeleteSymptom")
	 public  WebElement btnDeleteSymptom;
	
	//Confirm delete button 
	@FindBy(id = "android:id/button1")
	 public  WebElement button1;
	
	//AFB got it button 
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.incyte.ent.qa:id/tvGotItAFB']")
	public  WebElement tvGotItAFB;

}
