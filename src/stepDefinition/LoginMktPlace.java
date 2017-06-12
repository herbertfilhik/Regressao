package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginMktPlace {
	public static WebDriver driver;
	@Given("^User is on Home Page2$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "/Users/default/Downloads/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://hml.bonmarketplace.back.b2w/#/login");
		}

	@When("^User Navigate to LogIn Page2$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		driver.findElement(By.xpath("//*[@id='access']/a")).click();
		}

	@When("^User enters UserName and Password2$")
	public void user_enters_UserName_and_Password() throws Throwable {
		driver.findElement(By.id("loginname")).sendKeys("sub_ti_herbert"); 	 
	    driver.findElement(By.id("loginpwd")).sendKeys("dwr9980");
	    driver.findElement(By.xpath("//*[@id='access']/form/fieldset[1]/div[3]/button")).click();
		}

	@Then("^Message displayed Login Successfully2$")
	public void message_displayed_Login_Successfully() throws Throwable {
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
	    new Select(driver.findElement(By.xpath("//div[@id='customers']/select"))).selectByVisibleText("MONTELLA123");
	    driver.findElement(By.id("menu-cadastro")).click();
	    System.out.println("Login Successfully2");
	}

	private void assertTrue(boolean matches) {
		// TODO Auto-generated method stub
		
	}

	@When("^User LogOut from the Application2$")
	public void user_LogOut_from_the_Application() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
        driver.findElement(By.cssSelector("strong.ng-binding")).click();
        driver.findElement(By.linkText("Sair")).click();
    }

	@Then("^Message displayed Logout Successfully2$")
	public void message_displayed_Logout_Successfully() throws Throwable {
        System.out.println("LogOut Successfully");
        driver.quit();
        System.out.println("Driver quit Successfully");
	}
}