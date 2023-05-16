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

public class PaginaProductosTradicional {

	//Tradicional
	private WebDriver driver;
	private By btnAddLightBike;
//	private By btnAddAll;
	
	public PaginaProductosTradicional(WebDriver driver){
		//Tradicional
		this.driver = driver;
		btnAddLightBike = By.id("add-to-cart-sauce-labs-bike-light");
//		btnAddAll = By.className("btn btn_primary btn_small btn_inventory");

		}
	
//Tradicional
	
	public void agregarLucesBicicleta() {
			driver.findElement(btnAddLightBike).click();	
	}
	
//	public void agregarTodosLosProductos() {
//		List <WebElement> listaProductos = driver.findElements(btnAddAll);
//		for (WebElement elemento:listaProductos)
//				elemento.click();
//		
//		System.out.println(listaProductos.size());
//		Assert.assertTrue(listaProductos.size()==6);
//	}
}
