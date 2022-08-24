package icivics_pages;

import java.time.Duration;
import java.util.List;
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

public class Gameload extends ProjectSpecificMethods {
	public String gpropname1 = "PlayHub/Maingamespage";
	public String gpropname2 = "PlayHub/gametile";

	public Gameload(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL,
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
	public Gameload launchURL() {
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
	public Gameload verifygameload1() {

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='square']"));
		int tile = list.size();
		System.out.println(tile);

		for(int i=0;i<tile;i++)
		{
			WebElement list1 = driver.findElement(By.xpath("(//div[@class='square'])/descendant::h3[" + i + "]"));
			list1.click();
			waitTime(3000);
			reportStep(list1 + "is clicked", "Pass");
			switchToFrame(0);
			WebElement loadtime = driver.findElement(By.xpath("//a[@id='clickToPlayBtn']/i"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='clickToPlayBtn']/i")));
			click(loadtime);
			reportStep("Play button clicked", "Pass");

			driver.navigate().back();

			break;
		}
		return this;

	}

}
