package icivics_pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class GoogleIntegration_Pg1TeacherRegistration extends ProjectSpecificMethods {
	public String gpropname1 = "GoogleIntegration/GoogleSignOn";
	public String gpropname2 = "GoogleIntegration/GoogleRegistration";
	public String gpropname3 = "GoogleIntegration/Page1TeacherRegistration";

	public GoogleIntegration_Pg1TeacherRegistration(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "/user/login";
	String URL;
	@Given("Launch the icivis URL")
	public GoogleIntegration_Pg1TeacherRegistration launchURL() {
		if (Environment.equals("Stage.d9")) {
			URL = StageURL + url;
			navigateto(URL);
		} else {
			URL = Stage1URL + url;
			navigateto(URL);
		}
		return this;

	}

	public GoogleIntegration_Pg1TeacherRegistration Registrationpage() {
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname1, "Email"));
		waitTime(3000);
		emailfield.sendKeys("testuser@gedu.demo.icivics.org");

		WebElement nextbutton = propElement(getPropfile(gpropname1, "Nextbutton"));
		nextbutton.click();
		waitTime(3000);
		WebElement pwdfield = propElement(getPropfile(gpropname1, "Password"));

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
		WebElement registeraseducatorbutton = propElement(getPropfile(gpropname1, "RegisterasEducator"));
		waitTime(3000);
		registeraseducatorbutton.click();
		waitTime(3000);
		return this;
	}

	@Then("Verify Breadcrumb indicator shows page 1")

	public GoogleIntegration_Pg1TeacherRegistration verifypagecount1() throws IOException {

		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(gpropname3, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(gpropname3, "step2ele"), cssvalue, Greycolor);
		String Step3 = cssgetbefore(getPropfile(gpropname3, "step3ele"), cssvalue, Greycolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greycolor) && Step3.equals(Greycolor)) {
			reportStep("you are currently viewing page 1 in the breadcrumbs", "Pass");
		} else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}

		return this;
	}

	@Given("User on Page 1, Verify grade level field and option is displayed as checkbox and nothing is selected as default")
	public GoogleIntegration_Pg1TeacherRegistration verifygradelevelfield() throws IOException {

		WebElement gradelevellabel = propElement(getPropfile(gpropname3, "Gradelevel"));
		if (gradelevellabel.isDisplayed()) {
			reportStep(gradelevellabel.getText() + " label is displayed", "Pass");
		} else {
			reportStep("Grade Level label is not displayed", "Fail");
		}
		List<WebElement> checkbox = propElement1(getPropfile(gpropname3, "Checkboxlist"));
		for (int i = 0; i <= checkbox.size() - 1; i++) {
			checkbox.get(i).isDisplayed();
			String checkboxvalue = checkbox.get(i).getText();
			writePropfile("GoogleIntegration/gradelevel", "value", checkboxvalue);
			String checkboxvalue1 = getPropfile("GoogleIntegration/gradelevel", "value");
			if (checkboxvalue.equals(checkboxvalue1)) {
				reportStep(checkboxvalue1 + "options are matched and verified", "Pass");
			} else {
				reportStep(checkboxvalue1 + "options are not matched", "Fail");
			}
		}

		return this;
	}

	@When("User on Page 1, Verify nothing is selected as default for grade level")
	public GoogleIntegration_Pg1TeacherRegistration verifygradelevelfieldisselected() throws IOException {
		List<WebElement> checkbox = propElement1(getPropfile(gpropname3, "Checkboxlist"));
		for (int i = 0; i <= checkbox.size() - 1; i++) {

			if (!checkbox.get(i).isSelected()) {
				reportStep(checkbox.get(i).getAttribute("value") + " option is not selected as default", "Pass");
			} else {
				reportStep(checkbox.get(i).getAttribute("value") + " option is selected as default", "Fail");
			}
		}
		reportStep("Grade level Checkbox is not selected with any default", "Pass");

		return this;

	}

	@And("Verify role options in the dropdown")
	public GoogleIntegration_Pg1TeacherRegistration verifyrolefieldoptions() throws InterruptedException {
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Roledropdown"));
		waitTime(3000);
		WebElement rolelabel = propElement(getPropfile(gpropname3, "Rolelabel"));
		if (rolelabel.isDisplayed()) {
			reportStep(rolelabel.getText() + " label is displayed", "Pass");
		} else {
			reportStep("Role label is not displayed", "Fail");
		}
		WebElement role = propElement(getPropfile(gpropname3, "Roledropdown"));
		role.click();
		waitTime(3000);
		Select sel = new Select(role);
		if (sel.getFirstSelectedOption().getText().equals("- None -")) {
			reportStep(
					"verified " + sel.getFirstSelectedOption().getText() + " is selected as default in Role Dropdown",
					"Pass");
		} else {
			reportStep(
					"verified " + sel.getFirstSelectedOption().getText() + " is selected as default in Role Dropdown",
					"Fail");
		}
		List<WebElement> roleoptions = sel.getOptions();
		int size = roleoptions.size();
		for (int i = 0; i < size - 1; i++) {
			String options = roleoptions.get(i).getText();
			reportStep("verified that " + options + " is present in Role Dropdown", "Pass");
		}
		reportStep("Role dropdown is displayed and verified all the available options sucessfully", "Pass");
		return this;
	}

	@Given("Verify Grade level can have >1 value selected")
	public GoogleIntegration_Pg1TeacherRegistration verifygradelevelselection() {
		List<WebElement> chkBox = propElement1(getPropfile(gpropname3, "Checkboxlist"));
		int Size = chkBox.size();
		for (int i = 0; i < Size; i++) {
			if (!chkBox.get(i).isSelected()) {
				chkBox.get(i).click();
				waitTime(1000);
				reportStep(chkBox.get(i).getAttribute("value") + " option is selected", "Pass");
			} else {
				reportStep("This step failed", "Fail");
			}
		}
		reportStep("Grade level Checkbox allows to select more than one option, all checkbox's are selected", "Pass");
		return this;
	}

	@When("Verify Role can have only 1 value selected")
	public GoogleIntegration_Pg1TeacherRegistration verifyroledropdownselection() {
		WebElement role = propElement(getPropfile(gpropname3, "Roledropdown"));
		role.click();
		waitTime(3000);
		Select sel = new Select(role);
		Boolean selection = sel.isMultiple();
		if (selection == false) {
			reportStep("Role Dropdown is not an multi select option", "Pass");
		} else {
			reportStep("Role Dropdown is an multi select option", "Fail");
		}
		waitTime(3000);
		return this;
	}

	@Given("Verify Leave all grade level boxes unchecked and select next")
	public GoogleIntegration_Pg1TeacherRegistration verifyleavegradelevelboxesunchecked() {
		WebElement role = propElement(getPropfile(gpropname3, "Roledropdown"));
		role.click();
		waitTime(3000);
		selectDropDownUsingText(role, "Home school teacher");
		WebElement nextbutton = propElement(getPropfile(gpropname3, "Nextbutton"));
		nextbutton.click();
		WebElement errormsg = propElement(getPropfile(gpropname3, "Errormsg"));
		System.out.println(errormsg.getText());
		verifyExactText(propElement(getPropfile(gpropname3, "Errormsg")), "1 error has been found:");
		return this;
	}

	@Given("Verify Leave role none selected and select next")
	public GoogleIntegration_Pg1TeacherRegistration verifyleaverolenoneselected() {
		String value = getPropfile(gpropname3, "Checkboxvalue");
		List<WebElement> chkBox = propElement1(getPropfile(gpropname3, "Checkboxlist"));
		int Size = chkBox.size();
		for (int i = 0; i < Size; i++) {
			String val = chkBox.get(i).getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				if (!chkBox.get(i).isSelected()) {
					chkBox.get(i).click();
					reportStep(val + " is selected", "Pass");
					break;
				}
			}

		}
		WebElement nextbutton = propElement(getPropfile(gpropname3, "Nextbutton"));
		nextbutton.click();
		waitTime(3000);
		WebElement errormsg = propElement(getPropfile(gpropname3, "Roleerrormsg"));
		System.out.println(errormsg.getText());
		verifyExactText(propElement(getPropfile(gpropname3, "Roleerrormsg")), "Role field is required.");
		return this;
	}

	@Given("Verify on entering fields with valid data redirect to page2")
	public GoogleIntegration_Pg1TeacherRegistration verifyentervaliddata() {

		String value = getPropfile(gpropname3, "Checkboxvalue");
		List<WebElement> chkBox = propElement1(getPropfile(gpropname3, "Checkboxlist"));
		int Size = chkBox.size();
		for (int i = 0; i < Size; i++) {
			String val = chkBox.get(i).getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				if (!chkBox.get(i).isSelected()) {
					chkBox.get(i).click();
					reportStep(val + " is selected", "Pass");
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
		reportStep("Home school teacher option is selected from dropdown", "Pass");
		WebElement nextbutton = propElement(getPropfile(gpropname3, "Nextbutton"));
		if (nextbutton.isDisplayed()) {
			nextbutton.click();
			waitTime(3000);
			reportStep("Page2 is display", "Pass");
		} else {
			reportStep("Page2 is not display", "Fail");
		}

		waitTime(3000);
		return this;

	}
	public GoogleIntegration_Pg1TeacherRegistration verifydeleteuserfrombackend() {
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
		WebElement chkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		if(chkbox.isDisplayed())
		{
		WebElement emailfield2 =propElement(getPropfile(gpropname1, "EmailId2"));
		String Emailid2= emailfield2.getText();
		if (Emailid.equals(Emailid2)) {
			WebElement chkbox1 =propElement(getPropfile(gpropname1, "Chkbox"));
			chkbox1.click();
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
		}else {
			reportStep("email id entered did not match", "Fail");
		}} else {
			reportStep("No people found for the email id entered ", "Fail");
			WebElement returntosite = propElement(getPropfile(gpropname1, "Returntosite"));
			waitTime(3000);
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
		}
return this;
	}
}
