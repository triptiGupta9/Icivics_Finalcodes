package icivics_testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import icivics_pages.EducatorRegistration5;
import projectSpecific.base.ProjectSpecificMethods;

public class I15_EducatorRegistration5_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration Page5";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	// C372 - Can you tell which page you are currently viewing in the breadcrumbs?
	@Test(priority = 0)
	public void C372_verifybreadcrumbspage5() throws IOException, InterruptedException {
		node = test.createNode("C372 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(spark);
		new EducatorRegistration5(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().verifypagecount5();
	}

	// C373 - Do you see a notification that a welcome message has been sent to your email address?
	@Test(priority = 1)
	public void C373_verifywelcomemessage() throws IOException, InterruptedException {
		node = test.createNode(
				"C373 - Do you see a notification that a welcome message has been sent to your email address?");
		extent.attachReporter(spark);
		new EducatorRegistration5(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().verifycheckmsgdisplay();
	}

	// C374 - Do you see text that your confirmation email is on the way?
	@Test(priority = 2)
	public void C374_verifyconfirmationemail() throws IOException, InterruptedException {
		node = test.createNode("C374 - Do you see text that your confirmation email is on the way?");
		extent.attachReporter(spark);
		new EducatorRegistration5(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().verifyemailheaderlabel();
	}

	// C375 - Is your email displayed on the page?
	@Test(priority = 3)
	public void C375_verifyconfirmationemail() throws IOException, InterruptedException {
		node = test.createNode("C375 - Is your email displayed on the page?");
		extent.attachReporter(spark);
		new EducatorRegistration5(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata()
				.verifyregisteredemaildisplay();
	}

	// C376 - Can you select a button to resend your confirmation email?
	@Test(priority = 4)
	public void C376_verifyresendbutton() throws IOException, InterruptedException {
		node = test.createNode("C376 - Can you select a button to resend your confirmation email?");
		extent.attachReporter(spark);
		new EducatorRegistration5(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().verifyresendbutton();
	}

	// C377 - Do you see a notification when the email has been resent?
	@Test(priority = 5)
	public void C377_verifynotification() throws IOException, InterruptedException {
		node = test.createNode("C377 - Do you see a notification when the email has been resent?");
		extent.attachReporter(spark);
		new EducatorRegistration5(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifywithvaliddata().verifyconfirmationemail();
	}
}
