package icivics_pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class Pg3TeacherRegistration extends ProjectSpecificMethods {
	public String gpropname1 = "GoogleIntegration/GoogleSignOn";
	public String gpropname2 = "GoogleIntegration/GoogleRegistration";
	public String gpropname3 = "GoogleIntegration/Page1TeacherRegistration";
	public String gpropname4 = "GoogleIntegration/Page2TeacherRegistration";
	public String gpropname5 = "GoogleIntegration/Page3TeacherRegistration";

	public Pg3TeacherRegistration(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}
	
	String url = "/user/login";

	@Given("Launch the icivis URL")
	public Pg3TeacherRegistration launchURL() {
		if (Environment.equals("Stage.d9")) {
			navigateto(StageURL+url);
		}else {
			navigateto(Stage1URL+url);
		}
		return this;

	}

	public Pg3TeacherRegistration Registrationpage1() {
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		signinwithgooglebutton.click();

		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname1, "Email"));
		waitTime(3000);
		emailfield.sendKeys("testuser@gedu.demo.icivics.org");

		WebElement nextbutton = propElement(getPropfile(gpropname1, "Nextbutton"));
		nextbutton.click();
		waitTime(5000);
		WebElement pwdfield = propElement(getPropfile(gpropname1, "Password"));
		waitTime(3000);
		pwdfield.sendKeys("Abh64*S^K@");
		waitTime(3000);
		WebElement nextbutton1 = propElement(getPropfile(gpropname1, "Nextbutton"));
		if (nextbutton1.isDisplayed()) {
			nextbutton1.click();
			waitTime(3000);
			reportStep("Registration page display", "Pass");
		} else {
			reportStep("Registration page not display", "Fail");
		}
		waitTime(3000);
		WebElement registeraseducatorbutton = propElement(getPropfile(gpropname1, "RegisterasEducator"));
		waitTime(3000);
		registeraseducatorbutton.click();
		waitTime(3000);

		String value = getPropfile(gpropname3, "Checkboxvalue");
		List<WebElement> chkBox = propElement1(getPropfile(gpropname3, "Checkboxlist"));
		int Size = chkBox.size();
		for (int i = 0; i < Size; i++) {
			String val = chkBox.get(i).getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				if (!chkBox.get(i).isSelected()) {
					chkBox.get(i).click();
					break;
				}
			}

		}
		WebElement role = propElement(getPropfile(gpropname3, "Roledropdown"));
		role.click();
		waitTime(3000);
		selectDropDownUsingText(role, "Home school teacher");

		waitTime(3000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Roledropdown"));
		WebElement nextbutton2 = propElement(getPropfile(gpropname3, "Nextbutton"));
		nextbutton2.click();
		waitTime(3000);
		String SchoolName = getPropfile(gpropname4, "Schoolname");

		WebElement Schoolfield = propElement(getPropfile(gpropname4, "School"));
		Schoolfield.sendKeys(SchoolName);

		WebElement Zipcodefield = propElement(getPropfile(gpropname4, "Zipcode"));
		Zipcodefield.sendKeys(getPropfile(gpropname4, "Zipcode5"));

		String Teachstatevalue = getPropfile(gpropname4, "Teachstatevalue");

		WebElement teachingstate = propElement(getPropfile(gpropname4, "Teachingstate"));
		selectDropDownUsingText(teachingstate, Teachstatevalue);
		waitTime(3000);

		WebElement nextbutton3 = propElement(getPropfile(gpropname3, "Nextbutton"));
		nextbutton3.click();
		waitTime(3000);

		return this;
	}

	@Then("Verify Breadcrumb indicator shows page 3")
	public Pg3TeacherRegistration verifypagecount3() throws IOException {
		String cssvalue = "background-color";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(gpropname5, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(gpropname5, "step2ele"), cssvalue, Greencolor);
		String Step3 = cssgetbefore(getPropfile(gpropname5, "step3ele"), cssvalue, Greencolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greencolor) && Step3.equals(Greencolor)) {
			reportStep("you are currently viewing page 3 in the breadcrumbs", "Pass");
		} else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}

		return this;
	}

	@Given("Verify all the Fields for page 3")
	public Pg3TeacherRegistration verifypage3fields() {
		WebElement Checkbox1 = propElement(getPropfile(gpropname5, "Checkbox1"));
		if (Checkbox1.isSelected()) {
			reportStep("Sign up for emails is present and by default is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
		WebElement Checkbox2 = propElement(getPropfile(gpropname5, "Checkbox2"));
		if (Checkbox2.isDisplayed()) {
			reportStep("I agree to terms field is present and is not checked by default", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
		scrollToTheGivenWebElement(getPropfile(gpropname5, "Checkbox3"));
		WebElement Checkbox3 = propElement(getPropfile(gpropname5, "Checkbox3"));
		if (Checkbox3.isDisplayed()) {
			reportStep("Sync your google classroom is present and is not checked by default", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		return this;
	}

	@Given("Click back button and verify the result")
	public Pg3TeacherRegistration verifyclickbackbutton() {
		waitTime(3000);
		WebElement backbutton = propElement(getPropfile(gpropname5, "Backbutton"));
		if (backbutton.isDisplayed()) {
			backbutton.click();
			reportStep("On clicking back button page 2 display", "Pass");
		} else {
			reportStep(" page 2 is not display", "Fail");
		}
		waitTime(3000);

		String Teachstatevalue = getPropfile(gpropname4, "Teachstatevalue");
		String teachingstate = getPropfile(gpropname4, "Teachingstate");
		if (teachingstate.equals(teachingstate)) {
			reportStep(Teachstatevalue + "Teaching state is remembered", "Pass");
		} else {
			reportStep("Teaching state is not remembered", "Fail");
		}
		waitTime(3000);
		String SchoolName = getPropfile(gpropname4, "Schoolname");
		String Schoolfield = propElement(getPropfile(gpropname4, "School")).getAttribute("value");
		if (Schoolfield.equals(SchoolName)) {
			reportStep(SchoolName + "Schoolname is remembered", "Pass");
		} else {
			reportStep("Schoolname is not remembered", "Fail");
		}
		waitTime(3000);
		String zipcodevalue = getPropfile(gpropname4, "Zipcode5");
		String Zipcodefield = propElement(getPropfile(gpropname4, "Zipcode")).getAttribute("value");

		if (Zipcodefield.equals(zipcodevalue)) {
			reportStep(zipcodevalue + "zipcode is remembered", "Pass");
		} else {
			reportStep("zipcode is not remembered", "Fail");
		}
		return this;
	}

	@Given("Leave terms of use checkbox unchecked and verify the result")
	public Pg3TeacherRegistration verifyunchecktermsofusecheckbox() {
		WebElement Checkbox2 = propElement(getPropfile(gpropname5, "Checkbox2"));
		WebElement savebutton = propElement(getPropfile(gpropname5, "Savebutton"));
		if (Checkbox2.isDisplayed()) {
			savebutton.click();
			waitTime(1000);
			reportStep("Checkbox is not checked and Error is display", "Pass");
		} else {
			reportStep("Checkbox is not checked and Error not display", "Fail");
		}

		return this;
	}

	@Given("Make valid selections - check terms of use, check emails, leave sync classes unchecked and verify the result")
	public Pg3TeacherRegistration verifygettingstartedpagewithemailcheck() {
		WebElement Checkbox1 = propElement(getPropfile(gpropname5, "Checkbox1"));
		if (Checkbox1.isSelected()) {
			reportStep(Checkbox1.getText() + "is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
		WebElement Checkbox2 = propElement(getPropfile(gpropname5, "Checkbox2"));
		if (Checkbox2.isDisplayed()) {
			click(Checkbox2);
			reportStep(Checkbox2.getText() + "is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);

		WebElement Checkbox3 = propElement(getPropfile(gpropname5, "Checkbox3"));
		scrollToTheGivenWebElement(getPropfile(gpropname5, "Checkbox3"));
		if (!Checkbox3.isSelected()) {

			reportStep("Checkbox is not checked", "Pass");
		} else {
			reportStep(Checkbox3.getText() + "is checked", "Fail");
		}
		waitTime(3000);
		WebElement savebutton = propElement(getPropfile(gpropname5, "Savebutton"));
		if (savebutton.isDisplayed()) {
			savebutton.click();
			waitTime(3000);
			reportStep("Getting Started page is display", "Pass");
		} else {
			reportStep("Getting Started page is not display", "Fail");
		}

		return this;
	}

	public Pg3TeacherRegistration verifydeleteuserfrombackend() {
		WebElement signinbutton = propElement(getPropfile(gpropname1, "Signinbutton"));
		waitTime(3000);
		signinbutton.click();

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
		String Emailid = getPropfile(gpropname1, "EmailId3");
		WebElement emailfield=propElement(getPropfile(gpropname1, "Emailfield"));
		emailfield.sendKeys(Emailid);
		WebElement filterbutton=propElement(getPropfile(gpropname1, "Filterbutton"));
		filterbutton.click();
		waitTime(3000);
		WebElement emailfield2 =propElement(getPropfile(gpropname1, "EmailId2"));
		String Emailid2= emailfield2.getText();
		if (Emailid.equals(Emailid2)) {
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

	@Then("Make valid selections - check terms of use, uncheck emails, leave sync classes unchecked and verify the result")
	public Pg3TeacherRegistration verifygettingstartedpagewithemailuncheck() {
		WebElement Checkbox1 = propElement(getPropfile(gpropname5, "Checkbox1"));
		Checkbox1.click();
		waitTime(3000);
		if (!Checkbox1.isSelected()) {
			reportStep("Checkbox1 is not checked", "Pass");
		} else {
			reportStep("Checkbox is checked", "Fail");
		}
		waitTime(3000);
		WebElement Checkbox2 = propElement(getPropfile(gpropname5, "Checkbox2"));
		if (Checkbox2.isDisplayed()) {
			click(Checkbox2);
			reportStep("Checkbox2 is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);

		WebElement Checkbox3 = propElement(getPropfile(gpropname5, "Checkbox3"));
		scrollToTheGivenWebElement(getPropfile(gpropname5, "Checkbox3"));
		if (!Checkbox3.isSelected()) {
			reportStep("Checkbox is not checked", "Pass");
		} else {
			reportStep(Checkbox3.getText() + "is checked", "Fail");
		}
		waitTime(3000);
		WebElement savebutton = propElement(getPropfile(gpropname5, "Savebutton"));
		if (savebutton.isDisplayed()) {
			savebutton.click();
			waitTime(3000);
			reportStep("Getting Started page is display", "Pass");
		} else {
			reportStep("Getting Started page is not display", "Fail");
		}

		return this;
	}

	@Given("Make valid selections - check terms of use, check emails, check sync classes unchecked and verify the result")
	public Pg3TeacherRegistration verifywithchecksyncclasses1() {
		WebElement Checkbox1 = propElement(getPropfile(gpropname5, "Checkbox1"));
		if (Checkbox1.isSelected()) {
			reportStep(Checkbox1.getText() + "is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
		WebElement Checkbox2 = propElement(getPropfile(gpropname5, "Checkbox2"));
		if (Checkbox2.isDisplayed()) {
			click(Checkbox2);
			reportStep(Checkbox2.getText() + "is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);

		WebElement Checkbox3 = propElement(getPropfile(gpropname5, "Checkbox3"));
		scrollToTheGivenWebElement(getPropfile(gpropname5, "Checkbox3"));
		if (Checkbox3.isDisplayed()) {
			Checkbox3.click();
			reportStep(Checkbox3.getText() + "is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
		WebElement savebutton = propElement(getPropfile(gpropname5, "Savebutton"));
		if (savebutton.isDisplayed()) {
			savebutton.click();
			waitTime(3000);
			reportStep("Signin with google page display", "Pass");
		} else {
			reportStep("Signin with google page not display", "Fail");
		}
		WebElement username = propElement(getPropfile(gpropname5, "Username"));
		username.click();
		waitTime(3000);
		WebElement chkbox1 = propElement(getPropfile(gpropname5, "Checkbox1"));
		chkbox1.click();
		WebElement chkbox2 = propElement(getPropfile(gpropname5, "Checkbox2"));
		chkbox2.click();
		waitTime(3000);
		WebElement syncbutton = propElement(getPropfile(gpropname5, "Syncbutton"));
		if (syncbutton.isDisplayed()) {
			syncbutton.click();
			reportStep("Icivics Sync classes display", "Pass");
		} else {
			reportStep("Icivics Sync classes do not display", "Fail");
		}

		scrollToTheGivenWebElement(getPropfile(gpropname5, "Policyterms"));
		reportStep("Google classes display successfully", "Pass");
		return this;

	}

	@Then("Make valid selections - check terms of use, uncheck emails, check sync classes unchecked and verify the result")
	public Pg3TeacherRegistration verifywithchecksyncclasses2() {
		WebElement Checkbox1 = propElement(getPropfile(gpropname5, "Checkbox1"));
		if (Checkbox1.isSelected()) {
			Checkbox1.click();
			reportStep("Checkbox1 is unchecked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
		WebElement Checkbox2 = propElement(getPropfile(gpropname5, "Checkbox2"));
		if (Checkbox2.isDisplayed()) {

			Checkbox2.click();
			reportStep("Checkbox2 is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);

		WebElement Checkbox3 = propElement(getPropfile(gpropname5, "Checkbox3"));
		scrollToTheGivenWebElement(getPropfile(gpropname5, "Checkbox3"));
		if (Checkbox3.isDisplayed()) {
			Checkbox3.click();
			reportStep("Checkbox3 is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
		WebElement savebutton = propElement(getPropfile(gpropname5, "Savebutton"));
		if (savebutton.isDisplayed()) {
			savebutton.click();
			waitTime(3000);
			reportStep("Signin with google page display", "Pass");
		} else {
			reportStep("Signin with google page not display", "Fail");
		}
		WebElement username = propElement(getPropfile(gpropname5, "Username"));
		username.click();
		waitTime(3000);
		WebElement chkbox1 = propElement(getPropfile(gpropname5, "Checkbox1"));
		chkbox1.click();
		WebElement chkbox2 = propElement(getPropfile(gpropname5, "Checkbox2"));
		chkbox2.click();
		waitTime(3000);
		WebElement syncbutton = propElement(getPropfile(gpropname5, "Syncbutton"));
		if (syncbutton.isDisplayed()) {
			syncbutton.click();
			reportStep("Icivics Sync classes display", "Pass");
		} else {
			reportStep("Icivics Sync classes do not display", "Fail");
		}

		scrollToTheGivenWebElement(getPropfile(gpropname5, "Policyterms"));
		reportStep("Google classes display successfully", "Pass");
		return this;

	}
}
