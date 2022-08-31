package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.StudentRegistration3_ClassCode;
import projectSpecific.base.ProjectSpecificMethods;

public class I24_StudentRegistration3_ClassCode_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Student Registration3 classcode";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Studentregistration3classcode";
	}

	// C454- Can you tell which page you are currently viewing in the breadcrumbs?

	@Test(priority = 0)
	public void C454_verifypagecount3() throws IOException, InterruptedException {
		node = test.createNode("C454 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(spark);
		new StudentRegistration3_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyregistrationwithvaliddata()
				.verifypagecount3();
	}
	// C455 - Do you see a notification that displays your generated username?

	@Test(priority = 1)
	public void C455_verifyusernamegenerateddisplay() throws IOException, InterruptedException {
		node = test.createNode("C455 -Do you see a notification that displays your generated username?");
		extent.attachReporter(spark);
		new StudentRegistration3_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyregistrationwithvaliddata()
				.verifyusernamegenerateddisplay();
	}
	// C456 - Do you see text that you will use your username and chosen password to
	// log in?

	@Test(priority = 2)
	public void C456_verifyusernametextddisplay() throws IOException, InterruptedException {
		node = test.createNode("C456 -Do you see text that you will use your username and chosen password to log in?");
		extent.attachReporter(spark);
		new StudentRegistration3_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyregistrationwithvaliddata()
				.verifyusernametextddisplay();
	}
	// C457 - If you entered an email address, do you see a notification that
	// displays your entered email address?

	@Test(priority = 3)
	public void C457_verifyemailddisplay() throws IOException, InterruptedException {
		node = test.createNode(
				"C457 -If you entered an email address, do you see a notification that displays your entered email address?");
		extent.attachReporter(spark);
		new StudentRegistration3_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyregistrationwithvaliddata()
				.verifyemailddisplay();
	}
	// C458 - If you entered an email address, do you see text that the email address can be used to log in?


	@Test(priority = 4)
	public void C458_verifyemailtextddisplay() throws IOException, InterruptedException {
		node = test.createNode(
				"C458 -If you entered an email address, do you see text that the email address can be used to log in?");
		extent.attachReporter(spark);
		new StudentRegistration3_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyregistrationwithvaliddata()
				.verifyemailtextddisplay();
	}
	// C459 - When you select 'Continue to my Assignments,' are you brought to your My iCivics page?



		@Test(priority = 5)
		public void C459_clickcontinuetomyassignmentbutton() throws IOException, InterruptedException {
			node = test.createNode(
					"C459 -When you select 'Continue to my Assignments,' are you brought to your My iCivics page?");
			extent.attachReporter(spark);
			new StudentRegistration3_ClassCode(driver, node, prop, Environment, StageURL, Stage1URL).launchstudentURL().verifyregistrationwithvaliddata()
					.clickcontinuetomyassignmentbutton();
		}

}
