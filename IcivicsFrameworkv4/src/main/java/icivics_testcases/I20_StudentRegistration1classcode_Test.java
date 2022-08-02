package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.StudentRegistration1classcode;
import projectSpecific.base.ProjectSpecificMethods;

public class I20_StudentRegistration1classcode_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Student Registration classcode";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Studentregistration1classcode";
	}

	// C425 - Do 'Email address' and 'Verify email address' fields appear if you
	// select the 'Optional: Click here to enter your email address' button?

	@Test(priority = 0)
	public void C425_verifyemailfieldsappear() throws IOException, InterruptedException {
		node = test.createNode(
				"C425 - Do 'Email address' and 'Verify email address' fields appear if you select the 'Optional: Click here to enter your email address' button?");
		extent.attachReporter(spark);
		new StudentRegistration1classcode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyOptionallink();
	}

	// C426 -If you hover over the email/verify email address fields, do you see a
	// hover tooltip with appropriate text?
	@Test(priority = 1)
	public void C426_verifyemailtooltips() throws IOException, InterruptedException {
		node = test.createNode(
				"C426 - If you hover over the email/verify email address fields, do you see a hover tooltip with appropriate text?");
		extent.attachReporter(spark);
		new StudentRegistration1classcode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().hoveronemailfield()
				.hoveronverifyemailfield();
	}

	// C427 -Do the 'Email address' and 'Verify email address' fields disappear if
	// you select the 'Click here to remove the email address' button?
	@Test(priority = 2)
	public void C427_verifyemailfieldsdisappear() throws IOException, InterruptedException {
		node = test.createNode(
				"C427 - Do the 'Email address' and 'Verify email address' fields disappear if you select the 'Click here to remove the email address' button?");
		extent.attachReporter(spark);
		new StudentRegistration1classcode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().clickonremovelink();
	}
	// C428 -Is a username pre-generated when you arrive on the page?

	@Test(priority = 3)
	public void C428_verifyusernamepregenerated() throws IOException, InterruptedException {
		node = test.createNode("C428 - Is a username pre-generated when you arrive on the page");
		extent.attachReporter(spark);
		new StudentRegistration1classcode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().usernamepregenerated();
	}

	// C429 -Can you select a button to randomly generate a new username in the
	// field?

	@Test(priority = 4)
	public void C429_usernamegeneratedrandomly() throws IOException, InterruptedException {
		node = test.createNode("C429 - Can you select a button to randomly generate a new username in the field?");
		extent.attachReporter(spark);
		new StudentRegistration1classcode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().usernamegeneratedrandomly();
	}

	// C430 -Can you enter text in every field?

	@Test(priority = 5)
	public void C430_verifyregistrationwithvaliddata() throws IOException, InterruptedException {
		node = test.createNode("C430 - Can you enter text in every field?");
		extent.attachReporter(spark);
		new StudentRegistration1classcode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().clickOptionallink()
				.entertextinusernamefield().entertextinclasscodefield().entertextinfirstnamefield()
				.entertextinlastnamefield().entertextinemailfield().entertextinverifyemailfield().clicknext();
	}

	// C431 -Are required fields marked with an asterisk?

	@Test(priority = 6)
	public void C431_verifyAsteriks() throws IOException, InterruptedException {
		node = test.createNode("C431 -Are required fields marked with an asterisk?");
		extent.attachReporter(spark);
		new StudentRegistration1classcode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().clickOptionallink()
				.usernameAsteriks().classcodeAsteriks().firstnameAsteriks().lastnameAsteriks().emailAsteriks()
				.verifyemailAsteriks();
	}
	// C432 -If you enter invalid information in a required field and select Next,
	// do you receive an appropriate error message?

	@Test(priority = 7)
	public void C432_verifyinvaliderrormsg() throws IOException, InterruptedException {
		node = test.createNode(
				"C432 -If you enter invalid information in a required field and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new StudentRegistration1classcode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyinvaliderrormsg();
	}

	// C433 -If you leave a required field blank and select Next, do you receive an
	// appropriate error message?

	@Test(priority = 8)
	public void C433_verifyerrormsgverifyemailblankfield() throws IOException, InterruptedException {
		node = test.createNode(
				"C433 -If you leave a required field blank and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new StudentRegistration1classcode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyerrormsgblankfieldall()
				.verifyerrormsgclasscodeblankfield().verifyerrormsgfirstnameblankfield()
				.verifyerrormsglastnameblankfield().verifyerrormsgemailblankfield()
				.verifyerrormsgverifyemailblankfield();
	}
	// C434 -Do all error messages display correctly?

	@Test(priority = 9)
	public void C434_verifyinvaliderrormsg2() throws IOException, InterruptedException {
		node = test.createNode("C434 -Do all error messages display correctly?");
		extent.attachReporter(spark);
		new StudentRegistration1classcode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyinvaliderrormsg2();
	}

	// C435 -If you fill out all required fields with valid information and select
	// Next, are you taken to Page 2?

	@Test(priority = 10)
	public void C435_verifyregistrationwithvalidvalue() throws IOException, InterruptedException {
		node = test.createNode(
				"C435 -If you fill out all required fields with valid information and select Next, are you taken to Page 2?");
		extent.attachReporter(spark);
		new StudentRegistration1classcode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyregistrationwithvalidvalue();
	}
}
