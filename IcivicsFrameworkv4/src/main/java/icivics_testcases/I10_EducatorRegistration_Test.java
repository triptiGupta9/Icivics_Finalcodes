package icivics_testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import icivics_pages.EducatorRegistration;
import projectSpecific.base.ProjectSpecificMethods;

public class I10_EducatorRegistration_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration General";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	// C321 - Are all page elements consistent with those on Live?
	@Test(priority = 0)
	public void C321_VerifyallpageElements() throws IOException, InterruptedException {
		node = test.createNode("C321 - Are all page elements consistent with those on Live?");
		extent.attachReporter(spark);
		new EducatorRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyeducatorpage().pagecounter().username()
				.reloadbutton().firstname().lastname().Email().verifyEmail().nextbutton();
	}

	// C322 - Do all buttons have hover/click states consistent with Live?
	@Test(priority = 1)
	public void C322_ButtonHover() throws IOException, InterruptedException {
		node = test.createNode("C322 - Do all buttons have hover/click states consistent with Live?");
		extent.attachReporter(spark);
		new EducatorRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyeducatorpage().hoverplaybutton()
				.hoverteachbutton().hoveraboutbutton().Donatebutton().shopbutton().signinbutton().hoverfirstname()
				.hoverlastname().hoveremail().hoververifyemail().hovernextbutton();
	}

	// C323 - Do all buttons/links navigate you to the appropriate page?
	@Test(priority = 2)
	public void C323_Verifyallbuttonlinks() throws IOException, InterruptedException {
		node = test.createNode("C323 - Do all buttons/links navigate you to the appropriate page?");
		extent.attachReporter(spark);
		new EducatorRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyeducatorpage()
				.Playbuttonelementsverification().Teachbuttonelementsverification().aboutbuttonelementsverification();
	}

	// C324 - Does the page resize responsively at different resolutions?
	@Test(priority = 3)
	public void C324_WindowResize() throws IOException, InterruptedException {
		node = test.createNode("C324 - Does the page resize responsively at different resolutions?");
		extent.attachReporter(spark);
		new EducatorRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyeducatorpage().resizewindow();
	}

	// C325 - Is all copy correct?
	@Test(priority = 4)
	public void C325_Verifyerrormsg() throws IOException, InterruptedException {
		node = test.createNode("C325 - Is all copy correct??");
		extent.attachReporter(spark);
		new EducatorRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyeducatorpage().typos();
	}

	// C326 - Do you see a set of 5 numbered page breadcrumbs?
	@Test(priority = 5)
	public void C326_Verifybreadcrumbs() throws IOException, InterruptedException {
		node = test.createNode("C326 - Do you see a set of 5 numbered page breadcrumbs?");
		extent.attachReporter(spark);
		new EducatorRegistration(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyeducatorpage().pagebreadcrumbs();
	}

}
