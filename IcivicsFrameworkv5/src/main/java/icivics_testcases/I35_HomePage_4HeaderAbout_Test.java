package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.HomePage_4HeaderAbout;

import projectSpecific.base.ProjectSpecificMethods;

public class I35_HomePage_4HeaderAbout_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Homepage HeaderAbout";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageheaderabout";
	}

	// C22 - When you select About, does a submenu open below the About button?

	@Test(priority = 0)
	public void C22_Verifyaboutsubmenu() throws IOException, InterruptedException {
		node = test.createNode("C22 -  When you select About, does a submenu open below the About button?");
		extent.attachReporter(spark);
		new HomePage_4HeaderAbout(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().clickonaboutmenu().verifyaboutbuttonathomepage();
	}
	// C23 - Do you see links to About iCivics, Who We Are, Our Strategy, CIVXNOW,
	// Our Team, Blog, and Contact Us in the submenu?

	@Test(priority = 1)
	public void C23_Verifysubmenucount() throws IOException, InterruptedException {
		node = test.createNode(
				"C23 - Do you see links to About iCivics, Who We Are, Our Strategy, CIVXNOW, Our Team, Blog, and Contact Us in the submenu?");
		extent.attachReporter(spark);
		new HomePage_4HeaderAbout(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().clickonaboutmenu().verifyaboutoptionscount();
	}
	// C24 - When you select a link in the submenu, are you navigated to the
	// appropriate page?

	@Test(priority = 2)
	public void C24_VerifysubmenuElement() throws IOException, InterruptedException {
		node = test
				.createNode("C24 - When you select a link in the submenu, are you navigated to the appropriate page?");
		extent.attachReporter(spark);
		new HomePage_4HeaderAbout(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().aboutbuttonelementsverification();
	}
	/*// C26 - If you are viewing one of the pages in the About submenu, is that page underlined in the submenu?


	@Test(priority = 3)
	public void C26_Verifysubmenucount1() throws IOException, InterruptedException {
		node = test
				.createNode("C26 - If you are viewing one of the pages in the About submenu, is that page underlined in the submenu?");
		extent.attachReporter(reporter);
		new HomePage_4HeaderAbout(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().aboutbuttonelementsverification();
	}*/
	// C27 - When you select About again while the submenu is open, does the submenu close?


	@Test(priority = 3)
	public void C27_Verifyclickaboutbuttonagain() throws IOException, InterruptedException {
		node = test
				.createNode("C27 - When you select About again while the submenu is open, does the submenu close?");
		extent.attachReporter(spark);
		new HomePage_4HeaderAbout(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().clickonaboutmenu().clickaboutbuttonagain();
	}
}
