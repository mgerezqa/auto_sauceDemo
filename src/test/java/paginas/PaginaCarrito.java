package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class PaginaCarrito {

	@FindBy(how = How.ID, using= "checkout")
	WebElement btnCheckOut;
	
	public PaginaCarrito (WebDriver driver){
		PageFactory.initElements(driver, this);
		}
	
	public void hacerClickEnCheckOut() {
		
		btnCheckOut.click();
		
	}
}
