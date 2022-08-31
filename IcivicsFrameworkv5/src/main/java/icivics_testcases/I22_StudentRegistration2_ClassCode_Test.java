package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.StudentRegistration2_ClassCode;
import projectSpecific.base.ProjectSpecificMethods;

public class I22_StudentRegistration2_ClassCode_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Student Registration2 Classcode ";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Studentregistration2classcode";
	}

	// C398 - Can you tell which page you are currently viewing in the breadcrumbs?

	@Test(priority = 0)
	public void C398_verifypagecount2() throws IOException, InterruptedException {
		node = test.createNode("C398 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(spark);
		new StudentRegistration2_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL()
				.verifyregistrationwithvaliddata().verifypagecount2();
	}
	// C399 - Can you select Back to proceed to the previous page?

	@Test(priority = 1)
	public void C399_Clickbackbutton() throws IOException, InterruptedException {
		node = test.createNode("C399 - Can you select Back to proceed to the previous page?");
		extent.attachReporter(spark);
		new StudentRegistration2_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL()
				.verifyregistrationwithvaliddata().verifyClickbackbutton();
	}
	// C400 - When you go Back, are your entries in all fields remembered?

	@Test(priority = 2)
	public void C400_verifyfieldsisremembered() throws IOException, InterruptedException {
		node = test.createNode("C400 - When you go Back, are your entries in all fields remembered?");
		extent.attachReporter(spark);
		new StudentRegistration2_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL()
				.verifyregistrationwithvaliddata().Clickbackbutton().verifyclasscoderemembered()
				.verifyfirstnameremembered().verifylastnameremembered().verifyemailremembered()
				.verifyemailfieldremembered();
	}
	// C403- If you select the 'Terms of Use' link, does the iCivics Terms of Use
	// page open in a new tab?

	@Test(priority = 3)
	public void C403_clickontermsofuselink() throws IOException, InterruptedException {
		node = test.createNode(
				"C403- If you select the 'Terms of Use' link, does the iCivics Terms of Use page open in a new tab");
		extent.attachReporter(spark);
		new StudentRegistration2_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL()
				.verifyregistrationwithvaliddata().clickontermsofuselink();
	}
	// C404- If you select the 'Privacy Policy' link, does the iCivics Privacy
	// Policy page open in a new tab?

	@Test(priority = 4)
	public void C404_clickprivacypolicy() throws IOException, InterruptedException {
		node = test.createNode(
				"C404- If you select the 'Privacy Policy' link, does the iCivics Privacy Policy page open in a new tab?");
		extent.attachReporter(spark);
		new StudentRegistration2_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL()
				.verifyregistrationwithvaliddata().clickprivacypolicy();
	}
	// C405- As a student, are you NOT prompted to sign up for the newsletter?

	@Test(priority = 5)
	public void C405_verifypage2SignUpforEmailsfield() throws IOException, InterruptedException {
		node = test.createNode("C405- As a student, are you NOT prompted to sign up for the newsletter?");
		extent.attachReporter(spark);
		new StudentRegistration2_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL()
				.verifyregistrationwithvaliddata().verifypage2noemailsubscriptioncheckbox();
	}
	// C408- If you hover over the password field, do you see a hover tooltip with
	// appropriate text?

	@Test(priority = 6)
	public void C408_hoveronpwdfield() throws IOException, InterruptedException {
		node = test.createNode(
				"C408- If you hover over the password field, do you see a hover tooltip with appropriate text?");
		extent.attachReporter(spark);
		new StudentRegistration2_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL()
				.verifyregistrationwithvaliddata().hoveronpwdfield();
	}
	// C409- When you enter text in the Password field, do you see text indicating
	// the current password's strength?

	@Test(priority = 7)
	public void C409_VerifyPasswordstrengthmeter() throws IOException, InterruptedException {
		node = test.createNode(
				"C409- When you enter text in the Password field, do you see text indicating the current password's strength?");
		extent.attachReporter(spark);
		new StudentRegistration2_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL()
				.verifyregistrationwithvaliddata().VerifyPasswordstrengthmeter();
	}
	// C410- When you enter text in the Confirm Password field do you see text
	// indicating whether the two passwords match?

	@Test(priority = 8)
	public void C410_VerifyPasswordindicatormatch() throws IOException, InterruptedException {
		node = test.createNode(
				"C410- When you enter text in the Confirm Password field do you see text indicating whether the two passwords match?");
		extent.attachReporter(spark);
		new StudentRegistration2_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL()
				.verifyregistrationwithvaliddata().VerifyPasswordindicatormatch();
	}
	// C412- If you leave a required field blank and select Next, do you receive an
	// appropriate error message?

	@Test(priority = 9)
	public void C412_verifyenterinvaliddata() throws IOException, InterruptedException {
		node = test.createNode(
				"C412- If you leave a required field blank and select Next, do you receive an appropriate error message?");

		extent.attachReporter(spark);
		new StudentRegistration2_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL()
				.verifyregistrationwithvaliddata().verifyblankerrormsgforpwdandcpwd().verifyenterinvaliddataerror();
	}
	// C412- You must check terms of use and privacy

	@Test(priority = 10)
	public void C412_verifytermsofuseandprivacycheckbox() throws IOException, InterruptedException {
		node = test.createNode("C412- You must check terms of use and privacy");

		extent.attachReporter(spark);
		new StudentRegistration2_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL()
				.verifyregistrationwithvaliddata().verifytermsofuseandprivacycheckbox();
	}
	// C413- Do all error messages display correctly?

	@Test(priority = 11)
	public void C413_verifyblankerrormsg() throws IOException, InterruptedException {
		node = test.createNode("C413- Do all error messages display correctly?");

		extent.attachReporter(spark);
		new StudentRegistration2_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL()
				.verifyregistrationwithvaliddata().verifyblankerrormsg();
	}
	// C414- If you fill out all required fields with valid information and select
	// Finish, are you taken to Page 3?

	@Test(priority = 12)
	public void C414_verifypage3loaded() throws IOException, InterruptedException {
		node = test.createNode(
				"C414- If you fill out all required fields with valid information and select Finish, are you taken to Page 3?");

		extent.attachReporter(spark);
		new StudentRegistration2_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL()
				.verifyregistrationwithvaliddata().verifypage3loaded();
	}
}
