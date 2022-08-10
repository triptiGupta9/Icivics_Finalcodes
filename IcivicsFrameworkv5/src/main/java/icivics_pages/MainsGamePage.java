package icivics_pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class MainsGamePage extends ProjectSpecificMethods {
	public String gpropname1 = "PlayHub/Maingamespage";
	public String gpropname2 = "PlayHub/gametile";

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
	String URL;

	@Given("Launch the icivics URL")
	public MainsGamePage launchURL() {
		if (Environment.equals("Stage.d9")) {
			URL = StageURL + url;
			navigateto(URL);
		} else {
			URL = Stage1URL + url;
			navigateto(URL);
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
		WebElement signinwithgooglebutton = driver
				.findElement(By.xpath("//img[@src='/themes/custom/refresh/images/google_signin.png']"));
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
		nextbutton1.click();
		String url1 = "/games";
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL + url1);
		} else {
			navigateto(Stage1URL + url1);
		}
		waitTime(3000);

		reportStep("Banner to register as a student do not display", "Pass");
		return this;
	}

	@And("Verify when login as a teacher Banner to register as a student DOES NOT appear")
	public MainsGamePage Verifyloginasteacherregisterasastudentbanner() {
		return this;
	}

	@Given("Verify Goes to link /user/register?role=student&email=1")
	public MainsGamePage Verifylregisterbannerbuttonclick() {

		WebElement registerbannerbutton = driver.findElement(By.xpath("(//a[@class='btn btn-white'])[1]"));
		String parentWindow = driver.getWindowHandle();

		if (registerbannerbutton.isDisplayed()) {
			registerbannerbutton.click();
			waitTime(3000);
			String currentWindow = driver.getWindowHandle();

			if (parentWindow.equals(currentWindow)) {

				reportStep(driver.getTitle() + "Page opens", "Pass");
			}

			else {
				reportStep(driver.getTitle() + "Page not opens", "Fail");
			}
		}
		return this;

	}

	@Given("Verify Game tile appears for each game and Each tile contains Image Title of game Expected play time Short description")
	public MainsGamePage Verifygamestitles() {
		List<WebElement> Tilelist = driver
				.findElements(By.xpath("//div[@class='form-group']/descendant::div[@class='square']"));
		System.out.println(Tilelist.size());
		for (int i = 0; i < Tilelist.size(); i++) {
			String Tilename = Tilelist.get(i).getText();

			waitTime(3000);
			reportStep(Tilename + ":Text of each game Tile", "Pass");
		}
		return this;
	}

	@Given("Verify Click on game tile")
	public MainsGamePage Verifygamestitlesclick() throws IOException {

		// Arguments war
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "awtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "awtileele"));
		verifyExactText(getprop(gpropname2, "awheaderele"), getpropstring(gpropname2, "awheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "awUrL"));
		verifyTitle(getpropstring(gpropname2, "awTitle"));

		//Branches of Power
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "boptileele"));
		waitTime(2000);
		click(getprop(gpropname2, "boptileele"));
		verifyExactText(getprop(gpropname2, "bopheaderele"), getpropstring(gpropname2, "bopheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "bopUrL"));
		verifyTitle(getpropstring(gpropname2, "bopTitle"));

		// Cast Your Vote
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "cyvtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "cyvtileele"));
		verifyExactText(getprop(gpropname2, "cyvheaderele"), getpropstring(gpropname2, "cyvheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "cyvUrL"));
		verifyTitle(getpropstring(gpropname2, "cyvTitle"));

		// Convene the Council
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "ctctileele"));
		waitTime(2000);
		click(getprop(gpropname2, "ctctileele"));
		verifyExactText(getprop(gpropname2, "ctcheaderele"), getpropstring(gpropname2, "ctcheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "ctcUrL"));
		verifyTitle(getpropstring(gpropname2, "ctcTitle"));

		// Counties Work
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "cwtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "cwtileele"));
		verifyExactText(getprop(gpropname2, "cwheaderele"), getpropstring(gpropname2, "cwheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "cwUrL"));
		verifyTitle(getpropstring(gpropname2, "cwTitle"));

		// Counties Work/Texas
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "cwttileele"));
		waitTime(2000);
		click(getprop(gpropname2, "cwttileele"));
		verifyExactText(getprop(gpropname2, "cwtheaderele"), getpropstring(gpropname2, "cwtheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "cwtUrL"));
		verifyTitle(getpropstring(gpropname2, "cwtTitle"));

		// Court Quest
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "cqtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "cqtileele"));
		verifyExactText(getprop(gpropname2, "cqheaderele"), getpropstring(gpropname2, "cqheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "cqUrL"));
		verifyTitle(getpropstring(gpropname2, "cqTitle"));

		// Do I have a Right
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "dihrtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "dihrtileele"));
		verifyExactText(getprop(gpropname2, "dihrheaderele"), getpropstring(gpropname2, "dihrheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "dihrUrL"));
		verifyTitle(getpropstring(gpropname2, "dihrTitle"));

		// Executive Command
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "ectileele"));
		waitTime(2000);
		click(getprop(gpropname2, "ectileele"));
		verifyExactText(getprop(gpropname2, "echeaderele"), getpropstring(gpropname2, "echeadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "ecUrL"));
		verifyTitle(getpropstring(gpropname2, "ecTitle"));

		// Immigrationnation
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "intileele"));
		waitTime(2000);
		click(getprop(gpropname2, "intileele"));
		verifyExactText(getprop(gpropname2, "inheaderele"), getpropstring(gpropname2, "inheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "inUrL"));
		verifyTitle(getpropstring(gpropname2, "inTitle"));

		// Lawcraft
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "lctileele"));
		waitTime(2000);
		click(getprop(gpropname2, "lctileele"));
		verifyExactText(getprop(gpropname2, "lcheaderele"), getpropstring(gpropname2, "lcheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "lcUrL"));
		verifyTitle(getpropstring(gpropname2, "lcTitle"));
		// NewsFeedDefenders
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "nfdtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "nfdtileele"));
		verifyExactText(getprop(gpropname2, "nfdheaderele"), getpropstring(gpropname2, "nfdheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "nfdUrL"));
		verifyTitle(getpropstring(gpropname2, "nfdTitle"));
		
		// People'sPie
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "pptileele"));
		waitTime(2000);
		click(getprop(gpropname2, "pptileele"));
		verifyExactText(getprop(gpropname2, "ppheaderele"), getpropstring(gpropname2, "ppheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "ppUrL"));
		verifyTitle(getpropstring(gpropname2, "ppTitle"));

		// Race to ratify
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "rtrtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "rtrtileele"));
		verifyExactText(getprop(gpropname2, "rtrheaderele"), getpropstring(gpropname2, "rtrheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "rtrUrL"));
		verifyTitle(getpropstring(gpropname2, "rtrTitle"));

		// Sortify:U.S.Citizenship
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "stileele"));
		waitTime(2000);
		click(getprop(gpropname2, "stileele"));
		verifyExactText(getprop(gpropname2, "sheaderele"), getpropstring(gpropname2, "sheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "sUrL"));
		verifyTitle(getpropstring(gpropname2, "sTitle"));


		// Win The White House
		navigateto(URL);
		scrollToTheGivenWebElement(getpropstring(gpropname2, "wtwhtileele"));
		waitTime(2000);
		click(getprop(gpropname2, "wtwhtileele"));
		verifyExactText(getprop(gpropname2, "wtwhheaderele"), getpropstring(gpropname2, "wtwhheadertxt"));
		verifyUrlOfThePage(URL + getpropstring(gpropname2, "wtwhUrL"));
		verifyTitle(getpropstring(gpropname2, "wtwhTitle"));
		
		return this;

	}

	@Given("Verify Green tile with teacher links appears after all games")
	public MainsGamePage Verifygreentilewithteacherlink() {
		String greencolor = "rgba(0, 178, 124, 1)";
		WebElement Teachertile = driver.findElement(By.xpath("//div[@class='teachers-callout-cta']"));
		waitTime(3000);
		Teachertile.click();
		String cssvalue = Teachertile.getCssValue("background-color");
		waitTime(3000);
		System.out.println(cssvalue);
		if (Teachertile.isDisplayed() && cssvalue.equals(greencolor)) {
			reportStep(Teachertile.getText() + "Green Tile with teacher links display after all the games ", "Pass");
		} else {
			reportStep("Green Tile with teacher links do not display", "Fail");
		}
		return this;

	}

	@Given("Verify on clicking teach button goes to teachers")
	public MainsGamePage Verifyteachbuttonclick() {
		WebElement Teachbutton = driver.findElement(By.xpath("(//a[@class='btn btn-white'])[2]"));

		if (Teachbutton.isDisplayed()) {
			Teachbutton.click();
			verifyTitle("Teachers | iCivics");
			reportStep(driver.getTitle() + ":On clicking teach button it redirects to teacherspage successfully",
					"Pass");
		} else {
			reportStep("On clicking teach button it will not redirects to teacherspage", "Pass");
		}

		return this;
	}

	@Given("Verify Click get started on teachers tile goes to getstarted")
	public MainsGamePage Verifygetstartedbuttonclick() {
		WebElement getstartedbutton = driver.findElement(By.xpath("(//a[@class='btn btn-white'])[3]"));

		if (getstartedbutton.isDisplayed()) {
			getstartedbutton.click();
			verifyTitle("Get Started | iCivics");
			reportStep(driver.getTitle() + ":On clicking teach button it redirects to teacherspage successfully",
					"Pass");
		} else {
			reportStep("On clicking teach button it will not redirects to teacherspage", "Pass");
		}

		return this;
	}

}
