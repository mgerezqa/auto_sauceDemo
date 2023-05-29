package pruebas;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import paginas.PaginaInicio;
import paginas.PaginaProductos;
import paginas.PaginaCarrito;
import paginas.PaginaCheckOut;
import paginas.PaginaCheckOutComplete;
import paginas.PaginaCheckOutOverview;

public class SauceDemoTest {
	String url = "https://www.saucedemo.com/";
	WebDriver driver;
	String rutaEvidencias = "..\\sauceDemo\\Evidencias\\";
	File screen;
//	private By title;

	
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
		
//		title = By.className("app_logo");
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
	public void realizarCompra() throws IOException { //crear una clase base y extenderla para no repetir el login.
		
//		01 Captura: Ingreso de Credenciales
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // sacar foto
		FileUtils.copyFile(screen, new File(rutaEvidencias + "01_pantallaInicial.jpg")); // copiamos la info de captura "screen" en el archivo 01_pantallaInicial
		
		this.iniciarSesion();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		02 Captura: Inicio de Sesion Correcto
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // sacar foto
		FileUtils.copyFile(screen, new File(rutaEvidencias + "02_IniciarSesion.jpg")); // copiamos la info de captura "screen" en el archivo 01_pantallaInicial

		PaginaProductos productos = new PaginaProductos(driver);
		productos.agregarLucesBicicleta();

//		03 Captura: Agregar Producto a Carrito
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // sacar foto
		FileUtils.copyFile(screen, new File(rutaEvidencias + "03_AgregarProducto.jpg")); // copiamos la info de captura "screen" en el archivo 01_pantallaInicial
		
		
		productos.hacerClickEnCarrito();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		04 Captura: Ver Orden de Compra
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // sacar foto
		FileUtils.copyFile(screen, new File(rutaEvidencias + "04_OrdenDeCompra.jpg")); // copiamos la info de captura "screen" en el archivo 01_pantallaInicial

		PaginaCarrito carrito = new PaginaCarrito(driver);
		carrito.hacerClickEnCheckOut();

		
		PaginaCheckOut checkOut = new PaginaCheckOut (driver);
		checkOut.ingresarNombre("Martin"); //random
		checkOut.ingresarApellido("Gerez"); //random
		checkOut.ingresarCodigoPostal("1201"); //random
//		05 Captura: Completo el checkOut information
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // sacar foto
		FileUtils.copyFile(screen, new File(rutaEvidencias + "05_CheckOut.jpg")); // copiamos la info de captura "screen" en el archivo 01_pantallaInicial

		checkOut.hacerClickEnContinuE();

//		06 Captura: Overwiew
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // sacar foto
		FileUtils.copyFile(screen, new File(rutaEvidencias + "06_Overwiew.jpg")); // copiamos la info de captura "screen" en el archivo 01_pantallaInicial
		
		PaginaCheckOutOverview overwiew = new PaginaCheckOutOverview(driver);
		overwiew.hacerClickEnFinish();
		
//		07 Captura: Finish
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // sacar foto
		FileUtils.copyFile(screen, new File(rutaEvidencias + "07_Finish.jpg")); // copiamos la info de captura "screen" en el archivo 01_pantallaInicial

		PaginaCheckOutComplete checkFinish = new PaginaCheckOutComplete (driver);
		checkFinish.hacerClickEnBackHome();
	}
	
	
	@Test
	public void agregarTodosLosItems() {

		this.iniciarSesion();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		PaginaProductos productos = new PaginaProductos(driver);
		productos.agregarTodosLosProductos();
	}

	
	@AfterSuite
	public void cerrarNavegador() throws InterruptedException{
        Thread.sleep(5*1000);//espero 10 segundos antes de cerrar la pagina
		driver.close();	
	}
}
