package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class PaginaCheckOutOverview {
	
	@FindBy(how = How.NAME,using = "finish")
	WebElement btnFinish;
	
	public PaginaCheckOutOverview (WebDriver driver){
		PageFactory.initElements(driver, this);
		}

	public void hacerClickEnFinish() {
		btnFinish.click();
	}
}
