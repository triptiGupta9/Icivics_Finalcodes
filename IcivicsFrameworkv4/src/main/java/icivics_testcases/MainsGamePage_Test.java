package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.MainsGamePage;
import projectSpecific.base.ProjectSpecificMethods;

public class MainsGamePage_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Mainsgamepage";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_GoogleIntegration";
	}

	// C539 - Game carousel

	@Test(priority = 0)
	public void C73_Verifymainsgamepage() throws IOException, InterruptedException {
		node = test.createNode("C73 - Game carousel");
		extent.attachReporter(spark);
		new MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifygamecarousel();
	}

	// C73 - Game carousel left arrow

	@Test(priority = 1)
	public void C73_Verifyleftcarousel() throws IOException, InterruptedException {
		node = test.createNode("C73 - Game carousel left arrow");
		extent.attachReporter(spark);
		new MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifyleftcarousel();
	}
	// C73 - Game carousel right arrow

	@Test(priority = 2)
	public void C73_Verifyrightcarousel() throws IOException, InterruptedException {
		node = test.createNode("C73 - Game carousel right arrow");
		extent.attachReporter(spark);
		new MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifyrightcarousel();
	}
	// C73 - Game carousel dots

	@Test(priority = 3)
	public void C73_Verifycarouseldots() throws IOException, InterruptedException {
		node = test.createNode("C73 - Game carousel dots");
		extent.attachReporter(spark);
		new MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifycarouseldots();
	}

}
