package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.GoogleRegistration;

import projectSpecific.base.ProjectSpecificMethods;

public class I41_GoogleRegistration_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Google Registration";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_GoogleRegistration";
	}

	// C544 - "After Google sign-in with account not registered at iCivics
	// Select teacher registration"

	@Test(priority = 0)
	public void C544_Verifyeducatorregistrationpage1() throws IOException, InterruptedException {
		node = test.createNode(
				"C544 - After Google sign-in with account not registered at iCivics Select teacher registration");
		extent.attachReporter(spark);
		new GoogleRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyclickregisteraseducator();
	}
	// C545 - "Attempt to start registration process without being signed in with
	// Google"

	@Test(priority = 1)
	public void C545_Verifyregistrationwithoutsignin() throws IOException, InterruptedException {
		node = test.createNode("C545 - Attempt to start registration process without being signed in with Google");
		extent.attachReporter(spark);
		new GoogleRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyregistrationwithoutsignin();
	}
	// C546 - "Attempt to start registration process when already registered at
	// iCivics"

	@Test(priority = 2)
	public void C546_Verifyregistrationwithalreadyregisteredid() throws IOException, InterruptedException {
		node = test.createNode("C546 - Attempt to start registration process when already registered at iCivics");
		extent.attachReporter(spark);
		new GoogleRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyregistrationwithalreadyregisteredID();
	}
	// C544 - ""After Google sign-in with account not registered at iCivics
	// Select student registration"

	@Test(priority = 3)
	public void C544_Verifystudentregistrationpage1() throws IOException, InterruptedException {
		node = test.createNode(
				"C544 - After Google sign-in with account not registered at iCivics Select student registration");
		extent.attachReporter(spark);
		new GoogleRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyregisterasstudentclick();
	}
}
