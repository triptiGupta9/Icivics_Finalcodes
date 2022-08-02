package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.GoogleSignOn;
import projectSpecific.base.ProjectSpecificMethods;

public class I40_Googlesignon_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Google Sign On";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_GoogleIntegration";
	}

	// C539 - When you select Sign In With Google, are you asked to choose an
	// account?

	@Test(priority = 0)
	public void C539_Verifygooglesiginpage() throws IOException, InterruptedException {
		node = test.createNode("C539 - When you select Sign In With Google, are you asked to choose an account?");
		extent.attachReporter(spark);
		new GoogleSignOn(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifygoogleaccount();
	}
	// C540 - Select an account that is registered as a teacher #1

	@Test(priority = 1)
	public void C540_verifyentercredentails() throws IOException, InterruptedException {
		node = test.createNode("C540 -Select an account that is registered as a teacher #1");
		extent.attachReporter(spark);
		new GoogleSignOn(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyentercredentails();
	}
	// C541 - Select an account that is registered as a teacher #2

	@Test(priority = 2)
	public void C541_verifyentercredentails2() throws IOException, InterruptedException {
		node = test.createNode("C541 -Select an account that is registered as a teacher #2");
		extent.attachReporter(spark);
		new GoogleSignOn(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifyentercredentails2().verifyeducatorregistrationpagedisplay()
				.verifyenterfieldwithvaliddataforpage1().verifyenterfieldwithvaliddataforpage2()
				.verifyenterfieldwithvaliddataforpage3().launchURL().verifydeleteuserfrombackend2();

	}
	// C542 - Select an account that is registered as a student

	@Test(priority = 3)
	public void C542_verifyentercredentailsasstudent() throws IOException, InterruptedException {
		node = test.createNode("C542 -Select an account that is registered as a student");
		extent.attachReporter(spark);
		new GoogleSignOn(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyentercredentailsasStudent();
	}
	// C543 - Select an account that is not registered on iCivics

	@Test(priority = 4)
	public void C543_verifynotregisteredaccountforstudent() throws IOException, InterruptedException {
		node = test.createNode("C543 -Select an account that is not registered on iCivics");
		extent.attachReporter(spark);
		new GoogleSignOn(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifynotregisteredaccountforstudent().launchURL().verifydeleteuserfrombackend();
	}
}
