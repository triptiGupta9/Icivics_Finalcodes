package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.HomePage_5HeaderMyicivicsMisc;
import projectSpecific.base.ProjectSpecificMethods;

public class I36_HomePage_5HeaderMyicivicsMisc_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Homepage Header MyIcivics Misc";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageheadermyicivicsmisc";
	}

	// C29 - Can you see an appropriate icon for Donate?

	@Test(priority = 0)
	public void C29_Verifydonatebutton() throws IOException, InterruptedException {
		node = test.createNode("C29 -  Can you see an appropriate icon for Donate?");
		extent.attachReporter(spark);
		new HomePage_5HeaderMyicivicsMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifylogin().VerifyDonatebutton();
	}
	// C30 - When you select Donate, are you directed to https://give.icivics.org/?

	@Test(priority = 1)
	public void C30_Verifydonatebuttonclick() throws IOException, InterruptedException {
		node = test.createNode("C30 -  When you select Donate, are you directed to https://give.icivics.org/?");
		extent.attachReporter(spark);
		new HomePage_5HeaderMyicivicsMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifylogin().VerifyDonateclick();
	}
	// C31 - Can you see an appropriate icon for Shop?

	@Test(priority = 2)
	public void C31_Verifyshopbutton() throws IOException, InterruptedException {
		node = test.createNode("C31 -  Can you see an appropriate icon for Shop?");
		extent.attachReporter(spark);
		new HomePage_5HeaderMyicivicsMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifylogin().VerifyShopbutton();
	}
	// C32 - When you select Shop, are you directed to
	// https://icivics.myshopify.com/?

	@Test(priority = 3)
	public void C32_Verifyshopbuttonclick() throws IOException, InterruptedException {
		node = test.createNode("C32 -  When you select Shop, are you directed to https://icivics.myshopify.com/?");
		extent.attachReporter(spark);
		new HomePage_5HeaderMyicivicsMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifylogin().VerifyShopbuttonclick();
	}

	// C34 - If you are signed in, do you see a My iCivics button instead of Sign
	// In?

	@Test(priority = 4)
	public void C34_VerifyIcivicsbutton() throws IOException, InterruptedException {
		node = test.createNode("C34 - If you are signed in, do you see a My iCivics button instead of Sign In?");
		extent.attachReporter(spark);
		new HomePage_5HeaderMyicivicsMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifylogin()
				.verifymyicvicsbuttonafterlogin();
	}

	// C35 - Can you see your avatar icon represented in the button?

	@Test(priority = 5)
	public void C35_Verifytheavatar() throws IOException, InterruptedException {
		node = test.createNode("C35 - Can you see your avatar icon represented in the button?");
		extent.attachReporter(spark);
		new HomePage_5HeaderMyicivicsMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifylogin().verifywithavatar();
	}

	// C35 - Can you see your avatar icon represented in the button?

	@Test(priority = 6)
	public void C35_Verifythenoavatar() throws IOException, InterruptedException {
		node = test.createNode("C35 - Can you see your avatar icon represented in the button?");
		extent.attachReporter(spark);
		new HomePage_5HeaderMyicivicsMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithnoavatar();
	}

	// C36 - When you select Sign In/My iCivics, does a submenu open below the
	// button?

	@Test(priority = 7)
	public void C36_VerifyIcivicssubmenu() throws IOException, InterruptedException {
		node = test.createNode("C36 - When you select Sign In/My iCivics, does a submenu open below the button?");
		extent.attachReporter(spark);
		new HomePage_5HeaderMyicivicsMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifylogin()
				.verifymyicvicsbuttonsubmenu();
	}
	// C37 - When you select Sign In, do you see links to Sign In, Register As a
	// Student, Register As A Teacher in the submenu?

	@Test(priority = 8)
	public void C37_VerifyIcivicssubmenu() throws IOException, InterruptedException {
		node = test.createNode(
				"C37 - When you select Sign In, do you see links to Sign In, Register As a Student, Register As A Teacher in the submenu?");
		extent.attachReporter(spark);
		new HomePage_5HeaderMyicivicsMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifylogin()
				.verifymyicivicssubmenulist();
	}
	// C39 - When you select a link in the submenu, are you navigated to the
	// appropriate page?

	@Test(priority = 9)
	public void C39_Myicivicsbuttonelementsverification() throws IOException, InterruptedException {
		node = test
				.createNode("C39 -When you select a link in the submenu, are you navigated to the appropriate page?");
		extent.attachReporter(spark);
		new HomePage_5HeaderMyicivicsMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifylogin()
				.Myicivicsbuttonelementsverification();
	}
	// C41 - If you are viewing one of the pages in the Sign In/My iCivics submenu,
	// is that page underlined in the submenu?

	@Test(priority = 10)
	public void C41_verifyselectpageisunderlined() throws IOException, InterruptedException {
		node = test.createNode(
				"C41 -If you are viewing one of the pages in the Sign In/My iCivics submenu, is that page underlined in the submenu?");
		extent.attachReporter(spark);
		new HomePage_5HeaderMyicivicsMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifylogin()
				.verifymyicvicsbuttonsubmenu().verifyselectedmyicivicsunderlined().verifyselectedmyclassesunderlined()
				.verifyselectedmyfavoritesunderlined().Clickonmyicivicsbuttonagain();

	}
	// C42 - When you select Sign In / My iCivics again while the submenu is open,
	// does the submenu close?

	@Test(priority = 11)
	public void C42_Verifymyicivicsbuttonsubmenuclose() throws IOException, InterruptedException {
		node = test.createNode(
				"C42 - When you select Sign In / My iCivics again while the submenu is open, does the submenu close?");
		extent.attachReporter(spark);
		new HomePage_5HeaderMyicivicsMisc(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifylogin()
				.Clickonmyicivicsbuttonagain();
	}
}
