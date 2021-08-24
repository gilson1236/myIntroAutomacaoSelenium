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
import pages.CadastrarUsuarioPage;
import utils.Utils;

public class CadastrarUsuarioPageTest {

	private WebDriver driver;
	private CadastrarUsuarioPage cadastrarUsuarioPage;
	private Utils util;

	@BeforeEach
	public void inicializa() {
		System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
		this.driver = new EdgeDriver();
		cadastrarUsuarioPage = new CadastrarUsuarioPage(driver);
		
	}

	@Test
	public void cadastrarUsuarioPage() {
		
		cadastrarUsuarioPage.cadastrarUsuario();
		this.util.getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Orders'] span"))); 
		WebElement validaTexto = driver.findElement(By.cssSelector("a[title='Orders'] span"));
		Assert.assertEquals("ORDER HISTORY AND DETAILS", validaTexto.getText());

	}

	@AfterEach
	public void afterCenario() {
			this.driver.quit();
	}
}
