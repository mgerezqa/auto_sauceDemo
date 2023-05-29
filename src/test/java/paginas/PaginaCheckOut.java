package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaginaCheckOut {
	@FindBy(how = How.NAME,using = "firstName")
	WebElement nameField;
	
	@FindBy(how = How.NAME, using = "lastName")
	WebElement LastNameField;
	
	@FindBy(how = How.NAME, using = "postalCode")
	WebElement postalCodeField;
	
	@FindBy(how = How.NAME, using = "continue")
	WebElement btnContinue;
	
	
	public PaginaCheckOut (WebDriver driver){
		PageFactory.initElements(driver, this);
		}
	
	public void ingresarNombre(String name) {
		nameField.sendKeys(name);
	}
	
	public void ingresarApellido(String lastName) {
		LastNameField.sendKeys(lastName);
	}
	
	public void ingresarCodigoPostal(String zipCode) {
		postalCodeField.sendKeys(zipCode);
	}
	
	public void hacerClickEnContinuE() {
		btnContinue.click();
	}


}
