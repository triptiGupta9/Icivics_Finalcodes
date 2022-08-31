package icivics_pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class HomePage_2HeaderPlay extends ProjectSpecificMethods {
	public String gpropname1 = "Homepage/homepageheader";
	public String gpropname2 = "Homepage/homepageteacherheader";
	public String gpropname3 = "Homepage/homepageheaderplay";

	public HomePage_2HeaderPlay(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL,
			String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "/games";
	String URL;

	@Given("Launch the icivics URL")
	public HomePage_2HeaderPlay launchURL() {
		if (Environment.equals("Stage.d9")) {
			URL = StageURL + url;
			navigateto(URL);
		} else {
			URL = Stage1URL + url;
			navigateto(URL);
		}
		return this;
	}

	@Then("Verify Click on play button at top play submenu open")
	public HomePage_2HeaderPlay verifyplaysubmenu() {

		WebElement playbutton = propElement(getPropfile(gpropname2, "Playbutton"));
		if (playbutton.isDisplayed()) {
			playbutton.click();
			reportStep("playbutton submenu is display ", "Pass");
		} else {
			reportStep("playsubmenu  is not display ", "Pass");
		}

		return this;
	}

	@Given("Verify iCivics game submenu list display")
	public HomePage_2HeaderPlay verifyplaysubmenulist() {
		String locatorvalue = getPropfile(gpropname3, "Dropdownsubmenu");
		List<WebElement> allOptions = propElement1(locatorvalue);

		reportStep("playbutton submenu count is" + " " + allOptions.size(), "Pass");
		for (int i = 0; i < allOptions.size(); i++) {
			WebElement optionelement = allOptions.get(i);
			String optionsText = optionelement.getText();

			reportStep("Playbutton submenu is " + " " + optionsText, "Pass");

		}
		return this;
	}

	@Given("Verify click on each link navigate to correponding page")
	public HomePage_2HeaderPlay Playbuttonelementsverification() throws IOException {

		String propname = "Homepage/playdropdown";
		String PlayButton = getPropfile(propname, "PlayButtonElement");
		navigateto(URL);

		// All Games
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "AllgamesElement"), getpropstring(propname, "AllgameText"),
				URL + getpropstring(propname, "AllgameUrL"), getpropstring(propname, "AllgameTitle"));

		// cast your vote
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "cyvElement"), getpropstring(propname, "cyvText"),
				URL + getpropstring(propname, "cyvUrL"), getpropstring(propname, "cyvTitle"));
		verifyPartialText(getprop(propname, "cyvheaderele"), getpropstring(propname, "cyvheader"));

		// counties work Texas
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "cwtElement"), getpropstring(propname, "cwtText"),
				URL + getpropstring(propname, "cwtUrL"), getpropstring(propname, "cwtTitle"));
		verifyPartialText(getprop(propname, "cwtheaderele"), getpropstring(propname, "cwtheader"));

		// Execute Command
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "ecElement"), getpropstring(propname, "ecText"),
				URL + getpropstring(propname, "ecUrL"), getpropstring(propname, "ecTitle"));
		verifyPartialText(getprop(propname, "echeaderele"), getpropstring(propname, "echeader"));

		// Lawcraft
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "lcElement"), getpropstring(propname, "lcText"),
				URL + getpropstring(propname, "lcUrL"), getpropstring(propname, "lcTitle"));
		verifyPartialText(getprop(propname, "lcheaderele"), getpropstring(propname, "lcheader"));

		// Sortify:U.S.CITIZENSHIP
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "scElement"), getpropstring(propname, "scText"),
				URL + getpropstring(propname, "scUrL"), getpropstring(propname, "scTitle"));
		verifyPartialText(getprop(propname, "scheaderele"), getpropstring(propname, "scheader"));

		// ARGUMENT WARS
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "awElement"), getpropstring(propname, "awText"),
				URL + getpropstring(propname, "awUrL"), getpropstring(propname, "awTitle"));
		verifyPartialText(getprop(propname, "awheaderele"), getpropstring(propname, "awheader"));

		// Convene The Council
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "ctcElement"), getpropstring(propname, "ctcText"),
				URL + getpropstring(propname, "ctcUrL"), getpropstring(propname, "ctcTitle"));
		verifyPartialText(getprop(propname, "ctcheaderele"), getpropstring(propname, "ctcheader"));

		// Court Quest
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "cqElement"), getpropstring(propname, "cqText"),
				URL + getpropstring(propname, "cqUrL"), getpropstring(propname, "cqTitle"));
		verifyPartialText(getprop(propname, "cqheaderele"), getpropstring(propname, "cqheader"));

		// Game Odyssey
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "goElement"), getpropstring(propname, "goText"),
				URL + getpropstring(propname, "goUrL"), getpropstring(propname, "goTitle"));
		verifyPartialText(getprop(propname, "goheaderele"), getpropstring(propname, "goheader"));
		navigateto(URL);
		waitTime(3000);

		// newsfeeders defenders
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "nfdElement"), getpropstring(propname, "nfdText"),
				URL + getpropstring(propname, "nfdUrL"), getpropstring(propname, "nfdTitle"));
		verifyPartialText(getprop(propname, "nfdheaderele"), getpropstring(propname, "nfdheader"));

		// Win the white house
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "wtwhElement"), getpropstring(propname, "wtwhText"),
				URL + getpropstring(propname, "wtwhUrL"), getpropstring(propname, "wtwhTitle"));
		verifyPartialText(getprop(propname, "wtwhheaderele"), getpropstring(propname, "wtwhheader"));

		// Branches of Power
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "bopElement"), getpropstring(propname, "bopText"),
				URL + getpropstring(propname, "bopUrL"), getpropstring(propname, "bopTitle"));
		verifyPartialText(getprop(propname, "bopheaderele"), getpropstring(propname, "bopheader"));

		// Counties Work
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "cwElement"), getpropstring(propname, "cwText"),URL + getpropstring(propname, "cwUrL"),
				 getpropstring(propname, "cwTitle"));
		verifyPartialText(getprop(propname, "cwheaderele"), getpropstring(propname, "cwheader"));

		// Do I have A Birth?
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "drElement"), getpropstring(propname, "drText"),URL + getpropstring(propname, "drUrL"),
			 getpropstring(propname, "drTitle"));
		verifyPartialText(getprop(propname, "drheaderele"), getpropstring(propname, "drheader"));

		// Immigration Nation
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "inElement"), getpropstring(propname, "inText"), URL +getpropstring(propname, "inUrL"),
				 getpropstring(propname, "inTitle"));
		verifyPartialText(getprop(propname, "inheaderele"), getpropstring(propname, "inheader"));

		// Race To Ratify
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "rtrElement"), getpropstring(propname, "rtrText"),
				URL + getpropstring(propname, "rtrUrL"), getpropstring(propname, "rtrTitle"));
		verifyPartialText(getprop(propname, "rtrheaderele"), getpropstring(propname, "rtrheader"));

		reportStep("All links in the play dropdown is verified sucessfully", "Pass");

		return this;
	}

	@Given("Verify selected page is underlined")
	public HomePage_2HeaderPlay verifyselectedoptionunderlined() {
		if (Environment.equals("Stage.d9")) {
			
			navigateto(StageURL + "/teachers");
		}else {
			navigateto(Stage1URL + "/teachers");
		}

		click(propElement(getPropfile(gpropname2, "Playbutton")));
		waitTime(3000);
		String locatorvalue = getPropfile(gpropname3, "Dropdownlist");
		List<WebElement> allOptions = propElement1(locatorvalue);
		reportStep("Playbutton submenu count is" + " " + allOptions.size(), "Pass");
		for (int i = 1; i <= allOptions.size(); i++) {

			WebElement Options = propElement(getPropfile(gpropname3, "Dropdownlistplay"));
			Options.click();
			waitTime(3000);
			String currenturl = driver.getCurrentUrl();
			navigateto(URL + "/game-odyssey");
			if (currenturl == URL + "/game-odyssey") {
				navigateto(URL + url);

			} else {
				click(propElement(getPropfile(gpropname2, "Playbutton")));
				waitTime(3000);
				WebElement options1 = propElement(getPropfile(gpropname3, "Dropdownplaylist"));

				String cssvalue = options1.getCssValue("text-decoration-line");
				System.out.println(cssvalue);
				waitTime(3000);
				if (cssvalue.contains("underline")) {
					reportStep("Selected page is underlined", "Pass");
				} else {
					reportStep("Selected page is not underlined", "Fail");
				}

				if (Environment.equals("Stage.d9")) {
					
					navigateto(StageURL + "/teachers");
				}else {
					navigateto(Stage1URL + "/teachers");
				}


				click(propElement(getPropfile(gpropname2, "Playbutton")));
				waitTime(3000);

			}

		}
		return this;
	}

	@Given("Verify Click on the play menu again and submenu is close")

	public HomePage_2HeaderPlay clickplaybuttonagain() {

		WebElement playbutton = propElement(getPropfile(gpropname2, "Playbutton"));
		if (playbutton.isDisplayed()) {
			click(propElement(getPropfile(gpropname2, "Playbutton")));
			reportStep("On clicking Playbutton again submenu is close", "Pass");
		} else {
			reportStep("Playbutton submenu is not close", "Pass");
		}
		return this;

	}
}
