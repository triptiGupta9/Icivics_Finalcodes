package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Pg1TeacherRegistration;
import projectSpecific.base.ProjectSpecificMethods;

public class I42_Pg1TeacherRegistration_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Page1TeacherRegistration";
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
		new Pg1TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifydeleteuserfrombackend().launchURL()
				.Registrationpage().verifypagecount1();
	}
	// C546 - "Do you see fields for Role and Grade Level?"

	@Test(priority = 1)
	public void C546_Verifyroleandgradefield() throws IOException, InterruptedException {
		node = test.createNode("C546 - Do you see fields for Role and Grade Level?");
		extent.attachReporter(spark);
		new Pg1TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage().verifygradelevelfield()
				.verifygradelevelfieldisselected().verifyrolefieldoptions();
	}
	// C547 - "Can you make a selection for all fields?"

	@Test(priority = 2)
	public void C547_Verifyroleandgradefield() throws IOException, InterruptedException {
		node = test.createNode("C547 - Can you make a selection for all fields?");
		extent.attachReporter(spark);
		new Pg1TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage().verifygradelevelselection()
				.verifyroledropdownselection();
	}
	// C548 - "If you leave a no checks for grade level and select Next, do you
	// receive an appropriate error message?"

	@Test(priority = 3)
	public void C548_Verifyleavegradeboxesunchecked() throws IOException, InterruptedException {
		node = test.createNode(
				"C548 - If you leave a no checks for grade level and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new Pg1TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage()
				.verifyleavegradelevelboxesunchecked();
	}
	// C549 - "If you leave role none selected and select Next, do you receive an
	// appropriate error message?"

	@Test(priority = 4)
	public void C549_Verifyleaverolenoneselected() throws IOException, InterruptedException {
		node = test.createNode(
				"C548 -If you leave role none selected and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new Pg1TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage().verifyleaverolenoneselected();
	}
	// C550 - "If you fill out all required fields with valid information and select
	// Next, are you taken to Page 2?"

	@Test(priority = 5)
	public void C550_Verifyenterwithvaliddata() throws IOException, InterruptedException {
		node = test.createNode(
				"C550 -If you fill out all required fields with valid information and select Next, are you taken to Page 2?");
		extent.attachReporter(spark);
		new Pg1TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage().verifyentervaliddata();
	}
}
