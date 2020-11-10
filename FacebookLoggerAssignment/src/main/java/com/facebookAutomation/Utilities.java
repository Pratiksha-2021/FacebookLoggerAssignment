package com.facebookAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utilities {
static Logger logger=Logger.getLogger(Utilities.class);
	
/*	private EnvSetUp objEnvSetup; // if we extend then again browser open avoid
									// this use constructor
	//Utilities.createLog4JDirectoty();
public Utilities(EnvSetUp envSetup) {
		this.objEnvSetup = envSetup;
		objEnvSetup.log4jConfiguration();
	
	}*/
	

	
	public static String randomnogenerate(){
		
		double randomDouble = Math.random();
		randomDouble = randomDouble * 999999999 + 10000;
		int randomInt = (int) randomDouble;
		
		System.out.println(randomInt);// 2147483647
		String str1 = Integer.toString(randomInt);
		logger.info("Random number is>>>"+str1);
		String actual="str1";
		return str1;
		
 }
	
	public static void selectDropDown(WebElement ele,String strDropDownOption){
		Select sel = new Select(ele);
		sel.selectByVisibleText(strDropDownOption);
	}
	
	public static void selectDropDownOfMonth(WebElement ele,int index){
		String[] arr = { "Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        Select select = new Select(ele);
		List<WebElement> alloption = select.getOptions();
	    for (WebElement we : alloption) {
			for (int j = 1; j <arr.length; j++) {
			if (we.getText().equals(arr[j])) {
					String alldropdown=we.getText();
					// System.out.println("Matched");
					alloption.get(index).click();

				}

			}

		}
	}
		
		
		public static void selectDropDownOfYear(List<WebElement> yeardropdown,int no){
			int yearsize = yeardropdown.size();
			System.out.println("size of year>>>"+yearsize);
			for(int i = 1;i<yearsize;i++)
			{
				String dropDownOption= yeardropdown.get(i).getText();
				logger.info("dropdoen year>>>"+dropDownOption);
				System.out.println("All dropdown text is" + dropDownOption);
				yeardropdown.get(no).click();
				
				
			}
			}
		
		
		public static List<String> getAllMonthInCalender(){
			List<String>specifiedList=Arrays.asList("Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" );
			return specifiedList;
			
		    }
		
		
		
		
		
		public static String getRandomMonthInCalender(){
			Random random=new Random();
			String randomMonth="";
			List<String>givenlist=Arrays.asList("Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
			
			int numberofElement=12;
			for(int i=0;i<numberofElement;i++){
				int randomIndex=random.nextInt(givenlist.size());
				randomMonth=givenlist.get(randomIndex);
				logger.info("random month title>>>>"+randomMonth);
			   }
			
			return randomMonth;
			
		}
		
	//Excel Utility
		public static DataFormatter formatter = new DataFormatter();
		public static WebDriver driver;
		public static XSSFWorkbook wb;
		public static XSSFSheet sh;
		public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir"+"/src/main/resources/DP_ExcelSheet.xlsx");
				
		

		public static Object[][] getTestData() throws Exception {
			FileInputStream fis = new FileInputStream(TESTDATA_SHEET_PATH);
			System.out.println("initialisation of excelsheet");
			wb = new XSSFWorkbook(fis);
			sh = wb.getSheet("Sheet1");
			XSSFRow row = sh.getRow(0);
			int rowcount = sh.getPhysicalNumberOfRows();
			int lastcol = row.getLastCellNum();
			Object Data[][] = new Object[rowcount - 1][lastcol];

			System.out.println("total row count>>" + rowcount);
			System.out.println("total col count>>" + lastcol);
			for (int i = 0; i < rowcount - 1; i++) {
				XSSFRow row1 = sh.getRow(i + 1);
				for (int j = 0; j < lastcol; j++) {
					if (row1 == null)
						Data[i][j] = " ";
					else {
						XSSFCell cell = row1.getCell(j);
						System.out.println("cell value>>" + cell);
						if (cell == null)
							Data[i][j] = " ";
						else {
							String value = formatter.formatCellValue(cell);
							Data[i][j] = value;
						}
					}
				}
			}
			return Data;
		};

	

		
		

}
		
		
		
		
		
		
		
	



	

