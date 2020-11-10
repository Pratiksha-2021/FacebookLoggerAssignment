package com.facebookAutomation;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;



public class FacebookSignupAssignment extends EnvSetUp{

	private ModularFunctions objModularFunctions;
	
	//private By drpLocator=By.id("month");
	
	@BeforeClass
	public void initialiseWebEnvironment(){
		objModularFunctions=new ModularFunctions(this);
		initialiseWebEnv();
		
	}
	
	@Test
	public void registerFacebook(){
		objModularFunctions.verifyFacebookTitle();
		objModularFunctions.setFirstName(objconfig.getProperty("firstName"));
	    objModularFunctions.setLastName(objconfig.getProperty("lastName"));
		objModularFunctions.setMobileNumber(Utilities.randomnogenerate());
		objModularFunctions.setPassword(objconfig.getProperty("user.password"));
		objModularFunctions.setDateOfBirthDropDown(objconfig.getProperty("user.dateOfBirth"));//(selectbyvisibilitytext return string )
		//objModularFunctions.setDateOfMonthDropDown(5);
		objModularFunctions.setYearOfDropDown(Integer.parseInt(objconfig.getProperty("index")));//(selectbyvisibilityindex return int do type cast..properties file return string)
		//objModularFunctions.setYearOfDropDown((Integer.toString(objconfig.getProperty("index")));
		//objModularFunctions.verifyAllDropDownValues(drpLocator);
		objModularFunctions.setMonthInDropdown(Utilities.getRandomMonthInCalender());
		objModularFunctions.selectRadiobtn();
		
	}
	
	
	/*@DataProvider
	public Object[][] getFacebookWebsiteTestData() throws Exception{
	    Object data[][]=Utilities.getTestData() ; //written in test util
			return data;
		}
	@Test(priority=4,dataProvider="getFacebookWebsiteTestData") //getFacebookWebsiteTestData method is provide data
	 public void AddNewUser	(String tcid, String firstName, String lastName, String password, String dateOfBirth,
				int year, String tcdescription, String ExpMessage) {
		
		objModularFunctions.addNewUser( tcid,  firstName,  lastName,  password, dateOfBirth,
				year,  tcdescription,  ExpMessage);  
		
	}	
	*/
	
	
	
	
}

