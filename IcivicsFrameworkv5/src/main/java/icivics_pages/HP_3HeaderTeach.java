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

public class HP_3HeaderTeach extends ProjectSpecificMethods {
	public String gpropname = "Homepage/homepageheader";
	public String gpropname1 = "Homepage/homepageteacherheader";
	public String gpropname2 = "Homepage/homepageheaderplay";
	public String gpropname3 = "Homepage/homepageheaderteach";

	public HP_3HeaderTeach(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "/about";
	
	@Given("Launch the icivics URL")
	public HP_3HeaderTeach launchURL() {
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL+url);
		}else {
			navigateto(Stage1URL+url);
		}
		return this;

	}

	@Then("Verify on Clicking teach button at top teach submenu open")
	public HP_3HeaderTeach verifyteachmenu() {
		WebElement teachbutton = propElement(getPropfile(gpropname1, "Teachbutton"));
		if (teachbutton.isDisplayed()) {
			teachbutton.click();

			reportStep("Teachsubmenu is  display ", "Pass");
		} else {

			reportStep("Teachsubmenu is not display ", "Fail");
		}
		return this;
	}

	@Given("Verify click on Teach button and menu Options display")
	public HP_3HeaderTeach verifyteachmenulist() {
		String locatorvalue = getPropfile(gpropname3, "Dropdownlist");
		List<WebElement> allOptions = propElement1(locatorvalue);

		reportStep("Teachbutton submenu count is" + " " + allOptions.size(), "Pass");
		for (int i = 0; i < allOptions.size(); i++) {
			WebElement optionelement = allOptions.get(i);
			String optionsText = optionelement.getText();

			reportStep("Teachbutton submenu is " + " " + optionsText, "Pass");

		}
		return this;

	}

	@Then("Verify click on links in the submenu")
	public HP_3HeaderTeach Teachbuttonelementsverification() throws IOException {
		String propname = "Homepage/teachdropdown";
		String TeachButton = getPropfile(propname, "TeachButtonElement");
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL+url);
		}else {
			navigateto(Stage1URL+url);
		}

		// Search Our Library
		mouseOverAndClickAction(TeachButton);
		Verifylinks(getprop(propname, "solElement"), getpropstring(propname, "solText"),
				getpropstring(propname, "solUrL"), getpropstring(propname, "solTitle"));
		verifyPartialText(getprop(propname, "solheaderele"), getpropstring(propname, "solheader"));

		// SCOPE & SEQUENCE
		mouseOverAndClickAction(TeachButton);
		Verifylinks(getprop(propname, "sasElement"), getpropstring(propname, "sasText"),
				getpropstring(propname, "sasUrL"), getpropstring(propname, "sasTitle"));
		verifyPartialText(getprop(propname, "sasheaderele"), getpropstring(propname, "sasheader"));

		// PROFESSIONAL DEVELOPMENT
		mouseOverAndClickAction(TeachButton);
		Verifylinks(getprop(propname, "pdElement"), getpropstring(propname, "pdText"), getpropstring(propname, "pdUrL"),
				getpropstring(propname, "pdTitle"));
		verifyPartialText(getprop(propname, "pdheaderele"), getpropstring(propname, "pdheader"));

		// GET STARTED
		mouseOverAndClickAction(TeachButton);
		Verifylinks(getprop(propname, "gsElement"), getpropstring(propname, "gsText"), getpropstring(propname, "gsUrL"),
				getpropstring(propname, "gsTitle"));
		verifyPartialText(getprop(propname, "gsheaderele"), getpropstring(propname, "gsheader"));

		// EDUCATOR COMMUNITY
		mouseOverAndClickAction(TeachButton);
		verifyDisplayed(getprop(propname, "ecElement"));
		verifyExactText(getprop(propname, "ecElement"), getpropstring(propname, "ecText"));
		click(getprop(propname, "ecElement"));
		verifyTitle(getpropstring(propname, "Community � iCivics"));

		// FAQ
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL+url);
		}else {
			navigateto(Stage1URL+url);
		}
		waitTime(3000);
		mouseOverAndClickAction(TeachButton);
		Verifylinks(getprop(propname, "faqElement"), getpropstring(propname, "faqText"),
				getpropstring(propname, "faqUrL"), getpropstring(propname, "faqTitle"));
		verifyPartialText(getprop(propname, "faqheaderele"), getpropstring(propname, "faqheader"));

		reportStep("All links in the teach dropdown is verified sucessfully", "Pass");

		return this;

	}

	@Given("Verify click on teach menu again it close")
	public HP_3HeaderTeach clickteachbuttonagain() {
		WebElement teachbutton = propElement(getPropfile(gpropname1, "Teachbutton"));
		if (teachbutton.isDisplayed()) {
			click(propElement(getPropfile(gpropname1, "Teachbutton")));
			reportStep("Teach submenu is close on clicking again", "Pass");
		} else {
			reportStep("Teach submenu is not display", "Pass");
		}
		return this;

	}
}
