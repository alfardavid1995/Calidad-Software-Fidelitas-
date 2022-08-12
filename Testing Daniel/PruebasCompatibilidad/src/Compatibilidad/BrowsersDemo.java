package Compatibilidad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;


public class BrowsersDemo {

	public static void main(String[] args) {
		
		IEDwebdriver();
		FireFoxDriver();
		ChromeDriver();
		MicrsoftEdgeDriver();
		OperaWebDriver();
	}
	
	
	public static void IEDwebdriver() {
		//Internet Explorer
				
				System.setProperty("webdriver.ie.driver","C:\\Users\\Usuario\\Downloads\\IEDriverServer_x64_4.3.0\\IEDriverServer.exe");
				WebDriver driver5= new InternetExplorerDriver();
				driver5.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
	}
	
	public static void FireFoxDriver() {
		//FIREFOX
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Usuario\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
				WebDriver driver3= new FirefoxDriver();
				driver3.manage().window().maximize();
				driver3.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
	}
	
	public static void ChromeDriver() {
		//CHROME
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Downloads\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver2 = new ChromeDriver();
				driver2.navigate().to("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
	}
	
	public static void MicrsoftEdgeDriver() {
		//EDGE
				System.setProperty("webdriver.edge.driver","C:\\Users\\Usuario\\Downloads\\edgedriver_win64\\msedgedriver.exe");
				WebDriver driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
	}
	
	public static void OperaWebDriver() {
		//OPERA
				//System.setProperty("webdriver.opera.driver","C:\\Users\\Usuario\\Downloads\\operadriver_win64\\operadriver.exe");
				//WebDriver driver3 = new ChromeDriver();
				//driver3.manage().window().maximize();
				//driver3.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
				//-------------------------------------------------------------------------
				//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Downloads\\chromedriver_win32\\chromedriver.exe");
				//ChromeOptions options = new ChromeOptions();
				//options.setBinary(new File("C:\\Users\\Usuario\\AppData\\Local\\Programs\\Opera\\opera.exe"));
				//-----------------------------------------------------------------------------
				//For using Opera browser with ChromeDriver:
				//ChromeDriver driver4 = new ChromeDriver(options);
				//driver4.manage().window().maximize();
				//driver4.navigate().to("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
				//driver4.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
				//----------------------------------------------------------------------------
				
				// For use with RemoteWebDriver:
				//ChromeOptions options2 = new ChromeOptions();
				//options2.setBinary(new File("C:\\Users\\Usuario\\AppData\\Local\\Programs\\Opera\\opera.exe"));
				//RemoteWebDriver driver4 = new RemoteWebDriver(new URL("https://sistemas.ufidelitas.ac.cr/nokri-demo2/"), options2);
				//driver4.manage().window().maximize();
				//driver4.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
				//------------------------------------------------------------------------------
				System.setProperty("webdriver.opera.driver", "C:\\Users\\Usuario\\Downloads\\operadriver_win64\\operadriver_win64\\operadriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setBinary(new File("C:\\Users\\Usuario\\AppData\\Local\\Programs\\Opera\\opera.exe"));
				WebDriver driver = new OperaDriver(options);
				driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
	}
}
