package icivics_testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import icivics_pages.EducatorRegistration4;
import projectSpecific.base.ProjectSpecificMethods;

public class I14_EducatorRegistration4_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration Page4";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	// C358 - Can you tell which page you are currently viewing in the breadcrumbs?
	@Test(priority = 0)
	public void C358_verifybreadcrumbspage4() throws IOException, InterruptedException {
		node = test.createNode("C358 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(spark);

		new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().verifypagecount4();
	}

	// C359 - Can you select Back to proceed to the previous page?
	@Test(priority = 1)
	public void C359_verifypreviouspage() throws IOException, InterruptedException {
		node = test.createNode("C359 - Can you select Back to proceed to the previous page?");
		extent.attachReporter(spark);
		new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().clickbackbutton();
	}

	// C360 - When you go Back, are your entries in all fields remembered?
	@Test(priority = 2)
	public void C360_verifyalldataremembered() throws IOException, InterruptedException {
		node = test.createNode("C360 - When you go Back, are your entries in all fields remembered?");
		extent.attachReporter(spark);
		new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().verifySchoolremembered()
				.verifyZipCoderemembered().verifyTeachingStateremembered();
	}
	
	// C361 - Do you see fields for Password, Confirm Password, Sign Up for Emails, and Agree to Terms of Use/Privacy Policy?
	@Test(priority = 3)
	public void C361_verifyallpage3fields() throws IOException, InterruptedException {
		node = test.createNode("C361 - Do you see fields for Password, Confirm Password, Sign Up for Emails, and Agree to Terms of Use/Privacy Policy?");
		extent.attachReporter(spark);
		new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL)
		.launchURL()
		.verifywithvaliddata()
		.verifypage4passwordfield()
		.verifypage4confirmpasswordfield()
		.verifypage4SignUpforEmailsfield()
		.verifypage4AgreetoTermsfield();
	}
	
		// C362 - Is the Sign Up for emails box checked by default?
		@Test(priority = 4)
		public void C362_verifySignUpischecked() throws IOException, InterruptedException {
			node = test.createNode("C362 - Is the Sign Up for emails box checked by default?");
			extent.attachReporter(spark);
			new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL)
			.launchURL()
			.verifywithvaliddata()
			.signupcheckbox();
		}
		
		// C363 - Can you enter text/make a selection for all fields?
		@Test(priority = 5)
		public void C363_verifyallpage4fields() throws IOException, InterruptedException {
			node = test.createNode("C363 - Can you enter text/make a selection for all fields?");
			extent.attachReporter(spark);
			new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL)
			.launchURL()
			.verifywithvaliddata()
			.VerifyPassword()
			.VerifyPasswordacceptweakpwd()
			.Verifyaccepttermschecked();
		}
		
		// C364 - Are required fields marked with an asterisk?
		@Test(priority = 6)
		public void C364_verifyallfieldasterisk() throws IOException, InterruptedException {
			node = test.createNode("C364 - Are required fields marked with an asterisk?");
			extent.attachReporter(spark);
			new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL)
			.launchURL()
			.verifywithvaliddata()
			.verifypasswordAsteriks()
			.verifyconfirmpasswordAsteriks();
		}	
		
		// C365 - If you hover over the password field, do you see a hover tooltip with appropriate text?
		@Test(priority = 7)
		public void C365_verifypasswordtooltips() throws IOException, InterruptedException {
			node = test.createNode("C365 - If you hover over the password field, do you see a hover tooltip with appropriate text?");
			extent.attachReporter(spark);
			new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL)
			.launchURL()
			.verifywithvaliddata()
			.hoveronpwdfield();
		}
		
		// C366 - When you enter text in the Password field, do you see text indicating the current password's strength?
				@Test(priority = 8)
				public void C366_verifypasswordstrengthIndicator() throws IOException, InterruptedException {
					node = test.createNode("C366 - When you enter text in the Password field, do you see text indicating the current password's strength?");
					extent.attachReporter(spark);
					new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL)
					.launchURL()
					.verifywithvaliddata()
					.VerifyPasswordstrengthmeter();
				}
				// C367 - When you enter text in the Confirm Password field do you see text indicating whether the two passwords match?
				@Test(priority = 9)
				public void C367_verifypasswordIndicatormatch() throws IOException, InterruptedException {
					node = test.createNode("C367 - When you enter text in the Confirm Password field do you see text indicating whether the two passwords match?");
					extent.attachReporter(spark);
					new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL)
					.launchURL()
					.verifywithvaliddata()
					.VerifyPasswordindicatormatch();
				}	
				
				// C368 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?
				@Test(priority = 10)
				public void C368_verifyallfieldswithinvaliddata() throws IOException, InterruptedException {
					node = test.createNode("C368 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?");
					extent.attachReporter(spark);
					new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL)
					.launchURL()
					.verifywithvaliddata()
					.verifyenterinvaliddata();
				}
				// C369 - If you leave a required field blank and select Next, do you receive an appropriate error message?
				@Test(priority = 11)
				public void C369_verifyallfieldswithblankdata() throws IOException, InterruptedException {
					node = test.createNode("C369 - If you leave a required field blank and select Next, do you receive an appropriate error message?");
					extent.attachReporter(spark);
					new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL)
					.launchURL()
					.verifywithvaliddata()
					.verifyblankerrormsg();
				}
				
				// C370 - Do all error messages display correctly?
				@Test(priority = 12)
				public void C370_verifyallfieldswithblankandinvaliddata() throws IOException, InterruptedException {
					node = test.createNode("C370 - Do all error messages display correctly?");
					extent.attachReporter(spark);
					new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL)
					.launchURL()
					.verifywithvaliddata()
					.verifyenterinvaliddataerror();
				}
				
				// C371 - If you fill out all required fields with valid information and select Finish, are you taken to Page 5?
				@Test(priority = 13)
				public void C371_verifyvalidsubmission() throws IOException, InterruptedException {
					node = test.createNode("C371 - If you fill out all required fields with valid information and select Finish, are you taken to Page 5?");
					extent.attachReporter(spark);
					new EducatorRegistration4(driver, node, prop, Environment, StageURL, Stage1URL)
					.launchURL()
					.verifywithvaliddata()
					.verifyregistrationwithvaliddata()
					.verifypage5loaded();
				}
}
