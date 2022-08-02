package icivics_pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class Googlestudentregistration extends ProjectSpecificMethods {
	public String gpropname1 = "GoogleIntegration/GoogleSignOn";
	public String gpropname2 = "GoogleIntegration/GoogleRegistration";
	public String gpropname3 = "GoogleIntegration/Page1TeacherRegistration";
	public String gpropname4 = "GoogleIntegration/Page2TeacherRegistration";
	public String gpropname5 = "GoogleIntegration/Page3TeacherRegistration";
	public String gpropname6 = "GoogleIntegration/Googlestudentregistration";
	public String gpropname7 = "GoogleIntegration/Email";

	public Googlestudentregistration(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment,
			String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "/user/login";

	@Given("Launch the icivis URL")
	public Googlestudentregistration launchURL() {
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL + url);
		} else {
			navigateto(Stage1URL + url);
		}
		return this;

	}

	public Googlestudentregistration verifyregisterasstudent() {
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

		nextbutton1.click();
		waitTime(3000);
		WebElement studentasregisterbutton = propElement(getPropfile(gpropname6, "Registerasstudent"));
		studentasregisterbutton.click();
		waitTime(3000);
		return this;
	}

	@Then("Verify field for agree to terms of use privacy policy")
	public Googlestudentregistration verifyagreetotermsfield() {
		WebElement agreetoterrms = propElement(getPropfile(gpropname6, "Agreetoterms"));

		if (agreetoterrms.isDisplayed()) {
			reportStep("Agreetoterrms field is not checked by default", "Pass");
		} else {
			reportStep("Agreetoterrms field is checked", "Fail");
		}
		WebElement finishbutton = propElement(getPropfile(gpropname6, "Finishbutton"));
		if (finishbutton.isDisplayed()) {
			reportStep("Finish button is present", "Pass");
		} else {
			reportStep("Finish button is not present", "Fail");
		}
		return this;
	}

	@Given("Leave agree to terms of use checkbox unchecked and click finish and verify the result")
	public Googlestudentregistration verifyerrormsg() {

		WebElement finishbutton = propElement(getPropfile(gpropname6, "Finishbutton"));
		finishbutton.click();
		waitTime(3000);
		WebElement errormsg = propElement(getPropfile(gpropname6, "Errormsg"));
		WebElement errormsg1 = propElement(getPropfile(gpropname6, "Errormsg1"));
		WebElement errormsg2 = propElement(getPropfile(gpropname6, "Errormsg2"));
		if (errormsg.isDisplayed() && errormsg1.isDisplayed() && errormsg2.isDisplayed()) {
			waitTime(3000);
			verifyPartialText(errormsg, "1 error has been found:");
			reportStep(errormsg.getText() + " is verified", "Pass");
			verifyPartialText(errormsg1, "I agree to the");
			reportStep(errormsg1.getText() + " is verified", "Pass");
			verifyPartialText(errormsg2, "You must agree with Terms of Use and Privacy Policy to register!");
			reportStep(errormsg2.getText() + " is verified", "Pass");
		} else {
			reportStep("Errormsg is not present", "Fail");
		}

		return this;
	}

	@Given("Verify Check box for agree to terms of use and click finish")
	public Googlestudentregistration verifysubmit() throws IOException {
		WebElement agreetoterrms = propElement(getPropfile(gpropname6, "Agreetoterms"));
		if (agreetoterrms.isDisplayed()) {
			agreetoterrms.click();
			reportStep("Checkbox is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		WebElement finishbutton = propElement(getPropfile(gpropname6, "Finishbutton"));
		if (finishbutton.isDisplayed()) {
			finishbutton.click();
			waitTime(3000);
			reportStep("Student registration is done ", "Pass");
		} else {
			reportStep("Student registration is not done ", "Fail");
		}
		WebElement studentemail = propElement(getPropfile(gpropname6, "generateemail"));
		String studentgeneratedemail = studentemail.getText();
		writePropfile("GoogleIntegration/Email", "EmailID", studentgeneratedemail);
		waitTime(3000);
		WebElement logout = propElement(getPropfile(gpropname6, "Logoutbutton"));
		waitTime(3000);
		logout.click();
		return this;
	}

	public Googlestudentregistration verifydeleteuserfrombackend() {
		WebElement signinbutton = propElement(getPropfile(gpropname5, "Signinbutton"));
		waitTime(3000);
		signinbutton.click();

		WebElement signinlink = propElement(getPropfile(gpropname5, "Signinlink"));
		signinlink.click();
		WebElement username = propElement(getPropfile(gpropname5, "Username1"));
		username.sendKeys("abhishek.kumar.ameex");
		waitTime(3000);
		WebElement pwd = propElement(getPropfile(gpropname5, "Password"));
		pwd.sendKeys("Abh64*S^K@");
		waitTime(3000);
		WebElement loginbutton = propElement(getPropfile(gpropname5, "Loginbutton"));
		loginbutton.click();
		WebElement people = propElement(getPropfile(gpropname5, "People"));
		people.click();
		waitTime(3000);
		String studentgeneratedemail = getPropfile(gpropname7, "EmailID");
		WebElement emailfield = propElement(getPropfile(gpropname1, "Emailfield"));
		emailfield.sendKeys(studentgeneratedemail);
		WebElement filterbutton = propElement(getPropfile(gpropname1, "Filterbutton"));
		filterbutton.click();
		waitTime(3000);
		WebElement emailfield2 = propElement(getPropfile(gpropname1, "EmailId2"));
		String Emailid2 = emailfield2.getText();
		if (studentgeneratedemail.equals(Emailid2)) {
			driver.findElement(By.xpath("(//input[@class='form-checkbox'])[2]")).click();
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
		} else {
			reportStep("Email id is mismatch ", "Fail");
		}

		return this;

	}
}
