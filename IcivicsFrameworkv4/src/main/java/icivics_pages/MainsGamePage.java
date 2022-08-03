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

		
		
		
		WebElement options1 = driver.findElement(By.xpath("//li[@class='active']"));
		String Yellowcolor = "rgba(255, 208, 91, 1)";
		String cssvalue = options1.getCssValue("background-color");
		System.out.println(cssvalue);
		waitTime(3000);
		if (cssvalue.equals(Yellowcolor)) {
			reportStep("Crouseldot is lighted", "Pass");
		} else {
			reportStep("Crouseldot is not lighted", "Fail");
		}
	

		
		return this;
	}

}
