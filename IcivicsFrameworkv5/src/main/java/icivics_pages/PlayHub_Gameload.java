package icivics_pages;

import java.awt.AWTException;

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

public class PlayHub_Gameload extends ProjectSpecificMethods {
	public String gpropname1 = "PlayHub/Maingamespage";
	public String gpropname2 = "PlayHub/gametile";
	public String gpropname3 = "PlayHub/Argumentwars";

	public PlayHub_Gameload(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL,
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
	public PlayHub_Gameload launchURL() {
		if (Environment.equals("Stage.d9")) {
			URL = StageURL + url;
			navigateto(URL);
		} else {
			URL = Stage1URL + url;
			navigateto(URL);
		}
		return this;

	}

	@Then("Verify Game loads for all the games within iFrame")
	public PlayHub_Gameload verifygameload1() throws IOException, AWTException {
		String url = "/user/login";
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL + url);
		} else {
			navigateto(Stage1URL + url);
		}
		waitTime(2000);
		propElement(getPropfile(gpropname3, "Signin")).click();
		propElement(getPropfile(gpropname3, "Signinlink")).click();
		propElement(getPropfile(gpropname3, "Username")).sendKeys("Bronze Speaker 1r4e");
		propElement(getPropfile(gpropname3, "Password")).sendKeys("i898qrCiPK9Hwgb");
		propElement(getPropfile(gpropname3, "Loginbutton")).click();
		waitTime(3000);
		
		// Arguments war
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "awtileele"));
		click(getprop(gpropname2, "awtileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime.click();
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();

		// Branches of Power
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "boptileele"));
		click(getprop(gpropname2, "boptileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime1 = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime1.click();
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();

		// Cast Your Vote
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "cyvtileele"));
		click(getprop(gpropname2, "cyvtileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime2 = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime2.click();
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();

		// Convene the Council
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "ctctileele"));
		waitTime(2000);
		click(getprop(gpropname2, "ctctileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime3 = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime3.click();
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();
		
		// Counties Work
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "cwtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "cwtileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime4 = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime4.click();
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();
		
		// Counties Work/Texas
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "cwttileele"));
		waitTime(2000);
		click(getprop(gpropname2, "cwttileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime5 = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime5.click();
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();
		
		// Court Quest navigateto(URL);
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "cqtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "cqtileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime6 = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime6.click();
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();
		
		// Do I have a Right
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "dihrtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "dihrtileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime7 = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime7.click();
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();

		// Executive Command navigateto(URL);
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "ectileele"));
		waitTime(2000);
		click(getprop(gpropname2, "ectileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime8 = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime8.click();
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();

		// Immigrationnation navigateto(URL);
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "intileele"));
		waitTime(2000);
		click(getprop(gpropname2, "intileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime9 = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime9.click();
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();

		// Lawcraft navigateto(URL);
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "lctileele"));
		waitTime(2000);
		click(getprop(gpropname2, "lctileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime10 = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime10.click();
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();
		
		// NewsFeedDefenders
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "nfdtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "nfdtileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime11 = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime11.click();
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();

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

		// Race to ratify navigateto(URL);
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "rtrtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "rtrtileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime12 = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime12.click();
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();
		
		// Sortify:U.S.Citizenship
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "stileele"));
		waitTime(2000);
		click(getprop(gpropname2, "stileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime13 = propElement(getPropfile(gpropname3, "LoadTime1"));
		WebDriverWait wait13 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait13.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Sortifystartbutton"))));
		loadtime13.click();	
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();

		// Win The White House navigateto(URL);
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "wtwhtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "wtwhtileele"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Fullscreen"));
		switchToFrame(0);
		zoomout();
		WebElement loadtime14 = propElement(getPropfile(gpropname3, "LoadTime"));
		WebDriverWait wait14 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait14.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPropfile(gpropname2, "Playbutton"))));
		loadtime14.click();		
		waitTime(6000);
		reportStep("Game is loading inside the frame", "Pass");
		zoomin();

		return this;

	}

}
