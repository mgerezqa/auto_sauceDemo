package paginas;

import org.openqa.selenium.By;
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
	
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	WebElement btnAddLightBike;

	@FindBy(css = "[data-test='error']")
	WebElement errorElement;

	public PaginaInicio(WebDriver driver){
		
	PageFactory.initElements(driver, this);
	}
	
	public void ingresarCredenciales(String user, String password) {
		txtName.clear();
		txtName.sendKeys(user);
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void hacerClickEnLogin() {	
		buttonLogin.click();
	}
	
	public boolean mensajeDeError() {
		
	      if (errorElement.isDisplayed()) {
	            String errorMessage = errorElement.getText();
	            System.out.println("Inicio de sesión fallido: " + errorMessage);
	            return true;
	        } else {
	            System.out.println("No se encontró un mensaje de error de inicio de sesión");
	            return false;
	        }

	}
	
	
}