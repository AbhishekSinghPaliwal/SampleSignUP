package com.cognitivescale.framework.common;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cognitivescale.framework.Utilities.ElementActions;
import com.cognitivescale.framework.businessLogic.FacebookSignUpPage;

public class Base {

	private static WebDriver driver;
	private static final int GLOBAL_WAIT = 90;
	private static Properties myProperties;
	private static String directoryPath = System.getProperty("user.dir");
	public static String configDirectory = directoryPath;
	public static FacebookSignUpPage facebookSignUpPage;
	// ElementActions elementActions=new ElementActions();

	public Base() {
		if (driver == null) {
			System.out.println("Inside Base constructor");
			readJSONDataConfiguration();
			initWebDriver();
			openUrl();
			// facebookSignUpPage=new FacebookSignUpPage();
		}
	}

	private static void readJSONDataConfiguration() {
		String jsonFilePath = configDirectory + "/src/test/resources/jsondatafile/ConfigurationFile.json";
		File configuration = new File(jsonFilePath);
		myProperties = new Properties();
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(configuration));
			JSONObject configObj = (JSONObject) obj;
			for (Iterator<String> value = configObj.keySet().iterator(); value.hasNext();) {
				String key = value.next();
				myProperties.setProperty(key, (String) configObj.get(key));

			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (ParseException e2) {
			e2.printStackTrace();
		}

	}

	public static void initWebDriver() {
		
		String browser = getConfig("browser");
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			System.setProperty("webdriver.firefox.marionette", "Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		

		default:
			driver = null;
		}

	}

	public static WebDriver getDriver() {
		System.out.println("inside getDriver()");
		return driver;
	}

	public static String getConfig(String key) {
		return myProperties.getProperty(key);
	}

	public void openUrl() {
		driver.get(getConfig("url"));
		// elementActions.waitForPageLoad(driver);

	}

}
