package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utils;

public class RealizarLoginTest {

	private EdgeDriver driver;
	private Utils util;
	
	@BeforeEach
	public void inicializa() {
		System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
		this.driver = new EdgeDriver();
		this.util = new Utils(this.driver);
	}
	
	@Test
	public void logar() {
		
		this.driver.get("http://automationpractice.com/index.php");
		
		this.driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a")).click();
		this.driver.findElement(By.id("email")).sendKeys("everisbootcamp@qabeginner.com");
		this.driver.findElement(By.id("passwd")).sendKeys("QA@everis213");
		this.driver.findElement(By.name("SubmitLogin")).click();
		this.util.getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Orders'] span"))); 
		
	}
	
	@AfterEach
	public void afterCenario() {
		if(this.driver != null) {
			this.driver.close();
			this.driver.quit();
			this.driver = null;
		}
	}
}
