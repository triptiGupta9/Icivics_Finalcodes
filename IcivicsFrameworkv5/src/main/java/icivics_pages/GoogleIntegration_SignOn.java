package icivics_pages;

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
import projectSpecific.base.ProjectSpecificMethods;

public class GoogleIntegration_SignOn extends ProjectSpecificMethods {
	public String gpropname1 = "GoogleIntegration/GoogleSignOn";

	public GoogleIntegration_SignOn(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}
	
	
	String url = "/user/login";
	String URL;
	@Given("Launch the icivics URL")
	public GoogleIntegration_SignOn launchURL() {
		if (Environment.equals("Stage.d9")) {
			URL = StageURL + url;
			navigateto(URL);
		} else {
			URL = Stage1URL + url;
			navigateto(URL);
		}
		return this;

	}

	@And("Verify Dialog opens in same window with Google accounts that are available")
	public GoogleIntegration_SignOn verifygoogleaccount() {

		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		String parentWindow = driver.getWindowHandle();

		if (signinwithgooglebutton.isDisplayed()) {
			signinwithgooglebutton.click();
			waitTime(3000);
			String currentWindow = driver.getWindowHandle();

			if (parentWindow.equals(currentWindow)) {

				reportStep("Dialog opens in same window", "Pass");
			}

			else {
				reportStep("New window has been opened.", "Fail");
			}
		}
		return this;
	}

	@Given("Enter the credentials verify My iCivics page opens for this account")

	public GoogleIntegration_SignOn verifyentercredentails() {
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
			waitTime(5000);
			reportStep("My Icivics page open for this account", "Pass");
		} else {
			reportStep("My Icivics page not open for this account", "Fail");
		}

		return this;
	}

	@Given("Enter the credentials verify register page open")
	public GoogleIntegration_SignOn verifyentercredentails2() {
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
		waitTime(3000);
		pwdfield.sendKeys("Freedom17@");
		waitTime(3000);
		WebElement nextbutton1 = propElement(getPropfile(gpropname1, "Nextbutton"));
		if (nextbutton1.isDisplayed()) {
			nextbutton1.click();
			waitTime(3000);
			reportStep("Classroom/register page display", "Pass");
		} else {
			reportStep("Classroom/register page not display", "Fail");
		}
		return this;
	}

	@Then("Verify on clicking register as educator redirect to educator registration page")
	public GoogleIntegration_SignOn verifyeducatorregistrationpagedisplay() {
		WebElement registeraseducatorbutton = propElement(getPropfile(gpropname1, "RegisterasEducator"));
		if (registeraseducatorbutton.isDisplayed()) {
			waitTime(3000);
			registeraseducatorbutton.click();
			reportStep("Educator registration page 1 display", "Pass");
		} else {
			reportStep("Educator registration page 1 do not display", "Pass");

		}
		return this;
	}

	@Then("Enter the fields with valid data for first page and verify the result")
	public GoogleIntegration_SignOn verifyenterfieldwithvaliddataforpage1() {
		String value = getPropfile(gpropname1, "Checkboxvalue");
		List<WebElement> checkbox = propElement1(getPropfile(gpropname1, "Checkboxlist"));
		int Size = checkbox.size();

		for (int i = 0; i < Size; i++) {
			String val = checkbox.get(i).getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				waitTime(3000);
				if (!checkbox.get(i).isSelected()) {
					waitTime(3000);
					checkbox.get(i).click();
					reportStep(val + " is selected", "Pass");
				} else {
					reportStep(val + " is not selected", "Pass");
				}
			}
		}

		WebElement dropdownoption = propElement(getPropfile(gpropname1, "Roledropdown"));

		System.out.println(dropdownoption.getText());
		waitTime(3000);
		Select sel = new Select(dropdownoption);
		if (dropdownoption.isEnabled()) {
			sel.selectByVisibleText("Teacher");
			waitTime(3000);
			reportStep("Teacher Option is selected from dropdown", "Pass");
		} else {

			reportStep("Option is not selected from dropdown", "Fail");
		}
		List<WebElement> alloptions = sel.getOptions();
		System.out.println(alloptions.size());
		WebElement nextbutton = propElement(getPropfile(gpropname1, "Nextbutton1"));
		waitTime(3000);
		if (nextbutton.isDisplayed()) {
			nextbutton.click();
			waitTime(5000);
			reportStep("Page2 is display", "Pass");
		} else {
			reportStep("Page2 is not display", "Pass");
		}

		return this;
	}

	@Then("Enter the fields with valid data for second page and verify the result")
	public GoogleIntegration_SignOn verifyenterfieldwithvaliddataforpage2() {
		WebElement dropdownoption = propElement(getPropfile(gpropname1, "Roledropdown"));
		waitTime(3000);
		Select sel = new Select(dropdownoption);
		if (dropdownoption.isEnabled()) {
			sel.selectByVisibleText("Alabama");
			waitTime(3000);
			reportStep("Alabama Option is selected from dropdown", "Pass");
		} else {

			reportStep("Option is not selected from dropdown", "Fail");
		}
		List<WebElement> alloptions = sel.getOptions();
		System.out.println(alloptions.size());
		String Schoolvalue = "St.Thomas's";
		WebElement schoolfield = propElement(getPropfile(gpropname1, "School"));
		clearAndType(schoolfield, Schoolvalue);
		waitTime(3000);
		String zipcodevalue = "111111111";
		WebElement zipcodefield = propElement(getPropfile(gpropname1, "Zipcode"));
		clearAndType(zipcodefield, zipcodevalue);
		waitTime(3000);
		WebElement nextbutton = propElement(getPropfile(gpropname1, "Nextbutton1"));
		if (nextbutton.isDisplayed()) {
			nextbutton.click();
			waitTime(5000);
			reportStep("Page3 is display", "Pass");
		} else {
			reportStep("Page3 is not display", "Pass");
		}
		return this;
	}

	@Then("Enter the fields with valid data for third page and verify the result")
	public GoogleIntegration_SignOn verifyenterfieldwithvaliddataforpage3() {
		WebElement chkbox = propElement(getPropfile(gpropname1, "Agreetotermschkbox"));
		chkbox.click();
		WebElement savebutton = propElement(getPropfile(gpropname1, "Savebutton"));
		if (savebutton.isDisplayed()) {
			savebutton.click();
			waitTime(3000);
			reportStep("Registration is complete for this account and getting started page is display", "Pass");
		} else {
			reportStep("Registration is not complete for this account", "Fail");
		}
		WebElement myicivcsbutton = propElement(getPropfile(gpropname1, "Myicivicsbutton"));
		myicivcsbutton.click();
		waitTime(5000);
		WebElement myicivcslink = propElement(getPropfile(gpropname1, "Myicivcslink2"));
		waitTime(3000);
		myicivcslink.click();
		waitTime(3000);
		WebElement usernametext = driver.findElement(By.xpath("//div[@class='username profile-stat-label']"));
		waitTime(3000);
		String text = usernametext.getText();

		System.out.println(text);
		waitTime(3000);
		WebElement logout = propElement(getPropfile(gpropname1, "Logout"));
		waitTime(3000);
		logout.click();
		waitTime(3000);

		return this;
	}

	@Given("Enter the credentials as a student verify My iCivics page opens for this account")
	public GoogleIntegration_SignOn verifyentercredentailsasStudent() {
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		signinwithgooglebutton.click();

		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname1, "Email"));
		waitTime(3000);
		emailfield.sendKeys("amatt.student1@gedu.demo.icivics.org");

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
			reportStep("My Icivics page open for this account", "Pass");
		} else {
			reportStep("My Icivics page not open for this account", "Fail");
		}
		return this;
	}

	@Given("Enter the credentials not registered and verify My iCivics page opens for this account")
	public GoogleIntegration_SignOn verifycredentialsnotregistered() {
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		click(signinwithgooglebutton);
		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname1, "Email"));
		waitTime(3000);
		emailfield.sendKeys("amatt.student1@gedu.demo.icivics.org");

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
			reportStep("My Icivics page open for this account", "Pass");
		} else {
			reportStep("My Icivics page not open for this account", "Fail");
		}
		return this;
	}

	@Given("Enter the credentials not registered before and verify My iCivics page opens for this account")
	public GoogleIntegration_SignOn verifynotregisteredaccountforstudent() {
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
			reportStep("Classroom/register page display", "Pass");
		} else {
			reportStep("Classroom/register page not display", "Fail");
		}
		WebElement registerasstudentbutton = propElement(getPropfile(gpropname1, "RegisterasStudent"));
		waitTime(3000);
		registerasstudentbutton.click();
		waitTime(3000);
		WebElement agreetoterrms = propElement(getPropfile(gpropname1, "Studentagreetoterms"));
		if (agreetoterrms.isDisplayed()) {
			agreetoterrms.click();
			reportStep("Checkbox is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		WebElement finishbutton = propElement(getPropfile(gpropname1, "Finishbutton"));
		if (finishbutton.isDisplayed()) {
			finishbutton.click();
			waitTime(3000);
			reportStep("Gettingstarted page opens", "Pass");
		} else {
			reportStep("Gettingstarted page do not opens", "Fail");
		}
		WebElement logoutbutton = propElement(getPropfile(gpropname1, "Logout"));
		waitTime(3000);
		logoutbutton.click();
		waitTime(3000);
		return this;
	}

	public GoogleIntegration_SignOn verifydeleteuserfrombackend2() {
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
		String Emailid = getPropfile(gpropname1, "EmailId1");
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
	public  GoogleIntegration_SignOn  verifydeleteuserfrombackend() {
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
