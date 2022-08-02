package icivics_testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import icivics_pages.EducatorRegistration1;
import projectSpecific.base.ProjectSpecificMethods;

public class I11_EducatorRegistration1_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration Page1";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	// C327 - Can you tell which page you are currently viewing in the breadcrumbs?
	@Test(priority = 0)
	public void C327_verifybreadcrumbspage1() throws IOException, InterruptedException {
		node = test.createNode("C327 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifypagecount1();
	}

	// C328 - Do you see fields for Username, First Name, Last Name, E-mail address, and Verify email address?
	@Test(priority = 1)
	public void C328_verifytextfields() throws IOException, InterruptedException {
		node = test.createNode("C328 - Do you see fields for Username, First Name, Last Name, E-mail address, and Verify email address?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifyusernametextfields()
				.Verifyfirstnamenametextfields().Verifylastnametextfields().Verifyemailtextfields()
				.Verifyemail2textfields();
	}

	// C329 - Is a username pre-generated when you arrive on the page?
	@Test(priority = 2)
	public void C329_verifyusernamepregenerated() throws IOException, InterruptedException {
		node = test.createNode("C329 - Is a username pre-generated when you arrive on the page?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().usernamepregenerated();
	}

	// C330 - Can you select a button to randomly generate a new username in the field?
	@Test(priority = 3)
	public void C330_verifyusernamepregeneratedrandomly() throws IOException, InterruptedException {
		node = test.createNode("C330 - Can you select a button to randomly generate a new username in the field?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().usernamegeneratedrandomly();
	}

	// C331 - Can you enter text in every field?
	@Test(priority = 4)
	public void C331_verifyentertextinallfields() throws IOException, InterruptedException {
		node = test.createNode("C331 - Can you enter text in every field?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().entertextinusernamefield()
				.entertextinfirstnamefield().entertextinlastnamefield().entertextinemailfield()
				.entertextinverifyemailfield();
	}

	// C332 - Are required fields marked with an asterisk?
	@Test(priority = 5)
	public void C332_verifyfieldsmarkedwithanasterisk() throws IOException, InterruptedException {
		node = test.createNode("C332 - Are required fields marked with an asterisk?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().usernameAsteriks().firstnameAsteriks()
				.lastnameAsteriks().emailAsteriks().verifyemailAsteriks();
	}

	// C333 - If you hover over the email/verify email address fields, do you see a hover tooltip with appropriate text?
	@Test(priority = 6)
	public void C333_verifyemailtooltips() throws IOException, InterruptedException {
		node = test.createNode("C333 - If you hover over the email/verify email address fields, do you see a hover tooltip with appropriate text?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop, Environment, StageURL, Stage1URL)
		.launchURL()
		.hoveronemailfield()
		.hoveronverifyemailfield();
	}
	
	// C334 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?
		@Test(priority = 7)
		public void C334_verifyemailerrormsg() throws IOException, InterruptedException {
			node = test.createNode("C334 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?");
			extent.attachReporter(spark);
			new EducatorRegistration1(driver, node, prop, Environment, StageURL, Stage1URL)
			.launchURL()
			.Enterinvalidfirstname()
			.Enterinvalidlastname()
			.Enterinvalidemailfield()
			.Enterinvalidverifyemailfield()
			.clicknextbutton()
			.verifyerrormsgforinvaliddatasubmit();
		}
		
	// C335 - If you leave a required field blank and select Next, do you receive an appropriate error message?
		@Test(priority = 8)
		public void C335_verifyblankerrormsg() throws IOException, InterruptedException {
			node = test.createNode("C335 - If you leave a required field blank and select Next, do you receive an appropriate error message?");
			extent.attachReporter(spark);
			new EducatorRegistration1(driver, node, prop, Environment, StageURL, Stage1URL)
			.launchURL()
			.verifyerrormsgblankfieldall()
			.verifyerrormsgfirstnameblankfield()
			.verifyerrormsglastnameblankfield()
			.verifyerrormsgemailblankfield()
			.verifyerrormsgverifyemailblankfield();
		}	
		
	//C336 - Do all error messages display correctly?	
		@Test(priority = 9)
		public void C336_verifyinvaliderrormsg() throws IOException, InterruptedException {
			node = test.createNode("C336 - Do all error messages display correctly?");
			extent.attachReporter(spark);
			new EducatorRegistration1(driver, node, prop, Environment, StageURL, Stage1URL)
			.launchURL()
			.verifyinvaliderrormsg();
		}	
		
	//C337 - If you fill out all required fields with valid information and select Next, are you taken to Page 2?
		@Test(priority = 10)
		public void C337_verifyvalidregistration() throws IOException, InterruptedException {
			node = test.createNode("C337 - If you fill out all required fields with valid information and select Next, are you taken to Page 2?");
			extent.attachReporter(spark);
			new EducatorRegistration1(driver, node, prop, Environment, StageURL, Stage1URL)
			.launchURL()
			.verifyregistrationwithvaliddata();
		}	
		
}