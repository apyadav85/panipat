package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class steps {
	public static WebDriver driver;
	public Select sel;
	public WebElement elem;
	
	@Given("^Launch Browser$")
	public void launch_Browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Jars\\3.141\\Browser Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("^Navigate to Application$")
	public void navigate_to_Application() throws Throwable {
	    driver.get("http://localhost:81");
	}

	@When("^User enters UserName$")
	public void user_enters_UserName() throws Throwable {
		driver.findElement(By.name("user_name")).clear();
		driver.findElement(By.name("user_name")).sendKeys("admin");
	}

	@When("^User enter Password$")
	public void user_enter_Password() throws Throwable {
		driver.findElement(By.name("user_password")).clear();
		driver.findElement(By.name("user_password")).sendKeys("admin");
	}

	@When("^User select value from color theme dropdown$")
	public void user_select_value_from_language_dropdown() throws Throwable {
		elem = driver.findElement(By.name("login_theme"));
		sel = new Select(elem);
		sel.selectByVisibleText("woodspice");
	}
	
	@When("^User select value from color \"([^\"]*)\" dropdown$")
	public void user_select_value_from_color_dropdown(String color) throws Throwable {
		elem = driver.findElement(By.name("login_theme"));
		sel = new Select(elem);
		sel.selectByVisibleText(color);
	}

	@When("^User click on login button$")
	public void user_click_on_login_button() throws Throwable {
	    driver.findElement(By.name("Login")).click();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
	    String exp = "admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
	    if(driver.getTitle().equals(exp)) {
	    	System.out.println("logged-in");
	    }else {
	    	System.out.println("failed");
	    }
	}
	
	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
	    driver.findElement(By.linkText("Sign Out")).click();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
	    if(driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM")) {
	    	System.out.println("Logged-Out");
	    }else {
	    	System.out.println("failed");
	    }
	}

	@When("^User enters UserName (.*) and (.*)$")
	public void user_enters_UserName_Password(String uname, String pass) throws Throwable {
		driver.findElement(By.name("user_name")).clear();
		driver.findElement(By.name("user_name")).sendKeys(uname);
		driver.findElement(By.name("user_password")).clear();
		driver.findElement(By.name("user_password")).sendKeys(pass);
	}

	@Then("^(.*) displayed Login Successfully$")
	public void validate_credentionals(String exp) throws Throwable {
	    String title = driver.getTitle();
	    if(title.equals("vtiger CRM 5 - Commercial Open Source CRM")) {
	    	if(driver.findElement(By.tagName("font")).getText().equals(exp)) {
		    	System.out.println("Passed");
		    }else {
		    	System.out.println("Failed");
		    }
	    }else if(title.equals("admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM")) {
	    	if(driver.getTitle().equals(exp)){
		    	System.out.println("Passed");
		    }else {
		    	System.out.println("Failed");
		    }
	    }	
	}
	
	public void show(){
	   int ab = 100;	
	}
}
