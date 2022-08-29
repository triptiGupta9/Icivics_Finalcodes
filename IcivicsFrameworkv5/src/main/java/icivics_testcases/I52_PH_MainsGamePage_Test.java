package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.PH_MainsGamePage;
import projectSpecific.base.ProjectSpecificMethods;

public class I52_PH_MainsGamePage_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Mainsgamepage";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_GoogleIntegration";
	}

	// C539 - Game carousel

	@Test(priority = 0)
	public void C73_Verifymainsgamepage() throws IOException, InterruptedException {
		node = test.createNode("C73 - Game carousel");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifygamecarousel();
	}

	// C73 - Game carousel left arrow

	@Test(priority = 1)
	public void C73_Verifyleftcarousel() throws IOException, InterruptedException {
		node = test.createNode("C73 - Game carousel left arrow");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifyleftcarousel();
	}
	// C73 - Game carousel right arrow

	@Test(priority = 2)
	public void C73_Verifyrightcarousel() throws IOException, InterruptedException {
		node = test.createNode("C73 - Game carousel right arrow");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifyrightcarousel();
	}
	// C73 - Game carousel dots

	@Test(priority = 3)
	public void C73_Verifycarouseldots() throws IOException, InterruptedException {
		node = test.createNode("C73 - Game carousel dots");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifycarouseldots();
	}

	// C73 - Game carousel dots navigation

	@Test(priority = 4)
	public void C73_Verifycarouseldots3rdpage() throws IOException, InterruptedException {
		node = test.createNode("C73 - Game carousel dots navigation");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifycarouseldots3rdgame();
	}
	// C73 - Register banner not logged in

	@Test(priority = 5)
	public void C73_Verifybannerasananonymoususer() throws IOException, InterruptedException {
		node = test.createNode("C73 - Register banner not logged in");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.Verifyregisterasastudentbanner();
	}

	// C73 - Register banner logged in
	@Test(priority = 6)
	public void C73_Verifybannerasastudentlogin() throws IOException, InterruptedException {
		node = test.createNode("C73 - Register banner logged in");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL)
				.Verifyloginasastudentregisterasastudentbanner();
	}
	// C73 - Register banner logged in
	@Test(priority = 7)
	public void C73_Verifybannerasateacherlogin() throws IOException, InterruptedException {
		node = test.createNode("C73 - Register banner logged in");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).
		Verifyloginasteacherregisterasastudentbanner();
	}
	
	// C73 - Register banner button click

	@Test(priority = 8)
	public void C73_Verifyregisterbuttonclick() throws IOException, InterruptedException {
		node = test.createNode("C73 - Register banner button click");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.Verifylregisterbannerbuttonclick();
	}
	// C73 - Game tiles

	@Test(priority = 9)
	public void C73_VerifygamesTiles() throws IOException, InterruptedException {
		node = test.createNode("C73 - Game tiles");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifygamestitles();
	}
	// C73 - Click on game tile

	@Test(priority = 10)
	public void C73_VerifygamesTilesclick() throws IOException, InterruptedException {
		node = test.createNode("C73 - Click on game tile");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifygamestitlesclick();
	}
	// C73 - Teacher tile

	@Test(priority = 11)
	public void C73_Verifygreenteachertile() throws IOException, InterruptedException {
		node = test.createNode("C73 - Teacher tile");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.Verifygreentilewithteacherlink();
	}
	// C73 - Teacher tile teach button

	@Test(priority = 12)
	public void C73_Verifyteachbutton() throws IOException, InterruptedException {
		node = test.createNode("C73 - Teacher tile teach button");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().Verifyteachbuttonclick();
	}
	// C73 - Teacher tile

	@Test(priority = 13)
	public void C73_Verifygetstartedbutton() throws IOException, InterruptedException {
		node = test.createNode("C73 - Teacher tile");
		extent.attachReporter(spark);
		new PH_MainsGamePage(driver, node, prop, Environment, StageURL, Stage1URL).launchURL(). Verifygetstartedbuttonclick() ;
	}
}
