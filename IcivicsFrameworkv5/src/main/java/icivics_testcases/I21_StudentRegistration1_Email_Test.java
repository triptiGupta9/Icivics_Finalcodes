package icivics_testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;

import icivics_pages.StudentRegistration1_Email;
import projectSpecific.base.ProjectSpecificMethods;

public class I21_StudentRegistration1_Email_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Student Registration Email";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Studentregistration1Email";
	}

	// C383 - Do you see a set of 3 numbered page breadcrumbs?
	@Test(priority = 0)
	public void C383_Verifybreadcrumbs() throws IOException, InterruptedException {
		node = test.createNode("C383 - Do you see a set of 3 numbered page breadcrumbs?");
		extent.attachReporter(spark);
		new StudentRegistration1_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifystudentpage().verifybreadcrumbs();
	}

	// C384 - Can you tell which page you are currently viewing in the breadcrumbs?
	@Test(priority = 1)
	public void C384_Verifybreadcrumbspage() throws IOException, InterruptedException {
		node = test.createNode("C384 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(spark);
		new StudentRegistration1_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifypagecount1();
	}

	// C385 - If you select the Watch our student registration help video link
	@Test(priority = 2)
	public void C385_Verifyvideolink() throws IOException, InterruptedException {
		node = test.createNode("C385 - If you select the Watch our student registration help video link");
		extent.attachReporter(spark);
		new StudentRegistration1_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyregistrationvideolink();
	}

	// C387 - Do you see fields for Username, First Name, Last Name, E-mail address,
	// and Verify email address?
	@Test(priority = 3)
	public void C387_verifytextfields() throws IOException, InterruptedException {
		node = test.createNode(
				"C387 - Do you see fields for Username, First Name, Last Name, E-mail address, and Verify email address?");
		extent.attachReporter(spark);
		new StudentRegistration1_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().Verifyusernametextfields()
				.Verifyfirstnamenametextfields().Verifylastnametextfields().Verifyemailtextfields()
				.Verifyemail2textfields();
	}

	// C388 - Is a username pre-generated when you arrive on the page?
	@Test(priority = 4)
	public void C388_verifyusernamepregenerated() throws IOException, InterruptedException {
		node = test.createNode("C388 - Is a username pre-generated when you arrive on the page?");
		extent.attachReporter(spark);
		new StudentRegistration1_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().usernamepregenerated();
	}

	// C389 - Can you select a button to randomly generate a new username in the
	// field?
	@Test(priority = 5)
	public void C389_verifyusernamepregeneratedrandomly() throws IOException, InterruptedException {
		node = test.createNode("C389 - Can you select a button to randomly generate a new username in the field?");
		extent.attachReporter(spark);
		new StudentRegistration1_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().usernamegeneratedrandomly();
	}

	// C390 - Can you enter text in every field?
	@Test(priority = 6)
	public void C390_verifyentertextinallfields() throws IOException, InterruptedException {
		node = test.createNode("C390 - Can you enter text in every field?");
		extent.attachReporter(spark);
		new StudentRegistration1_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().entertextinusernamefield()
				.entertextinfirstnamefield().entertextinlastnamefield().entertextinemailfield()
				.entertextinverifyemailfield();
	}

	// C391 - Are required fields marked with an asterisk?
	@Test(priority = 7)
	public void C391_verifyfieldsmarkedwithanasterisk() throws IOException, InterruptedException {
		node = test.createNode("C391 - Are required fields marked with an asterisk?");
		extent.attachReporter(spark);
		new StudentRegistration1_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().usernameAsteriks().firstnameAsteriks()
				.lastnameAsteriks().emailAsteriks().verifyemailAsteriks();
	}

	// C392 - If you hover over the email/verify email address fields, do you see a
	// hover tooltip with appropriate text?
	@Test(priority = 8)
	public void C392_verifyemailtooltips() throws IOException, InterruptedException {
		node = test.createNode(
				"C392 - If you hover over the email/verify email address fields, do you see a hover tooltip with appropriate text?");
		extent.attachReporter(spark);
		new StudentRegistration1_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().hoveronemailfield().hoveronverifyemailfield();
	}

	// C393 - If you enter invalid information in a required field and select Next,
	// do you receive an appropriate error message?
	@Test(priority = 9)
	public void C393_verifyemailerrormsg() throws IOException, InterruptedException {
		node = test.createNode(
				"C393 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new StudentRegistration1_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().Enterinvalidfirstname().Enterinvalidlastname()
				.Enterinvalidemailfield().Enterinvalidverifyemailfield().clicknextbutton()
				.verifyerrormsgforinvaliddatasubmit();
	}

	// C394 - If you leave a required field blank and select Next, do you receive an
	// appropriate error message?
	@Test(priority = 10)
	public void C394_verifyblankerrormsg() throws IOException, InterruptedException {
		node = test.createNode(
				"C394 - If you leave a required field blank and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new StudentRegistration1_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyerrormsgblankfieldall()
				.verifyerrormsgfirstnameblankfield().verifyerrormsglastnameblankfield().verifyerrormsgemailblankfield()
				.verifyerrormsgverifyemailblankfield();
	}

	// C396 - If you fill out all required fields with valid information and select
	// Next, are you taken to Page 2?
	@Test(priority = 11)
	public void C396_verifyvalidregistration() throws IOException, InterruptedException {
		node = test.createNode(
				"C396 - If you fill out all required fields with valid information and select Next, are you taken to Page 2?");
		extent.attachReporter(spark);
		new StudentRegistration1_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyregistrationwithvaliddata();
	}
	
	// C397 - Does classcode link lead to class code page
		@Test(priority = 12)
		public void C397_Verifyclasscodelink() throws IOException, InterruptedException {
			node = test.createNode("C397 - Does classcode link lead to class code page");
			extent.attachReporter(spark);
			new StudentRegistration1_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyclasscodelink();
		}
}
