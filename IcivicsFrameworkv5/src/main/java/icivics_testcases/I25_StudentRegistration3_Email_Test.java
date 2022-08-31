package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.StudentRegistration3_Email;
import projectSpecific.base.ProjectSpecificMethods;

public class I25_StudentRegistration3_Email_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Student Registration3 Email id ";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Studentregistration2email";
	}

	// C372 - Can you tell which page you are currently viewing in the breadcrumbs?

	@Test(priority = 0)
	public void C372_verifypagecount3() throws IOException, InterruptedException {
		node = test.createNode("C372 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(spark);
		new StudentRegistration3_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifywithvaliddata().verifypagecount3();
	}
	// C373 - Do you see a notification that a welcome message has been sent to your
	// email address?

	@Test(priority = 1)
	public void C373_verifycheckmsgdisplay() throws IOException, InterruptedException {
		node = test.createNode(
				"C373 - Do you see a notification that a welcome message has been sent to your email address?");
		extent.attachReporter(spark);
		new StudentRegistration3_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifywithvaliddata()
				.verifycheckmsgdisplay();
	}
	// C374 - Do you see text that your confirmation email is on the way?

	@Test(priority = 2)
	public void C374_verifycheckmsgdisplay() throws IOException, InterruptedException {
		node = test.createNode("C374 - Do you see text that your confirmation email is on the way?");
		extent.attachReporter(spark);
		new StudentRegistration3_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifywithvaliddata()
				.verifyemailheaderlabel();
	}
	// C375 - Is your email displayed on the page?

	@Test(priority = 3)
	public void C375_verifyregisteredemaildisplay() throws IOException, InterruptedException {
		node = test.createNode("C375 - Is your email displayed on the page?");
		extent.attachReporter(spark);
		new StudentRegistration3_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifywithvaliddata()
				.verifyregisteredemaildisplay();
	}
	// C376 - Can you select a button to resend your confirmation email?

	@Test(priority = 4)
	public void C376_verifyresendbutton() throws IOException, InterruptedException {
		node = test.createNode("C376 - Can you select a button to resend your confirmation email?");
		extent.attachReporter(spark);
		new StudentRegistration3_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifywithvaliddata()
				.verifyresendbutton();
	}
	// C377 - Do you see a notification when the email has been resent?

	@Test(priority = 5)
	public void C377_verifyconfirmationemail() throws IOException, InterruptedException {
		node = test.createNode("C377 - Do you see a notification when the email has been resent?");
		extent.attachReporter(spark);
		new StudentRegistration3_Email(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifywithvaliddata()
				.verifyconfirmationemail();
	}
}
