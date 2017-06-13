package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

public class NavegacaoDashboard {
	public static WebDriver driver;
	private WebElement aboutMe;
	
	@Given("^Usuário está na página Dashboard$") 
	public void usuariodashboard() throws Throwable {	
		System.setProperty("webdriver.gecko.driver", "/Users/default/Downloads/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://hml.bonmarketplace.back.b2w/#/login");
        System.out.println("Na Página");
	}

	@When("^Usuário faz login na página Dashboard$")
	public void pgdashboard() throws Throwable {
		driver.findElement(By.xpath("//*[@id='access']/a")).click();
		System.out.println("No login");
	}

	@When("^usuário digita usuário e senha Dashboard$")
	public void pgdashboardusuario() throws Throwable {
		driver.findElement(By.id("loginname")).sendKeys("sub_ti_herbert"); 	 
	    driver.findElement(By.id("loginpwd")).sendKeys("dwr9980");
	    driver.findElement(By.xpath("//*[@id='access']/form/fieldset[1]/div[3]/button")).click();
	    System.out.println("Acessei");
	}

	@Then("^exibe mensagem de sucesso do login Dashboard$")
	public void sucessouserdash() throws Throwable {
	    new Select(driver.findElement(By.xpath("//div[@id='customers']/select"))).selectByVisibleText("MONTELLA123");
	    driver.findElement(By.id("menu-cadastro")).click();
	    System.out.println("Login Successfully2");
	}

	@Then("^usuário navega até o menu Dashboard$")
	public void navegadash() throws Throwable {
		driver.get("http://hml.bonmarketplace.back.b2w/#/itens/novo-ean");
		driver.get("http://hml.bonmarketplace.back.b2w/#/dashboard");
		System.out.println("Estou na Dash");
	}
	
	@Then("^usuário valida itens da tela e seus acessos Dashboard$")
	public void validaitens() throws Throwable {
		
		//texto 1
		WebElement element1 = driver.findElement(By.xpath("//span[text()='Atualize seu catálogo, preço e estoque']"));
		String strng1 = element1.getText();
		Assert.assertEquals("Atualize seu catálogo, preço e estoque", strng1);
		System.out.println(strng1);
		
		//texto 2
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		setAboutMe(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Aumente suas vendas com frete grátis ou desconto']"))));
		
		WebElement element2 = driver.findElement(By.xpath("//span[text()='Aumente suas vendas com frete grátis ou desconto']"));
		String strng2 = element2.getText();
		Assert.assertEquals("Aumente suas vendas com frete grátis ou desconto", strng2);	
		System.out.println(strng2);
		
		//texto 3
		WebElement element3 = driver.findElement(By.xpath("//span[text()='Veja seus novos pedidos e atualize os status']"));
		String strng3 = element3.getText();
		Assert.assertEquals("Veja seus novos pedidos e atualize os status", strng3);		
		System.out.println(strng3);
		
		//texto 4
		WebElement element4 = driver.findElement(By.xpath("//span[text()='Acompanhe e responda aos chamados dos clientes']"));
		String strng4 = element4.getText();
		Assert.assertEquals("Acompanhe e responda aos chamados dos clientes", strng4);		
		System.out.println(strng4);
		
		//texto 5
		WebElement element5 = driver.findElement(By.xpath("//span[text()='Veja seu saldo e valores das suas vendas']"));
		String strng5 = element5.getText();
		Assert.assertEquals("Veja seu saldo e valores das suas vendas", strng5);
		System.out.println(strng5);
		
		System.out.println("Asserts realizados com sucesso");
	}

	@When("^usuário efetua logout Dashboard$")
	public void usuariorealizalogout() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
        driver.findElement(By.cssSelector("strong.ng-binding")).click();
        driver.findElement(By.linkText("Sair")).click();
        System.out.println("Logout com sucesso");
	}


	@Then("^mensagem ao usuário informando o logout com sucesso Dashboard$") 
	public void mensagemsucessologout() throws Throwable {
        System.out.println("LogOut Successfully");
        driver.quit();
        System.out.println("Driver quit Successfully");
	}

	public WebElement getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(WebElement aboutMe) {
		this.aboutMe = aboutMe;
	}
}