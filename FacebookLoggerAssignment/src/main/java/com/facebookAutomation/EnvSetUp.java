package com.facebookAutomation;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class EnvSetUp{
private	WebDriver driver;
public Properties objconfig;
	
	public void initialiseWebEnv(){
		loadConfigurationfile();
		log4jConfiguration();
		System.setProperty("webdriver.chrome.driver", "chromedriver85.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("open url>>>>"+objconfig.getProperty("AUT_URL"));
		driver.get(objconfig.getProperty("AUT_URL"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver(){
		return driver;
		
	
}
	
	public void loadConfigurationfile(){
		try{
			objconfig=new Properties();
			objconfig.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
  public void log4jConfiguration() {
        createLog4JDirectoty();
		String log4Jpath=System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
		PropertyConfigurator.configure(log4Jpath);
	}
	
	public void createLog4JDirectoty() {

		String logfilepath = System.getProperty("user.dir") + "/target/LogFile/log4j-Logger.log";// file extention must
																							// be .log
		File reportfile = new File(logfilepath);
		try {
			if (!reportfile.exists()) {
				new File(System.getProperty("user.dir") + "target/LogFile").mkdir();
				reportfile.createNewFile();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

}
