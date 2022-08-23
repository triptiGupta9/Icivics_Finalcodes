package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.AgrumentsWar;

import projectSpecific.base.ProjectSpecificMethods;

public class ArgumentsWar_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "ArgumentsWar";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_GoogleIntegration";
	}

	// C81 - Link to Leaderboard and Achievements

	@Test(priority = 0)
	public void C81_Verifylink() throws IOException, InterruptedException {
		node = test.createNode("C81 - Link to Leaderboard and Achievements");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifylink();
	}
	// C82 - Leaderboard and Achievements

	@Test(priority = 1)
	public void C82_Verifypopup() throws IOException, InterruptedException {
		node = test.createNode("C82 - Leaderboard and Achievements");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifylinkpopup();
	}

	// C83 - Game load
	@Test(priority = 2)
	public void C83_Verifygameload() throws IOException, InterruptedException {
		node = test.createNode("C83 - Game load");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyload();
	}
	// C84 - Educator buttons

	@Test(priority = 3)
	public void C84_Verifyeducatorbutton() throws IOException, InterruptedException {
		node = test.createNode("C84 - Educator buttons");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifydownloadteacherresourcesandassignbuttons();
	}
	// C85 - Educator buttons

	@Test(priority = 4)
	public void C85_Verifyeducatorbuttonforstudent() throws IOException, InterruptedException {
		node = test.createNode("C85 - Educator buttons");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifydownloadteacherresourcesandassignbuttonsforstudent();
	}
	// C86 - Download teacher resources

	@Test(priority = 5)
	public void C86_Verifyteacherresourcespopup() throws IOException, InterruptedException {
		node = test.createNode("C86 - Download teacher resources");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifydownloadteacherresourcesandassignclick();
	}
	// C87 - Assign button - no classes

	@Test(priority = 6)
	public void C87_Verifyassignpopup() throws IOException, InterruptedException {
		node = test.createNode("C87 - Assign button - no classes");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyassignpopup();
	}
	// C88 - Assign button

	@Test(priority = 7)
	public void C88_Verifyassignform() throws IOException, InterruptedException {
		node = test.createNode("C88 - Assign button");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyassignform();
	}
	// C89 - Apple app store button

	@Test(priority = 8)
	public void C89_Verifyappleapp() throws IOException, InterruptedException {
		node = test.createNode("C89 - Apple app store button");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyappleapp();
	}

	// C90 - Link to Apple app store
	@Test(priority = 9)
	public void C90_Verifyappleapppage() throws IOException, InterruptedException {
		node = test.createNode("C90 - Link to Apple app store");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyappleapppage();
	}
	// C91 - Google play store button

	@Test(priority = 10)
	public void C91_Verifygoogleplaybutton() throws IOException, InterruptedException {
		node = test.createNode("C91 - Google play store button");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifygoogleplaybutton();
	}
	// C93 - Extension pack section

	@Test(priority = 11)
	public void C93_Verifyextensionpack() throws IOException, InterruptedException {
		node = test.createNode("C93 - Extension pack section");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL().verifyextensionpacklink();
	}

	// C93 - Extension pack section

	@Test(priority = 12)
	public void C93_Verifyextensionpackforsortifygame() throws IOException, InterruptedException {
		node = test.createNode("C93 - Extension pack section");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifyextensionpacklinkforsortifygame();
	}
	// C94 - Extension pack section

	@Test(priority = 13)
	public void C94_Verifyextensionpackforanonymoususere() throws IOException, InterruptedException {
		node = test.createNode("C94 - Extension pack section");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifyextensionpacklinkforanonymoususer();
	}
	// C94 - Extension pack section

	@Test(priority = 14)
	public void C94_Verifyextensionpackforstudent() throws IOException, InterruptedException {
		node = test.createNode("C94 - Extension pack section");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifyextensionpacklinkforastudent();
	}
	// C95 - Link to extension pack

	@Test(priority = 15)
	public void C95_Verifyextensionpackclick() throws IOException, InterruptedException {
		node = test.createNode("C95 - Link to extension pack");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifyextensionpacklinkclick();
	}
	// C96 - Learning objectives section

	@Test(priority = 16)
	public void C96_Verifylearningobjectives() throws IOException, InterruptedException {
		node = test.createNode("C96 - Learning objectives section");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifylearningobjectivessection();
	}
	// C97 - Extension pack section

	@Test(priority = 17)
	public void C97_Verifylearningobjectivesforanonymoususer() throws IOException, InterruptedException {
		node = test.createNode("C97 - Extension pack section");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifylearningobjectivessectionasananonymoususer();
	}

	// C97 - Extension pack section

	@Test(priority = 18)
	public void C97_Verifylearningobjectivesforstudent() throws IOException, InterruptedException {
		node = test.createNode("C97 - Extension pack section");
		extent.attachReporter(spark);
		new AgrumentsWar(driver, node, prop, Environment, StageURL, Stage1URL).launchURL()
				.verifylearningobjectivessectionasstudent();
	}

}
