package Installation_Login;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.PageObjects.login;


public class Test_Symptom extends Base_Class{
	//Symptom_Feature lp = new Symptom_Feature(driver);
	Random random = new Random();
	List<String> SelectedSymptomList = new ArrayList<String>();
	List<String> SelectedActivityList = new ArrayList<String>();
	List<String> RHSvalidationList = new ArrayList<String>();

	@Test(priority = 1)
	public void Track() throws Throwable {
		System.out.println("Track method has started");
		login lp = new login(driver);
		//Clicking on MPN app on home screen 
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'VoicesofMPN® -Q']")).click();
		//Enterring login pin i.e , 0000
		lp.etLoginPin();
		//Clicing on login button 
		lp.loginbtn();
		//Clicking on fab icon (Track)
		lp.fabTrack.click();
		//Selecting symtoms
		lp.tvSymptoms.click();
		//Clicking on ok on date picker screen 
		lp.confirm_button.click();
		
		
		//int NoOFfSymptoms = st.Symptom_List.size(); 
		//Random random = new Random();
		int No_of_symptoms = random.nextInt(1 , 3);
		System.out.println(No_of_symptoms);
		for(int i = 0; i< No_of_symptoms; i++) {
		String Symptom_name = lp.SelectCheckTextlist.get(i).getText();
		SelectedSymptomList.add(Symptom_name);
		  lp.CheckBox.get(i).click();
		}
		System.out.println(SelectedSymptomList);
		//Click on next button 
		lp.btnNext.click();
				
		int No_of_Activity = random.nextInt(1 , 3);
		for(int i=0 ; i< No_of_Activity ; i++) {
			//fetching Activity names selected 
			String Activity_Name = lp.SelectCheckTextlist.get(i).getText();
			//Adding acivity name to the list 
			SelectedActivityList.add(Activity_Name);
			//Clicking on the check box 
			lp.CheckBox.get(i).click();
		}
		//Printing activity list 
		System.out.println(SelectedActivityList);
		//Click on next button 
		lp.btnNext.click();
	
		//Severity page
		List<String> LHSvalidationList = new ArrayList<String>();
		for(int i =0 ; i < SelectedSymptomList.size() ; i++) {
			String SelectedSymptomName = lp.tvSymptomName.get(i).getText();
				int j = i+1;
				int k = random.nextInt(1,4);
				 WebElement Severity = driver.findElement(By.xpath("(//android.widget.Button/..)[" + j + "]/(android.widget.Button)[ " + k + "]"));
				 String Validate = SelectedSymptomName + Severity.getText();
				 LHSvalidationList.add(Validate);
				 Severity.click();
		}
		System.out.println(LHSvalidationList);
		

		//Clicking on next button 
		lp.btnNext.click();
		
		//Symptom summary page 
		List<WebElement> SymtomSelectdSubmit = lp.tvSymptomName;
		List<WebElement> SelectedSeverity = lp.severity_name;
		int NoOfSymtomsSubmit = SymtomSelectdSubmit.size();
		for(int i =0 ; i< NoOfSymtomsSubmit ; i++) {
			String SelectedSymtomSelectdSubmit = SymtomSelectdSubmit.get(i).getText();
			String SelectedSeveritySelectdSubmit = SelectedSeverity.get(i).getText();
			String RHS = SelectedSymtomSelectdSubmit + SelectedSeveritySelectdSubmit;
			RHSvalidationList.add(RHS);	 
		 }
		 System.out.println(RHSvalidationList);
		 
		 //Validating whether the selected combination is correct
		 if(LHSvalidationList.equals(RHSvalidationList)) {
			 System.out.println("PASS : Sysmptom and severity validated");
		 }else {
			 System.out.println("FAIL : Sysmptom and severity is wrong");
		 }
		 
		 if(SelectedActivityList.isEmpty()) {
			 if(lp.tvNoActivitiesAvailable.isDisplayed()) {
			 System.out.println("default activity section is displayed");
			 }
		 }else {
			 List<WebElement> tvActivityNameSubmitPage = lp.tvActivityName;
			 List<String> RHSActivityList = new ArrayList<String>();
			 int NoOfActivity = tvActivityNameSubmitPage.size();
			 for(int i =0 ; i< NoOfActivity ; i++) {
				 String RHS = tvActivityNameSubmitPage.get(i).getText();
				 RHSActivityList.add(RHS);
				 
			 }
			 System.out.println(RHSActivityList);
			 //validating Activities 
			 if(SelectedActivityList.equals(RHSActivityList)) {
					 System.out.println("PASS : Acitivity is vaidated");
			 }else {
					 System.out.println("FAIL : Acitivity is wrong");
			 }
		 }
		//Clicking on submit Button
		 lp.tvSaveSymptom.click();
		 if(driver.getPageSource().contains("tvGotItAFB")) {
			 System.out.println("AFB is displayed");
			 lp.tvGotItAFB.click();
		 }else {
			 System.out.println("AFB message is not displayed");
		 }
		System.out.println("Track method has ended");
	}
	
	
	//READ METHOD 
	@Test(priority = 2)
	public void Read() {
		//Read method
		System.out.println("Read method has startd");
		login lp = new login(driver);
		//Tap on History button 
		lp.btHistory.click();
		//Selecting symptom record on history page 
		//lp.Symptoms_Tracked.get(0).click();
		lp.Symptoms_Tracked1.click();
		//Symptom names list 
		List<WebElement> readSelectdSymptom = lp.tvSymptomName;
		//Severity names list 
		List<WebElement> readSelectedSeverity = lp.severity_name;
		//Size of the symptom 
		int NoOfSymtomSubmit = readSelectdSymptom.size();
		//List for validation 
		List<String> ReadValidationList = new ArrayList<String>();
		//looping 
		for(int i= 0 ; i <NoOfSymtomSubmit ; i++) {
			//Fetching symptom names 
			String SelectedSymtomSelectdSubmit = readSelectdSymptom.get(i).getText();
			//fecthing severity names 
			String SelectedSeveritySelectdSubmit = readSelectedSeverity.get(i).getText();
			//Concating both the names 
			String RHS = SelectedSymtomSelectdSubmit + SelectedSeveritySelectdSubmit;
			//Adding to the list
			ReadValidationList.add(RHS);
		}
		//Printing the validation list 
		System.out.println(ReadValidationList);
		//Validating whether the selected combination is correct
		 if(ReadValidationList.equals(RHSvalidationList)) {
			 System.out.println("PASS : Sysmptom and severity validated");
		 }else {
			 System.out.println("FAIL : Sysmptom and severity is wrong");
		 }
		 
		 
		 //Checking whether Selected activity list is empty 
		 if(SelectedActivityList.isEmpty()) {
			 //validating default activity section is displayed 
			 if(lp.tvNoActivitiesAvailable.isDisplayed()) {
			 System.out.println("default activity section is displayed");
			 }
		 }else {
			 
			 List<WebElement> tvActivityNameSubmitPage = lp.tvActivityName;
			 List<String> RHSActivityList = new ArrayList<String>();
			 int NoOfActivity = tvActivityNameSubmitPage.size();
			 for(int i =0 ; i< NoOfActivity ; i++) {
				 String RHS = tvActivityNameSubmitPage.get(i).getText();
				 RHSActivityList.add(RHS);
				 
			 }
			 //Printing the combination of selected activity list 
			 System.out.println(RHSActivityList);
			 
		     //validating the with selected activity list 
			 if(SelectedActivityList.equals(RHSActivityList)) {
					 System.out.println("PASS : Acitivity is vaidated");
			 }else {
					 System.out.println("FAIL : Acitivity is wrong");
			 }
		 }
		 lp.closeButton.click();
		 lp.btHome.click();
		 System.out.println("read method has ended");
	}
	
	//UPDATE METHOD 
	@Test(priority = 3)
	public void Update() throws Throwable {
		//List of selected symptom 
		List<String> UpdatedSymptomList = new ArrayList<String>();
		List<String> UpdatedSymptomSeverityList = new ArrayList<String>();
		
		System.out.println("Update method has started");
		
		login lp = new login(driver);
		
		//Click on history button 
		lp.btHistory.click();
		//Click on symptom record 
		lp.Symptoms_Tracked.get(0).click();
		//Click on Edit symptom icon
		lp.ivEditSymptoms.click();
		//DeSelecting all the check Boxes
		for(int i = lp.SelectedCheckBox.size()-1  ;  i>=0 ; i--) {
			lp.SelectedCheckBox.get(i).click();
		}
		//NO of symptom to be selected
		int No_of_symptoms = random.nextInt(1 , 3);
		//Selecting the symptoms and fetching the symptom name 
		for(int i = 0; i< No_of_symptoms; i++) {
			 int j = random.nextInt(lp.CheckBox.size());
			String Symptom_name = lp.SelectCheckTextlist.get(j).getText();
			UpdatedSymptomList.add(Symptom_name);
			  lp.CheckBox.get(j).click();
			}
		//Printing all the symptom record 
		System.out.println("UpdatedSymptomList : " + UpdatedSymptomList);
		//Click on next button 
		lp.btnNext.click(); 
		
		//Symptom name list on severity page 
		List<WebElement> Symptom_Name = lp.tvSymptomName;		
		for(int i =0 ; i< Symptom_Name.size() ; i++) {
			String SelectedSymptomName = lp.tvSymptomName.get(i).getText();
			int j = i+1;
			int k = random.nextInt(1,4);
			 WebElement Severity = driver.findElement(By.xpath("(//android.widget.Button/..)[" + j + "]/(android.widget.Button)[ " + k + "]"));
			 String Severity1 = Severity.getText();
			 String Symptom_Severity = SelectedSymptomName + Severity1;
			 UpdatedSymptomSeverityList.add(Symptom_Severity);
			 Severity.click();
		 }
		//Printing all the UpdatedSymptomSeverityList
		System.out.println("UpdatedSymptomSeverityList : " + UpdatedSymptomSeverityList);
		//Click on next button 
		lp.btnNext.click();
		//Clicking on the Activity edit option 
		lp.ivEditActivities.click();
		//DeSelecting all the check Boxes
		for(int i = lp.SelectedCheckBox.size()-1  ;  i>=0 ; i--) {
				lp.SelectedCheckBox.get(i).click();
		}
		
		//Activities list name defining 
		List<String> UpdatedActivityList = new ArrayList<String>();
		//Defining no of activities to be selected  
		int No_of_Activities = random.nextInt(1 , 3);
		//Slecting the activities and fetching the activities name which are selected
		for(int i = 0; i< No_of_Activities; i++) {
			 int j = random.nextInt(lp.CheckBox.size());
			String Symptom_name = lp.SelectCheckTextlist.get(j).getText();
			UpdatedActivityList.add(Symptom_name);
			  lp.CheckBox.get(j).click();
			}
		//Printing the selected activities 
		System.out.println("UpdatedActivityList : " + UpdatedActivityList);
		//Click on next button 
		lp.btnNext.click();
		//Clicking on Update button 
		lp.tvSaveSymptom.click();
		//Click on Got it button 
		if(driver.getPageSource().contains("tvGotItAFB")) {
			 System.out.println("AFB is displayed");
			 lp.tvGotItAFB.click();
		 }else {
			 System.out.println("AFB message is not displayed");
		 }
		
		//Click on symptom record 
		lp.Symptoms_Tracked.get(0).click();
		//Validating the updated symptom , Activity and severity in the symptom summary page 
		//Symptom names list 
		List<WebElement> UpdatedSelectdSymptom = lp.tvSymptomName;
		//Severity names list 
		List<WebElement> UpdatedSelectedSeverity = lp.severity_name;
		//Size of the symptom 
		int NoOfSymtomUpdated = UpdatedSelectdSymptom.size();
		//List for validation 
		List<String> UpdateValidationList = new ArrayList<String>();
		//looping 
		for(int i= 0 ; i <NoOfSymtomUpdated ; i++) {
		//Fetching symptom names 	
		String SelectedSymtomSelectdSubmit = UpdatedSelectdSymptom.get(i).getText();
		//fecthing severity names 
		String SelectedSeveritySelectdSubmit = UpdatedSelectedSeverity.get(i).getText();
		//Concating both the names 
		String RHS = SelectedSymtomSelectdSubmit + SelectedSeveritySelectdSubmit;
		//Adding to the list
		UpdateValidationList.add(RHS);
		}
		//Printing the validation list 
		System.out.println("UpdateValidationList : " + UpdateValidationList);
		System.out.println("UpdatedSymptomSeverityList : " + UpdatedSymptomSeverityList);
		//Validating whether the selected combination is correct
		if(UpdateValidationList.equals(UpdatedSymptomSeverityList)) {
					 System.out.println("PASS : Sysmptom and severity validated");
		}else {
					 System.out.println("FAIL : Sysmptom and severity is wrong");
		} 
		
			List<WebElement> tvActivityNameUpdatePage = lp.tvActivityName;
			List<String> RHSActivityList = new ArrayList<String>();
			int NoOfActivity = tvActivityNameUpdatePage.size();
				for(int i =0 ; i< NoOfActivity ; i++) {
					String RHS = tvActivityNameUpdatePage.get(i).getText();
						RHSActivityList.add(RHS);
				}
				//Printing the combination of selected activity list 
				System.out.println("RHSActivityList : " +  RHSActivityList);
				System.out.println("UpdatedActivityList : " + UpdatedActivityList);
				//validating the with selected activity list 
			    if(RHSActivityList.equals(UpdatedActivityList)) {
					System.out.println("PASS : Acitivity is vaidated");
				}else {
					System.out.println("FAIL : Acitivity is wrong");
				}
		//Clicking on close button 
		lp.closeButton.click();
		//Clicking on the Home button 
		lp.btHome.click();	
		System.out.println("Update method has ended");
	}
	
	
	@Test(priority = 4)
	public void delete_symptom() {
		System.out.println("Delete method has started");
		login lp = new login(driver);
		//Click on history button 
		lp.btHistory.click();
		//Click on symptom record 
		lp.Symptoms_Tracked.get(0).click();
		//Clicking on delete button 
		lp.btnDeleteSymptom.click();
		//Click on confirm delete
		lp.button1.click();
		//Clicking on the Home button 
		lp.btHome.click();
		System.out.println("Delete method has ended");
		
	}
}
