package com.PageObjects;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Blood_Count {

	Random random = new Random();
	AndroidDriver<AndroidElement> driver;
	public Blood_Count(AndroidDriver<AndroidElement> rdriver) {
		driver=rdriver;
		PageFactory.initElements(driver, this);
	}

	//Select Blood Count section 
	@FindBy(id = "com.incyte.ent.qa:id/tvBloodCount")
	 public  WebElement tvBloodCount;
	
	//Get MPN_Type
	@FindBy(id = "com.incyte.ent.qa:id/action_learn_profile")
	 public  WebElement action_learn_profile;
	//Locating profile icon on Account page 
	@FindBy(id = "com.incyte.ent.qa:id/tvProfile")
	 public  WebElement tvProfile;
	//Locating on MPN updateMpnTypeTextView
	@FindBy(id = "com.incyte.ent.qa:id/updateMpnTypeTextView")
	 public  WebElement updateMpnTypeTextView;
	
	//Click on close button on account page
	@FindBy(className = "android.widget.ImageButton")
	 public  WebElement closeAccountPage;
	//Fetching MPN type 
	public String getMpnType() {
		//Click on profile icon on home page 
		action_learn_profile.click();
		//click on Profile button 
		tvProfile.click();
		String MpnType = updateMpnTypeTextView.getText();
		((AndroidDriver) driver).navigate().back();
		closeAccountPage.click();
		return MpnType;
	}
	//Locating the Platelet Count text field
	@FindBy(xpath = "//android.widget.EditText[@text='Platelet Count']")
	 public  WebElement Platelet_Count;
	//Sending value to the Platelet Count text feild 
	public float AddValuePlatelet_Count() {
		//Clicking WBC_Leukocytes text feild 
		//Platelet_Count.click();
		//Adding value the Platelet Count text feild
	    int Platelet_Count2 = random.nextInt(1, 1000);
	    Platelet_Count.sendKeys("" + Platelet_Count2);
	    return Platelet_Count2;
	}
	
	//Locating the Hemoglobin text field
	@FindBy(xpath = "//android.widget.EditText[@text='Hemoglobin']")
	 public  WebElement Hemoglobin;
	//Sending value to the Hemoglobin text feild 
	public float AddValueHemoglobin() {
		//Clicking WBC_Leukocytes text feild 
		//Hemoglobin.click();
		//Adding value the WBC_Leukocytes text feild
		float Hemoglobin1 = random.nextFloat() * 34 + 1;  // Generate a random float between 1 and 35
	    float Hemoglobin2 = Float.parseFloat(String.format("%.2f", Hemoglobin1));
	    Hemoglobin.sendKeys("" + Hemoglobin2);
	    return Hemoglobin2;
	}
	
	//Locating the Hematocrit text field
		@FindBy(xpath = "//android.widget.EditText[@text='Hematocrit']")
		 public  WebElement Hematocrit;
		//Sending value to the Hematocrit text feild 
		public float AddValueHematocrit() {
			//Clicking Hematocrit text feild 
			//Hemoglobin.click();
			//Adding value the Hematocrit text feild
			float Hematocrit1 = random.nextFloat() * 64 + 10;  // Generate a random float between 1 and 75
		    float Hematocrit2 = Float.parseFloat(String.format("%.2f", Hematocrit1));
		    Hematocrit.sendKeys("" + Hematocrit2);
		    return Hematocrit2;
		}
		
		//Locating the WBC Leukocytes text field
		@FindBy(xpath = "//android.widget.EditText[@text='WBC Leukocytes']")
		public  WebElement WBC_Leukocytes;
		//Sending value to the WBC Leukocytes text feild 
		public float AddValueWBC_Leukocytes() {
		//Clicking WBC Leukocytes text feild 
		//WBC_Leukocytes.click();
		//Adding value the WBC Leukocytes text feild
		float WBC_Leukocytes1 = random.nextFloat() * 79 + 1;  // Generate a random float between 1 and 80
		float WBC_Leukocytes12 = Float.parseFloat(String.format("%.2f", WBC_Leukocytes1));
		WBC_Leukocytes.sendKeys("" + WBC_Leukocytes12);
		return WBC_Leukocytes12;
		}
		
	//Locating create button on new blood count page 
	@FindBy(id = "com.incyte.ent.qa:id/toolBarActionText")
	public  WebElement toolBarActionText;
	
	//EDIT BLOOD COUNT PAGE 
	
	//Locating First blood count text feild 
	@FindBy(id = "com.incyte.ent.qa:id/etFirst")
	 public  WebElement etFirst;
	//Locating Second blood count text feild 
	@FindBy(id = "com.incyte.ent.qa:id/etSecond")
	 public  WebElement etSecond;
	//Locating Third blood count text feild 
	@FindBy(id = "com.incyte.ent.qa:id/etThird")
	public  WebElement etThird;
	//Locating Fourth blood count text feild 
	@FindBy(id = "com.incyte.ent.qa:id/etFourth")
	public  WebElement etFourth;
	public void tryCatch(WebElement TRY) {
		try{
			System.out.println("Something");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//Delete Blood Count 
	//Locating delete blood count 
	@FindBy(id = "com.incyte.ent.qa:id/btnDeleteBloodCount")
	 public  WebElement btnDeleteBloodCount;
	

}
