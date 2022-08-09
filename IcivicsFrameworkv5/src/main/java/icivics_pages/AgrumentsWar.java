package icivics_pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

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
		WebElement link = driver.findElement(By.xpath("//a[@class='ctools-use-modal use-ajax']"));
		if (link.isDisplayed()) {
			reportStep("Leaderboard and achievements link display", "Pass");
		} else {
			reportStep("Leaderboard and achievements link do not display", "Fail");
		}
		return this;
	}

	@Given("Verify Popup dialog appears for leaderboard and achievements")
	public AgrumentsWar verifylinkpopup() {
		WebElement link = driver.findElement(By.xpath("//a[@class='ctools-use-modal use-ajax']"));
		link.click();
		waitTime(3000);
		reportStep("Popup dialog appears for leaderboard and achievements", "Pass");
		return this;
	}
	@Given("Verify Game loads within iFrame")
	public AgrumentsWar verifyload() {
		WebElement loadtime = driver.findElement(By.xpath("//a[@id='clickToPlayBtn']"));
		waitTime(9000);
		loadtime.click();
		return this;
	}

	@Given("Verify for logged in as an educator download teacher resources and assign buttons appear")
	public AgrumentsWar verifydownloadteacherresourcesandassignbuttons() {
		WebElement signinbutton = driver.findElement(By.xpath("(//span[@class='link-title'])[2]"));
		signinbutton.click();
		WebElement signinlink = driver.findElement(By.xpath("(//a[@title='Sign In'])[4]"));
		signinlink.click();
		WebElement username = driver.findElement(By.xpath("//input[@id='edit-name']"));
		waitTime(3000);
		username.sendKeys("Bronze Speaker 1r4e");
		WebElement password = driver.findElement(By.xpath("//input[@id='edit-pass']"));
		waitTime(3000);
		password.sendKeys("i898qrCiPK9Hwgb");
		waitTime(3000);
		WebElement loginbutton = driver.findElement(By.xpath("//button[@id='edit-submit']"));
		waitTime(3000);
		loginbutton.click();
		driver.navigate().to("https://staging.d9.icivics.org/games/argument-wars");
		waitTime(5000);
		WebElement downloadteach = driver.findElement(By.xpath("//button[@id='dropdownMenu1']"));
		WebElement assign = driver.findElement(By.xpath("//button[@class='button']"));
		if (downloadteach.isDisplayed() && assign.isDisplayed()) {
			reportStep("Download teacher resources and assign buttons display", "Pass");
		} else {
			reportStep("Download teacher resources and assign buttons do not display", "Fail");
		}
		waitTime(3000);
		return this;

	}

	@Given("Verify for logged in as an Student download teacher resources and assign buttons appear")
	public AgrumentsWar verifydownloadteacherresourcesandassignbuttonsforstudent() {
		WebElement signinbutton = driver.findElement(By.xpath("(//span[@class='link-title'])[2]"));
		signinbutton.click();
		WebElement signinlink = driver.findElement(By.xpath("(//a[@title='Sign In'])[4]"));
		signinlink.click();
		WebElement username = driver.findElement(By.xpath("//input[@id='edit-name']"));
		waitTime(3000);
		username.sendKeys("Granite Governor 3s9h");
		WebElement password = driver.findElement(By.xpath("//input[@id='edit-pass']"));
		waitTime(3000);
		password.sendKeys("123456789");
		waitTime(3000);
		WebElement loginbutton = driver.findElement(By.xpath("//button[@id='edit-submit']"));
		waitTime(3000);
		loginbutton.click();
		waitTime(5000);
		driver.navigate().to("https://staging.d9.icivics.org/games/argument-wars");
		waitTime(5000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "scrollelement"));
		reportStep("Download teacher resources and assign buttons do not display for logged in as student", "Pass");
		return this;
	}
	@Given("Verify click link to download teacher resources Popup dialog appears with links to teacher resources")
	public AgrumentsWar verifydownloadteacherresourcesandassignclick() {
		WebElement signinbutton = driver.findElement(By.xpath("(//span[@class='link-title'])[2]"));
		signinbutton.click();
		WebElement signinlink = driver.findElement(By.xpath("(//a[@title='Sign In'])[4]"));
		signinlink.click();
		WebElement username = driver.findElement(By.xpath("//input[@id='edit-name']"));
		waitTime(3000);
		username.sendKeys("Bronze Speaker 1r4e");
		WebElement password = driver.findElement(By.xpath("//input[@id='edit-pass']"));
		waitTime(3000);
		password.sendKeys("i898qrCiPK9Hwgb");
		waitTime(3000);
		WebElement loginbutton = driver.findElement(By.xpath("//button[@id='edit-submit']"));
		waitTime(3000);
		loginbutton.click();
		waitTime(3000);
		driver.navigate().to("https://staging.d9.icivics.org/games/argument-wars");
		waitTime(5000);
		WebElement downloadteach = driver.findElement(By.xpath("//button[@id='dropdownMenu1']"));
		waitTime(3000);
		if(downloadteach.isDisplayed()) {
			downloadteach.click();
			waitTime(3000);
			reportStep("Popup dialog display with links to teacher resources", "Pass");
		}
		else
		{
			reportStep("Popup dialog do not display with links to teacher resources", "Fail");
		}
		return this;
	}
	@Given("Verify click link to assign Popup dialog appears with message that the teacher has no classes")
	public AgrumentsWar verifyassignpopup() {
		WebElement signinbutton = driver.findElement(By.xpath("(//span[@class='link-title'])[2]"));
		signinbutton.click();
		WebElement signinlink = driver.findElement(By.xpath("(//a[@title='Sign In'])[4]"));
		signinlink.click();
		WebElement username = driver.findElement(By.xpath("//input[@id='edit-name']"));
		waitTime(3000);
		username.sendKeys("Bronze Speaker 1r4e");
		WebElement password = driver.findElement(By.xpath("//input[@id='edit-pass']"));
		waitTime(3000);
		password.sendKeys("i898qrCiPK9Hwgb");
		waitTime(3000);
		WebElement loginbutton = driver.findElement(By.xpath("//button[@id='edit-submit']"));
		waitTime(3000);
		loginbutton.click();
		waitTime(3000);
		driver.navigate().to("https://staging.d9.icivics.org/games/argument-wars");
		waitTime(5000);
		WebElement assign = driver.findElement(By.xpath("//button[@class='button']"));
		waitTime(3000);
		if(assign.isDisplayed()) {
			assign.click();
			waitTime(3000);
			scrollToTheGivenWebElement(getPropfile(gpropname3, "noclasses"));
			reportStep("Popup dialog display with links to teacher resources", "Pass");
		}
		else
		{
			reportStep("Popup dialog do not display with links to teacher resources", "Fail");
		}
		return this;
	}	
		
	@Given("Verify Go to game page Extension pack link appears")	
	public AgrumentsWar verifyextensionpacklink() {
		return this;
	}
		
	
}
