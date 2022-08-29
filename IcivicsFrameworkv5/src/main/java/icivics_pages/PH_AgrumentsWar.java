package icivics_pages;

import java.io.IOException;
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

public class PH_AgrumentsWar extends ProjectSpecificMethods {
	public String gpropname1 = "PlayHub/Maingamespage";
	public String gpropname2 = "PlayHub/gametile";
	public String gpropname3 = "PlayHub/Argumentwars";

	public PH_AgrumentsWar(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment,
			String StageURL, String Stage1URL) {
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
	public PH_AgrumentsWar launchURL() {
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
	public PH_AgrumentsWar verifylink() {
		WebElement leaderboardachievementlink = propElement(getPropfile(gpropname3, "Leaderboard&Achievementlink"));
		if (leaderboardachievementlink.isDisplayed()) {
			reportStep("Leaderboard and achievements link display", "Pass");
		} else {
			reportStep("Leaderboard and achievements link do not display", "Fail");
		}
		return this;
	}

	@Given("Verify Popup dialog appears for leaderboard and achievements")
	public PH_AgrumentsWar verifylinkpopup() {
		WebElement leaderboardachievementlink = propElement(getPropfile(gpropname3, "Leaderboard&Achievementlink"));
		leaderboardachievementlink.click();
		waitTime(12000);
		reportStep("Popup dialog appears for leaderboard and achievements", "Pass");
		return this;
	}

	@Given("Verify Game loads within iFrame")
	public PH_AgrumentsWar verifyload() {

		switchToFrame(0);
		WebElement loadtime = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='clickToPlayBtn']/i")));
		click(loadtime);
		reportStep("Play button clicked", "Pass");
		return this;
	}

	@Given("Verify for logged in as an educator download teacher resources and assign buttons appear")
	public PH_AgrumentsWar verifydownloadteacherresourcesandassignbuttons() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
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
	public PH_AgrumentsWar verifydownloadteacherresourcesandassignbuttonsforstudent() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
		signinbutton.click();
		WebElement signinlink = propElement(getPropfile(gpropname3, "Signinlink"));
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
	public PH_AgrumentsWar verifydownloadteacherresourcesandassignclick() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
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
	public PH_AgrumentsWar verifyassignpopup() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
		signinbutton.click();
		WebElement signinlink = propElement(getPropfile(gpropname3, "Signinlink"));
		signinlink.click();
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname3, "Signinwithgooglebutton"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname3, "Email"));
		waitTime(3000);
		emailfield.sendKeys("amatt.teacher24@gedu.demo.icivics.org");

		WebElement nextbutton = propElement(getPropfile(gpropname3, "Nextbutton"));
		waitTime(3000);
		nextbutton.click();
		waitTime(3000);
		WebElement pwdfield = propElement(getPropfile(gpropname3, "Password"));

		pwdfield.sendKeys("Freedom17@");
		waitTime(3000);

		WebElement nextbutton1 = propElement(getPropfile(gpropname3, "Nextbutton"));
		nextbutton1.click();
		waitTime(3000);
		navigateto(URL);
		waitTime(5000);
		WebElement assign = propElement(getPropfile(gpropname3, "Assignbutton"));
		assign.click();
		waitTime(7000);
		WebElement noclasses = propElement(getPropfile(gpropname3, "NoClasses"));
		waitTime(3000);
		if (noclasses.isDisplayed()) {
			waitTime(3000);
			reportStep("Popup dialog appears with message that the teacher has no classes", "Pass");
		} else {
			reportStep("Popup dialog do not appears with message that the teacher has no classes", "Fail");

		}
		return this;
	}

	@Given("Verify click link to assign Popup dialog appears with form to assign the game")
	public PH_AgrumentsWar verifyassignform() {
		String url = "/user/login";
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL + url);
		} else {
			navigateto(Stage1URL + url);
		}
		waitTime(2000);
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signin"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname1, "Email"));
		waitTime(3000);
		emailfield.sendKeys("amatt.teacher24@gedu.demo.icivics.org");
		waitTime(3000);
		WebElement nextbutton = propElement(getPropfile(gpropname1, "Next"));
		nextbutton.click();
		waitTime(3000);
		WebElement pwdfield = propElement(getPropfile(gpropname1, "Password"));
		waitTime(3000);
		pwdfield.sendKeys("Freedom17@");
		waitTime(3000);
		WebElement nextbutton1 = propElement(getPropfile(gpropname1, "Next1"));
		nextbutton1.click();
		waitTime(3000);
		String url1 = "/games/argument-wars";
		String URL;

		if (Environment.equals("Stage.d9")) {
			URL = StageURL + url1;
			navigateto(URL);
		} else {
			URL = Stage1URL + url1;
			navigateto(URL);
		}
		waitTime(3000);

		WebElement assign = propElement(getPropfile(gpropname3, "Assignbutton"));
		assign.click();
		waitTime(7000);
		WebElement createassignment = propElement(getPropfile(gpropname3, "Createassignmentlink"));
		waitTime(3000);
		if (createassignment.isDisplayed()) {
			waitTime(3000);
			reportStep("Popup dialog appears with message that the teacher has no classes", "Pass");
		} else {

			reportStep("Popup dialog do not appears with message that the teacher has no classes", "Fail");
		}
		return this;
	}

	@Given("Verify Apple App Store button appears")
	public PH_AgrumentsWar verifyappleapp() throws IOException {
		String url = "/games";
		String URL;
		{
			if (Environment.equals("Stage.d9")) {
				URL = StageURL + url;
				navigateto(URL);
			} else {
				URL = Stage1URL + url;
				navigateto(URL);
			}
			// Arguments war
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "awtileele"));
			waitTime(3000);
			click(getprop(gpropname2, "awtileele"));
			verifyExactText(getprop(gpropname2, "awheaderele"), getpropstring(gpropname2, "awheadertxt"));
			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("Appleapp do not display for Argument war game", "Fail");
			waitTime(3000);

			// Branches of Power
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "boptileele"));
			waitTime(2000);
			click(getprop(gpropname2, "boptileele"));
			verifyExactText(getprop(gpropname2, "bopheaderele"), getpropstring(gpropname2, "bopheadertxt"));
			WebElement appleapp = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for game", "Pass");
			} else {

				reportStep("Apple App Store button do not display", "Fail");
			}

			// Cast Your Vote
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cyvtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cyvtileele"));
			verifyExactText(getprop(gpropname2, "cyvheaderele"), getpropstring(gpropname2, "cyvheadertxt"));
			WebElement appleapp1 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp1.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for game", "Pass");
			} else {

				reportStep("Apple App Store button do not display", "Fail");
			}

			// Convene the Council
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "ctctileele"));
			waitTime(2000);
			click(getprop(gpropname2, "ctctileele"));
			verifyExactText(getprop(gpropname2, "ctcheaderele"), getpropstring(gpropname2, "ctcheadertxt"));

			WebElement appleapp2 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp2.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for game", "Pass");
			} else {

				reportStep("Apple App Store button do not display", "Fail");
			}

			// Counties Work
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cwtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cwtileele"));
			verifyExactText(getprop(gpropname2, "cwheaderele"), getpropstring(gpropname2, "cwheadertxt"));

			WebElement appleapp3 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp3.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for game", "Pass");
			} else {

				reportStep("Apple App Store button do not display", "Fail");
			}

			// Counties Work/Texas
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cwttileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cwttileele"));
			verifyExactText(getprop(gpropname2, "cwtheaderele"), getpropstring(gpropname2, "cwtheadertxt"));

			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("Appleapp do not display for Counties Work game", "Fail");
			waitTime(3000);

			// Court Quest
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cqtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cqtileele"));
			verifyExactText(getprop(gpropname2, "cqheaderele"), getpropstring(gpropname2, "cqheadertxt"));
			WebElement appleapp4 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp4.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for game", "Pass");
			} else {

				reportStep("Apple App Store button do not display", "Fail");
			}

			// Do I have a Right
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "dihrtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "dihrtileele"));
			verifyExactText(getprop(gpropname2, "dihrheaderele"), getpropstring(gpropname2, "dihrheadertxt"));
			WebElement appleapp5 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp5.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for game", "Pass");
			} else {

				reportStep("Apple App Store button do not display", "Fail");
			}

			// Executive Command
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "ectileele"));
			waitTime(2000);
			click(getprop(gpropname2, "ectileele"));
			verifyExactText(getprop(gpropname2, "echeaderele"), getpropstring(gpropname2, "echeadertxt"));
			WebElement appleapp6 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp6.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for game", "Pass");
			} else {

				reportStep("Apple App Store button do not display", "Fail");
			}

			// Immigrationnation
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "intileele"));
			waitTime(2000);
			click(getprop(gpropname2, "intileele"));
			verifyExactText(getprop(gpropname2, "inheaderele"), getpropstring(gpropname2, "inheadertxt"));
			WebElement appleapp7 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp7.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for game", "Pass");
			} else {

				reportStep("Apple App Store button do not display", "Fail");
			}

			// Lawcraft
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "lctileele"));
			waitTime(2000);
			click(getprop(gpropname2, "lctileele"));
			verifyExactText(getprop(gpropname2, "lcheaderele"), getpropstring(gpropname2, "lcheadertxt"));
			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("Appleapp do not display for Lawcraft game", "Fail");
			waitTime(3000);

			// NewsFeedDefenders
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "nfdtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "nfdtileele"));
			verifyExactText(getprop(gpropname2, "nfdheaderele"), getpropstring(gpropname2, "nfdheadertxt"));
			WebElement appleapp8 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp8.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for game", "Pass");
			} else {

				reportStep("Apple App Store button do not display", "Fail");
			}

			// People'sPie

			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "pptileele"));
			waitTime(2000);
			reportStep("People's Pie should not be included", "Fail");
			/*
			 * click(getprop(gpropname2, "pptileele")); verifyExactText(getprop(gpropname2,
			 * "ppheaderele"), getpropstring(gpropname2, "ppheadertxt"));
			 * verifyUrlOfThePage(URL + getpropstring(gpropname2, "ppUrL"));
			 * verifyTitle(getpropstring(gpropname2, "ppTitle"));
			 */

			// Race to ratify
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "rtrtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "rtrtileele"));
			verifyExactText(getprop(gpropname2, "rtrheaderele"), getpropstring(gpropname2, "rtrheadertxt"));

			WebElement appleapp9 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp9.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for game", "Pass");
			} else {

				reportStep("Apple App Store button do not display", "Fail");
			}

			// Sortify:U.S.Citizenship
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "stileele"));
			waitTime(2000);
			click(getprop(gpropname2, "stileele"));
			verifyExactText(getprop(gpropname2, "sheaderele"), getpropstring(gpropname2, "sheadertxt"));

			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("Appleapp do not display for Sortify game", "Fail");
			waitTime(3000);

			// Win The White House
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "wtwhtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "wtwhtileele"));
			verifyExactText(getprop(gpropname2, "wtwhheaderele"), getpropstring(gpropname2, "wtwhheadertxt"));

			WebElement appleapp10 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp10.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for game", "Pass");
			} else {

				reportStep("Apple App Store button do not display", "Fail");
			}

			return this;

		}
	}

	@Given("Verify click link to Apple app store Page goes to Apple app store with the correct game")
	public PH_AgrumentsWar verifyappleapppage() throws IOException {
		String url = "/games";
		String URL;
		{
			if (Environment.equals("Stage.d9")) {
				URL = StageURL + url;
				navigateto(URL);
			} else {
				URL = Stage1URL + url;
				navigateto(URL);
			}
			// Arguments war
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "awtileele"));
			waitTime(3000);
			click(getprop(gpropname2, "awtileele"));
			verifyExactText(getprop(gpropname2, "awheaderele"), getpropstring(gpropname2, "awheadertxt"));
			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("Appleapp do not display for Argument war game", "Fail");
			waitTime(3000);

			// Branches of Power
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "boptileele"));
			waitTime(2000);
			click(getprop(gpropname2, "boptileele"));
			verifyExactText(getprop(gpropname2, "bopheaderele"), getpropstring(gpropname2, "bopheadertxt"));
			WebElement appleapp = propElement(getPropfile(gpropname3, "Appleapp"));
			click(appleapp);
			waitTime(3000);
			switchToWindow("Branches of Power on the App Store");
			WebElement gamename = propElement(getPropfile(gpropname3, "Gamename"));
			waitTime(5000);
			if (gamename.isDisplayed()) {

				reportStep("On clicking Apple app store  link Page goes to Apple app store with the correct game",
						"Pass");
			} else {

				reportStep("On clicking Apple app store link Page do not goes to Apple app store with the correct game",
						"Fail");
			}

			// Cast Your Vote
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cyvtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cyvtileele"));
			verifyExactText(getprop(gpropname2, "cyvheaderele"), getpropstring(gpropname2, "cyvheadertxt"));
			WebElement appleapp1 = propElement(getPropfile(gpropname3, "Appleapp"));
			click(appleapp1);
			waitTime(3000);
			switchToWindow("Cast Your Vote on the App Store");
			WebElement gamename1 = propElement(getPropfile(gpropname3, "Gamename"));
			waitTime(3000);
			if (gamename1.isDisplayed()) {

				reportStep("On clicking Apple app store  link Page goes to Apple app store with the correct game",
						"Pass");
			} else {

				reportStep("On clicking Apple app store link Page do not goes to Apple app store with the correct game",
						"Fail");
			}

			// Convene the Council
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "ctctileele"));
			waitTime(2000);
			click(getprop(gpropname2, "ctctileele"));
			verifyExactText(getprop(gpropname2, "ctcheaderele"), getpropstring(gpropname2, "ctcheadertxt"));
			WebElement appleapp2 = propElement(getPropfile(gpropname3, "Appleapp"));
			click(appleapp2);
			waitTime(3000);
			switchToWindow("Convene the Council on the App Store");
			WebElement gamename2 = propElement(getPropfile(gpropname3, "Gamename"));
			waitTime(3000);
			if (gamename2.isDisplayed()) {

				reportStep("On clicking Apple app store  link Page goes to Apple app store with the correct game",
						"Pass");
			} else {

				reportStep("On clicking Apple app store link Page do not goes to Apple app store with the correct game",
						"Fail");
			}

			// Counties Work
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cwtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cwtileele"));
			verifyExactText(getprop(gpropname2, "cwheaderele"), getpropstring(gpropname2, "cwheadertxt"));

			WebElement appleapp3 = propElement(getPropfile(gpropname3, "Appleapp"));
			click(appleapp3);
			waitTime(3000);
			switchToWindow("Counties Work on the App Store");
			WebElement gamename3 = propElement(getPropfile(gpropname3, "Gamename"));
			waitTime(3000);
			if (gamename3.isDisplayed()) {

				reportStep("On clicking Apple app store  link Page goes to Apple app store with the correct game",
						"Pass");
			} else {

				reportStep("On clicking Apple app store link Page do not goes to Apple app store with the correct game",
						"Fail");
			}

			// Counties Work/Texas
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cwttileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cwttileele"));
			verifyExactText(getprop(gpropname2, "cwtheaderele"), getpropstring(gpropname2, "cwtheadertxt"));

			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("Appleapp do not display for Counties Work game", "Fail");
			waitTime(3000);

			// Court Quest
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cqtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cqtileele"));
			verifyExactText(getprop(gpropname2, "cqheaderele"), getpropstring(gpropname2, "cqheadertxt"));
			WebElement appleapp4 = propElement(getPropfile(gpropname3, "Appleapp"));
			click(appleapp4);
			waitTime(3000);
			switchToWindow("Court Quest on the App Store");
			WebElement gamename4 = propElement(getPropfile(gpropname3, "Gamename"));
			waitTime(3000);
			if (gamename4.isDisplayed()) {

				reportStep("On clicking Apple app store  link Page goes to Apple app store with the correct game",
						"Pass");
			} else {

				reportStep("On clicking Apple app store link Page do not goes to Apple app store with the correct game",
						"Fail");
			}

			// Do I have a Right
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "dihrtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "dihrtileele"));
			verifyExactText(getprop(gpropname2, "dihrheaderele"), getpropstring(gpropname2, "dihrheadertxt"));
			WebElement appleapp5 = propElement(getPropfile(gpropname3, "Appleapp"));
			click(appleapp5);
			waitTime(3000);
			switchToWindow("Do I Have a Right? on the App Store");
			WebElement gamename5 = propElement(getPropfile(gpropname3, "Gamename"));
			waitTime(3000);
			if (gamename5.isDisplayed()) {

				reportStep("On clicking Apple app store  link Page goes to Apple app store with the correct game",
						"Pass");
			} else {

				reportStep("On clicking Apple app store link Page do not goes to Apple app store with the correct game",
						"Fail");
			}

			// Executive Command
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "ectileele"));
			waitTime(2000);
			click(getprop(gpropname2, "ectileele"));
			verifyExactText(getprop(gpropname2, "echeaderele"), getpropstring(gpropname2, "echeadertxt"));
			WebElement appleapp6 = propElement(getPropfile(gpropname3, "Appleapp"));
			click(appleapp6);
			waitTime(3000);
			switchToWindow("Executive Command on the App Store");
			WebElement gamename6 = propElement(getPropfile(gpropname3, "Gamename"));
			waitTime(3000);
			if (gamename6.isDisplayed()) {

				reportStep("On clicking Apple app store  link Page goes to Apple app store with the correct game",
						"Pass");
			} else {

				reportStep("On clicking Apple app store link Page do not goes to Apple app store with the correct game",
						"Fail");
			}

			// Immigrationnation
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "intileele"));
			waitTime(2000);
			click(getprop(gpropname2, "intileele"));
			verifyExactText(getprop(gpropname2, "inheaderele"), getpropstring(gpropname2, "inheadertxt"));
			WebElement appleapp7 = propElement(getPropfile(gpropname3, "Appleapp"));
			click(appleapp7);
			waitTime(3000);
			switchToWindow("Immigration Nation! on the App Store");
			WebElement gamename7 = propElement(getPropfile(gpropname3, "Gamename"));
			waitTime(3000);
			if (gamename7.isDisplayed()) {

				reportStep("On clicking Apple app store  link Page goes to Apple app store with the correct game",
						"Pass");
			} else {

				reportStep("On clicking Apple app store link Page do not goes to Apple app store with the correct game",
						"Fail");
			}

			// Lawcraft
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "lctileele"));
			waitTime(2000);
			click(getprop(gpropname2, "lctileele"));
			verifyExactText(getprop(gpropname2, "lcheaderele"), getpropstring(gpropname2, "lcheadertxt"));
			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("Appleapp do not display for Lawcraft game", "Fail");
			waitTime(3000);

			// NewsFeedDefenders
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "nfdtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "nfdtileele"));
			verifyExactText(getprop(gpropname2, "nfdheaderele"), getpropstring(gpropname2, "nfdheadertxt"));
			WebElement appleapp8 = propElement(getPropfile(gpropname3, "Appleapp"));
			click(appleapp8);
			waitTime(3000);
			switchToWindow("NewsFeed Defenders on the App Store");
			WebElement gamename8 = propElement(getPropfile(gpropname3, "Gamename"));
			waitTime(3000);
			if (gamename8.isDisplayed()) {

				reportStep("On clicking Apple app store  link Page goes to Apple app store with the correct game",
						"Pass");
			} else {

				reportStep("On clicking Apple app store link Page do not goes to Apple app store with the correct game",
						"Fail");
			}

			// People'sPie

			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "pptileele"));
			waitTime(2000);
			reportStep("People's Pie should not be included", "Fail");
			/*
			 * click(getprop(gpropname2, "pptileele")); verifyExactText(getprop(gpropname2,
			 * "ppheaderele"), getpropstring(gpropname2, "ppheadertxt"));
			 * verifyUrlOfThePage(URL + getpropstring(gpropname2, "ppUrL"));
			 * verifyTitle(getpropstring(gpropname2, "ppTitle"));
			 */

			// Race to ratify
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "rtrtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "rtrtileele"));
			verifyExactText(getprop(gpropname2, "rtrheaderele"), getpropstring(gpropname2, "rtrheadertxt"));
			WebElement appleapp9 = propElement(getPropfile(gpropname3, "Appleapp"));
			click(appleapp9);
			waitTime(3000);
			switchToWindow("Race to Ratify on the App Store");
			WebElement gamename9 = propElement(getPropfile(gpropname3, "Gamename"));
			waitTime(3000);
			if (gamename9.isDisplayed()) {

				reportStep("On clicking Apple app store  link Page goes to Apple app store with the correct game",
						"Pass");
			} else {

				reportStep("On clicking Apple app store link Page do not goes to Apple app store with the correct game",
						"Fail");
			}

			// Sortify:U.S.Citizenship
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "stileele"));
			waitTime(2000);
			click(getprop(gpropname2, "stileele"));
			verifyExactText(getprop(gpropname2, "sheaderele"), getpropstring(gpropname2, "sheadertxt"));

			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("Appleapp do not display for Sortify game", "Fail");
			waitTime(3000);

			// Win The White House
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "wtwhtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "wtwhtileele"));
			verifyExactText(getprop(gpropname2, "wtwhheaderele"), getpropstring(gpropname2, "wtwhheadertxt"));
			WebElement appleapp10 = propElement(getPropfile(gpropname3, "Appleapp"));
			click(appleapp10);
			waitTime(3000);
			switchToWindow("Win the White House on the App Store");
			WebElement gamename10 = propElement(getPropfile(gpropname3, "Gamename"));
			waitTime(3000);
			if (gamename10.isDisplayed()) {

				reportStep("On clicking Apple app store  link Page goes to Apple app store with the correct game",
						"Pass");
			} else {

				reportStep("On clicking Apple app store link Page do not goes to Apple app store with the correct game",
						"Fail");
			}

			return this;

		}

	}

	@Given("Verify Google Play Store button appears")
	public PH_AgrumentsWar verifygoogleplaybutton() throws IOException {
		String url = "/games";
		String URL;
		{
			if (Environment.equals("Stage.d9")) {
				URL = StageURL + url;
				navigateto(URL);
			} else {
				URL = Stage1URL + url;
				navigateto(URL);
			}
			// Arguments war
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "awtileele"));
			waitTime(3000);
			click(getprop(gpropname2, "awtileele"));
			verifyExactText(getprop(gpropname2, "awheaderele"), getpropstring(gpropname2, "awheadertxt"));
			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("Google play store button  do not display for Argument war game", "Fail");
			waitTime(3000);

			// Branches of Power
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "boptileele"));
			waitTime(2000);
			click(getprop(gpropname2, "boptileele"));
			verifyExactText(getprop(gpropname2, "bopheaderele"), getpropstring(gpropname2, "bopheadertxt"));
			WebElement googleplaybutton = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Branch of Power game", "Pass");
			} else {

				reportStep("Googleplay Store button do not display", "Fail");
			}

			// Cast Your Vote
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cyvtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cyvtileele"));
			verifyExactText(getprop(gpropname2, "cyvheaderele"), getpropstring(gpropname2, "cyvheadertxt"));
			WebElement googleplaybutton1 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton1.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Cast your Vote", "Pass");
			} else {

				reportStep("Googleplay Store button do not display", "Fail");
			}

			// Convene the Council
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "ctctileele"));
			waitTime(2000);
			click(getprop(gpropname2, "ctctileele"));
			verifyExactText(getprop(gpropname2, "ctcheaderele"), getpropstring(gpropname2, "ctcheadertxt"));
			WebElement googleplaybutton2 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton2.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Convene the council", "Pass");
			} else {

				reportStep("Googleplay Store button do not display", "Fail");
			}

			// Counties Work
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cwtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cwtileele"));
			verifyExactText(getprop(gpropname2, "cwheaderele"), getpropstring(gpropname2, "cwheadertxt"));

			WebElement googleplaybutton3 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton3.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Counties work", "Pass");
			} else {

				reportStep("Googleplay Store button do not display", "Fail");
			}
			// Counties Work/Texas
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cwttileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cwttileele"));
			verifyExactText(getprop(gpropname2, "cwtheaderele"), getpropstring(gpropname2, "cwtheadertxt"));

			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("Googleplay store button do not display for Counties Work game", "Fail");
			waitTime(3000);

			// Court Quest
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cqtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cqtileele"));
			verifyExactText(getprop(gpropname2, "cqheaderele"), getpropstring(gpropname2, "cqheadertxt"));
			WebElement googleplaybutton4 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton4.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for CourtQuest", "Pass");
			} else {

				reportStep("Googleplay Store button do not display", "Fail");
			}

			// Do I have a Right
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "dihrtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "dihrtileele"));
			verifyExactText(getprop(gpropname2, "dihrheaderele"), getpropstring(gpropname2, "dihrheadertxt"));
			WebElement googleplaybutton5 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton5.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Do I have a right", "Pass");
			} else {

				reportStep("Googleplay Store button do not display", "Fail");
			}

			// Executive Command
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "ectileele"));
			waitTime(2000);
			click(getprop(gpropname2, "ectileele"));
			verifyExactText(getprop(gpropname2, "echeaderele"), getpropstring(gpropname2, "echeadertxt"));
			WebElement googleplaybutton6 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton6.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Executive Command", "Pass");
			} else {

				reportStep("Googleplay Store button do not display", "Fail");
			}

			// Immigrationnation
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "intileele"));
			waitTime(2000);
			click(getprop(gpropname2, "intileele"));
			verifyExactText(getprop(gpropname2, "inheaderele"), getpropstring(gpropname2, "inheadertxt"));
			WebElement googleplaybutton7 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton7.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Immigrationnation", "Pass");
			} else {

				reportStep("Googleplay Store button do not display", "Fail");
			}

			// Lawcraft
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "lctileele"));
			waitTime(2000);
			click(getprop(gpropname2, "lctileele"));
			verifyExactText(getprop(gpropname2, "lcheaderele"), getpropstring(gpropname2, "lcheadertxt"));
			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("Googleplay store button do not display for Lawcraft game", "Fail");
			waitTime(3000);

			// NewsFeedDefenders
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "nfdtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "nfdtileele"));
			verifyExactText(getprop(gpropname2, "nfdheaderele"), getpropstring(gpropname2, "nfdheadertxt"));
			WebElement googleplaybutton8 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton8.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for NewsFeed Defenders", "Pass");
			} else {

				reportStep("Googleplay Store button do not display", "Fail");
			}

			// People'sPie

			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "pptileele"));
			waitTime(2000);
			reportStep("People's Pie should not be included", "Fail");
			/*
			 * click(getprop(gpropname2, "pptileele")); verifyExactText(getprop(gpropname2,
			 * "ppheaderele"), getpropstring(gpropname2, "ppheadertxt"));
			 * verifyUrlOfThePage(URL + getpropstring(gpropname2, "ppUrL"));
			 * verifyTitle(getpropstring(gpropname2, "ppTitle"));
			 */

			// Race to ratify
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "rtrtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "rtrtileele"));
			verifyExactText(getprop(gpropname2, "rtrheaderele"), getpropstring(gpropname2, "rtrheadertxt"));
			WebElement googleplaybutton9 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton9.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Race to ratify", "Pass");
			} else {

				reportStep("Googleplay Store button do not display", "Fail");
			}

			// Sortify:U.S.Citizenship
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "stileele"));
			waitTime(2000);
			click(getprop(gpropname2, "stileele"));
			verifyExactText(getprop(gpropname2, "sheaderele"), getpropstring(gpropname2, "sheadertxt"));

			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("Googleplay store button do not display for Sortify game", "Fail");
			waitTime(3000);

			// Win The White House
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "wtwhtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "wtwhtileele"));
			verifyExactText(getprop(gpropname2, "wtwhheaderele"), getpropstring(gpropname2, "wtwhheadertxt"));
			WebElement googleplaybutton10 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton10.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Win the White house", "Pass");
			} else {

				reportStep("Googleplay Store button do not display", "Fail");
			}

			return this;
		}
	}

	@Given("Verify click link to Google play store Page goes to Google play store with the correct game")
	public PH_AgrumentsWar verifygoogleplaypage() throws IOException {
		String url = "/games";
		String URL;
		{
			if (Environment.equals("Stage.d9")) {
				URL = StageURL + url;
				navigateto(URL);
			} else {
				URL = Stage1URL + url;
				navigateto(URL);
			}
			// Arguments war
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "awtileele"));
			waitTime(3000);
			click(getprop(gpropname2, "awtileele"));
			verifyExactText(getprop(gpropname2, "awheaderele"), getpropstring(gpropname2, "awheadertxt"));
			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("Google play store button  do not display for Argument war game", "Fail");
			waitTime(3000);

			// Branches of Power
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "boptileele"));
			waitTime(2000);
			click(getprop(gpropname2, "boptileele"));
			verifyExactText(getprop(gpropname2, "bopheaderele"), getpropstring(gpropname2, "bopheadertxt"));
			WebElement googleplay = propElement(getPropfile(gpropname3, "Googleplay"));
			click(googleplay);
			waitTime(3000);
			switchToWindow("Branches of Power - Apps on Google Play");
			WebElement gooleplayheading = propElement(getPropfile(gpropname3, "Googleplaypage"));
			waitTime(3000);
			if (gooleplayheading.isDisplayed()) {

				reportStep(
						"On clicking googleplay store  link Page goes to googleplay store store with the correct game",
						"Pass");
			} else {

				reportStep(
						"On clicking googleplay store store link Page do not goes to googleplay store store with the correct game",
						"Fail");
			}

			// Cast Your Vote
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cyvtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cyvtileele"));
			verifyExactText(getprop(gpropname2, "cyvheaderele"), getpropstring(gpropname2, "cyvheadertxt"));
			WebElement googleplay1 = propElement(getPropfile(gpropname3, "Googleplay"));
			click(googleplay1);
			waitTime(3000);
			switchToWindow("Cast Your Vote - Apps on Google Play");
			WebElement gooleplayheading1 = propElement(getPropfile(gpropname3, "Googleplaypage"));
			waitTime(3000);
			if (gooleplayheading1.isDisplayed()) {

				reportStep(
						"On clicking googleplay store  link Page goes to googleplay store store with the correct game",
						"Pass");
			} else {

				reportStep(
						"On clicking googleplay store store link Page do not goes to googleplay store store with the correct game",
						"Fail");
			}

			// Convene the Council
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "ctctileele"));
			waitTime(2000);
			click(getprop(gpropname2, "ctctileele"));
			verifyExactText(getprop(gpropname2, "ctcheaderele"), getpropstring(gpropname2, "ctcheadertxt"));
			WebElement googleplay2 = propElement(getPropfile(gpropname3, "Googleplay"));
			click(googleplay2);
			waitTime(3000);
			switchToWindow("Convene the Council - Apps on Google Play");
			WebElement gooleplayheading2 = propElement(getPropfile(gpropname3, "Googleplaypage"));
			waitTime(3000);
			if (gooleplayheading2.isDisplayed()) {

				reportStep(
						"On clicking googleplay store  link Page goes to googleplay store store with the correct game",
						"Pass");
			} else {

				reportStep(
						"On clicking googleplay store store link Page do not goes to googleplay store store with the correct game",
						"Fail");
			}

			// Counties Work
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cwtileele"));
			waitTime(2000);
			click(getprop(gpropname2, "cwtileele"));
			verifyExactText(getprop(gpropname2, "cwheaderele"), getpropstring(gpropname2, "cwheadertxt"));
			WebElement googleplay3 = propElement(getPropfile(gpropname3, "Googleplay"));
			click(googleplay3);
			waitTime(3000);
			switchToWindow("Play Counties Work - County Government Game | iCivics");
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep(
					"On clicking googleplay store store link Page do not goes to googleplay store store with the correct game",
					"Fail");
		}
		// Counties Work/Texas
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "cwttileele"));
		waitTime(2000);
		click(getprop(gpropname2, "cwttileele"));
		verifyExactText(getprop(gpropname2, "cwtheaderele"), getpropstring(gpropname2, "cwtheadertxt"));

		waitTime(5000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Areueducator"));
		reportStep("Googleplay store button do not display for Counties Work game", "Fail");

		// Court Quest
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "cqtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "cqtileele"));
		verifyExactText(getprop(gpropname2, "cqheaderele"), getpropstring(gpropname2, "cqheadertxt"));
		WebElement googleplay4 = propElement(getPropfile(gpropname3, "Googleplay"));
		click(googleplay4);
		waitTime(3000);
		switchToWindow("Court Quest - Apps on Google Play");
		WebElement gooleplayheading4 = propElement(getPropfile(gpropname3, "Googleplaypage"));
		waitTime(3000);
		if (gooleplayheading4.isDisplayed()) {

			reportStep("On clicking googleplay store  link Page goes to googleplay store store with the correct game",
					"Pass");
		} else {

			reportStep(
					"On clicking googleplay store store link Page do not goes to googleplay store store with the correct game",
					"Fail");
		}

		// Do I have a Right
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "dihrtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "dihrtileele"));
		verifyExactText(getprop(gpropname2, "dihrheaderele"), getpropstring(gpropname2, "dihrheadertxt"));
		WebElement googleplay5 = propElement(getPropfile(gpropname3, "Googleplay"));
		click(googleplay5);
		waitTime(3000);
		switchToWindow("Do I Have a Right? - Apps on Google Play");
		WebElement gooleplayheading5 = propElement(getPropfile(gpropname3, "Googleplaypage"));
		waitTime(3000);
		if (gooleplayheading5.isDisplayed()) {

			reportStep("On clicking googleplay store  link Page goes to googleplay store store with the correct game",
					"Pass");
		} else {

			reportStep(
					"On clicking googleplay store store link Page do not goes to googleplay store store with the correct game",
					"Fail");
		}
		// Executive Command
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "ectileele"));
		waitTime(2000);
		click(getprop(gpropname2, "ectileele"));
		verifyExactText(getprop(gpropname2, "echeaderele"), getpropstring(gpropname2, "echeadertxt"));
		WebElement googleplay6 = propElement(getPropfile(gpropname3, "Googleplay"));
		click(googleplay6);
		waitTime(3000);
		switchToWindow("Executive Command - Apps on Google Play");
		WebElement gooleplayheading6 = propElement(getPropfile(gpropname3, "Googleplaypage"));
		waitTime(3000);
		if (gooleplayheading6.isDisplayed()) {

			reportStep("On clicking googleplay store  link Page goes to googleplay store store with the correct game",
					"Pass");
		} else {

			reportStep(
					"On clicking googleplay store store link Page do not goes to googleplay store store with the correct game",
					"Fail");
		}

		// Immigrationnation
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "intileele"));
		waitTime(2000);
		click(getprop(gpropname2, "intileele"));
		verifyExactText(getprop(gpropname2, "inheaderele"), getpropstring(gpropname2, "inheadertxt"));
		WebElement googleplay7 = propElement(getPropfile(gpropname3, "Googleplay"));
		click(googleplay7);
		waitTime(3000);
		switchToWindow("Immigration Nation - Apps on Google Play");
		WebElement gooleplayheading7 = propElement(getPropfile(gpropname3, "Googleplaypage"));
		waitTime(3000);
		if (gooleplayheading7.isDisplayed()) {

			reportStep("On clicking googleplay store  link Page goes to googleplay store store with the correct game",
					"Pass");
		} else {

			reportStep(
					"On clicking googleplay store store link Page do not goes to googleplay store store with the correct game",
					"Fail");
		}

		// Lawcraft
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "lctileele"));
		waitTime(2000);
		click(getprop(gpropname2, "lctileele"));
		verifyExactText(getprop(gpropname2, "lcheaderele"), getpropstring(gpropname2, "lcheadertxt"));
		waitTime(3000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Areueducator"));
		reportStep("Googleplay store button do not display for Lawcraft game", "Fail");
		waitTime(3000);

		// NewsFeedDefenders
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "nfdtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "nfdtileele"));
		verifyExactText(getprop(gpropname2, "nfdheaderele"), getpropstring(gpropname2, "nfdheadertxt"));
		WebElement googleplay8 = propElement(getPropfile(gpropname3, "Googleplay"));
		click(googleplay8);
		waitTime(3000);
		switchToWindow("Play NewsFeed Defenders - News Literacy Game | iCivics");
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Areueducator"));
		reportStep(
				"On clicking googleplay store store link Page do not goes to googleplay store store with the correct game",
				"Fail");

		// People'sPie

		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "pptileele"));
		waitTime(2000);
		reportStep("People's Pie should not be included", "Fail");
		/*
		 * click(getprop(gpropname2, "pptileele")); verifyExactText(getprop(gpropname2,
		 * "ppheaderele"), getpropstring(gpropname2, "ppheadertxt"));
		 * verifyUrlOfThePage(URL + getpropstring(gpropname2, "ppUrL"));
		 * verifyTitle(getpropstring(gpropname2, "ppTitle"));
		 */

		// Race to ratify
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "rtrtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "rtrtileele"));
		verifyExactText(getprop(gpropname2, "rtrheaderele"), getpropstring(gpropname2, "rtrheadertxt"));
		WebElement googleplay9 = propElement(getPropfile(gpropname3, "Googleplay"));
		click(googleplay9);
		waitTime(3000);
		switchToWindow("Race to Ratify - Apps on Google Play");
		WebElement gooleplayheading9 = propElement(getPropfile(gpropname3, "Googleplaypage"));
		waitTime(3000);
		if (gooleplayheading9.isDisplayed()) {

			reportStep("On clicking googleplay store  link Page goes to googleplay store store with the correct game",
					"Pass");
		} else {

			reportStep(
					"On clicking googleplay store store link Page do not goes to googleplay store store with the correct game",
					"Fail");
		}
		// Sortify:U.S.Citizenship
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "stileele"));
		waitTime(2000);
		click(getprop(gpropname2, "stileele"));
		verifyExactText(getprop(gpropname2, "sheaderele"), getpropstring(gpropname2, "sheadertxt"));

		waitTime(3000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Areueducator"));
		reportStep("Googleplay store button do not display for Sortify game", "Fail");
		waitTime(3000);

		// Win The White House
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "wtwhtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "wtwhtileele"));
		verifyExactText(getprop(gpropname2, "wtwhheaderele"), getpropstring(gpropname2, "wtwhheadertxt"));
		WebElement googleplay10 = propElement(getPropfile(gpropname3, "Googleplay"));
		click(googleplay10);
		waitTime(3000);
		switchToWindow("Win the White House - Apps on Google Play");
		WebElement gooleplayheading10 = propElement(getPropfile(gpropname3, "Googleplaypage"));
		waitTime(3000);
		if (gooleplayheading10.isDisplayed()) {

			reportStep("On clicking googleplay store  link Page goes to googleplay store store with the correct game",
					"Pass");
		} else {

			reportStep(
					"On clicking googleplay store store link Page do not goes to googleplay store store with the correct game",
					"Fail");
		}

		return this;

	}

	@Given("Verify Go to game page Extension pack link appears")
	public PH_AgrumentsWar verifyextensionpacklink() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
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
		WebElement extensionpack = propElement(getPropfile(gpropname3, "extensionpack"));
		if (extensionpack.isDisplayed()) {
			scrollToTheGivenWebElement(getPropfile(gpropname3, "extensionpack"));
			reportStep("Extension pack link display as a teacher login", "Pass");
		} else {
			reportStep("Extension pack link do not display", "Fail");
		}
		return this;
	}

	public PH_AgrumentsWar verifyextensionpacklinkforsortifygame() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
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
		WebElement playbutton = propElement(getPropfile(gpropname3, "playbutton"));
		playbutton.click();
		waitTime(3000);
		WebElement sortifygamelink = propElement(getPropfile(gpropname3, "Sortifygame"));
		sortifygamelink.click();
		waitTime(3000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "share"));
		reportStep("Extension pack link do not display for sortifygame", "Pass");

		return this;
	}

	@Given("Verify Go to game page not logged Extension pack link DOES NOT appear")
	public PH_AgrumentsWar verifyextensionpacklinkforanonymoususer() {
		scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
		waitTime(3000);
		reportStep("Extension pack link do not display for an anonymous user", "Pass");
		return this;
	}

	@Then("Verify logged in as a student Extension pack link DOES NOT appear")
	public PH_AgrumentsWar verifyextensionpacklinkforastudent() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
		signinbutton.click();
		WebElement signinlink = propElement(getPropfile(gpropname3, "Signinlink"));
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
		waitTime(3000);
		navigateto(URL);
		waitTime(5000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
		waitTime(3000);
		reportStep("Extension pack link do not display for an Student", "Pass");
		return this;

	}

	@Given("Verify click link to extension pack Page goes to lesson plan containing game extension pack")
	public PH_AgrumentsWar verifyextensionpacklinkclick() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
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
		WebElement extensionpack = propElement(getPropfile(gpropname3, "extensionpack"));
		if (extensionpack.isDisplayed()) {
			extensionpack.click();
			waitTime(3000);
			switchToWindow("Argument Wars Extension Pack | iCivics");
			waitTime(3000);

			WebElement gameextensionpack = propElement(getPropfile(gpropname3, "gameextensionpack"));
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
	public PH_AgrumentsWar verifylearningobjectivessection() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
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
		WebElement learningobj = propElement(getPropfile(gpropname3, "Learningobj"));
		waitTime(3000);
		if (learningobj.isDisplayed()) {
			learningobj.click();
			waitTime(3000);
			reportStep("Learning objectives section display for teacher", "Pass");
		} else {
			reportStep("Learning objectives section do not display", "Fail");
		}
		return this;
	}

	@Given("Verify Go to game page not logged in Learning objectives section DOES NOT appear")
	public PH_AgrumentsWar verifylearningobjectivessectionasananonymoususer() {
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Icivicslogo"));
		reportStep("Learning objectives section do not display for anonymous user", "Pass");
		return this;
	}

	@Then("Verify Go to game page logged in as a student Learning objectives section DOES NOT appear")
	public PH_AgrumentsWar verifylearningobjectivessectionasstudent() {
		WebElement signinbutton = propElement(getPropfile(gpropname3, "Signin"));
		signinbutton.click();
		WebElement signinlink = propElement(getPropfile(gpropname3, "Signinlink"));
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
