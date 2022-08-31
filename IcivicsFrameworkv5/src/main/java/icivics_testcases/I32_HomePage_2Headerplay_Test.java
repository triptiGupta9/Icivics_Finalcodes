package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.HomePage_2HeaderPlay;
import projectSpecific.base.ProjectSpecificMethods;

public class I32_HomePage_2Headerplay_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Homepage Headerplay";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageheaderplay";
	}

	// C8 - When you select Play, does a submenu open below the Play button?

	@Test(priority = 0)
	public void C8_Verifyplaysubmenu() throws IOException, InterruptedException {
		node = test.createNode("C8 -  When you select Play, does a submenu open below the Play button?");
		extent.attachReporter(spark);
		new HomePage_2HeaderPlay(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyplaysubmenu();
	}
	// C9 - Do you see links to All Games, as well as each individual game in the
	// submenu?

	@Test(priority = 1)
	public void C9_Verifyplaybuttonlist() throws IOException, InterruptedException {
		node = test.createNode("C9- Do you see links to All Games, as well as each individual game in the submenu?");
		extent.attachReporter(spark);
		new HomePage_2HeaderPlay(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyplaysubmenu().verifyplaysubmenulist();
	}
	// C10 - When you select a link in the submenu, are you navigated to the
	// appropriate page?

	@Test(priority = 2)
	public void C10_Verifyplaybuttonelements() throws IOException, InterruptedException {
		node = test
				.createNode("C10- When you select a link in the submenu, are you navigated to the appropriate page?");
		extent.attachReporter(spark);
		new HomePage_2HeaderPlay(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Playbuttonelementsverification();
	}

	// C12 -If you are viewing one of the pages in the Play submenu, is that page
	// underlined in the submenu?

	@Test(priority = 3)
	public void C12_Verifypageisunderlined() throws IOException, InterruptedException {
		node = test.createNode(
				"C12- If you are viewing one of the pages in the Play submenu, is that page underlined in the submenu?");
		extent.attachReporter(spark);
		new HomePage_2HeaderPlay(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifyselectedoptionunderlined();
	}

	// C13 - When you select Play again while the submenu is open, does the submenu
	// close?

	@Test(priority = 4)
	public void C13_Verifyclickonplaybuttonagain() throws IOException, InterruptedException {
		node = test.createNode("C13- When you select Play again while the submenu is open, does the submenu close?");
		extent.attachReporter(spark);
		new HomePage_2HeaderPlay(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyplaysubmenu().clickplaybuttonagain();
	}
}
