package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.HP_1TeacherHeader;
import projectSpecific.base.ProjectSpecificMethods;

public class I31_HP_1TeacherHeader_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Homepage TeacherHeader";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageteacherheader";
	}

	// C3 - While on all other pages, do you see buttons for Play, Teach, About,
	// Donate, Shop, and My iCivics in the navigation bar?

	@Test(priority = 0)
	public void C3_Verifyheaderbuttonsforanonymoususer() throws IOException, InterruptedException {
		node = test.createNode(
				"C3 - While on all other pages, do you see buttons for Play, Teach, About, Donate, Shop, and My iCivics in the navigation bar?(for anonymous user)");
		extent.attachReporter(spark);
		new HP_1TeacherHeader(driver, node, prop, Environment, StageURL, Stage1URL).launchteacherpageURL().playbutton().Teachbutton()
				.aboutbutton().donatebutton().shopbutton().Verifymyicivicsbuttondisplayafterlogin();
	}
	// C3 - While on all other pages, do you see buttons for Play, Teach, About,
	// Donate, Shop, and My iCivics in the navigation bar?

	@Test(priority = 1)
	public void C3_Verifyheaderbuttonsforauthenticateduser() throws IOException, InterruptedException {
		node = test.createNode(
				"C3 - While on all other pages, do you see buttons for Play, Teach, About, Donate, Shop, and My iCivics in the navigation bar?for authenticated user");
		extent.attachReporter(spark);
		new HP_1TeacherHeader(driver, node, prop, Environment, StageURL, Stage1URL).launchteacherpageURL().signin2()
				.Verifyheaderbuttonsafterlogin();
	}
	// C4 - Are all header elements consistent with those in the mockups?(Need to
	// take one content from each content type)

	@Test(priority = 2)
	public void C4_Verifyheaderelemets() throws IOException, InterruptedException {
		node = test.createNode(
				"C4 - Are all header elements consistent with those in the mockups?(Need to take one content from each content type");
		extent.attachReporter(spark);
		new HP_1TeacherHeader(driver, node, prop, Environment, StageURL, Stage1URL).launchteacherpageURL().verifyblogcontenttype()
				.VerifyLogo().playbutton().Teachbutton().aboutbutton().donatebutton().shopbutton().verifysigninbutton()
				.launchteacherpageURL().verifycurriculumcontenttype().VerifyLogo().playbutton().Teachbutton()
				.aboutbutton().donatebutton().shopbutton().verifysigninbutton().launchteacherpageURL()
				.verifydbquestcontenttype().VerifyLogo().playbutton().Teachbutton().aboutbutton().donatebutton()
				.shopbutton().verifysigninbutton().launchteacherpageURL().verifygamecontenttype().VerifyLogo()
				.playbutton().Teachbutton().aboutbutton().donatebutton().shopbutton().verifysigninbutton()
				.launchteacherpageURL().verifylessonplaycontenttype().VerifyLogo().playbutton().Teachbutton()
				.aboutbutton().donatebutton().shopbutton().verifysigninbutton().launchteacherpageURL()
				.verifyprofessionaldeveopmentcontenttype().VerifyLogo().playbutton().Teachbutton().aboutbutton()
				.donatebutton().shopbutton().verifysigninbutton().launchteacherpageURL().verifyvideocontenttype()
				.VerifyLogo().playbutton().Teachbutton().aboutbutton().donatebutton().shopbutton().verifysigninbutton()
				.launchteacherpageURL().verifyWebquestcontenttype().VerifyLogo().playbutton().Teachbutton()
				.aboutbutton().donatebutton().shopbutton().verifysigninbutton();
	}
	// C6 - Do all buttons have hover/click states?

	@Test(priority = 3)
	public void C6_Verifyheaderbuttonhoverforanonymoususer() throws IOException, InterruptedException {
		node = test.createNode("C6 - Do all buttons have hover/click states?for anonymous user");
		extent.attachReporter(spark);
		new HP_1TeacherHeader(driver, node, prop, Environment, StageURL, Stage1URL).launchteacherpageURL().verifyplaybuttonhover()
				.verifyteachbuttonhover().verifyaboutbuttonhover().verifydonatebuttonhover().launchteacherpageURL()
				.verifyshopbuttonhover().launchteacherpageURL().verifysigninbuttonhover().signin2()
				.verifymyicvicsbuttonhover();
	}

	// C6 - Do all buttons have hover/click states?

	@Test(priority = 4)
	public void C6_verifyaheaderbuttonhoverforauthenticateduser() {
		node = test.createNode("C6 - Do all buttons have hover/click states?for authenticated user");
		extent.attachReporter(spark);
		new HP_1TeacherHeader(driver, node, prop, Environment, StageURL, Stage1URL).launchteacherpageURL().signin2()
				.verifyplaybuttonhover().verifyteachbuttonhover().verifyaboutbuttonhover().verifydonatebuttonhover()
				.launchteacherpageURL().verifyshopbuttonhover2().launchteacherpageURL()
				.verifymyicvicsbuttonhover();
	}
	// C7 - Does the header resize responsively at different resolutions?

	@Test(priority = 5)
	public void C7_verifyresizeheaderintohamburger() throws IOException, InterruptedException {
		node = test.createNode("C7 - Does the header resize responsively at different resolutions?");
		extent.attachReporter(spark);

		new HP_1TeacherHeader(driver, node, prop, Environment, StageURL, Stage1URL).launchteacherpageURL().resizeheader()
				.carddisplayinlistpattern();
	}
}
