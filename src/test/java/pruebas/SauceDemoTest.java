package pruebas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaProductos;

public class SauceDemoTest {
	String url = "https://www.saucedemo.com/";
	WebDriver driver;
	private By title;
	
	@BeforeSuite //rutina para abrir el navegador
	public void setUp() { //se suele llamar setUp()
		// 1) Configurando el navegador Chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		// 2) Abrir el navegador en la página donde haremos la prueba
		driver.get(url);
//		3)  maximizar el navegador
		driver.manage().window().maximize();
		
		title = By.className("app_logo");
	}
	@Test
	public void iniciarSesion() {
		PaginaInicio login = new PaginaInicio (driver);
		login.ingresarCredenciales("standard_user","secret_sauce");
		login.hacerClickEnLogin();
		
	}
	
	@Test
	public void agregarItem() { //crear una clase base y extenderla para no repetir el login.
		
		this.iniciarSesion();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PaginaProductos productos = new PaginaProductos(driver);
		productos.agregarLucesBicicleta();
	}
	
	@Test
	public void agregarTodosLosItems() {

		this.iniciarSesion();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PaginaProductos productos = new PaginaProductos(driver);
		productos.agregarTodosLosProductos();
	}

	
	@AfterSuite
	public void cerrarNavegador() throws InterruptedException{
        Thread.sleep(10*1000);//espero 10 segundos antes de cerrar la pagina
		driver.close();	
	}
}
