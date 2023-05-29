package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaginaCheckOutComplete {
	@FindBy(how = How.ID,using = "back-to-products")
	WebElement btnBackToProducts;

	public PaginaCheckOutComplete (WebDriver driver){
		PageFactory.initElements(driver, this);
		}
	

	public void hacerClickEnBackHome() {
		btnBackToProducts.click();
	}


}
