package pruebas;

import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;
import Utilidades.DatosExcel;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

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
	String nombreDocumento = "Documento de Evidencias - DemoBlaze.docx";
	String directorioDatos = "..\\sauceDemo\\Datos\\";
	File screen;
//	private By title;

	
	@BeforeSuite
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
	
//	@Parameters("navegador") // la variable navegador se pasa por el archivo de configuración XML
//	@BeforeTest
//	public void abrirNavegador(String navegador) {
//		if (navegador.equalsIgnoreCase("CHROME")) {
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--remote-allow-origins=*");
//			driver = new ChromeDriver(options);
//		} else if (navegador.equalsIgnoreCase("EDGE")) { 
//			driver = new EdgeDriver();
//		} else if (navegador.equalsIgnoreCase("FIREFOX")) {
//			driver = new FirefoxDriver();
//		}
//				
//		driver.get(url);
//		driver.manage().window().maximize();
//	}
	
	public void iniciarSesion() { //inicio de sesion por happy path
		PaginaInicio login = new PaginaInicio (driver);
		login.ingresarCredenciales("standard_user","secret_sauce");
		login.hacerClickEnLogin();

	}

	
	
	
	@Test(dataProvider = "Datos Excel")
	public void iniciarYCerrarSesion(String user, String password) {
		PaginaInicio login = new PaginaInicio (driver);
		login.ingresarCredenciales(user,password);
		login.hacerClickEnLogin();
		
        WebElement inventoryContainer = driver.findElement(By.id("inventory_container"));

        // Verificar si se ha iniciado sesión correctamente
        if (inventoryContainer.isDisplayed()) {
            System.out.println("Inicio de sesión exitoso");
    		this.cerrarSesion();

        } else {
            System.out.println("Fallo en el inicio de sesión");
        }		
		// Si inicia sesión, el botón Sign In ya no aparecerá
		// Entonces para resolverlo habría que validar si inició o no
		// En caso positivo, habría que hacer clic en Sign Out
	}
	
	@DataProvider(name = "Datos Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		// Leer los datos que están en el archivo excel
		// y armar un arreglo de objetos con esos datos
		return DatosExcel.leerExcel(
				directorioDatos + "Datos_IniciarSesion.xlsx", 
				"Hoja1");
	}
	
	

	public void cerrarSesion() { //No utilizo @Test porque es un metodo que debe ejecutarse luego de iniciar sesión
		
		PaginaProductos producto = new PaginaProductos(driver);
		producto.hacerClickEnMenu();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		producto.hacerClickenCerrarSesion();
	}
	
	@Test
	public void agregarItem() { //crear una clase base y extenderla para no repetir el login.
		
		this.iniciarSesion();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PaginaProductos productos = new PaginaProductos(driver);
		productos.agregarLucesBicicleta();
		this.cerrarSesion();
	}

	@Test
	public void realizarCompra() throws IOException, InvalidFormatException, InterruptedException { //crear una clase base y extenderla para no repetir el login.
		
//		01 Captura: Ingreso de Credenciales
		CapturaEvidencia.escribirTituloEnDocumento(nombreDocumento,"Documento de Evidencias - DemoBlaze",18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + "img.jpg", rutaEvidencias + nombreDocumento, "1 - Pantalla Principal");
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.iniciarSesion();

//		02 Captura: Inicio de Sesion Correcto
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + "img.jpg", rutaEvidencias + nombreDocumento, "2 - Iniciar Sesion");

		PaginaProductos productos = new PaginaProductos(driver);
		productos.agregarLucesBicicleta();

//		03 Captura: Agregar Producto a Carrito
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + "img.jpg", rutaEvidencias + nombreDocumento, "3 - Agregar Producto");

		
		productos.hacerClickEnCarrito();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		04 Captura: Ver Orden de Compra
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + "img.jpg", rutaEvidencias + nombreDocumento, "4 - Ver Orden de Compra");

		PaginaCarrito carrito = new PaginaCarrito(driver);
		carrito.hacerClickEnCheckOut();

		
		PaginaCheckOut checkOut = new PaginaCheckOut (driver);
		checkOut.ingresarNombre("Martin"); //random
		checkOut.ingresarApellido("Gerez"); //random
		checkOut.ingresarCodigoPostal("1201"); //random
//		05 Captura: Completo el checkOut information
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + "img.jpg", rutaEvidencias + nombreDocumento, "5 - CheckOut Information");


		checkOut.hacerClickEnContinuE();

//		06 Captura: Overwiew
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + "img.jpg", rutaEvidencias + nombreDocumento, "6 - CheckOut Overwiew");

		
		PaginaCheckOutOverview overwiew = new PaginaCheckOutOverview(driver);
		overwiew.hacerClickEnFinish();
		
//		07 Captura: Finish
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + "img.jpg", rutaEvidencias + nombreDocumento, "7- Finalizar Compra");
		PaginaCheckOutComplete checkFinish = new PaginaCheckOutComplete (driver);
	
		
		// Comprobacion de orden pre-generada
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
		
		checkFinish.hacerClickEnBackHome();
		
		this.cerrarSesion();

	}
	
	@Test
	public void agregarTodosLosItems() {

		this.iniciarSesion();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		PaginaProductos productos = new PaginaProductos(driver);
		productos.agregarTodosLosProductos();
		this.cerrarSesion();
	}

	@Test
	public void ordenarProductosPorOrdenAlf() {
		this.iniciarSesion();
		PaginaProductos productos = new PaginaProductos(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		productos.ordenarPorOrdenAlfabeticoA_Z();
		this.cerrarSesion();

	}
	
	@Test
	public void ordenarProductosPorOrdenAlfInverso() {
		this.iniciarSesion();
		PaginaProductos productos = new PaginaProductos(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		productos.ordenarPorOrdenAlfabeticoZ_A();
		this.cerrarSesion();

	}
	
	
	
	@AfterSuite
	public void cerrarNavegador() throws InterruptedException{
        Thread.sleep(2*1000);//espero 10 segundos antes de cerrar la pagina
		driver.close();	
	}
}
