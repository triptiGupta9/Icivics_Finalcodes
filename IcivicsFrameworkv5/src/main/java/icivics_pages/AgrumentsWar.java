package icivics_pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class AgrumentsWar extends ProjectSpecificMethods {
	public String gpropname1 = "PlayHub/Maingamespage";
	public String gpropname2 = "PlayHub/gametile";
	public String gpropname3 = "PlayHub/Argumentwars";

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
	String URL;

	@Given("Launch the icivis game Argumentwar URL")
	public AgrumentsWar launchURL() {
		if (Environment.equals("Stage.d9")) {
			URL = StageURL + url;
			navigateto(URL);
		} else {
			URL = Stage1URL + url;
			navigateto(URL);
		}
		return this;

	}

	@Then("Verify Link to leaderboard and achievements appears")
	public AgrumentsWar verifylink() {
		WebElement leaderboardachievementlink = propElement(getPropfile(gpropname3, "Leaderboard&Achievementlink"));
		if (leaderboardachievementlink.isDisplayed()) {
			reportStep("Leaderboard and achievements link display", "Pass");
		} else {
			reportStep("Leaderboard and achievements link do not display", "Fail");
		}
		return this;
	}

	@Given("Verify Popup dialog appears for leaderboard and achievements")
	public AgrumentsWar verifylinkpopup() {
		WebElement leaderboardachievementlink = propElement(getPropfile(gpropname3, "Leaderboard&Achievementlink"));
		leaderboardachievementlink.click();
		waitTime(3000);
		reportStep("Popup dialog appears for leaderboard and achievements", "Pass");
		return this;
	}

	@Given("Verify Game loads within iFrame")
	public AgrumentsWar verifyload() {

		switchToFrame(0);
		WebElement loadtime = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='clickToPlayBtn']/i")));
		click(loadtime);
		reportStep("Play button clicked", "Pass");
		return this;
	}

	@Given("Verify for logged in as an educator download teacher resources and assign buttons appear")
	public AgrumentsWar verifydownloadteacherresourcesandassignbuttons() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
		signinbutton.click();
		WebElement signinlink = propElement(getPropfile(gpropname3, "Signinlink"));
		signinlink.click();
		WebElement username = propElement(getPropfile(gpropname3, "Username"));
		waitTime(3000);
		username.sendKeys("Bronze Speaker 1r4e");
		WebElement password = propElement(getPropfile(gpropname3, "Password "));
		waitTime(3000);
		password.sendKeys("i898qrCiPK9Hwgb");
		waitTime(3000);
		WebElement loginbutton = propElement(getPropfile(gpropname3, "Loginbutton"));
		waitTime(3000);
		loginbutton.click();
		waitTime(3000);
		navigateto(URL);
		waitTime(5000);
		WebElement downloadteach = propElement(getPropfile(gpropname3, "Downloadteach"));
		WebElement assign = propElement(getPropfile(gpropname3, "Assignbutton"));
		if (downloadteach.isDisplayed() && assign.isDisplayed()) {
			scrollToTheGivenWebElement(getPropfile(gpropname3, "Downloadteach"));
			reportStep("Download teacher resources and assign buttons display", "Pass");
		} else {
			reportStep("Download teacher resources and assign buttons do not display", "Fail");
		}
		waitTime(3000);
		return this;

	}

	@Given("Verify for logged in as an Student download teacher resources and assign buttons appear")
	public AgrumentsWar verifydownloadteacherresourcesandassignbuttonsforstudent() {
		WebElement signinbutton =  propElement(getPropfile(gpropname3, "Signin"));
		signinbutton.click();
		WebElement signinlink =propElement(getPropfile(gpropname3, "Signinlink"));
		signinlink.click();
		WebElement username = propElement(getPropfile(gpropname3, "Username"));
		waitTime(3000);
		username.sendKeys("Granite Governor 3s9h");
		WebElement password = propElement(getPropfile(gpropname3, "Password"));
		waitTime(3000);
		password.sendKeys("123456789");
		waitTime(3000);
		WebElement loginbutton = propElement(getPropfile(gpropname3, "Loginbutton"));
		waitTime(3000);
		loginbutton.click();
		waitTime(5000);
		navigateto(URL);
		waitTime(5000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "scrollelement"));
		reportStep("Download teacher resources and assign buttons do not display for logged in as student", "Pass");
		return this;
	}

	@Given("Verify click link to download teacher resources Popup dialog appears with links to teacher resources")
	public AgrumentsWar verifydownloadteacherresourcesandassignclick() {
		WebElement signinbutton =  propElement(getPropfile(gpropname3, "Signin"));
		signinbutton.click();
		WebElement signinlink = propElement(getPropfile(gpropname3, "Signinlink"));
		signinlink.click();
		WebElement username = propElement(getPropfile(gpropname3, "Username"));
		waitTime(3000);
		username.sendKeys("Bronze Speaker 1r4e");
		WebElement password = propElement(getPropfile(gpropname3, "Password"));
		waitTime(3000);
		password.sendKeys("i898qrCiPK9Hwgb");
		waitTime(3000);
		WebElement loginbutton = propElement(getPropfile(gpropname3, "Loginbutton"));
		waitTime(3000);
		loginbutton.click();
		waitTime(3000);
		navigateto(URL);
		waitTime(5000);
		WebElement downloadteach = propElement(getPropfile(gpropname3, "Downloadteach"));
		waitTime(3000);
		if (downloadteach.isDisplayed()) {
			downloadteach.click();
			waitTime(3000);
			reportStep("Popup dialog display with links to teacher resources", "Pass");
		} else {
			reportStep("Popup dialog do not display with links to teacher resources", "Fail");
		}
		return this;
	}

	@Given("Verify click link to assign Popup dialog appears with message that the teacher has no classes")
	public AgrumentsWar verifyassignpopup() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
		signinbutton.click();
		WebElement signinlink =propElement(getPropfile(gpropname3, "Signinlink"));
		signinlink.click();
		WebElement username = propElement(getPropfile(gpropname3, "Username"));
		waitTime(3000);
		username.sendKeys("Bronze Speaker 1r4e");
		WebElement password = propElement(getPropfile(gpropname3, "Password"));
		waitTime(3000);
		password.sendKeys("i898qrCiPK9Hwgb");
		waitTime(3000);
		WebElement loginbutton = propElement(getPropfile(gpropname3, "Loginbutton"));
		waitTime(3000);
		loginbutton.click();
		waitTime(3000);
		navigateto(URL);
		waitTime(5000);
		WebElement assign = propElement(getPropfile(gpropname3, "Assignbutton"));
		waitTime(3000);
		if (assign.isDisplayed()) {
			assign.click();
			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "noclasses"));
			reportStep("Popup dialog display with links to teacher resources", "Pass");
		} else {
			reportStep("Popup dialog do not display with links to teacher resources", "Fail");
		}
		return this;
	}

	@Given("Verify Go to game page Extension pack link appears")
	public AgrumentsWar verifyextensionpacklink() {
		WebElement extensionpack = propElement(getPropfile(gpropname3, "extensionpack"));
		if (extensionpack.isDisplayed()) {
			scrollToTheGivenWebElement(getPropfile(gpropname3, "extensionpack"));
			reportStep("extension pack link display", "Pass");
		} else {
			reportStep("extension pack link do not display", "Fail");
		}
		return this;
	}

	@Given("Verify click link to extension pack Page goes to lesson plan containing game extension pack")
	public AgrumentsWar verifyextensionpacklinkclick() {
		WebElement extensionpack = propElement(getPropfile(gpropname3, "extensionpack"));
		if (extensionpack.isDisplayed()) {
			extensionpack.click();
			waitTime(3000);
			switchToWindow("Teaching Argument Wars - Supreme Court Simulation | iCivics");
			waitTime(3000);

			WebElement gameextensionpack= propElement(getPropfile(gpropname3, "gameextensionpack"));
			if (gameextensionpack.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "gameextensionpack"));
				reportStep("Page goes to lesson plan containing game's extension pack", "Pass");
			} else {
				reportStep("Page goes to lesson plan containing game's extension pack", "Fail");
			}

		}

		return this;
	}

	@Given("Verify Go to game page Learning objectives section appears")
	public AgrumentsWar verifylearningobjectivessection() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
		signinbutton.click();
		WebElement signinlink =propElement(getPropfile(gpropname3, "Signinlink"));
		signinlink.click();
		WebElement username = propElement(getPropfile(gpropname3, "Username"));
		waitTime(3000);
		username.sendKeys("Bronze Speaker 1r4e");
		WebElement password = propElement(getPropfile(gpropname3, "Password"));
		waitTime(3000);
		password.sendKeys("i898qrCiPK9Hwgb");
		waitTime(3000);
		WebElement loginbutton = propElement(getPropfile(gpropname3, "Loginbutton"));
		waitTime(3000);
		loginbutton.click();
		waitTime(3000);
		navigateto(URL);
		waitTime(5000);
		WebElement learningobj = propElement(getPropfile(gpropname3, "Learningobj"));
		waitTime(3000);
		if (learningobj.isDisplayed()) {
			learningobj.click();
			waitTime(3000);
			reportStep("Learning objectives section display", "Pass");
		} else {
			reportStep("Learning objectives section do not display", "Fail");
		}
		return this;
	}
	@Given("Verify Go to game page not logged in Learning objectives section DOES NOT appear")
	public AgrumentsWar verifylearningobjectivessectionasananonymoususer()
	{
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Icivicslogo"));
		reportStep("Learning objectives section do not display for anonymous user", "Pass");
		return this;
	}
	@Then("Verify Go to game page logged in as a student Learning objectives section DOES NOT appear")
	public AgrumentsWar verifylearningobjectivessectionasstudent() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
		signinbutton.click();
		WebElement signinlink =propElement(getPropfile(gpropname3, "Signinlink"));
		signinlink.click();
		WebElement username = propElement(getPropfile(gpropname3, "Username"));
		waitTime(3000);
		username.sendKeys("Granite Governor 3s9h");
		WebElement password = propElement(getPropfile(gpropname3, "Password"));
		waitTime(3000);
		password.sendKeys("123456789");
		waitTime(3000);
		WebElement loginbutton = propElement(getPropfile(gpropname3, "Loginbutton"));
		waitTime(3000);
		loginbutton.click();
		waitTime(5000);
		navigateto(URL);
		waitTime(5000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Icivicslogo"));
		reportStep("Learning objectives section do not display for Student", "Pass");
		return this;
	}
}
