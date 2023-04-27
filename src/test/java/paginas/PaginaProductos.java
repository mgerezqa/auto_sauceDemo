package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaProductos {

	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	WebElement btnAddToCart;
	
	public PaginaProductos(WebDriver driver){
		PageFactory.initElements(driver, this);
		}
	
	public void agregarAlCarrito() {
		btnAddToCart.click();
		
	}
}
