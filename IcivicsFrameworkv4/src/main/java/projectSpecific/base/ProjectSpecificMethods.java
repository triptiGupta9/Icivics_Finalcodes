package projectSpecific.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import selenium.base.SeleniumBase;
import utilities.DataLibrary;

public class ProjectSpecificMethods extends SeleniumBase {

	public String dataSheetName;
	public String Environment;
	public String StageURL;
	public String Stage1URL;

	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(dataSheetName);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		// Stage.d9 or Stage.d11
		Environment = "Stage.d9";
		
		StageURL = "https://staging.d9.icivics.org";
		Stage1URL = "https://staging.d11.icivics.org";
		
		String browser = "chrome";
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = startApp1("chrome");

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = startApp1("firefox");

		}
		// node = test.createNode(testCaseName);
	}

	@AfterMethod
	public void afterMethod() {
		quit();
	}
}