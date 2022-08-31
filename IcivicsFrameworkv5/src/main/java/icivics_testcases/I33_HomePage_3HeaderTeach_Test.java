package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.HomePage_3HeaderTeach;

import projectSpecific.base.ProjectSpecificMethods;

public class I33_HomePage_3HeaderTeach_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Homepage Header teach1";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageheaderteach";
	}

	// C15 - When you select Teach, does a submenu open below the Teach button?

	@Test(priority = 0)
	public void C15_Verifyteachsubmenu() throws IOException, InterruptedException {
		node = test.createNode("C15 - When you select Teach, does a submenu open below the Teach button?");
		extent.attachReporter(spark);
		new HomePage_3HeaderTeach(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyteachmenu();
	}
	// C16 - Do you see links to Search Our Library, Scope and Sequence,
	// Professional Development, Get Started, Educatory Community, and FAQ in the
	// submenu?

	@Test(priority = 1)
	public void C16_Verifysubmenucount() throws IOException, InterruptedException {
		node = test.createNode(
				"C16 - Do you see links to Search Our Library, Scope and Sequence, Professional Development, Get Started, Educatory Community, and FAQ in the submenu?");
		extent.attachReporter(spark);
		new HomePage_3HeaderTeach(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyteachmenu().verifyteachmenulist();
	}
	// C17 - When you select a link in the submenu, are you navigated to the
	// appropriate page?

	@Test(priority = 2)
	public void C17_Verifyteachbuttonelements() throws IOException, InterruptedException {
		node = test
				.createNode("C17 - When you select a link in the submenu, are you navigated to the appropriate page?");
		extent.attachReporter(spark);
		new HomePage_3HeaderTeach(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Teachbuttonelementsverification();
	}

	// C20 - When you select Teach again while the submenu is open, does the submenu
	// close?

	@Test(priority = 3)
	public void C20_verifyclickteachbuttonagain() throws IOException, InterruptedException {
		node = test.createNode("C20 - When you select Teach again while the submenu is open, does the submenu close?");
		extent.attachReporter(spark);
		new HomePage_3HeaderTeach(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyteachmenu().clickteachbuttonagain();
	}

}
