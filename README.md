

# Descripción del proyecto 

El sitio [saucedemo.com](https://www.saucedemo.com/) es un sitio de prácticas que simula una tienda de venta de ropa y accesorios en línea. Ofrece a los usuarios la posibilidad de explorar un catálogo de productos, ordenarlos según el criterio establecido, agregar artículos al carrito de compras, realizar pagos y completar los datos de la compra.

La automatización de las pruebas permitió simular las interacciones de los usuarios con el sitio web. Se desarrollaron casos de prueba que cubrieron diversas funcionalidades, como la navegación por las diferentes secciones del sitio : el orden de los productos según un criterio, el proceso de compra, la gestión del carrito y la verificación de la integridad de los datos.

Para lograrlo, se utilizó el framework **Selenium**, que proporciona una interfaz de automatización de navegadores web. Se empleó el lenguaje de programación Java para desarrollar los scripts de prueba y se aplicaron técnicas de **Page Object Model (POM)** para mejorar la estructura y reutilización del código.

El proyecto demostró habilidades en el diseño de casos de prueba, la implementación de scripts de automatización, el uso de Selenium Web Driver y el conocimiento de programación en Java. Además, se prestaron especial atención a los aspectos de mantenibilidad y extensibilidad del código, lo que facilita futuras actualizaciones y mejoras del proyecto.

La automatización de las pruebas en el sitio saucedemo.com resultó en una mayor eficiencia, ya que se redujo el tiempo necesario para realizar pruebas manuales repetitivas. Además, proporcionó una mayor confiabilidad en la detección de errores y problemas funcionales, lo que a su vez mejoró la calidad del sitio web.

## 1. Resumen del proyecto

El proyecto de automatización del sitio saucedemo.com consistió en desarrollar una serie de pruebas automatizadas utilizando el framework Selenium con el lenguaje de programación Java. El propósito principal fue demostrar habilidades en automatización de pruebas y garantizar la calidad del sitio web saucedemo.com.

## 2. Objetivos

- Automatizar pruebas de funcionalidad para mejorar la eficiencia y precisión de las pruebas.
- Reducir el tiempo y los recursos requeridos para realizar pruebas manuales.
- Detectar errores y problemas en el sitio web de manera temprana.

## 3. Alcance

En el proyecto se realizará la automatización de los casos de prueba para validar las siguientes funcionalidades: 

 - Inicio de Sesión
 - Cierre de Sesión
 - Generación de una orden de compras
 - Ordenar productos 

## 4. Tecnologías utilizadas

Para la construcción del proyecto se emplearon las siguientes tecnologías , librerías , técnicas y herramientas de desarrollo:

### 4.1 Tecnologías 

- Selenium WebDriver: Framework de automatización de pruebas para interactuar con los elementos de la interfaz de usuario.
- Java: Lenguaje de programación utilizado para desarrollar las pruebas automatizadas.
- TestNG: Framework de pruebas utilizado para la ejecución y gestión de los casos de prueba.
- Maven: Gestor de dependencias utilizado para la gestión del proyecto.

### 4.2 Herramientas

- IDE : Eclipse

## 5. Arquitectura de las pruebas

El proyecto sigue el patrón **Page Object Model (POM)** para una mejor organización y mantenibilidad. Los elementos de la interfaz de usuario se encuentran separados en clases individuales, lo que permite un fácil mantenimiento y reutilización del código.

## 6. Casos de prueba



## 7. Configuración y ejecución

- Se requiere tener instalado Java Development Kit (JDK) y Maven para ejecutar las pruebas.
- Las dependencias y configuraciones necesarias están definidas en el archivo pom.xml.
- Para ejecutar las pruebas, se utiliza el comando `mvn test` en la terminal o se ejecutan los archivos de prueba individualmente.

## 8. Resultados y métricas

Adjuntar reportes:



## 9. Capturas de pantalla y ejemplos

Se adjuntan las evidencias del correcto funcionamiento de los scripts realizados:

**CP01_iniciarSesion_fail()**:
Se intenta acceder al sitio con un usuario que fue bloqueado por los administradores del sitio , para ello se ejecuta el caso de prueba:

![CP01_iniciarSesionFail](https://github.com/mgerezqa/auto_sauceDemo/assets/54424951/1348aced-cc68-4821-81be-f821054a8ec5)

**CP02_iniciarSesion_userFail()**:
Se intenta acceder al sitio con un usuario inexistente pero con una contraseña valida: 

![CP02_iniciarSesionFail](https://github.com/mgerezqa/auto_sauceDemo/assets/54424951/3aa14659-c067-49b1-8321-10a8331f9b58)


**CP03_iniciarSesion_passfail()**:
Se intenta acceder al sitio con un usuario válido  pero con una contraseña incorrecta:

![CP03_iniciarSesionFail](https://github.com/mgerezqa/auto_sauceDemo/assets/54424951/a1ae2ddb-1483-40f9-b617-e5ea211333cb)

**CP04_iniciarYCerrarSesion()**:

Se realiza el inicio de sesión mediante la validación de un conjunto de datos de un archivo externo llamado Datos_IniciarSesion.xlsx el cual contendrá información de las credenciales de acceso al sitio, para ello hacemos uso de la anotación data provider en el método de prueba. 

![image](https://github.com/mgerezqa/auto_sauceDemo/assets/54424951/89dffb6f-bb41-422c-90ae-d00caf5aa38d)

Ejecución del caso de prueba: 

![iniciarSesionConDataProvider](https://github.com/mgerezqa/auto_sauceDemo/assets/54424951/db5e2121-1510-4395-bd45-89a2ea2cbdae)






## 10. Lecciones Aprendidas: Skills 
- Maven Project 
 - TestNG : CrossBrowsing, Data Provider , Test Report.
 - JUnit
 - Page Object Model
 - Page Factory
 - CrossBrowsing
