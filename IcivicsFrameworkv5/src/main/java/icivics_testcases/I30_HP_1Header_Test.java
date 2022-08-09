package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.HP_1Header;
import projectSpecific.base.ProjectSpecificMethods;

public class I30_HP_1Header_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Homepage Header";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageheader";
	}

	// C1 - Do you see the iCivics Logo in the upper left?

	@Test(priority = 0)
	public void C1_VerifyLogo() throws IOException, InterruptedException {
		node = test.createNode("C1 - Do you see the iCivics Logo in the upper left?");
		extent.attachReporter(spark);
		new HP_1Header(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().VerifyLogo();
	}
	// C2 - While on the iCivics Home Page, do you see buttons for Donate, Shop, and
	// My iCivics in the navigation bar?

	@Test(priority = 1)
	public void C2_VerifyHeaderbuttonforanonymoususer() throws IOException, InterruptedException {
		node = test.createNode(
				"C2 - While on the iCivics Home Page, do you see buttons for Donate, Shop,  and My iCivics in the navigation bar?for anonymous user");
		extent.attachReporter(spark);
		new HP_1Header(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().VerifyDonatebutton()
				.Verifyshopbutton().Verifymyicivicsbuttondisplayafterlogin();
	}
	// C2 - While on the iCivics Home Page, do you see buttons for Donate, Shop, and
	// My iCivics in the navigation bar?

	@Test(priority = 2)
	public void C2_VerifyHeaderbuttonforauthenticateduser() throws IOException, InterruptedException {
		node = test.createNode(
				"C2 - While on the iCivics Home Page, do you see buttons for Donate, Shop,  and My iCivics in the navigation bar?for authenticated user");
		extent.attachReporter(spark);
		new HP_1Header(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().signin().Verifyheaderbuttonsafterlogin();
	}

	// C1538 - Does the donation popup NOT show?

	@Test(priority = 3)
	public void C1538_Verifydonationpopup() throws IOException, InterruptedException {
		node = test.createNode("C1538 - Does the donation popup NOT show?");
		extent.attachReporter(spark);
		new HP_1Header(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifydonationpopup();
	}

}
