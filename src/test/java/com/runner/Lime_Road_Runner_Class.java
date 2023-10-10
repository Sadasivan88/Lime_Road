package com.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.baseclass.BrowserName;
import com.baseclass.Lime_Road_Base_Class;
import com.baseclass.NykkaBase;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "D:\\IPT\\Lime_Road_Project_Cucumber\\src\\test\\java\\com\\feature\\lime_road_sports_wear.feature",
					glue = "com.stepdefinition",
					plugin = {"pretty",
							   "json:Resources/lime.json",
							  "html:Res/limeroad.html",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					}
					
					

		)
public class Lime_Road_Runner_Class extends NykkaBase  {
	@BeforeClass
	public static void launchBrowser() {
		browserLaunch(BrowserName.Chrome, "private");
	}
	
	@AfterClass
	public static void quitBrowser() {
		driver.quit();
	}
}

