package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;

public class MainTest {
	String url = "https://www.saucedemo.com/";
	WebDriver driver;
	
	@BeforeSuite //rutina para abrir el navegador
	public void abrirNavegador() { //se suele llamar setUp()
		// 1) Configurando el navegador Chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		// 2) Abrir el navegador en la página donde haremos la prueba
		driver.get(url);
//		3)  maximizar el navegador
		driver.manage().window().maximize();
	}
	@Test
	public void iniciarSesion() {
		PaginaInicio login = new PaginaInicio (driver);
		login.ingresarCredenciales("standard_user","secret_sauce");
		login.hacerClickEnLogin();
		
	}
	
	@AfterSuite
	public void cerrarNavegador() throws InterruptedException{
        Thread.sleep(10*1000);//espero 10 segundos antes de cerrar la pagina
		driver.close();	
	}
}
