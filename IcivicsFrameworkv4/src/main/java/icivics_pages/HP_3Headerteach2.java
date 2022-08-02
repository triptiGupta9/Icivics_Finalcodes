package icivics_pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class HP_3Headerteach2 extends ProjectSpecificMethods {
	public String gpropname = "Homepage/homepageheader";
	public String gpropname1 = "Homepage/homepageteacherheader";
	public String gpropname2 = "Homepage/homepageheaderplay";
	public String gpropname3 = "Homepage/homepageheaderteach";
	public String gpropname4 = "Homepage/homepageheaderteach2";

	public HP_3Headerteach2(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}
	
	String url = "/teachers";

	@Given("Launch the icivics URL")
	public HP_3Headerteach2 launchURL() {
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL+url);
		}else {
			navigateto(Stage1URL+url);
		}
		return this;

	}

	@Then("Verify on Clicking teach button at top teach submenu open")
	public HP_3Headerteach2 verifyteachmenu() {
		WebElement teachbutton = propElement(getPropfile(gpropname1, "Teachbutton"));
		if (teachbutton.isDisplayed()) {
			teachbutton.click();
			reportStep("Teachsubmenu is  display ", "Pass");
		} else {
			reportStep("Teachsubmenu is not display ", "Fail");
		}
		return this;
	}

	@Then("Verify main teach page appears with underlined")
	public HP_3Headerteach2 verifytextisunderlined() {
		waitTime(3000);
		WebElement sollink = propElement(getPropfile(gpropname4, "Sollink1"));
		sollink.click();
		waitTime(3000);
		click(propElement(getPropfile(gpropname1, "Teachbutton")));
		waitTime(7000);
		String cssValue = propElement(getPropfile(gpropname4, "Sollink1")).getCssValue("text-decoration-line");
		String cssValue1 = propElement(getPropfile(gpropname4, "Snslink")).getCssValue("text-decoration-line");
		String cssValue2 = propElement(getPropfile(gpropname4, "Pdlink")).getCssValue("text-decoration-line");
		String cssValue3 = propElement(getPropfile(gpropname4, "Gslink")).getCssValue("text-decoration-line");
		String cssValue4 = propElement(getPropfile(gpropname4, "Eclink")).getCssValue("text-decoration-line");
		String cssValue5 = propElement(getPropfile(gpropname4, "Faqlink")).getCssValue("text-decoration-line");
		System.out.println(cssValue);
		if (cssValue.contains("underline") && cssValue1.contains("none") && cssValue2.contains("none")
				&& cssValue3.contains("none") && cssValue4.contains("none") && cssValue5.contains("none")) {

			reportStep("Selected page is underlined and non selected page is not underlined", "Pass");

		} else {
			reportStep("Selected page is not underlined", "Fail");
		}
		return this;
	}

	@Then("Verify scope and sequence page display with underlined")
	public HP_3Headerteach2 verifytextisunderlined1() {
		WebElement snslink = propElement(getPropfile(gpropname4, "Snslink"));
		snslink.click();
		waitTime(3000);
		click(propElement(getPropfile(gpropname1, "Teachbutton")));
		waitTime(3000);
		String cssValue = propElement(getPropfile(gpropname4, "Sollink")).getCssValue("text-decoration-line");
		String cssValue1 = propElement(getPropfile(gpropname4, "Snslink")).getCssValue("text-decoration-line");
		String cssValue2 = propElement(getPropfile(gpropname4, "Pdlink")).getCssValue("text-decoration-line");
		String cssValue3 = propElement(getPropfile(gpropname4, "Gslink")).getCssValue("text-decoration-line");
		String cssValue4 = propElement(getPropfile(gpropname4, "Eclink")).getCssValue("text-decoration-line");
		String cssValue5 = propElement(getPropfile(gpropname4, "Faqlink")).getCssValue("text-decoration-line");
		if (cssValue.contains("none") && cssValue1.contains("underline") && cssValue2.contains("none")
				&& cssValue3.contains("none") && cssValue4.contains("none") && cssValue5.contains("none")) {

			reportStep("Selected page is underlined and non selected page is not underlined", "Pass");

		} else {
			reportStep("Selected page is not underlined", "Fail");
		}
		return this;
	}

	@Then("Verify professional Development page display with underlined")
	public HP_3Headerteach2 verifytextisunderlined2() {
		WebElement pdlink = propElement(getPropfile(gpropname4, "Pdlink"));
		pdlink.click();
		waitTime(3000);
		click(propElement(getPropfile(gpropname1, "Teachbutton")));
		waitTime(3000);
		String cssValue = propElement(getPropfile(gpropname4, "Sollink")).getCssValue("text-decoration-line");
		String cssValue1 = propElement(getPropfile(gpropname4, "Snslink")).getCssValue("text-decoration-line");
		String cssValue2 = propElement(getPropfile(gpropname4, "Pdlink1")).getCssValue("text-decoration-line");
		String cssValue3 = propElement(getPropfile(gpropname4, "Gslink")).getCssValue("text-decoration-line");
		String cssValue4 = propElement(getPropfile(gpropname4, "Eclink")).getCssValue("text-decoration-line");
		String cssValue5 = propElement(getPropfile(gpropname4, "Faqlink")).getCssValue("text-decoration-line");
		if (cssValue.contains("none") && cssValue1.contains("none") && cssValue2.contains("underline")
				&& cssValue3.contains("none") && cssValue4.contains("none") && cssValue5.contains("none")) {

			reportStep("Selected page is underlined and non selected page is not underlined", "Pass");

		} else {
			reportStep("Selected page is not underlined", "Fail");
		}
		return this;
	}

	@Then("Verify get started page display with underlined")
	public HP_3Headerteach2 verifytextisunderlined3() {
		WebElement gslink = propElement(getPropfile(gpropname4, "Gslink"));
		gslink.click();
		waitTime(3000);
		click(propElement(getPropfile(gpropname1, "Teachbutton")));
		waitTime(3000);
		String cssValue = propElement(getPropfile(gpropname4, "Sollink")).getCssValue("text-decoration-line");
		String cssValue1 = propElement(getPropfile(gpropname4, "Snslink")).getCssValue("text-decoration-line");
		String cssValue2 = propElement(getPropfile(gpropname4, "Pdlink1")).getCssValue("text-decoration-line");
		String cssValue3 = propElement(getPropfile(gpropname4, "Gslink")).getCssValue("text-decoration-line");
		String cssValue4 = propElement(getPropfile(gpropname4, "Eclink")).getCssValue("text-decoration-line");
		String cssValue5 = propElement(getPropfile(gpropname4, "Faqlink")).getCssValue("text-decoration-line");

		if (cssValue.contains("none") && cssValue1.contains("none") && cssValue2.contains("none")
				&& cssValue3.contains("underline") && cssValue4.contains("none") && cssValue5.contains("none")) {

			reportStep("Selected page is underlined and non selected page is not underlined", "Pass");

		} else {
			reportStep("Selected page is not underlined", "Fail");
		}
		return this;
	}

	@Then("Verify educatorcommunity page display with underlined")
	public HP_3Headerteach2 verifytextisunderlined4() {

		navigateto("https://staging.d9.icivics.org/teachers");
		click(propElement(getPropfile(gpropname1, "Teachbutton")));
		waitTime(3000);
		mouseOverAction(getPropfile(gpropname4, "Eclink"));
		waitTime(5000);
		String cssValue4 = propElement(getPropfile(gpropname4, "Eclink")).getCssValue("text-decoration-line");

		if (cssValue4.contains("underline")) {

			reportStep("Selected page is underlined and non selected page is not underlined", "Pass");

		} else {
			reportStep("Selected page is not underlined", "Fail");
		}
		return this;
	}

	@Then("Verify faq page display with underlined")
	public HP_3Headerteach2 verifytextisunderlined5() {
		waitTime(3000);
		mouseOverAction(getPropfile(gpropname4, "Faqlink"));
		waitTime(5000);
		String cssValue5 = propElement(getPropfile(gpropname4, "Faqlink")).getCssValue("text-decoration-line");

		if (cssValue5.contains("underline")) {

			reportStep("Selected page is underlined and non selected page is not underlined", "Pass");

		} else {
			reportStep("Selected page is not underlined", "Fail");
		}
		return this;
	}

	@And("Verify teach menu close on clicking again")
	public HP_3Headerteach2 clickteachbuttonagain() {
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
