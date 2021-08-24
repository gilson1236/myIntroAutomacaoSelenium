package pages;

import org.openqa.selenium.WebDriver;

import utils.Utils;

public class RealizarLoginPage {

	private WebDriver driver;
	private Utils util;
	
	public RealizarLoginPage(WebDriver driver) {
		this.driver = driver;
		this.util = new Utils(driver);
	}
	
	public void RealizarLogin() {
		
		this.driver.get("http://automationpractice.com/index.php");

		this.util.clickPorCss("#header > div.nav > div > div > nav > div.header_user_info > a");
		this.util.preencheCampoPorId("email", "everisbootcamp@qabeginner.com");
		this.util.preencheCampoPorId("passwd", "QA@everis213");
		this.util.clickPorNome("SubmitLogin");
		
	}
}
