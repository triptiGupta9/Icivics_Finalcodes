package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.HomePage_5HeaderSigninMisc;
import projectSpecific.base.ProjectSpecificMethods;

public class I37_HomePage_5HeaderSigninMisc_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Homepage Header mysignin misc";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageheadersigninmisc";
	}

	// C29 - Can you see an appropriate icon for Donate?

	@Test(priority = 0)
	public void C29_Verifydonatebutton() throws IOException, InterruptedException {
		node = test.createNode("C29 -  Can you see an appropriate icon for Donate?");
		extent.attachReporter(spark);
		new HomePage_5HeaderSigninMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().VerifyDonatebutton();
	}
	// C30 - When you select Donate, are you directed to https://give.icivics.org/?

	@Test(priority = 1)
	public void C30_Verifydonatebuttonclick() throws IOException, InterruptedException {
		node = test.createNode("C30 -  When you select Donate, are you directed to https://give.icivics.org/?");
		extent.attachReporter(spark);
		new HomePage_5HeaderSigninMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().VerifyDonateclick();
	}
	// C31 - Can you see an appropriate icon for Shop?

	@Test(priority = 2)
	public void C31_Verifyshopbutton() throws IOException, InterruptedException {
		node = test.createNode("C31 -  Can you see an appropriate icon for Shop?");
		extent.attachReporter(spark);
		new HomePage_5HeaderSigninMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().VerifyShopbutton();
	}
	// C32 - When you select Shop, are you directed to
	// https://icivics.myshopify.com/?

	@Test(priority = 3)
	public void C32_Verifyshopbuttonclick() throws IOException, InterruptedException {
		node = test.createNode("C32 -  When you select Shop, are you directed to https://icivics.myshopify.com/?");
		extent.attachReporter(spark);
		new HomePage_5HeaderSigninMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().VerifyShopbuttonclick();
	}
	// C33 - If you are not signed in, do you see a Sign In button instead of My
	// iCivics?

	@Test(priority = 4)
	public void C33_Verifysigninbuttonforanonymoususer() throws IOException, InterruptedException {
		node = test.createNode("C33 - If you are not signed in, do you see a Sign In button instead of My iCivics?");
		extent.attachReporter(spark);
		new HomePage_5HeaderSigninMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifysigninbutton();
	}

	// C37 - When you select Sign In, do you see links to Sign In, Register As a
	// Student, Register As A Teacher in the submenu?

	@Test(priority = 5)
	public void C37_Verifysigninbuttonsubmenu() throws IOException, InterruptedException {
		node = test.createNode(
				"C37 - When you select Sign In, do you see links to Sign In, Register As a Student, Register As A Teacher in the submenu?");
		extent.attachReporter(spark);
		new HomePage_5HeaderSigninMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifysigninbuttonsubmenulist();
	}
	// C38 - If not signed in and you select a link in the submenu, are you
	// navigated to the appropriate page?

	@Test(priority = 6)
	public void C38_Verifysigninbuttonsubmenu() throws IOException, InterruptedException {
		node = test.createNode(
				"C38 - If not signed in and you select a link in the submenu, are you navigated to the appropriate page?");
		extent.attachReporter(spark);
		new HomePage_5HeaderSigninMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Signinbuttonelementsverification();
	}
	// C41 - If you are viewing one of the pages in the Sign In submenu, is that
	// page underlined in the submenu?

	@Test(priority = 7)
	public void C41_Verifysubmenuoptionisunderlined() throws IOException, InterruptedException {
		node = test.createNode(
				"C41 - If you are viewing one of the pages in the Sign In/My iCivics submenu, is that page underlined in the submenu?");
		extent.attachReporter(spark);
		new HomePage_5HeaderSigninMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifysigninbutton()
				.verifyselectedsigninunderlined().verifyselectedregasmystuunderlined()
				.verifyselectedregzasmyteacherunderlined().Clickonsigninbuttonagain();
	}

	// C42 - When you select Sign In / My iCivics again while the submenu is open,
	// does the submenu close?

	@Test(priority = 8)
	public void C42_Verifysubmenuoptionisunderlined() throws IOException, InterruptedException {
		node = test.createNode(
				"C42 - When you select Sign In / My iCivics again while the submenu is open, does the submenu close?");
		extent.attachReporter(spark);
		new HomePage_5HeaderSigninMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifysigninbutton().Clickonsigninbuttonagain();
	}

}
