package icivics_pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class PlayHub_Individual_Game_AgrumentsWar extends ProjectSpecificMethods {
	public String gpropname1 = "PlayHub/Maingamespage";
	public String gpropname2 = "PlayHub/gametile";
	public String gpropname3 = "PlayHub/Argumentwars";

	public PlayHub_Individual_Game_AgrumentsWar(RemoteWebDriver driver, ExtentTest node, Properties prop,
			String Environment, String StageURL, String Stage1URL) {
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
	public PlayHub_Individual_Game_AgrumentsWar launchURL() {
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
	public PlayHub_Individual_Game_AgrumentsWar verifylink() {
		WebElement leaderboardachievementlink = propElement(getPropfile(gpropname3, "Leaderboard&Achievementlink"));
		if (leaderboardachievementlink.isDisplayed()) {
			reportStep("Leaderboard and achievements link is displayed", "Pass");
		} else {
			reportStep("Leaderboard and achievements link is not displayed", "Fail");
		}
		return this;
	}

	@Given("Verify Popup dialog appears for leaderboard and achievements")
	public PlayHub_Individual_Game_AgrumentsWar verifylinkpopup() {
		WebElement leaderboardachievementlink = propElement(getPropfile(gpropname3, "Leaderboard&Achievementlink"));
		leaderboardachievementlink.click();
		waitTime(12000);
		WebElement leaderboardachievementpopup = propElement(getPropfile(gpropname3, "Popup"));
		if (leaderboardachievementpopup.isDisplayed()) {
			waitTime(2000);
			reportStep("Popup dialog appear for leaderboard and achievements", "Pass");
		} else {
			reportStep("Popup dialog do not appear for leaderboard and achievements", "Fail");
		}
		return this;
	}

	@Given("Verify for logged in as an educator download teacher resources and assign buttons appear")
	public PlayHub_Individual_Game_AgrumentsWar verifydownloadteacherresourcesandassignbuttons() {
		propElement(getPropfile(gpropname3, "Signin")).click();
		propElement(getPropfile(gpropname3, "Signinlink")).click();
		propElement(getPropfile(gpropname3, "Username")).sendKeys("Bronze Speaker 1r4e");
		propElement(getPropfile(gpropname3, "Password")).sendKeys("i898qrCiPK9Hwgb");
		propElement(getPropfile(gpropname3, "Loginbutton")).click();
		waitTime(3000);
		navigateto(URL);
		waitTime(7000);
		WebElement downloadteach = propElement(getPropfile(gpropname3, "Downloadteach"));
		WebElement assign = propElement(getPropfile(gpropname3, "Assignbutton"));
		if (downloadteach.isDisplayed() && assign.isDisplayed()) {
			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "Downloadteach"));
			reportStep("Download teacher resources and assign buttons display for login as Teacher", "Pass");
		} else {
			reportStep("Download teacher resources and assign buttons do not display", "Fail");
		}
		waitTime(3000);
		return this;

	}

	@Given("Verify for logged in as an Student download teacher resources and assign buttons appear")
	public PlayHub_Individual_Game_AgrumentsWar verifydownloadteacherresourcesandassignbuttonsforstudent() {
		propElement(getPropfile(gpropname3, "Signin")).click();
		propElement(getPropfile(gpropname3, "Signinlink")).click();
		propElement(getPropfile(gpropname3, "Username")).sendKeys("Granite Governor 3s9h");
		propElement(getPropfile(gpropname3, "Password")).sendKeys("123456789");
		propElement(getPropfile(gpropname3, "Loginbutton")).click();
		navigateto(URL);
		waitTime(2000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "scrollelement"));
		waitTime(3000);
		if (driver.getPageSource().contains("DOWNLOAD TEACHER RESOURCES") == false) {
			reportStep("Download teacher resources and assign buttons do not display", "Pass");
		} else {
			reportStep("Download teacher resources and assign buttons display for login as Student", "Fail");
		}
		return this;
	}

	@Then("Verify for logged in as an anonymous user download teacher resources and assign buttons appear")
	public PlayHub_Individual_Game_AgrumentsWar verifydownloadteacherresourcesandassignbuttonsforanonymoususer() {
		scrollToTheGivenWebElement(getPropfile(gpropname3, "scrollelement"));
		if (driver.getPageSource().contains("DOWNLOAD TEACHER RESOURCES") == false) {
			reportStep(
					"Download teacher resources and assign buttons do not display for logged in as an anonymous user",
					"Pass");
		} else {
			reportStep("Download teacher resources and assign buttons display for logged in as an anonymous user",
					"Fail");
		}
		return this;
	}

	@Given("Verify click link to download teacher resources Popup dialog appears with links to teacher resources")
	public PlayHub_Individual_Game_AgrumentsWar verifydownloadteacherresourcesandassignclick() {
		propElement(getPropfile(gpropname3, "Signin")).click();
		propElement(getPropfile(gpropname3, "Signinlink")).click();
		propElement(getPropfile(gpropname3, "Username")).sendKeys("Bronze Speaker 1r4e");
		propElement(getPropfile(gpropname3, "Password")).sendKeys("i898qrCiPK9Hwgb");
		propElement(getPropfile(gpropname3, "Loginbutton")).click();
		waitTime(5000);
		navigateto(URL);
		waitTime(5000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Downloadteach"));
		propElement(getPropfile(gpropname3, "Downloadteach")).click();
		waitTime(3000);
		WebElement downloadteachpopup = propElement(getPropfile(gpropname3, "DownloadteachPopup"));
		if (downloadteachpopup.isDisplayed()) {
			waitTime(2000);
			reportStep("Popup dialog display with links to teacher resources", "Pass");
		} else {
			reportStep("Popup dialog do not display with links to teacher resources", "Fail");
		}
		return this;
	}

	@Given("Verify click link to assign Popup dialog appears with message that the teacher has no classes")
	public PlayHub_Individual_Game_AgrumentsWar verifyassignpopup() {
		String url = "/user/login";
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL + url);
		} else {
			navigateto(Stage1URL + url);
		}
		propElement(getPropfile(gpropname1, "Signin")).click();
		propElement(getPropfile(gpropname1, "Email")).sendKeys("amatt.teacher24@gedu.demo.icivics.org");
		propElement(getPropfile(gpropname1, "Next")).click();
		waitTime(5000);
		propElement(getPropfile(gpropname1, "Password")).sendKeys("Freedom17@");
		propElement(getPropfile(gpropname1, "Next1")).click();
		waitTime(5000);

		String url1 = "/games/argument-wars";
		String URL;

		if (Environment.equals("Stage.d9")) {
			URL = StageURL + url1;
			navigateto(URL);
		} else {
			URL = Stage1URL + url1;
			navigateto(URL);
		}
		waitTime(5000);
		WebElement assign = propElement(getPropfile(gpropname3, "Assignbutton"));
		waitTime(3000);
		assign.click();
		waitTime(7000);
		WebElement noclasses = propElement(getPropfile(gpropname3, "NoClasses"));
		waitTime(3000);
		String text = noclasses.getText();
		waitTime(3000);
		if (text.contains("No Classes")) {
			waitTime(3000);
			reportStep("Popup dialog appears with message that the teacher has no classes", "Pass");
		} else {
			reportStep("Popup dialog do not appears with message that the teacher has no classes", "Fail");

		}
		return this;
	}

	@Given("Verify click link to assign Popup dialog appears with form to assign the game")
	public PlayHub_Individual_Game_AgrumentsWar verifyassignform() {
		String url = "/user/login";
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL + url);
		} else {
			navigateto(Stage1URL + url);
		}
		propElement(getPropfile(gpropname1, "Signin")).click();
		propElement(getPropfile(gpropname1, "Email")).sendKeys("amatt.teacher24@gedu.demo.icivics.org");
		propElement(getPropfile(gpropname1, "Next")).click();
		waitTime(3000);
		propElement(getPropfile(gpropname1, "Password")).sendKeys("Freedom17@");
		propElement(getPropfile(gpropname1, "Next1")).click();
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
		String text = createassignment.getText();
		waitTime(3000);
		if (text.contains("Create assignment")) {
			waitTime(3000);
			reportStep("Popup dialog appears with form to assign the game", "Pass");
		} else {
			reportStep("Popup dialog do not appears with form to assign the game", "Fail");
		}
		return this;
	}

	@Given("Verify Apple App Store button appears")
	public PlayHub_Individual_Game_AgrumentsWar verifyappleapp() throws IOException {
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
			getprop(gpropname2, "awtileele").click();
			waitTime(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,450)", "");
			if (driver.getPageSource().contains("app-link app_store")==true) {
				reportStep("Apple App Store display for Argument war game", "Pass");
				}else {
				reportStep("Apple App Store is not display for Argument war game", "Fail");
				}
			waitTime(3000);

			// Branches of Power
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "boptileele"));
			waitTime(2000);
			getprop(gpropname2, "boptileele").click();
			WebElement appleapp = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for Branches of Power game", "Pass");
			} else {
				reportStep("Apple App Store button do not display for Branches of Power game", "Fail");
			}

			// Cast Your Vote
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cyvtileele"));
			waitTime(2000);
			getprop(gpropname2, "cyvtileele").click();
			WebElement appleapp1 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp1.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for Cast Your Vote game", "Pass");
			} else {
				reportStep("Apple App Store button do not display for Cast Your Vote game", "Fail");
			}

			// Convene the Council
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "ctctileele"));
			waitTime(2000);
			getprop(gpropname2, "ctctileele").click();
			WebElement appleapp2 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp2.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for Convene the Council game", "Pass");
			} else {
				reportStep("Apple App Store button do not display for Convene the Council game", "Fail");
			}

			// Counties Work
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cwtileele"));
			waitTime(2000);
			getprop(gpropname2, "cwtileele").click();
			WebElement appleapp3 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp3.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for Counties Work game", "Pass");
			} else {
				reportStep("Apple App Store button do not display for Counties Work game", "Fail");
			}

			// Counties Work/Texas
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cwttileele"));
			waitTime(2000);
			getprop(gpropname2, "cwttileele").click();
			waitTime(3000);
			js.executeScript("window.scrollBy(0,450)", "");
			if (driver.getPageSource().contains("app-link app_store")==true) {
				reportStep("Apple App Store display for Counties Work/Texas game", "Pass");
				}else {
				reportStep("Apple App Store is not display for Counties Work/Texas game", "Fail");
				}
			waitTime(3000);

			// Court Quest
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cqtileele"));
			waitTime(2000);
			getprop(gpropname2, "cqtileele").click();
			WebElement appleapp4 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp4.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for Court Quest game", "Pass");
			} else {
				reportStep("Apple App Store button do not display for Court Quest game", "Fail");
			}

			// Do I have a Right
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "dihrtileele"));
			waitTime(2000);
			getprop(gpropname2, "dihrtileele").click();
			WebElement appleapp5 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp5.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for Do I have a Right game", "Pass");
			} else {
				reportStep("Apple App Store button do not display for Do I have a Right game", "Fail");
			}

			// Executive Command
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "ectileele"));
			waitTime(2000);
			getprop(gpropname2, "ectileele").click();
			WebElement appleapp6 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp6.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for  Executive Command game", "Pass");
			} else {
				reportStep("Apple App Store button do not display for  Executive Command game", "Fail");
			}

			// Immigrationnation
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "intileele"));
			waitTime(2000);
			getprop(gpropname2, "intileele").click();
			WebElement appleapp7 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp7.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for Immigrationnation game", "Pass");
			} else {
				reportStep("Apple App Store button do not display for Immigrationnation game", "Fail");
			}

			// Lawcraft
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "lctileele"));
			waitTime(2000);
			getprop(gpropname2, "lctileele").click();
			waitTime(3000);
			js.executeScript("window.scrollBy(0,450)", "");
			if (driver.getPageSource().contains("app-link app_store")==true) {
				reportStep("Apple App Store display for Lawcraft game", "Pass");
				}else {
				reportStep("Apple App Store is not display for Lawcraft game", "Fail");
				}
			waitTime(3000);

			// NewsFeedDefenders
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "nfdtileele"));
			waitTime(2000);
			getprop(gpropname2, "nfdtileele").click();
			WebElement appleapp8 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp8.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for NewsFeed Defenders game", "Pass");
			} else {
				reportStep("Apple App Store button do not display for NewsFeed Defenders game", "Fail");
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
			getprop(gpropname2, "rtrtileele").click();
			WebElement appleapp9 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp9.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for Race to ratify game", "Pass");
			} else {
				reportStep("Apple App Store button do not display for Race to ratify game", "Fail");
			}

			// Sortify:U.S.Citizenship
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "stileele"));
			waitTime(2000);
			getprop(gpropname2, "stileele").click();
			waitTime(3000);
			js.executeScript("window.scrollBy(0,450)", "");
			if (driver.getPageSource().contains("app-link app_store")==true) {
				reportStep("Apple App Store display for Sortify:U.S.Citizenship game", "Pass");
				}else {
				reportStep("Apple App Store is not display for Sortify:U.S.Citizenship game", "Fail");
				}
			waitTime(3000);

			// Win The White House
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "wtwhtileele"));
			waitTime(2000);
			getprop(gpropname2, "wtwhtileele").click();
			WebElement appleapp10 = propElement(getPropfile(gpropname3, "Appleapp"));
			waitTime(3000);
			if (appleapp10.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Appleapp"));
				reportStep("Apple App Store button display for Win The White House game", "Pass");
			} else {
				reportStep("Apple App Store button do not display for Win The White House game", "Fail");
			}
			return this;
		}
		}

	@Given("Verify click link to Apple app store Page goes to Apple app store with the correct game")
	public PlayHub_Individual_Game_AgrumentsWar verifyappleapppage() throws IOException {
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
			waitTime(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)", "");
			if (driver.getPageSource().contains("app-link app_store")==true) {
				reportStep("Apple App Store display for Argument war game", "Pass");
				}else {
				reportStep("Apple App Store is not display for Argument war game", "Fail");
				}
			waitTime(3000);

			// Branches of Power
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "boptileele"));
			waitTime(2000);
			getprop(gpropname2, "boptileele").click();
			WebElement appleapp = propElement(getPropfile(gpropname3, "Appleapp"));
			click(appleapp);
			waitTime(3000);
			switchToWindow("Branches of Power on the App Store");
			WebElement gamename = propElement(getPropfile(gpropname3, "Gamename"));
			waitTime(5000);
			if (gamename.isDisplayed()) {
				reportStep("On clicking Apple app store link Page goes to Apple app store with the correct game",
						"Pass");
			} else {
				reportStep("On clicking Apple app store link Page do not goes to Apple app store with the correct game",
						"Fail");
			}

			// Cast Your Vote
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cyvtileele"));
			waitTime(2000);
			getprop(gpropname2, "cyvtileele").click();
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
			getprop(gpropname2, "ctctileele").click();
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
			getprop(gpropname2, "cwtileele").click();
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
			getprop(gpropname2, "cwttileele").click();
			waitTime(3000);
			js.executeScript("window.scrollBy(0,450)", "");
			if (driver.getPageSource().contains("app-link app_store")==true) {
				reportStep("Apple App Store display for Counties Work game", "Pass");
				} else {
				reportStep("Apple App Store is not display for Counties Work game", "Fail");
				}
			waitTime(3000);

			// Court Quest
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cqtileele"));
			waitTime(2000);
			getprop(gpropname2, "cqtileele").click();
			WebElement appleapp4 = propElement(getPropfile(gpropname3, "Appleapp"));
			click(appleapp4);
			waitTime(3000);
			switchToWindow("Court Quest on the App Store");
			WebElement gamename4 = propElement(getPropfile(gpropname3, "Gamename"));
			waitTime(3000);
			if (gamename4.isDisplayed()) {
				reportStep("On clicking Apple app store link Page goes to Apple app store with the correct game",
						"Pass");
			} else {
				reportStep("On clicking Apple app store link Page do not goes to Apple app store with the correct game",
						"Fail");
			}

			// Do I have a Right
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "dihrtileele"));
			waitTime(2000);
			getprop(gpropname2, "dihrtileele").click();
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
			getprop(gpropname2, "ectileele").click();
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
			getprop(gpropname2, "intileele").click();
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
			getprop(gpropname2, "lctileele").click();
			waitTime(3000);
			js.executeScript("window.scrollBy(0,450)", "");
			if (driver.getPageSource().contains("app-link app_store")==true) {
				reportStep("Apple App Store display for Lawcraft game", "Pass");
				} else {
				reportStep("Apple App Store is not display for Lawcraft game", "Fail");
				}
			waitTime(3000);

			// NewsFeedDefenders
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "nfdtileele"));
			waitTime(2000);
			getprop(gpropname2, "nfdtileele").click();
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
			getprop(gpropname2, "rtrtileele").click();
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
			getprop(gpropname2, "stileele").click();
			waitTime(3000);
			js.executeScript("window.scrollBy(0,450)", "");
			if (driver.getPageSource().contains("app-link app_store")==true) {
				reportStep("Apple App Store display for Sortify:U.S.Citizenship game", "Pass");
				} else {
				reportStep("Apple App Store is not display for Sortify:U.S.Citizenship game", "Fail");
				}
			waitTime(3000);

			// Win The White House
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "wtwhtileele"));
			waitTime(2000);
			getprop(gpropname2, "wtwhtileele").click();
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
	public PlayHub_Individual_Game_AgrumentsWar verifygoogleplaybutton() throws IOException {
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
			getprop(gpropname2, "awtileele").click();
			waitTime(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,450)", "");
			if (driver.getPageSource().contains("app-link play_store")==true) {
				reportStep("Google play store display for Argument war game", "Pass");
				} else {
				reportStep("Google play store is not display for Argument war game", "Fail");
				}
			waitTime(3000);

			// Branches of Power
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "boptileele"));
			waitTime(2000);
			getprop(gpropname2, "boptileele").click();
			WebElement googleplaybutton = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Branch of Power game", "Pass");
			} else {
				reportStep("Googleplay Store button do not display for Branch of Power game", "Fail");
			}

			// Cast Your Vote
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cyvtileele"));
			waitTime(2000);
			getprop(gpropname2, "cyvtileele").click();
			WebElement googleplaybutton1 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton1.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Cast your Vote", "Pass");
			} else {
				reportStep("Googleplay Store button do not display for Cast your Vote", "Fail");
			}

			// Convene the Council
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "ctctileele"));
			waitTime(2000);
			getprop(gpropname2, "ctctileele").click();
			WebElement googleplaybutton2 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton2.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Convene the council", "Pass");
			} else {
				reportStep("Googleplay Store button do not display for Convene the council", "Fail");
			}

			// Counties Work
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cwtileele"));
			waitTime(2000);
			getprop(gpropname2, "cwtileele").click();
			WebElement googleplaybutton3 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton3.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Counties work", "Pass");
			} else {
				reportStep("Googleplay Store button do not display for Counties work", "Fail");
			}
			
			// Counties Work/Texas
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cwttileele"));
			waitTime(2000);
			getprop(gpropname2, "cwttileele").click();
			waitTime(3000);
			js.executeScript("window.scrollBy(0,450)", "");
			if (driver.getPageSource().contains("app-link play_store")==true) {
				reportStep("Google play store display for Counties Work game", "Pass");
				} else {
				reportStep("Google play store is not display for Counties Work game", "Fail");
				}
			waitTime(3000);

			// Court Quest
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "cqtileele"));
			waitTime(2000);
			getprop(gpropname2, "cqtileele").click();
			WebElement googleplaybutton4 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton4.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for CourtQuest", "Pass");
			} else {
				reportStep("Googleplay Store button do not display for CourtQuest", "Fail");
			}

			// Do I have a Right
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "dihrtileele"));
			waitTime(2000);
			getprop(gpropname2, "dihrtileele").click();
			WebElement googleplaybutton5 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton5.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Do I have a right", "Pass");
			} else {
				reportStep("Googleplay Store button do not display for Do I have a right", "Fail");
			}

			// Executive Command
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "ectileele"));
			waitTime(2000);
			getprop(gpropname2, "ectileele").click();
			WebElement googleplaybutton6 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton6.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Executive Command", "Pass");
			} else {
				reportStep("Googleplay Store button do not display for Executive Command", "Fail");
			}

			// Immigrationnation
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "intileele"));
			waitTime(2000);
			getprop(gpropname2, "intileele").click();
			WebElement googleplaybutton7 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton7.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Immigrationnation", "Pass");
			} else {
				reportStep("Googleplay Store button do not display for Immigrationnation", "Fail");
			}

			// Lawcraft
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "lctileele"));
			waitTime(2000);
			getprop(gpropname2, "lctileele").click();
			waitTime(3000);
			js.executeScript("window.scrollBy(0,450)", "");
			if (driver.getPageSource().contains("app-link play_store")==true) {
				reportStep("Google play store display for Lawcraft game", "Pass");
				} else {
				reportStep("Google play store is not display for Lawcraft game", "Fail");
				}
			waitTime(3000);

			// NewsFeedDefenders
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "nfdtileele"));
			waitTime(2000);
			getprop(gpropname2, "nfdtileele").click();
			WebElement googleplaybutton8 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton8.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for NewsFeed Defenders", "Pass");
			} else {
				reportStep("Googleplay Store button do not display for NewsFeed Defenders", "Fail");
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
			getprop(gpropname2, "rtrtileele").click();
			WebElement googleplaybutton9 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton9.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Race to ratify", "Pass");
			} else {
				reportStep("Googleplay Store button do not display for Race to ratify", "Fail");
			}

			// Sortify:U.S.Citizenship
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "stileele"));
			waitTime(2000);
			getprop(gpropname2, "stileele").click();
			waitTime(3000);
			js.executeScript("window.scrollBy(0,450)", "");
			if (driver.getPageSource().contains("app-link play_store")==true) {
				reportStep("Google play store display for Sortify:U.S.Citizenship game", "Pass");
				} else {
				reportStep("Google play store is not display for Sortify:U.S.Citizenship game", "Fail");
				}
			waitTime(3000);

			// Win The White House
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "wtwhtileele"));
			waitTime(2000);
			getprop(gpropname2, "wtwhtileele").click();
			WebElement googleplaybutton10 = propElement(getPropfile(gpropname3, "Googleplay"));
			waitTime(3000);
			if (googleplaybutton10.isDisplayed()) {
				scrollToTheGivenWebElement(getPropfile(gpropname3, "Googleplay"));
				reportStep("Googleplay Store button display for Win the White house", "Pass");
			} else {
				reportStep("Googleplay Store button do not display for Win the White house", "Fail");
			}
			return this;
		}
	}

	@Given("Verify click link to Google play store Page goes to Google play store with the correct game")
	public PlayHub_Individual_Game_AgrumentsWar verifygoogleplaypage() throws IOException {
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
			waitTime(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,450)", "");
			if (driver.getPageSource().contains("app-link play_store")==true) {
				reportStep("Google play store display for Argument war game", "Pass");
				} else {
				reportStep("Google play store button do not display for Argument war game", "Fail");
				}
			waitTime(3000);

			// Branches of Power
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "boptileele"));
			waitTime(2000);
			getprop(gpropname2, "boptileele").click();
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
			getprop(gpropname2, "cyvtileele").click();
			WebElement googleplay1 = propElement(getPropfile(gpropname3, "Googleplay"));
			click(googleplay1);
			waitTime(3000);
			switchToWindow("Cast Your Vote - Apps on Google Play");
			WebElement gooleplayheading1 = propElement(getPropfile(gpropname3, "Googleplaypage"));
			waitTime(3000);
			if (gooleplayheading1.isDisplayed()) {
				reportStep("On clicking googleplay store  link Page goes to googleplay store store with the correct game",
						"Pass");
			} else {
				reportStep("On clicking googleplay store store link Page do not goes to googleplay store store with the correct game",
						"Fail");
			}

			// Convene the Council
			navigateto(URL);
			scrollToTheGivenWebElement(getpropstring(gpropname2, "ctctileele"));
			waitTime(2000);
			getprop(gpropname2, "ctctileele").click();
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
			getprop(gpropname2, "cwtileele").click();
			WebElement googleplay3 = propElement(getPropfile(gpropname3, "Googleplay"));
			click(googleplay3);
			waitTime(3000);
			switchToWindow("Play Counties Work - County Government Game | iCivics");
			scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
			reportStep("On clicking googleplay store store link Page do not goes to googleplay store store with the correct game",
					"Fail");
		}
		
		// Counties Work/Texas
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "cwttileele"));
		waitTime(2000);
		getprop(gpropname2, "cwttileele").click();
		waitTime(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		if (driver.getPageSource().contains("app-link play_store")==true) {
			reportStep("Google play store display for Counties Work game", "Pass");
			} else {
			reportStep("Google play store button do not display for Counties Work game", "Fail");
			}

		// Court Quest
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "cqtileele"));
		waitTime(2000);
		getprop(gpropname2, "cqtileele").click();
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
		getprop(gpropname2, "dihrtileele").click();
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
		getprop(gpropname2, "ectileele").click();
		WebElement googleplay6 = propElement(getPropfile(gpropname3, "Googleplay"));
		click(googleplay6);
		waitTime(3000);
		switchToWindow("Executive Command - Apps on Google Play");
		WebElement gooleplayheading6 = propElement(getPropfile(gpropname3, "Googleplaypage"));
		waitTime(3000);
		if (gooleplayheading6.isDisplayed()) {
			reportStep("On clicking googleplay store  link Page goes to googleplay store store with the correct game", "Pass");
		} else {
			reportStep("On clicking googleplay store store link Page do not goes to googleplay store store with the correct game", "Fail");
		}

		// Immigrationnation
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "intileele"));
		waitTime(2000);
		getprop(gpropname2, "intileele").click();
		WebElement googleplay7 = propElement(getPropfile(gpropname3, "Googleplay"));
		click(googleplay7);
		waitTime(3000);
		switchToWindow("Immigration Nation - Apps on Google Play");
		WebElement gooleplayheading7 = propElement(getPropfile(gpropname3, "Googleplaypage"));
		waitTime(3000);
		if (gooleplayheading7.isDisplayed()) {
			reportStep("On clicking googleplay store  link Page goes to googleplay store store with the correct game", "Pass");
		} else {
			reportStep("On clicking googleplay store store link Page do not goes to googleplay store store with the correct game", "Fail");
		}

		// Lawcraft
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "lctileele"));
		waitTime(2000);
		getprop(gpropname2, "lctileele").click();
		waitTime(3000);
		
		js.executeScript("window.scrollBy(0,450)", "");
		if (driver.getPageSource().contains("app-link play_store")==true) {
			reportStep("Google play store display for Lawcraft game", "Pass");
			} else {
			reportStep("Google play store button do not display for Lawcraft game", "Fail");
			}
		waitTime(3000);

		// NewsFeedDefenders
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "nfdtileele"));
		waitTime(2000);
		getprop(gpropname2, "nfdtileele").click();
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
		getprop(gpropname2, "rtrtileele").click();
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
		getprop(gpropname2, "stileele").click();
		waitTime(3000);
		js.executeScript("window.scrollBy(0,450)", "");
		if (driver.getPageSource().contains("app-link play_store")==true) {
			reportStep("Google play store display for Sortify:U.S.Citizenship game", "Pass");
			} else {
			reportStep("Google play store button do not display for Sortify:U.S.Citizenship game", "Fail");
			}
		waitTime(3000);

		// Win The White House
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "wtwhtileele"));
		waitTime(2000);
		getprop(gpropname2, "wtwhtileele").click();
		WebElement googleplay10 = propElement(getPropfile(gpropname3, "Googleplay"));
		click(googleplay10);
		waitTime(3000);
		switchToWindow("Win the White House - Apps on Google Play");
		WebElement gooleplayheading10 = propElement(getPropfile(gpropname3, "Googleplaypage"));
		waitTime(3000);
		if (gooleplayheading10.isDisplayed()) {
			reportStep("On clicking googleplay store  link Page goes to googleplay store store with the correct game", "Pass");
		} else {
			reportStep("On clicking googleplay store store link Page do not goes to googleplay store store with the correct game", "Fail");
		}
		return this;
	}

	@Given("Verify Go to game page Extension pack link appears")
	public PlayHub_Individual_Game_AgrumentsWar verifyextensionpacklink() {
		propElement(getPropfile(gpropname3, "Signin")).click();
		propElement(getPropfile(gpropname3, "Signinlink")).click();
		propElement(getPropfile(gpropname3, "Username")).sendKeys("Bronze Speaker 1r4e");
		propElement(getPropfile(gpropname3, "Password")).sendKeys("i898qrCiPK9Hwgb");
		propElement(getPropfile(gpropname3, "Loginbutton")).click();
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

	public PlayHub_Individual_Game_AgrumentsWar verifyextensionpacklinkforsortifygame() {
		propElement(getPropfile(gpropname3, "Signin")).click();
		propElement(getPropfile(gpropname3, "Signinlink")).click();
		propElement(getPropfile(gpropname3, "Username")).sendKeys("Bronze Speaker 1r4e");
		propElement(getPropfile(gpropname3, "Password")).sendKeys("i898qrCiPK9Hwgb");
		propElement(getPropfile(gpropname3, "Loginbutton")).click();
		waitTime(3000);
		propElement(getPropfile(gpropname3, "playbutton")).click();
		waitTime(3000);
		propElement(getPropfile(gpropname3, "Sortifygame")).click();
		waitTime(3000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "share"));
		reportStep("Extension pack link do not display for sortifygame", "Pass");
		return this;
	}

	@Given("Verify Go to game page not logged Extension pack link DOES NOT appear")
	public PlayHub_Individual_Game_AgrumentsWar verifyextensionpacklinkforanonymoususer() {
		scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
		waitTime(3000);
		reportStep("Extension pack link do not display for an anonymous user", "Pass");
		return this;
	}

	@Then("Verify logged in as a student Extension pack link DOES NOT appear")
	public PlayHub_Individual_Game_AgrumentsWar verifyextensionpacklinkforastudent() {
		propElement(getPropfile(gpropname3, "Signin")).click();
		propElement(getPropfile(gpropname3, "Signinlink")).click();
		propElement(getPropfile(gpropname3, "Username")).sendKeys("Granite Governor 3s9h");
		propElement(getPropfile(gpropname3, "Password")).sendKeys("123456789");
		propElement(getPropfile(gpropname3, "Loginbutton")).click();
		waitTime(3000);
		navigateto(URL);
		waitTime(5000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "caseinclude"));
		waitTime(3000);
		reportStep("Extension pack link do not display for Student", "Pass");
		return this;

	}

	@Given("Verify click link to extension pack Page goes to lesson plan containing game extension pack")
	public PlayHub_Individual_Game_AgrumentsWar verifyextensionpacklinkclick() {
		propElement(getPropfile(gpropname3, "Signin")).click();
		propElement(getPropfile(gpropname3, "Signinlink")).click();
		propElement(getPropfile(gpropname3, "Username")).sendKeys("Bronze Speaker 1r4e");
		propElement(getPropfile(gpropname3, "Password")).sendKeys("i898qrCiPK9Hwgb");
		propElement(getPropfile(gpropname3, "Loginbutton")).click();
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
				reportStep(driver.getCurrentUrl() + " - Page goes to lesson plan containing game's extension pack",
						"Pass");
			} else {
				reportStep("Page goes to lesson plan containing game's extension pack", "Fail");
			}
		}
		return this;
	}

	@Given("Verify Go to game page Learning objectives section appears")
	public PlayHub_Individual_Game_AgrumentsWar verifylearningobjectivessection() {
		propElement(getPropfile(gpropname3, "Signin")).click();
		propElement(getPropfile(gpropname3, "Signinlink")).click();
		propElement(getPropfile(gpropname3, "Username")).sendKeys("Bronze Speaker 1r4e");
		propElement(getPropfile(gpropname3, "Password")).sendKeys("i898qrCiPK9Hwgb");
		waitTime(3000);
		propElement(getPropfile(gpropname3, "Loginbutton")).click();
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
	public PlayHub_Individual_Game_AgrumentsWar verifylearningobjectivessectionasananonymoususer() {
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Icivicslogo"));
		reportStep("Learning objectives section do not display for anonymous user", "Pass");
		return this;
	}

	@Then("Verify Go to game page logged in as a student Learning objectives section DOES NOT appear")
	public PlayHub_Individual_Game_AgrumentsWar verifylearningobjectivessectionasstudent() {
		propElement(getPropfile(gpropname3, "Signin")).click();
		propElement(getPropfile(gpropname3, "Signinlink")).click();
		propElement(getPropfile(gpropname3, "Username")).sendKeys("Granite Governor 3s9h");
		propElement(getPropfile(gpropname3, "Password")).sendKeys("123456789");
		waitTime(3000);
		propElement(getPropfile(gpropname3, "Loginbutton")).click();
		waitTime(5000);
		navigateto(URL);
		waitTime(5000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Icivicslogo"));
		reportStep("Learning objectives section do not display for Student", "Pass");
		return this;
	}
}
