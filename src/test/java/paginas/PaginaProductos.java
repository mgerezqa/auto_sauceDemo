package paginas;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	
	@FindBy(className ="product_sort_container" )
	WebElement btnSort;
	
    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;
    
    @FindBy(className = "inventory_item_price")
    List <WebElement> productPrices;
	
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
	
	public void ordenarSegunCriterio(String optionValue) {
		Select sortSelect = new Select(btnSort);
		sortSelect.selectByValue(optionValue);		
	}
	
//	public void ordenarPorOrdenAlfabeticoA_Z() {
//		Select sortSelect = new Select(btnSort);
//		sortSelect.selectByValue("az");		
//	}
//	
//	public void ordenarPorOrdenAlfabeticoZ_A() {
//		Select sortSelect = new Select(btnSort);
//		sortSelect.selectByValue("za");
//	}
//	
//	public void ordenarPorPrecioMenor() {
//		Select sortSelect = new Select(btnSort);
//		sortSelect.selectByValue("lohi");
//	}
//	public void ordenarPorPrecioMayor() {
//		Select sortSelect = new Select(btnSort);
//		sortSelect.selectByValue("hilo");
//	}
	
    public void selectSortOption(String optionValue) {
    	btnSort.sendKeys(optionValue);
    }

    public boolean losProductosEstanOrdenadosSegunCriterio(String sortOption) {
        List <String> originalProductNames = new ArrayList <String>(); // declaro una colección de array de strings, para almacenar los textos identificadores de los productos.
        List <Float> originalProductPrices = new ArrayList <>(); 
        
        for (WebElement productName : productNames) { // utilizo estructura forEach para recorrer cada elemento de toda la lista de WebElements es decir  cada producto, y pido el texto que lo identifica y agrego dicho array a otra colección
            originalProductNames.add(productName.getText());
        }
        
        for (WebElement productPrice: productPrices) { // utilizo estructura forEach para recorrer cada elemento de toda la lista de WebElements es decir  cada producto, y pido el texto que lo identifica y agrego dicho array a otra colección
            String priceStr = productPrice.getText().replace("$", "");
            float price = Float.parseFloat(priceStr);
            originalProductPrices.add(price);
        }

        switch (sortOption) {
            case "az":
                // Verificar si los nombres están en orden ascendente
                for (int i = 0; i < originalProductNames.size() - 1; i++) {
                    if (originalProductNames.get(i).compareTo(originalProductNames.get(i + 1)) > 0) {
                        return false;
                    }
                }
                break;

            case "za":
                // Verificar si los nombres están en orden descendente
                for (int i = 0; i < originalProductNames.size() - 1; i++) {
                    if (originalProductNames.get(i).compareTo(originalProductNames.get(i + 1)) < 0) {
                        return false;
                    }
                }
                break;

            case "lohi":
                // Verificar que los precios esten ordenados de menor a mayor
                for (int i = 0; i < originalProductPrices.size() - 1; i++) {
                    if (originalProductPrices.get(i) > originalProductPrices.get(i + 1)) {
                        return false;
                    }
                }
                break;

            case "hilo":
                // Verificar que los precios esten ordenados de mayor a menor
                for (int i = 0; i > originalProductPrices.size() - 1; i++) {
                    if (originalProductPrices.get(i) > originalProductPrices.get(i + 1)) {
                        return false;
                    }
                }
                break;

                
                
                // Agregar más casos para otros criterios de ordenamiento si es necesario

            default:
                return false;
        }

        return true;
    }
}
