package icivics_testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import icivics_pages.EducatorRegistration2;
import projectSpecific.base.ProjectSpecificMethods;

public class I12_EducatorRegistration2_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration Page2";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	// C338 - Can you tell which page you are currently viewing in the breadcrumbs?
		@Test(priority = 0)
		public void C338_verifybreadcrumbspage1() throws IOException, InterruptedException {
			node = test.createNode("C338 - Can you tell which page you are currently viewing in the breadcrumbs?");
			extent.attachReporter(spark);
			new EducatorRegistration2(driver, node, prop, Environment, StageURL, Stage1URL)
			.launchURL().verifywithvaliddata().verifypagecount2();
		}
		
		// C339 - Can you select Back to proceed to the previous page?
			@Test(priority = 1)
			public void C339_verifypreviouspage() throws IOException, InterruptedException {
				node = test.createNode("C339 - Can you select Back to proceed to the previous page?");
				extent.attachReporter(spark);
				new EducatorRegistration2(driver, node, prop, Environment, StageURL, Stage1URL)
				.launchURL()
				.verifywithvaliddata()
				.Clickbackbutton();
		}
			
		//C340 - When you go Back, are your entries in all fields remembered (but not the randomly generated username)?	
			@Test(priority = 2)
			public void C340_verifyalldataremembered() throws IOException, InterruptedException {
				node = test.createNode("C340 - When you go Back, are your entries in all fields remembered (but not the randomly generated username)?");
				extent.attachReporter(spark);
				new EducatorRegistration2(driver, node, prop, Environment, StageURL, Stage1URL)
				.launchURL()
				.verifywithvaliddata()
				.Clickbackbutton()
				.verifyusernameisnotremembered()
				.verifyfirstnameisremembered()
				.verifylastnameisremembered()
				.verifyemailisremembered()
				.verifyemail2isremembered();
		}	
			
		//C341 - Do you see fields for Role and Grade Level?	
			@Test(priority = 3)
			public void C341_verifyRoleandGradeLevel() throws IOException, InterruptedException {
				node = test.createNode("C341 - Do you see fields for Role and Grade Level?");
				extent.attachReporter(spark);
				new EducatorRegistration2(driver, node, prop, Environment, StageURL, Stage1URL)
				.launchURL()
				.verifywithvaliddata()
				.verifygradelevelfield()
				.verifygradelevelfieldisselected()
				.verifyrolefieldoptions();
		}	
			
		//C342 - Can you make a selection for all fields?	
			@Test(priority = 4)
			public void C342_verifymakeselection() throws IOException, InterruptedException {
				node = test.createNode("C342 - Can you make a selection for all fields?");
				extent.attachReporter(spark);
				new EducatorRegistration2(driver, node, prop, Environment, StageURL, Stage1URL)
				.launchURL()
				.verifywithvaliddata()
				.verifygradelevelselection()
				.verifyroledropdown();
		}	
			
		//C343 - If you select the Role 'Other' does an additional 'What is your role?' field appear?	
			@Test(priority = 5)
			public void C343_verifyotheradditionalfield() throws IOException, InterruptedException {
				node = test.createNode("C343 - If you select the Role 'Other' does an additional 'What is your role?' field appear?");
				extent.attachReporter(spark);
				new EducatorRegistration2(driver, node, prop, Environment, StageURL, Stage1URL)
				.launchURL()
				.verifywithvaliddata()
				.verifyotheradditionalfield();
		}		
			
		//C344 - Are required fields marked with an asterisk?	
			@Test(priority = 6)
			public void C344_verifyasterisk() throws IOException, InterruptedException {
				node = test.createNode("C344 - Are required fields marked with an asterisk?");
				extent.attachReporter(spark);
				new EducatorRegistration2(driver, node, prop, Environment, StageURL, Stage1URL)
				.launchURL()
				.verifywithvaliddata()
				.verifyGradeLevelAsteriks()
				.verifyRoleAsteriks()
				.verifyWhatisyourroleAsteriks();
		}	
			
		//C345 - If you leave a required field blank and select Next, do you receive an appropriate error message?
			@Test(priority = 7)
			public void C345_verifyblankerrormsg() throws IOException, InterruptedException {
				node = test.createNode("C345 - If you leave a required field blank and select Next, do you receive an appropriate error message?");
				extent.attachReporter(spark);
				new EducatorRegistration2(driver, node, prop, Environment, StageURL, Stage1URL)
				.launchURL()
				.verifywithvaliddata()
				.verifygradeandroleerrormsg()
				.verifygradeandwhatisyourroleerrormsg();
		}	
		
		// C346 - Do all error messages display correctly?
			@Test(priority = 8)
			public void C346_verifyerrormsgboxcolor() throws IOException, InterruptedException {
				node = test.createNode("C346 - Do all error messages display correctly?");
				extent.attachReporter(spark);
				new EducatorRegistration2(driver, node, prop, Environment, StageURL, Stage1URL)
				.launchURL()
				.verifywithvaliddata()
				.verifyerrormsgboxcolor();
		}	
			
		// C347 - If you fill out all required fields with valid information and select Next, are you taken to Page 3?
			@Test(priority = 9)
			public void C347_verifyvalidsubmission() throws IOException, InterruptedException {
				node = test.createNode("C347 - If you fill out all required fields with valid information and select Next, are you taken to Page 3?");
				extent.attachReporter(spark);
				new EducatorRegistration2(driver, node, prop, Environment, StageURL, Stage1URL)
				.launchURL()
				.verifywithvaliddata()
				.verifyregistrationwithvaliddata()
				.verifypage3loaded();
		}	
			
}