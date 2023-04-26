package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {

	@FindBy(name = "user-name")
	WebElement txtName;
			
	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(id = "login-button")
	WebElement buttonLogin;

	public PaginaInicio(WebDriver driver){
	PageFactory.initElements(driver, this);
	}
	
	public void ingresarCredenciales(String user, String password) {
		txtName.sendKeys(user);
		txtPassword.sendKeys(password);
	}
	
	public void hacerClickEnLogin() {	
		buttonLogin.click();
	}
	
}