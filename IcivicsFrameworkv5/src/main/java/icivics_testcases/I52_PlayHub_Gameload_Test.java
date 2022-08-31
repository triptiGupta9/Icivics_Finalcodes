package icivics_testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.PlayHub_Gameload;

import projectSpecific.base.ProjectSpecificMethods;

public class I52_PlayHub_Gameload_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Mainsgamepage";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_GoogleIntegration";
	}

	// C83-Game load
	@Test(priority = 0)
	public void C83_Verifymainsgamepage() throws IOException, InterruptedException, AWTException {
		node = test.createNode("C83-Game load");
		extent.attachReporter(spark);
		new PlayHub_Gameload(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifygameload1();
	} 

}
