package com.facebookAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class ModularFunctions {
	Logger logger=Logger.getLogger(ModularFunctions.class);
	
	private EnvSetUp objEnvSetup; // if we extend then again browser open avoid
									// this use constructor
	//Utilities.createLog4JDirectoty();
	public ModularFunctions(EnvSetUp envSetup) {
		this.objEnvSetup = envSetup;
		objEnvSetup.log4jConfiguration();
		
	}
	

	
	public void verifyFacebookTitle() {
		String strTitle = objEnvSetup.getDriver().getTitle();
		
		logger.info("Facebook Title>>>"+strTitle);
		
		Assert.assertEquals(strTitle, "Sign up for Facebook | Facebook");
		objEnvSetup.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void setFirstName(String strFirstName) {
		WebElement username = objEnvSetup.getDriver().findElement(By.name("firstname"));
		username.sendKeys(strFirstName);
		logger.info("username is enter");
	}

	public void setLastName(String strLastName) {
		WebElement webelementlastname = objEnvSetup.getDriver().findElement(By.name("lastname"));
		webelementlastname.sendKeys(strLastName);
	
	}

	public void setMobileNumber(String strMobileNumber) {
		WebElement webelementMobNo = objEnvSetup.getDriver().findElement(By.name("reg_email__"));
		webelementMobNo.sendKeys("9" + strMobileNumber);
		logger.warn("mobile no should be ten digit ");
	}

	public void setPassword(String strpassword) {
		WebElement elementSetPsw = objEnvSetup.getDriver().findElement(By.name("reg_passwd__"));
		elementSetPsw.sendKeys(strpassword);
		logger.warn("password strenth must be strong");
		
	}

	public void setDateOfBirthDropDown(String drpOptions) {
		WebElement elementDOB = objEnvSetup.getDriver().findElement(By.id("day"));
		Utilities.selectDropDown(elementDOB, drpOptions);
		
	}

	public void setDateOfMonthDropDown(int index) {
		WebElement dropdownmonth = objEnvSetup.getDriver().findElement(By.id("month"));
		Utilities.selectDropDownOfMonth(dropdownmonth, index);
		
	}

	public void setYearOfDropDown(int index) {
		List<WebElement> yeardropdown = objEnvSetup.getDriver()
				.findElements(By.xpath("//option[contains(@value,'199')]"));
		Utilities.selectDropDownOfYear(yeardropdown, index);
	}

	public void selectRadiobtn() {
		objEnvSetup.getDriver().findElement(By.name("sex")).click();
	}

	public void verifyAllDropDownValues(By locator) {

		WebElement webElement = objEnvSetup.getDriver().findElement(locator);
		Select select = new Select(webElement);
		List<WebElement> alloption = select.getOptions();
		List<String> expectedMonthResult = Utilities.getAllMonthInCalender();
		for (WebElement weElement : alloption) {
			logger.info("All month is"+weElement);
			boolean blnFlag = false;

			for (int i = 0; i < expectedMonthResult.size(); i++) {
				if (weElement.getText().equals(expectedMonthResult.get(i))) {

					blnFlag = true;

				}
			}
			Assert.assertTrue(blnFlag);
		}
		

	}

	public void setMonthInDropdown(String drpOptions) {
		WebElement element = objEnvSetup.getDriver().findElement(By.id("month"));
		Utilities.selectDropDown(element, drpOptions);

	}
	

	//Action On Adduser
		public void addNewUser(String tcid, String firstName, String lastName, String password, String dateOfBirth,
				int year, String tcdescription, String ExpMessage) {
			
				System.out.println("test case id" + tcid); // String emailid,
				System.out.println("test case description" + tcdescription);
				setFirstName(firstName);
				setLastName(lastName);
				setPassword(password);
				setDateOfBirthDropDown(dateOfBirth);
				setYearOfDropDown(year);
				if (tcdescription.equals("register_valid")) {
					Assert.assertEquals(objEnvSetup.getDriver().getTitle(), ExpMessage);
				}

			}
		
	

			}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


