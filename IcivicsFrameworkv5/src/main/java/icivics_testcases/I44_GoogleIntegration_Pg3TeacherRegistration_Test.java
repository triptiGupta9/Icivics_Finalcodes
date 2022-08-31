package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.GoogleIntegration_Pg3TeacherRegistration;
import projectSpecific.base.ProjectSpecificMethods;

public class I44_GoogleIntegration_Pg3TeacherRegistration_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Page3TeacherRegistration";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_GoogleIntegration";
	}

	// C551- "Can you tell which page you are currently viewing in the breadcrumbs?"

	@Test(priority = 0)
	public void C551_Verifypagecount3() throws IOException, InterruptedException {
		node = test.createNode("C551 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(spark);
		new GoogleIntegration_Pg3TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage1().verifypagecount3();
	}

	// C552- "Do you see fields for Sign Up for Emails, Agree to Terms of
	// Use/Privacy Policy, and Sync Google Classroom courses?"

	@Test(priority = 1)
	public void C552_Verifypage3fields() throws IOException, InterruptedException {
		node = test.createNode(
				"C552 - Do you see fields for Sign Up for Emails, Agree to Terms of Use/Privacy Policy, and Sync Google Classroom courses?");
		extent.attachReporter(spark);
		new GoogleIntegration_Pg3TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage1().verifypage3fields();
	}
	// C553- "Can you select Back to proceed to the previous page?"

	@Test(priority = 2)
	public void C553_Verifybackbutton() throws IOException, InterruptedException {
		node = test.createNode("C553 - Can you select Back to proceed to the previous page?");
		extent.attachReporter(spark);
		new GoogleIntegration_Pg3TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage1().verifyclickbackbutton();
	}
	// C554- "If you do not check agree to terms of use, does it display an error
	// message"

	@Test(priority = 3)
	public void C554_Verifygettingstartedpagewithemailcheck1() throws IOException, InterruptedException {
		node = test.createNode("C554 - If you do not check agree to terms of use, does it display an error message");
		extent.attachReporter(spark);
		new GoogleIntegration_Pg3TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage1()
				.verifyunchecktermsofusecheckbox();
	}
	// C555- "If you enter valid information, do not check sync classes, does it
	// move you to the next page"

	@Test(priority = 4)
	public void C555_Verifygettingstartedpagewithemailcheck() throws IOException, InterruptedException {
		node = test.createNode(
				"C555 - If you enter valid information, do not check sync classes, does it move you to the next page");
		extent.attachReporter(spark);
		new GoogleIntegration_Pg3TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Registrationpage1()
				.verifygettingstartedpagewithemailcheck();
	}
	// C555- "If you enter valid information, do not check sync classes, does it
	// move you to the next page"

	@Test(priority = 5)
	public void C555_Verifygettingstartedpagewithemailuncheck() throws IOException, InterruptedException {
		node = test.createNode(
				"C555 - If you enter valid information, do not check sync classes, does it move you to the next page");
		extent.attachReporter(spark);
		new GoogleIntegration_Pg3TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifydeleteuserfrombackend().launchURL()
				.Registrationpage1().verifygettingstartedpagewithemailuncheck();
	}

	// C556- "If you enter valid information, do check sync classes, does it move
	// you to the next page"

	@Test(priority = 6)
	public void C556_Verifysynccheckboxwithemailcheck() throws IOException, InterruptedException {
		node = test.createNode(
				"C556 - If you enter valid information, do check sync classes, does it move you to the next page");
		extent.attachReporter(spark);
		new GoogleIntegration_Pg3TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifydeleteuserfrombackend().launchURL().

				Registrationpage1().verifywithchecksyncclasses1();
	}
	// C556- "If you enter valid information, do check sync classes, does it move
	// you to the next page"

	@Test(priority = 7)
	public void C556_Verifysynccheckboxwithemailuncheck() throws IOException, InterruptedException {
		node = test.createNode(
				"C556 - If you enter valid information, do check sync classes, does it move you to the next page");
		extent.attachReporter(spark);
		new GoogleIntegration_Pg3TeacherRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifydeleteuserfrombackend().launchURL()
				.Registrationpage1().verifywithchecksyncclasses2();
	}
}
