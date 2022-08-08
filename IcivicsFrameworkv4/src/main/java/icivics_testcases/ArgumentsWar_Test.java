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

}
