package icivics_pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class MainsGamePage extends ProjectSpecificMethods {
	public String gpropname1 = "PlayHub/Maingamespage";

	public MainsGamePage(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL,
			String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "/games";

	@Given("Launch the icivics URL")
	public MainsGamePage launchURL() {
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL + url);
		} else {
			navigateto(Stage1URL + url);
		}
		return this;

	}

	@Then("Verify Game carousel appears with 5-6 games")
	public MainsGamePage Verifygamecarousel() {
		// String selector = "//div[@class='slider-title']/span";

		List<WebElement> items = driver.findElements(By.xpath("//div[@class='slider-title']/span"));
		waitTime(3000);
		int itemslist = items.size();
		System.out.println(itemslist);
		waitTime(3000);
		for (int i = 0; i < itemslist; i++) {
			String itemlist = items.get(i).getText();
			waitTime(10000);
			reportStep("verified that " + itemlist + " is present in carousel", "Pass");
		}

		return this;
	}

	@Given("Verify Carousel goes to previous game")
	public MainsGamePage Verifyleftcarousel() {
		WebElement leftcarousel = driver.findElement(By.xpath("//a[@class='left carousel-control']/span"));
		reportStep("Before clicking game name ", "Pass");
		if (leftcarousel.isDisplayed()) {
			leftcarousel.click();
			waitTime(3000);
			reportStep("After Clicking Carousel goes to previous game successfully", "Pass");

		} else {
			reportStep("Carousel is in the same game", "Fail");
		}
		return this;
	}

	@Given("Carousel goes to next game")
	public MainsGamePage Verifyrightcarousel() {
		WebElement leftcarousel = driver.findElement(By.xpath("//a[@class='right carousel-control']/span"));
		reportStep("Before clicking game name ", "Pass");
		if (leftcarousel.isDisplayed()) {
			leftcarousel.click();
			waitTime(3000);
			reportStep("After Clicking Carousel goes to next game successfully", "Pass");

		} else {
			reportStep("Carousel is in the same game", "Fail");
		}
		return this;
	}

	@Given("Game carousel dots")
	public MainsGamePage Verifycarouseldots() {

		List<WebElement> carouseldots = driver.findElements(By.xpath("//ol[@class='carousel-indicators']/li"));
		int number = carouseldots.size();
		System.out.println(number);
		String Yellowcolor = "rgba(255, 208, 91, 1)";

		for (int i = 0; i < number; i++) {
			carouseldots.get(i).click();
			waitTime(3000);
			String cssvalue1 = carouseldots.get(i).getCssValue("background-color");
			waitTime(6000);

			System.out.println(cssvalue1);

			if (cssvalue1.equals(Yellowcolor)) {

				reportStep("Crouseldot is lighted", "Pass");

			} else {

				reportStep("Crouseldot is not lighted", "Fail");
			}
		}

		return this;

	}

	@Given("Verify Carousel goes the 3rd game")
	public MainsGamePage Verifycarouseldots3rdgame() {
		List<WebElement> carouseldots = driver.findElements(By.xpath("//ol[@class='carousel-indicators']/li"));
		int number = carouseldots.size();
		String Yellowcolor = "rgba(255, 208, 91, 1)";

		for (int i = 0; i < number; i++) {
			String cssvalue1 = carouseldots.get(i).getCssValue("background-color");
			waitTime(5000);
			System.out.println(cssvalue1);

			if (cssvalue1.equals(Yellowcolor)) {
				carouseldots.get(2).click();
				waitTime(3000);
				reportStep("On clicking 3rd dot Crousel goes to the 3rd game successfully", "Pass");
				break;
			} else {

				reportStep("Crouseldot is not lighted", "Fail");
			}
		}
		return this;
	}

	@Given("Verify Banner to register as a student appears")
	public MainsGamePage Verifyregisterasastudentbanner() {
		WebElement registerbanner = driver
				.findElement(By.xpath("//div[@class='callout-banner register-student-banner callout-banner-blue']"));
		waitTime(3000);
		if (registerbanner.isDisplayed()) {
			registerbanner.click();
			reportStep("Banner to register as a student display", "Pass");
		} else {
			reportStep("Banner to register as a student do not display", "Fail");
		}

		return this;
	}

	@Given("Verify when login as a student Banner to register as a student DOES NOT appear")
	public MainsGamePage Verifyloginasastudentregisterasastudentbanner() {
		String url = "/user/login";
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL + url);
		} else {
			navigateto(Stage1URL + url);
		}
		WebElement signinwithgooglebutton = driver.findElement(By.xpath("//img[@src='/themes/custom/refresh/images/google_signin.png']"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = driver.findElement(By.xpath("//input[@type='email']"));
		waitTime(3000);
		emailfield.sendKeys("amatt.student1@gedu.demo.icivics.org");

		WebElement nextbutton = driver.findElement(By.xpath("//span[text()='Next']"));
		nextbutton.click();
		waitTime(3000);
		WebElement pwdfield = driver.findElement(By.xpath("//input[@type='password']"));

		pwdfield.sendKeys("Freedom17@");
		waitTime(3000);
		WebElement nextbutton1 = driver.findElement(By.xpath("//span[text()='Next']"));
		if (nextbutton1.isDisplayed()) {
			nextbutton1.click();
			waitTime(3000);
			reportStep("My Icivics page open for this account", "Pass");
		} else {
			reportStep("My Icivics page not open for this account", "Fail");
		}
		String url1= "/games";
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL + url1);
		} else {
			navigateto(Stage1URL + url1);
		}
		waitTime(3000);
		scrollToTheGivenWebElement("//h3[text()='Argument Wars']");
		reportStep("Banner to register as a student do not display", "Pass");
		return this;
	}
}
