package prueba_software;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    
	public test() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\XPC\\Downloads\\chromedriver_win32\\chromedriver.exe");  
	    WebDriver driver=new ChromeDriver(); 

		// Login --- WORKING
	    driver.navigate().to("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.className("n-login-header")).click();
		
	    
		//Logout - Credentials: abc67890@yopmail.com // 12345 --- WORKING
		driver.navigate().to("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.className("n-login-header")).click();
		driver.findElement(By.name("sb_reg_email")).sendKeys("abc67890@yopmail.com");
		driver.findElement(By.name("sb_reg_password")).sendKeys("12345");
		driver.findElement(By.id("sb_login_submit")).click();
		driver.findElement(By.xpath("//*[@id=\"menu-1\"]/section/div/ul[3]/li/a")).click();
	    
		 //Search jobs by location --- Not able to get it working, drop down
		driver.navigate().to("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/div/div/section/div/div/div/div/div[2]/div[1]/div/form/div[2]/div/span/span[1]/span")).click();
		driver.findElement(By.xpath("/html/body/span[2]/span/span[1]/input")).sendKeys("India");
		driver.findElement(By.xpath("/html/body/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/div/div/section/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();

		//search jobs by name job --- WORKING
		driver.navigate().to("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.name("job-title")).sendKeys("Network Assistant Manager");
		driver.findElement(By.name("job-title")).sendKeys(Keys.ENTER);
		
		
		//Apply now --- WORKING
		driver.navigate().to("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div/div/div/section/div/div/div[2]/div/a[2]")).click();
		quit(driver);
	}
	
	public void quit(WebDriver driver) {
		driver.quit();
	}

	
}
