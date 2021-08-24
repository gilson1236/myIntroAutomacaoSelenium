package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import junit.framework.Assert;
import utils.Utils;

public class CadastrarUsuarioTest {

	private EdgeDriver driver;
	private Utils util;
	
	@BeforeEach
	public void inicializa() {
		System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
		this.driver = new EdgeDriver();
		this.util = new Utils(this.driver);
	}

	@Test
	public void cadastrarUsuario() {
		
		this.driver.get("http://automationpractice.com/index.php");

		this.driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a")).click();
		this.driver.findElement(By.id("email_create")).sendKeys("everisbootcamp@qabeginner.com");
		this.driver.findElement(By.cssSelector("button[id='SubmitCreate'] span")).click();
		this.util.getWait().until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender2")));
		this.driver.findElement(By.id("id_gender2")).click();
		this.driver.findElement(By.id("customer_firstname")).sendKeys("July");
		this.driver.findElement(By.id("customer_lastname")).sendKeys("Sanders");
		this.driver.findElement(By.id("passwd")).sendKeys("QA@everis213");
		this.driver.findElement(By.cssSelector("#days")).sendKeys("1");
		this.driver.findElement(By.cssSelector("#months")).sendKeys("January");
		this.driver.findElement(By.cssSelector("#years")).sendKeys("2000");
		this.driver.findElement(By.id("address1")).sendKeys("Street name, 213");
		this.driver.findElement(By.id("city")).sendKeys("Honolulu");
		this.driver.findElement(By.id("id_state")).sendKeys("Hawaii");
		this.driver.findElement(By.id("postcode")).sendKeys("96815");
		this.driver.findElement(By.id("id_country")).sendKeys("United States");
		this.driver.findElement(By.id("phone_mobile")).sendKeys("9999999999");
		this.driver.findElement(By.id("alias")).clear();
		this.driver.findElement(By.id("alias")).sendKeys("Address 1");
		this.driver.findElement(By.id("submitAccount")).click();
		this.util.getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Orders'] span"))); 
		WebElement validaTexto = this.driver.findElement(By.cssSelector("a[title='Orders'] span"));
		Assert.assertEquals("ORDER HISTORY AND DETAILS", validaTexto.getText());
		
	}

	@AfterEach
	public void afterCenario() {
			this.driver.quit();		
	}

}
