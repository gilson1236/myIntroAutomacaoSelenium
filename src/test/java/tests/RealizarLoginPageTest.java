package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import junit.framework.Assert;
import pages.RealizarLoginPage;
import utils.Utils;

public class RealizarLoginPageTest {

	private WebDriver driver;
	private RealizarLoginPage realizarLoginPage;
	private Utils util;
	
	@BeforeEach
	public void inicializa() {
		System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
		this.driver = new EdgeDriver();
		this.realizarLoginPage = new RealizarLoginPage(this.driver);
		this.util = new Utils(this.driver);
	}
	
	@Test
	public void realizarlogin() {
				
		this.realizarLoginPage.RealizarLogin();
		this.util.getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Orders'] span"))); 
		WebElement validaTexto = this.driver.findElement(By.cssSelector("a[title='Orders'] span"));
		Assert.assertEquals("ORDER HISTORY AND DETAILS", validaTexto.getText());
	}
	
	@AfterEach
	public void quit() {
		this.driver.quit();
	}
}
