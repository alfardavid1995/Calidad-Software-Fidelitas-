import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.w3c.dom.events.MouseEvent;
import java.lang.Object;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;


public class Main {
	
	private static final String CANDIDATE_USER = "abc12345@yopmail.com";
    private static final String CANDIDATE_CON = "12345";
    private static final String EMPLOYER_USER = "abc67890@yopmail.com";
    private static final String EMPLOYER_CON = "12345";
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buscarTrabajo();
		//hacerCompras();
		
		



	}

	private static void buscarTrabajo() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\css124646\\Downloads\\chromedriver_win32bits\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/div/div/section/div/div/div/div/div[2]/div[1]/div/form/div[1]/div/input")).sendKeys("Developer");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/div/div/section/div/div/div/div/div[2]/div[1]/div/form/div[1]/div/input")).sendKeys(Keys.ENTER);

		Assert.assertEquals(driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[1]/aside/div[1]/h4")).getText(), "Search Filters");
		
		//borrando la busqueda
		
		try {
			driver.manage().timeouts().wait(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id=\"search-widget\"]/div/form/div[1]/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"search-widget\"]/div/form/div[1]/input")).sendKeys("testing");
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[1]/aside/div[2]/div[3]/div[2]/div/form/div[2]/button/i")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		//driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[1]/aside/div[2]/div[5]/div[2]/div/form/ul/li[2]")).click();//select engineering option 
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[1]/aside/div[2]/div[5]/div[2]/div/form/ul/li[1]/div/ins")).click();// haciendo click a freelance 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[1]/aside/div[2]/div[5]/div[2]/div/form/ul/li[2]/div/ins")).click();//haciendo click a full time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[1]/aside/div[2]/div[6]/div[2]/div/form/ul/li[1]/div/ins")).click();// hacer click a bachelor
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[1]/aside/div[2]/div[6]/div[2]/div/form/ul/li[2]/div/ins")).click();// hacer click a master
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[1]/aside/div[2]/div[6]/div[2]/div/form/ul/li[3]/div/ins")).click();// hacer click a phd
		try {
			driver.manage().timeouts().wait(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		

	}
	
	private static void hacerCompras() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\css124646\\Downloads\\chromedriver_win32bits\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		
		
		//driver.findElement(By.xpath("/html/body/div[4]/section[1]/div/div/div/div/div/section/div/div/div[2]/div/div[1]/div/div[2]/div/a")).click();
		
		
		
		
		//WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div/div/div/section[2]/div/div/div/div/div/div[1]/div/div/form/div[1]/div/input")));
		
		
		
		driver.findElement(By.xpath("//*[@id=\"menu-1\"]/section/div/ul[2]/li[1]/a")).click();
        //Date finalCarga = new Date();
        //tiempoCarga4 = (int) ((finalCarga.getTime() - inicioCarga.getTime()) / 1000);
        driver.findElement(By.xpath("//*[@id=\"sb_reg_email\"]")).sendKeys(EMPLOYER_USER);//manda user
        driver.findElement(By.xpath("//*[@id=\"sb_reg_password\"]")).sendKeys(EMPLOYER_CON);//manda password
        driver.findElement(By.xpath("//*[@id=\"sb_login_submit\"]")).click();//
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/nav/section/div/ul[3]/li/a")).click();// back to home
        driver.findElement(By.xpath("/html/body/div[4]/section[1]/div/div/div/div/div/section/div/div/div[2]/div/div[1]/div/div[2]/div/a")).click();
        
        
		
		
		
		
		
		
		
		/*driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/section[2]/div/div/div/div/div/div[1]/div/div/form/div[1]/div/input")).sendKeys(CANDIDATE_USER);//manda user 
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/section[2]/div/div/div/div/div/div[1]/div/div/form/div[2]/div/input")).sendKeys(CANDIDATE_CON);//manda contrasena
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/section[2]/div/div/div/div/div/div[1]/div/div/form/div[4]/div/button[1]")).click();
		*/
		//driver.fi
		//driver
		
		
		
		
	}

}
