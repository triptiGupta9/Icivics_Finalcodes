package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Pg2TeacherRegistration;
import projectSpecific.base.ProjectSpecificMethods;

public class I43_Pg2TeacherRegistration_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Page2TeacherRegistration";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_GoogleIntegration";
	}

	// C545 - "Can you tell which page you are currently viewing in the
	// breadcrumbs?"

	@Test(priority = 0)
	public void C545_VerifyTeacherregistrationpage1() throws IOException, InterruptedException {
		node = test.createNode("C545 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage()
				.verifypagecount2();
	}

	// C546 - "Do you see fields for teaching state, school or institution, and zip
	// code?"

	@Test(priority = 1)
	public void C546_Verifypage2fields() throws IOException, InterruptedException {
		node = test.createNode("C546- Do you see fields for teaching state, school or institution, and zip code?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage()
				.verifypage2field();
	}
	// C546 - "Can you select Back to proceed to the previous page?"

	@Test(priority = 2)
	public void C546_Verifybackbutton() throws IOException, InterruptedException {
		node = test.createNode("C546- Can you select Back to proceed to the previous page?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage()
				.verifyclickonbackbutton();
	}

// C547 - "Can you make a selection for all fields?"

	@Test(priority = 3)
	public void C547_Verifyfieldselection() throws IOException, InterruptedException {
		node = test.createNode("C547- Can you make a selection for all fields?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage()
				.verifyteachingstateselection().verifyselectschoolfield().Verifyzipcodeerrormsg();
	}
	// C548 - "If you enter invalid information in a required field and select Next,
	// do you receive an appropriate error message?"

	@Test(priority = 4)
	public void C548_Verifyfieldswithinvaliddata() throws IOException, InterruptedException {
		node = test.createNode(
				"C548- If you enter invalid information in a required field and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage()
				.verifyenterinvaliddata();
	}
	// C549 - "If you leave a required field blank and select Next, do you receive
	// an appropriate error message?"

	@Test(priority = 5)
	public void C549_Verifyfieldswithinvaliddata() throws IOException, InterruptedException {
		node = test.createNode(
				"C549- If you leave a required field blank and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage()
				.verifyblankfield();
	}

	// C550 - "If you fill out all required fields with valid information and select
	// Next, are you taken to Page 3?"

	@Test(priority = 6)
	public void C550_Verifyfieldswithvaliddata() throws IOException, InterruptedException {
		node = test.createNode(
				"C550- If you fill out all required fields with valid information and select Next, are you taken to Page 3?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage()
				.verifyregistrationwithvaliddata().verifypage3loaded();
	}
}
