package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.GoogleIntegration_StudentRegistration;
import projectSpecific.base.ProjectSpecificMethods;

public class I45_GoogleIntegration_StudentRegistration_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Google Student Registration ";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_GoogleIntegration";
	}

	// C557 - Do you see field for Agree to Terms of Use/Privacy Policy?

	@Test(priority = 0)
	public void C557_Verifyagreetotermsandconditionfield() throws IOException, InterruptedException {
		node = test.createNode("C557- Do you see field for Agree to Terms of Use/Privacy Policy?");
		extent.attachReporter(spark);
		new GoogleIntegration_StudentRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().

				verifyregisterasstudent().verifyagreetotermsfield();
	}

	// C558 - If you do not check agree to terms of use, does it display an error
	// message

	@Test(priority = 1)
	public void C558_Verifyerrormsg() throws IOException, InterruptedException {
		node = test.createNode("C558-If you do not check agree to terms of use, does it display an error message");
		extent.attachReporter(spark);
		new GoogleIntegration_StudentRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifyregisterasstudent().verifyerrormsg();

	}
	// C559 -If you enter valid information, do not check sync classes, does it move
	// you to the next page

	@Test(priority = 2)
	public void C559_Verifyerrormsg() throws IOException, InterruptedException {
		node = test.createNode(
				"C559-If you enter valid information, do not check sync classes, does it move you to the next page");
		extent.attachReporter(spark);
		new GoogleIntegration_StudentRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifyregisterasstudent().verifysubmit().verifydeleteuserfrombackend();

	}
}
