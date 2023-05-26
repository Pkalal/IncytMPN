package Installation_Login;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.PageObjects.Blood_Count;
import com.PageObjects.login;



public class Test_TBloodCount extends Base_Class {
	String MPN_Type;
	String MPN;
	Random random = new Random();
	float Hemoglobin;
	float Hematocrit;
	float WBC_Leukocytes;
	float Platelet_Count;
	@Test(priority = 1)
	public void CreateBloodCount() throws Throwable {
		//extends Base_Class
		System.out.println("Test_bloodCount has started");
		login lp = new login(driver);
		Blood_Count bc = new Blood_Count(driver);
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'VoicesofMPN® -Q']")).click();
		lp.etLoginPin();
		lp.loginbtn();
		//Getting MPN type 
		MPN_Type = bc.getMpnType();
		System.out.println("MPN_Type : " + MPN_Type);
		//Click on Fab icon 
		lp.fabTrack.click();
		//Click on  blood Count section 
		bc.tvBloodCount.click();
		//Click on Date confirm page 
		lp.confirm_button.click();
		//Getting MPN type 
		MPN = "Myelofibrosis (MF)";
		if(MPN_Type.equals(MPN)) {
			//Entering the value between 1 to 35
			Hemoglobin = bc.AddValueHemoglobin();
			System.out.println("Hemoglobin : " + Hemoglobin);
			//Entering the value between 1 to 80
			Hematocrit = bc.AddValueHematocrit();
			System.out.println("Hematocrit : " + Hematocrit);
			//Entering the value between 1 to 1000
			WBC_Leukocytes = bc.AddValueWBC_Leukocytes();
			System.out.println("WBC_Leukocytes : " + WBC_Leukocytes);
			//Entering the value between 1 to 1000 
			Platelet_Count = bc.AddValuePlatelet_Count();
			System.out.println("Platelet_Count : " + Platelet_Count);
		}else {
			//Entering the value between 1 to 1000 
			Platelet_Count = bc.AddValuePlatelet_Count();
			System.out.println("Platelet_Count : " + Platelet_Count);
			//Entering the value between 1 to 1000
			WBC_Leukocytes = bc.AddValueWBC_Leukocytes();
			System.out.println("WBC_Leukocytes : " + WBC_Leukocytes);
			//Entering the value between 1 to 80
			Hematocrit = bc.AddValueHematocrit();
			System.out.println("Hematocrit : " + Hematocrit);
			
		}
		//Clicking on Create button on New blood count page 
		bc.toolBarActionText.click();
		Thread.sleep(2000);
		String AFB = driver.getPageSource();
		System.out.println(AFB);
		 if(AFB.contains("tvGotItAFB")) {
			 System.out.println("AFB is displayed");
			 lp.tvGotItAFB.click();
		 }else {
			 System.out.println("AFB message is not displayed");
		 }
		System.out.println("Test2_bloodCount has ended");
	}
	
	@Test(priority = 2)
	public void readBloodCount(){
		System.out.println("readBloodCount has started");
		login lp = new login(driver);
		Blood_Count bc = new Blood_Count(driver);
		//Click on history button 
		lp.btHistory.click();
		//Click on symptom record 
		lp.Symptoms_Tracked.get(0).click();
		//Reading based on the MPN type
		System.out.println("MPN_Type : " + MPN_Type);
		System.out.println("MPN : " + MPN);
		if(MPN_Type.equals(MPN)) {
			//Fethching hemoglibin value 
			float readHemoglobin = Float.parseFloat(bc.etFirst.getText());
			//Fethching the hemotocrit value 
			float readHematocrit = Float.parseFloat(bc.etSecond.getText());
			//Fethching the WBC_Leukocytes value 
			float readWBC_Leukocytes = Float.parseFloat(bc.etThird.getText());
			//Fethching the WBC_Leukocytes value 
			float readPlatelet_Count = Float.parseFloat(bc.etFourth.getText());
			System.out.println("readHemoglobin : " + readHemoglobin);
			System.out.println("readHematocrit : " + readHematocrit);
			System.out.println("WBC_Leukocytes : " + readWBC_Leukocytes);
			System.out.println("Platelet_Count : " + readPlatelet_Count);
			//Validating the values 
			if(Hemoglobin==readHemoglobin) {
				System.out.println("PASS : Hemoglobin ");
			}else {System.out.println("FAIL : Hemoglobin");}
			if(Hematocrit==readHematocrit) {
				System.out.println("PASS : Hematocrit ");
			}else {System.out.println("FAIL : Hematocrit");}
			if(WBC_Leukocytes==readWBC_Leukocytes) {
				System.out.println("PASS : WBC_Leukocytes ");
			}else {System.out.println("FAIL : WBC_Leukocytes");}
			if(Platelet_Count==readPlatelet_Count) {
				System.out.println("PASS : Platelet_Count ");
			}else {System.out.println("FAIL : readPlatelet_Count");}	
		}else {
			//Fethching the hemotocrit value 
			float readHematocrit = Float.parseFloat(bc.etFirst.getText());
			//Fethching the WBC_Leukocytes value 
			float readWBC_Leukocytes = Float.parseFloat(bc.etSecond.getText());
			//Fethching the WBC_Leukocytes value 
			float readPlatelet_Count = Float.parseFloat(bc.etThird.getText());
			//Validating the values 
			if(Hematocrit==readHematocrit) {
				System.out.println("PASS : Hematocrit ");
			}else {System.out.println("FAIL : Hematocrit");}
			if(WBC_Leukocytes==readWBC_Leukocytes) {
				System.out.println("PASS : WBC_Leukocytes ");
			}else {System.out.println("FAIL : WBC_Leukocytes");}
			if(Platelet_Count==readPlatelet_Count) {
				System.out.println("PASS : Platelet_Count ");
			}else {System.out.println("FAIL : readPlatelet_Count");}
		}
		//Clicking on close button 
		lp.closeButton.click();
		//Click on Home button
		lp.btHome.click();
		System.out.println("readBloodCount has ended");
	}
	
	@Test(priority = 3)
	public void updateBloodCount() throws Throwable {
		System.out.println("updateBloodCount has started");
		login lp = new login(driver);
		Blood_Count bc = new Blood_Count(driver);
		//Click on history button 
		lp.btHistory.click();
		//Click on symptom record 
		lp.Symptoms_Tracked.get(0).click();
		//Updating values in the text feilds 
		if(MPN_Type.equals(MPN)) {
			//Clearing the existing data in the text feild 
			bc.etFirst.clear();
			bc.etSecond.clear();
			bc.etThird.clear();
			bc.etFourth.clear();
			//Entering the value between 1 to 35
			Hemoglobin = bc.AddValueHemoglobin();
			System.out.println("Hemoglobin : " + Hemoglobin);
			//Entering the value between 1 to 80
			Hematocrit = bc.AddValueHematocrit();
			System.out.println("Hematocrit : " + Hematocrit);
			//Entering the value between 1 to 1000
			WBC_Leukocytes = bc.AddValueWBC_Leukocytes();
			System.out.println("WBC_Leukocytes : " + WBC_Leukocytes);
			//Entering the value between 1 to 1000 
			Platelet_Count = bc.AddValuePlatelet_Count();
			System.out.println("Platelet_Count : " + Platelet_Count);
		}else {
			//Clearing the existing data in the text feild 
			bc.etFirst.clear();
			bc.etSecond.clear();
			bc.etThird.clear();
			//Entering the value between 1 to 1000 
			Platelet_Count = bc.AddValuePlatelet_Count();
			System.out.println("Platelet_Count : " + Platelet_Count);
			//Entering the value between 1 to 1000
			WBC_Leukocytes = bc.AddValueWBC_Leukocytes();
			System.out.println("WBC_Leukocytes : " + WBC_Leukocytes);
			//Entering the value between 1 to 80
			Hematocrit = bc.AddValueHematocrit();
			System.out.println("Hematocrit : " + Hematocrit);
		}
		//Clicking on Update button 
		bc.toolBarActionText.click();
		Thread.sleep(2000);
		 if(driver.getPageSource().contains("tvGotItAFB")) {
			 System.out.println("AFB is displayed");
			 lp.tvGotItAFB.click();
		 }else {
			 System.out.println("AFB message is not displayed");
		 }
		//Click on BloodCount record 
		lp.Symptoms_Tracked.get(0).click();
		//Validating the values 
		if(MPN_Type.equals(MPN)) {
			//Fethching hemoglibin value 
			float UpdateHemoglobin = Float.parseFloat(bc.etFirst.getText());
			//Fethching the hemotocrit value 
			float UpdateHematocrit = Float.parseFloat(bc.etSecond.getText());
			//Fethching the WBC_Leukocytes value 
			float UpdateWBC_Leukocytes = Float.parseFloat(bc.etThird.getText());
			//Fethching the WBC_Leukocytes value 
			float UpdatePlatelet_Count = Float.parseFloat(bc.etFourth.getText());
			System.out.println("Hemoglobin : " + UpdateHemoglobin);
			System.out.println("Hematocrit : " + UpdateHematocrit);
			System.out.println("WBC_Leukocytes : " + UpdateWBC_Leukocytes);
			System.out.println("Platelet_Count : " + UpdatePlatelet_Count);
			//Validating the values 
			if(Hemoglobin==UpdateHemoglobin) {
				System.out.println("PASS : Hemoglobin ");
			}else {System.out.println("FAIL : Hemoglobin");}
			if(Hematocrit==UpdateHematocrit) {
				System.out.println("PASS : Hematocrit ");
			}else {System.out.println("FAIL : Hematocrit");}
			if(WBC_Leukocytes==UpdateWBC_Leukocytes) {
				System.out.println("PASS : WBC_Leukocytes ");
			}else {System.out.println("FAIL : WBC_Leukocytes");}
			if(Platelet_Count==UpdatePlatelet_Count) {
				System.out.println("PASS : Platelet_Count ");
			}else {System.out.println("FAIL : Platelet_Count");}	
		}else {
			//Fethching the hemotocrit value 
			float UpdateHematocrit = Float.parseFloat(bc.etFirst.getText());
			//Fethching the WBC_Leukocytes value 
			float UpdateWBC_Leukocytes = Float.parseFloat(bc.etSecond.getText());
			//Fethching the WBC_Leukocytes value 
			float UpdatePlatelet_Count = Float.parseFloat(bc.etThird.getText());
			//Validating the values 
			if(Hematocrit==UpdateHematocrit) {
				System.out.println("PASS : Hematocrit ");
			}else {System.out.println("FAIL : Hematocrit");}
			if(WBC_Leukocytes==UpdateWBC_Leukocytes) {
				System.out.println("PASS : WBC_Leukocytes ");
			}else {System.out.println("FAIL : WBC_Leukocytes");}
			if(Platelet_Count==UpdatePlatelet_Count) {
				System.out.println("PASS : Platelet_Count ");
			}else {System.out.println("FAIL : Platelet_Count");}
		}
		//Clicking on close button 
		lp.closeButton.click();
		//Click on Home button
		lp.btHome.click();
		System.out.println("updateBloodCount has ended");
	}
	
	@Test(priority = 4)
	public void deleteBloodCount() {
		System.out.println("deleteBloodCount has started");
		login lp = new login(driver);
		Blood_Count bc = new Blood_Count(driver);
		//Click on history button 
		lp.btHistory.click();
		//Click on symptom record 
		lp.Symptoms_Tracked.get(0).click();
		//Clicking on btnDeleteBloodCount
		bc.btnDeleteBloodCount.click();
		//Clicking on Confirm button (pop-Up)
		lp.button1.click();
		//Click on Home button
		lp.btHome.click();
		System.out.println("deleteBloodCount has Ended");
	}

}
