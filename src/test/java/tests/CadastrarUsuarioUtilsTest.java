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

public class CadastrarUsuarioUtilsTest {

	private EdgeDriver driver;
	private Utils util;

	@BeforeEach
	public void inicializa() {
		System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
		this.driver = new EdgeDriver();
		this.util = new Utils(this.driver);
	}

	@Test
	public void cadastrarUsuarioUtils() {
		
		driver.get("http://automationpractice.com/index.php");

		util.clickPorCss("#header > div.nav > div > div > nav > div.header_user_info > a");
		util.preencheCampoPorId("email_create", "everisbootcamp@qabeginner.com");
		util.clickPorCss("button[id='SubmitCreate'] span");
		this.util.getWait().until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender2")));
		util.clickPorId("id_gender2");
		util.preencheCampoPorId("customer_firstname", "July");
		util.preencheCampoPorId("customer_lastname", "Sanders");
		util.preencheCampoPorId("passwd", "QA@everis213");
		util.preencheCampoPorCss("#days", "1");
		util.preencheCampoPorCss("#months", "January");
		util.preencheCampoPorCss("#years", "2000");
		util.preencheCampoPorId("address1", "Street name, 213");
		util.preencheCampoPorId("city", "Honolulu");
		util.preencheCampoPorId("id_state", "Hawaii");
		util.preencheCampoPorId("postcode", "96815");
		util.preencheCampoPorId("id_country", "United States");
		util.preencheCampoPorId("phone_mobile", "9999999999");
		util.clickPorId("submitAccount");
		this.util.getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Orders'] span"))); 
		WebElement validaTexto = driver.findElement(By.cssSelector("a[title='Orders'] span"));
		Assert.assertEquals("ORDER HISTORY AND DETAILS", validaTexto.getText());

	}

	@AfterEach
	public void afterCenario() {
			this.driver.quit();

	}

}
