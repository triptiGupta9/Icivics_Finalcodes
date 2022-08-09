package icivics_testcases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import icivics_pages.EducatorRegistration3;
import projectSpecific.base.ProjectSpecificMethods;

public class I13_EducatorRegistration3_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration Page3";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	// C348 - Can you tell which page you are currently viewing in the breadcrumbs?
	@Test(priority = 0)
	public void C348_verifybreadcrumbspage3() throws IOException, InterruptedException {
		node = test.createNode("C348 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(spark);
		new EducatorRegistration3(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().verifypagecount3();
	}

	// C349 - Can you select Back to proceed to the previous page?
	@Test(priority = 1)
	public void C349_verifypreviouspage() throws IOException, InterruptedException {
		node = test.createNode("C349 - Can you select Back to proceed to the previous page?");
		extent.attachReporter(spark);
		new EducatorRegistration3(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().Clickbackbutton();
	}

	// C350 - When you go Back, are your entries in all fields remembered?
	@Test(priority = 2)
	public void C350_verifyalldataremembered() throws IOException, InterruptedException {
		node = test.createNode("C350 - When you go Back, are your entries in all fields remembered?");
		extent.attachReporter(spark);
		new EducatorRegistration3(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().verifygradelevelremembered()
				.verifyroleremembered();
	}

	// C351 - Do you see fields for School or Institution, Zip Code, and Teaching State?
	@Test(priority = 3)
	public void C351_verifyallpage3fields() throws IOException, InterruptedException {
		node = test.createNode("C351 - Do you see fields for School or Institution, Zip Code, and Teaching State?");
		extent.attachReporter(spark);
		new EducatorRegistration3(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().verifypage3schoolfield()
				.verifypage3zipcodefield().verifypage3TeachingStatefield().verifyteachstatedropdownoptions();
	}

	// C352 - Can you enter text/make a selection for all fields?
	@Test(priority = 4)
	public void C352_verifyallfieldsallowtoentertextandmakeselection()
			throws IOException, InterruptedException {
		node = test.createNode("C352 - Can you enter text/make a selection for all fields?");
		extent.attachReporter(spark);
		new EducatorRegistration3(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().VerifySchoolfield()
				.Verifyzipcodefield().VerifyTeachingstatefield().Verifyzipcodeerrormsg();
	}

	// C354 - If you enter invalid information in a required field and select Next,
	// do you receive an appropriate error message?
	@Test(priority = 5)
	public void C354_verifyallfieldswithinvaliddata() throws IOException, InterruptedException {
		node = test.createNode(
				"C354 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new EducatorRegistration3(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().verifyenterinvaliddata();
	}

	// C355 - If you leave a required field blank and select Next, do you receive an
	// appropriate error message?
	@Test(priority = 6)
	public void C355_verifyallfieldswithblankfield() throws IOException, InterruptedException {
		node = test.createNode(
				"C355 - If you leave a required field blank and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new EducatorRegistration3(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().verifyblankfielderrormsg();
	}

	// C357 - If you fill out all required fields with valid information and select
	// Next, are you taken to Page 4?
	@Test(priority = 7)
	public void C357_verifyvalidsubmission() throws IOException, InterruptedException {
		node = test.createNode(
				"C357 - If you fill out all required fields with valid information and select Next, are you taken to Page 4?");
		extent.attachReporter(spark);
		new EducatorRegistration3(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata()
				.verifyregistrationwithvaliddata().verifypage4loaded();
	}
}
