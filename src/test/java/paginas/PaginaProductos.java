package paginas;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Page Factory


public class PaginaProductos {

	@FindBy(how =How.ID, using = "add-to-cart-sauce-labs-bike-light")
	WebElement btnAddLightBike;
	
	@FindBy(className = "btn_inventory")
	List <WebElement> btnAddAll;
	
	@FindBy(using = "shopping_cart_container")
	WebElement btnCart;
	
	@FindBy(how = How.ID, using = "react-burger-menu-btn")
	WebElement btnMenu;
	
	@FindBy(how = How.CSS, using = "#logout_sidebar_link")
	WebElement btnLogout;
	
	
	public PaginaProductos(WebDriver driver){
		PageFactory.initElements(driver, this);
		}
	
	public void agregarLucesBicicleta() {
		btnAddLightBike.click();
	}
	
	public void agregarTodosLosProductos() {		
//		usando For
		for (int i = 0; i< btnAddAll.size(); i++)
			btnAddAll.get(i).click();

		//usando ForEach
//		for (WebElement button:btnAddAll)
//				button.click();

		System.out.println(btnAddAll.size());
		Assert.assertTrue(btnAddAll.size()==6);
	}
	
	public void hacerClickEnCarrito() {
		btnCart.click();
	}
	
	public void hacerClickEnMenu() {
		btnMenu.click();
	}
	
	public void hacerClickenCerrarSesion() {
		btnLogout.click();
	}
}
