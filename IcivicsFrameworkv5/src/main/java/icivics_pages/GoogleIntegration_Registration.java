package icivics_pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class GoogleIntegration_Registration extends ProjectSpecificMethods {
	public String gpropname1 = "GoogleIntegration/GoogleIntegration_SignOn";
	public String gpropname2 = "GoogleIntegration/GoogleIntegration_Registration";

	public GoogleIntegration_Registration(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}
	
	String url = "/classroom/register";
	String URL;
	@Given("Launch the icivis URL")
	public GoogleIntegration_Registration launchURL() {
		if (Environment.equals("Stage.d9")) {
			URL = StageURL + url;
			navigateto(URL);
		} else {
			URL = Stage1URL + url;
			navigateto(URL);
		}
		return this;

	}

	@Then("Enter credentials not registered before and select register as an Educator or parent")
	public GoogleIntegration_Registration verifyclickregisteraseducator() {

		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL+url);
		}else {
			navigateto(Stage1URL+url);
		}
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname1, "Email"));
		waitTime(3000);
		emailfield.sendKeys("amatt.teacher26@gedu.demo.icivics.org");

		WebElement nextbutton = propElement(getPropfile(gpropname1, "Nextbutton"));
		nextbutton.click();
		waitTime(3000);
		WebElement pwdfield = propElement(getPropfile(gpropname1, "Password"));

		pwdfield.sendKeys("Freedom17@");
		waitTime(3000);
		WebElement nextbutton1 = propElement(getPropfile(gpropname1, "Nextbutton"));
		if (nextbutton1.isDisplayed()) {
			nextbutton1.click();
			waitTime(3000);
			reportStep("Registration page display", "Pass");
		} else {
			reportStep("Registration page not display", "Fail");
		}
		WebElement registeraseducatorbutton = propElement(getPropfile(gpropname1, "RegisterasEducator"));
		waitTime(3000);
		registeraseducatorbutton.click();
		String text = (getPropfile(gpropname2, "Headervalue"));
		WebElement header = propElement(getPropfile(gpropname2, "Header"));
		String headertext = header.getText();
		System.out.println(headertext);
		if (headertext.contains(text)) {
			reportStep("Teacher registration page 1 display ", "Pass");
		} else {
			reportStep("Teacher registration page 1 not display ", "Fail");
		}
		return this;
	}

	@Given("Start Registration without being signed in with google and verify the error message")
	public GoogleIntegration_Registration verifyregistrationwithoutsignin() {

		WebElement errormsg = propElement(getPropfile(gpropname2, "Errormsg"));
		String msg = errormsg.getText();
		System.out.println(msg);
		verifyText(errormsg, "Google Classroom token was not set correctly.");
		return this;

	}

	@Given("Start registration with already registered Id and verify the error message")
	public GoogleIntegration_Registration verifyregistrationwithalreadyregisteredID() {
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL+url);
		}else {
			navigateto(Stage1URL+url);
		}
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname1, "Email"));
		waitTime(3000);
		emailfield.sendKeys("amatt.teacher24@gedu.demo.icivics.org");

		WebElement nextbutton = propElement(getPropfile(gpropname1, "Nextbutton"));
		nextbutton.click();
		waitTime(3000);
		WebElement pwdfield = propElement(getPropfile(gpropname1, "Password"));
		pwdfield.sendKeys("Freedom17@");
		waitTime(3000);
		WebElement nextbutton1 = propElement(getPropfile(gpropname1, "Nextbutton"));
		if (nextbutton1.isDisplayed()) {
			nextbutton1.click();
			waitTime(3000);
			reportStep("Registration page display", "Pass");
		} else {
			reportStep("Registration page not display", "Fail");
		}if (Environment.equals("Stage.d9")) {
			navigateto(StageURL+url);
		}else {
			navigateto(Stage1URL+url);
		}
		WebElement errormsg = propElement(getPropfile(gpropname2, "Errormsg1"));
		verifyText(errormsg, "Sorry but you do not have permission to view this page");
		return this;
	}

	@Given("Enter credentials not registered before and select register as Student")
	public GoogleIntegration_Registration verifyregisterasstudentclick() {
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL+url);
		}else {
			navigateto(Stage1URL+url);
		}
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname1, "Email"));
		waitTime(3000);
		emailfield.sendKeys("amatt.teacher30@gedu.demo.icivics.org");

		WebElement nextbutton = propElement(getPropfile(gpropname1, "Nextbutton"));
		nextbutton.click();
		waitTime(3000);
		WebElement pwdfield = propElement(getPropfile(gpropname1, "Password"));

		pwdfield.sendKeys("Freedom17@");
		waitTime(3000);
		WebElement nextbutton1 = propElement(getPropfile(gpropname1, "Nextbutton"));
		if (nextbutton1.isDisplayed()) {
			nextbutton1.click();
			waitTime(3000);
			reportStep("Registration page display", "Pass");
		} else {
			reportStep("Registration page not display", "Fail");
		}
		WebElement registerasstudentbutton = propElement(getPropfile(gpropname1, "RegisterasStudent"));
		waitTime(3000);
		registerasstudentbutton.click();
		waitTime(3000);
		WebElement studentpage = propElement(getPropfile(gpropname2, "Studentpage"));
		if (studentpage.isDisplayed()) {
			verifyText(studentpage, "Your registration is almost complete.");
			reportStep("Student page display", "Pass");
		} else {
			reportStep("Student page is not display", "Fail");
		}
		return this;
	}

	public GoogleIntegration_Registration verifydeleteuserfrombackend() {
		WebElement signinbutton = propElement(getPropfile(gpropname1, "Signinbutton"));
		signinbutton.click();
		waitTime(3000);
		WebElement signinlink = propElement(getPropfile(gpropname1, "Signinlink"));
		signinlink.click();
		WebElement username = propElement(getPropfile(gpropname1, "Username1"));
		username.sendKeys("abhishek.kumar.ameex");
		waitTime(3000);
		WebElement pwd = propElement(getPropfile(gpropname1, "Password"));
		pwd.sendKeys("Abh64*S^K@");
		waitTime(3000);
		WebElement loginbutton = propElement(getPropfile(gpropname1, "Loginbutton"));
		loginbutton.click();
		WebElement people = propElement(getPropfile(gpropname1, "People"));
		people.click();
		waitTime(3000);
		driver.navigate().refresh();
		WebElement chkbox = propElement(getPropfile(gpropname1, "Chkbox"));
		chkbox.click();
		waitTime(3000);
		WebElement dropdown = propElement(getPropfile(gpropname1, "Dropdown"));
		dropdown.click();
		selectDropDownUsingText(dropdown, "Cancel the selected user account(s)");
		waitTime(3000);
		WebElement applybutton = propElement(getPropfile(gpropname1, "Applybutton"));
		applybutton.click();
		waitTime(3000);
		WebElement radiobutton = propElement(getPropfile(gpropname1, "Radiobutton"));
		radiobutton.click();
		waitTime(3000);
		WebElement confirmbutton = propElement(getPropfile(gpropname1, "Confirmbutton"));
		confirmbutton.click();
		waitTime(5000);
		WebElement returntosite = propElement(getPropfile(gpropname1, "Returntosite"));
		waitTime(5000);
		returntosite.click();
		waitTime(3000);
		WebElement myicivcsbutton = propElement(getPropfile(gpropname1, "Myicivicsbutton"));
		myicivcsbutton.click();
		waitTime(3000);
		WebElement myicivcslink = propElement(getPropfile(gpropname1, "Myicivcslink"));
		waitTime(3000);
		myicivcslink.click();
		waitTime(3000);
		WebElement logoutbutton = propElement(getPropfile(gpropname1, "Logoutbutton"));
		logoutbutton.click();
		waitTime(3000);
		return this;

	}
}
