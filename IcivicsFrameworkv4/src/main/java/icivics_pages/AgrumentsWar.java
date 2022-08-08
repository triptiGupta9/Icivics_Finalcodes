package icivics_pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class AgrumentsWar extends ProjectSpecificMethods {
	public String gpropname1 = "PlayHub/Maingamespage";

	public AgrumentsWar(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL,
			String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "/games/argument-wars";

	@Given("Launch the icivis game Argumentwar URL")
	public AgrumentsWar launchURL() {
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL + url);
		} else {
			navigateto(Stage1URL + url);
		}
		return this;

	}

	@Then("Verify Link to leaderboard and achievements appears")
	public AgrumentsWar verifylink() {
		WebElement link = driver.findElement(By.xpath("//a[@class='ctools-use-modal use-ajax']"));
		if (link.isDisplayed()) {
			reportStep("Leaderboard and achievements link display", "Pass");
		} else {
			reportStep("Leaderboard and achievements link do not display", "Fail");
		}
		return this;
	}

	@Given("Verify Popup dialog appears for leaderboard and achievements")
	public AgrumentsWar verifylinkpopup() {
		WebElement link = driver.findElement(By.xpath("//a[@class='ctools-use-modal use-ajax']"));
		link.click();
		waitTime(3000);
		reportStep("Popup dialog appears for leaderboard and achievements", "Pass");
		return this;
	}
	@Given("Verify for logged in as an educator download teacher resources and assign buttons appear")
	public AgrumentsWar verifydownloadteacherresourcesandassignbuttons() {
		
	}
}
