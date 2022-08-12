import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest{
	private int tiempoCarga1 = 0;
	private int tiempoPrueba1 = 0;
	private int tiempoCarga2 = 0;
	private int tiempoPrueba2 = 0;
	private int tiempoCarga3 = 0;
	private int tiempoPrueba3 = 0;
	private int tiempoCarga4 = 0;
	private int tiempoPrueba4 = 0;
	private int tiempoCarga5 = 0;
	private int tiempoPrueba5 = 0;
	private static final String EMPLOYER_USER = "abc67890@yopmail.com";
	private static final String EMPLOYER_CON = "12345";
	private static final String CANDIDATE_USER = "abc12345@yopmail.com";
	private static final String CANDIDATE_CON = "12345";

	@Test
	public void BusquedaPersonalizada() {
		System.setProperty("webdriver.chrome.driver", "D:\\Google Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Date inicioCarga = new Date();
		driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath(
				"/html/body/div[4]/div[1]/div/div/div/div/div/section/div/div/div/div/div[2]/div[1]/div/form/div[1]/div/input"))
				.sendKeys("Developer");
		Date finalCarga = new Date();
		driver.findElement(By.xpath(
				"/html/body/div[4]/div[1]/div/div/div/div/div/section/div/div/div/div/div[2]/div[1]/div/form/div[2]/div/span"))
				.click();
		driver.findElement(By.xpath("/html/body/span[2]/span/span[1]/input")).sendKeys("India");
		driver.findElement(By.xpath("/html/body/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(
				"/html/body/div[4]/div[1]/div/div/div/div/div/section/div/div/div/div/div[2]/div[1]/div/form/div[3]/button"))
				.click();
		Date inicioPrueba = new Date();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[1]/ol/li[2]/a"))
						.getText().startsWith("Search Page");
			}
		});
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"search-widget\"]/div/form/div[1]/input"))
				.getAttribute("value").equals("Developer"), true);
		Assert.assertEquals(driver
				.findElement(By.xpath(
						"/html/body/section[1]/div/div/div/div/div[2]/div/div[6]/div/div[1]/div[2]/ul/li[1]/h4/a"))
				.getText().contains("Developer"), true);
		Date finalPrueba = new Date();
		String nombre = driver
				.findElement(By.xpath(
						"/html/body/section[1]/div/div/div/div/div[2]/div/div[6]/div/div[1]/div[2]/ul/li[1]/h4/a"))
				.getText();
		Assert.assertEquals(driver.findElement(By.xpath(
				"/html/body/section[1]/div/div/div/div/div[2]/div/div[6]/div/div[1]/div[2]/ul/li[1]/p[2]/span[1]/a[2]"))
				.getText(), "India");
		driver.findElement(
				By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[6]/div/div[1]/div[2]/ul/li[1]/h4/a"))
				.click();
		(new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("/html/body/section[2]/div/div/div[1]/div[2]/h4")).getText()
						.startsWith("Job Information");
			}
		});
		Assert.assertEquals(
				driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/h1")).getText().equals(nombre),
				true);
		tiempoCarga1 = (int) ((finalCarga.getTime() - inicioCarga.getTime()) / 1000);
		tiempoPrueba1 = (int) ((finalPrueba.getTime() - inicioPrueba.getTime()) / 1000);
		driver.quit();
	}

	@Test
	public void ExplorarCategoria() {
		System.setProperty("webdriver.chrome.driver", "D:\\Google Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Date inicioCarga = new Date();
		driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("//*[@id=\"elegent_catz\"]/div/div/div[2]/div[1]/div/ul/li[1]/a")).click();
		Date finalCarga = new Date();
		Date inicioPrueba = new Date();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[1]/ol/li[2]/a"))
						.getText().startsWith("Search Page");
			}
		});
		if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("Available Jobs")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Automotive");
			Assert.assertEquals(driver.findElement(By.xpath(
					"/html/body/section[1]/div/div/div/div/div[2]/div/div[6]/div/div[1]/div[2]/ul/li[1]/p[2]/span[2]/a"))
					.getText(), "Automotive");
		} else if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("No Jobs Matched")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Automotive");
		}
		Date finalPrueba = new Date();

		driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("//*[@id=\"elegent_catz\"]/div/div/div[2]/div[1]/div/ul/li[2]/a")).click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[1]/ol/li[2]/a"))
						.getText().startsWith("Search Page");
			}
		});
		if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("Available Jobs")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Education");
			Assert.assertEquals(driver.findElement(By.xpath(
					"/html/body/section[1]/div/div/div/div/div[2]/div/div[6]/div/div[1]/div[2]/ul/li[1]/p[2]/span[2]/a"))
					.getText(), "Education");
		} else if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("No Jobs Matched")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Education");
		}

		driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("//*[@id=\"elegent_catz\"]/div/div/div[2]/div[1]/div/ul/li[3]/a")).click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[1]/ol/li[2]/a"))
						.getText().startsWith("Search Page");
			}
		});
		if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("Available Jobs")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Health and Care");
			Assert.assertEquals(driver.findElement(By.xpath(
					"/html/body/section[1]/div/div/div/div/div[2]/div/div[6]/div/div[1]/div[2]/ul/li[1]/p[2]/span[2]/a"))
					.getText(), "Health and Care");
		} else if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("No Jobs Matched")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Health and Care");
		}

		driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("//*[@id=\"elegent_catz\"]/div/div/div[2]/div[1]/div/ul/li[4]/a")).click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[1]/ol/li[2]/a"))
						.getText().startsWith("Search Page");
			}
		});
		if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("Available Jobs")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Construction");
			Assert.assertEquals(driver.findElement(By.xpath(
					"/html/body/section[1]/div/div/div/div/div[2]/div/div[6]/div/div[1]/div[2]/ul/li[1]/p[2]/span[2]/a"))
					.getText(), "Construction");
		} else if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("No Jobs Matched")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Construction");
		}

		driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("//*[@id=\"elegent_catz\"]/div/div/div[2]/div[1]/div/ul/li[5]/a")).click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[1]/ol/li[2]/a"))
						.getText().startsWith("Search Page");
			}
		});
		if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("Available Jobs")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Designer");
			Assert.assertEquals(driver.findElement(By.xpath(
					"/html/body/section[1]/div/div/div/div/div[2]/div/div[6]/div/div[1]/div[2]/ul/li[1]/p[2]/span[2]/a"))
					.getText(), "Designer");
		} else if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("No Jobs Matched")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Designer");
		}

		driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("//*[@id=\"elegent_catz\"]/div/div/div[2]/div[1]/div/ul/li[6]/a")).click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[1]/ol/li[2]/a"))
						.getText().startsWith("Search Page");
			}
		});
		if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("Available Jobs")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Fitness Trainer");
			Assert.assertEquals(driver.findElement(By.xpath(
					"/html/body/section[1]/div/div/div/div/div[2]/div/div[6]/div/div[1]/div[2]/ul/li[1]/p[2]/span[2]/a"))
					.getText(), "Fitness Trainer");
		} else if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("No Jobs Matched")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Fitness Trainer");
		}

		driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("//*[@id=\"elegent_catz\"]/div/div/div[2]/div[1]/div/ul/li[7]/a")).click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[1]/ol/li[2]/a"))
						.getText().startsWith("Search Page");
			}
		});
		if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("Available Jobs")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Marketing");
			Assert.assertEquals(driver.findElement(By.xpath(
					"/html/body/section[1]/div/div/div/div/div[2]/div/div[6]/div/div[1]/div[2]/ul/li[1]/p[2]/span[2]/a"))
					.getText(), "Marketing");
		} else if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("No Jobs Matched")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Marketing");
		}

		driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("//*[@id=\"elegent_catz\"]/div/div/div[2]/div[1]/div/ul/li[8]/a")).click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[1]/ol/li[2]/a"))
						.getText().startsWith("Search Page");
			}
		});
		if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("Available Jobs")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Other Services");
			Assert.assertEquals(driver.findElement(By.xpath(
					"/html/body/section[1]/div/div/div/div/div[2]/div/div[6]/div/div[1]/div[2]/ul/li[1]/p[2]/span[2]/a"))
					.getText(), "Other Services");
		} else if (driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/div/div[1]/h4"))
				.getText().contains("No Jobs Matched")) {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"select2-make_id-container\"]")).getText(),
					"Other Services");
		}
		tiempoCarga2 = (int) ((finalCarga.getTime() - inicioCarga.getTime()) / 1000);
		tiempoPrueba2 = (int) ((finalPrueba.getTime() - inicioPrueba.getTime()) / 1000);
		driver.quit();
	}

	@Test
	public void ExplorarPerfiles() {
		System.setProperty("webdriver.chrome.driver", "D:\\Google Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Date inicioCarga = new Date();
		driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("//*[@id=\"menu-1\"]/section/div/ul[2]/li[1]/a")).click();
		Date finalCarga = new Date();
		driver.findElement(By.xpath("//*[@id=\"sb_reg_email\"]")).sendKeys(EMPLOYER_USER);
		driver.findElement(By.xpath("//*[@id=\"sb_reg_password\"]")).sendKeys(EMPLOYER_CON);
		driver.findElement(By.xpath("//*[@id=\"sb_login_submit\"]")).click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("//*[@id=\"dashboard-bar-right\"]/div/div/div[1]/div[2]/h4")).getText()
						.equals("EDUARDO");
			}
		});
		driver.findElement(By.xpath("//*[@id=\"menu-1\"]/section/div/ul[3]/li/a")).click();
		Date inicioPrueba = new Date();
		driver.findElement(By.xpath(
				"/html/body/div[4]/div[5]/div/div/div/div/div/section/div/div/div[2]/div/div/div/div[1]/div/div[26]/div/div/div[2]/a"))
				.click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("/html/body/section[3]/div/div/div[1]/aside/div/h4")).getText()
						.startsWith("Candidate Detail");
			}
		});
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div/div[2]/h4")).getText(),
				"Jon Doe");
		Date finalPrueba = new Date();
		driver.findElement(By.xpath("//*[@id=\"contact_form_email\"]/div/div[1]/div/input")).sendKeys("Employer");
		driver.findElement(By.xpath("//*[@id=\"contact_form_email\"]/div/div[2]/div/input")).sendKeys(EMPLOYER_USER);
		driver.findElement(By.xpath("//*[@id=\"contact_form_email\"]/div/div[3]/div/input")).sendKeys("TEST");
		driver.findElement(By.xpath("//*[@id=\"contact_form_email\"]/div/div[4]/div/textarea")).sendKeys("TEST");
		driver.findElement(By.xpath("//*[@id=\"contact_form_email\"]/div/div[5]/button")).click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("//*[@id=\"toast-container\"]/div[1]/div")).getText()
						.startsWith("Message sent");
			}
		});
		driver.findElement(By.xpath("/html/body/section[3]/div/div/div[1]/aside/div/button")).click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				if (d.findElement(By.xpath("//*[@id=\"toast-container\"]/div[1]/div")).getText()
						.equals("Resume Saved Succesfully")) {
					return true;
				} else if (d.findElement(By.xpath("//*[@id=\"toast-container\"]/div[1]/div")).getText()
						.equals("Already saved")) {
					return true;
				} else {
					return false;
				}
			}
		});
		tiempoCarga3 = (int) ((finalCarga.getTime() - inicioCarga.getTime()) / 1000);
		tiempoPrueba3 = (int) ((finalPrueba.getTime() - inicioPrueba.getTime()) / 1000);
		driver.quit();
	}

	@Test
	public void ExplorarPagos() {
			System.setProperty("webdriver.chrome.driver", "D:\\Google Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			Date inicioCarga = new Date();
			driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
			driver.findElement(By.xpath("//*[@id=\"menu-1\"]/section/div/ul[2]/li[1]/a")).click();
			Date finalCarga = new Date();
			tiempoCarga4 = (int) ((finalCarga.getTime() - inicioCarga.getTime()) / 1000);
			driver.findElement(By.xpath("//*[@id=\"sb_reg_email\"]")).sendKeys(EMPLOYER_USER);
			driver.findElement(By.xpath("//*[@id=\"sb_reg_password\"]")).sendKeys(EMPLOYER_CON);
			driver.findElement(By.xpath("//*[@id=\"sb_login_submit\"]")).click();
			Date inicioPrueba = new Date();
			(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.findElement(By.xpath("//*[@id=\"dashboard-bar-right\"]/div/div/div[1]/div[2]/h4"))
							.getText().equals("EDUARDO");
				}
			});
			driver.findElement(By.xpath("//*[@id=\"menu-1\"]/section/div/ul[3]/li/a")).click();
			driver.findElement(By.xpath(
					"/html/body/div[4]/section[1]/div/div/div/div/div/section/div/div/div[2]/div/div[1]/div/div[2]/div/a"))
					.click();
			(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div/h4")).getText()
							.startsWith("Cart");
				}
			});
			Assert.assertEquals(driver
					.findElement(
							By.xpath("/html/body/section[1]/div/div/div/div/div/div[1]/form/table/tbody/tr[1]/td[3]/a"))
					.getText(), "Premium");
			Assert.assertEquals(driver
					.findElement(By.xpath(
							"/html/body/section[1]/div/div/div/div/div/div[1]/form/table/tbody/tr[1]/td[6]/span/bdi"))
					.getText(), "$600.00");
			driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div/div[1]/div[2]/div/div/a")).click();
			(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div/h4")).getText()
							.startsWith("Checkout");
				}
			});
			driver.findElement(By.xpath("//*[@id=\"billing_first_name\"]")).sendKeys("TEST");
			driver.findElement(By.xpath("//*[@id=\"billing_last_name\"]")).sendKeys("TEST");
			driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]")).sendKeys("TEST");
			driver.findElement(By.xpath("//*[@id=\"billing_city\"]")).sendKeys("TEST");
			driver.findElement(By.xpath("//*[@id=\"select2-billing_state-container\"]")).click();
			driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Alabama");
			driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]")).sendKeys("88888");
			driver.findElement(By.xpath("//*[@id=\"billing_phone\"]")).sendKeys("88888888");
			driver.findElement(By.xpath("//*[@id=\"payment\"]/ul")).getText().contains("Método de Pago");
			driver.findElement(By.xpath("//*[@id=\"payment\"]/ul")).click();
			driver.findElement(By.xpath("//*[@id=\"payment\"]/ul")).getAttribute("aria-activedescendant")
					.equals("Visa");
			driver.findElement(By.xpath("//*[@id=\"place_order\"]")).click();
			Date finalPrueba = new Date();

			driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
			driver.findElement(By.xpath("//*[@id=\"menu-1\"]/section/div/ul[2]/li[1]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"sb_reg_email\"]")).sendKeys(CANDIDATE_USER);
			driver.findElement(By.xpath("//*[@id=\"sb_reg_password\"]")).sendKeys(CANDIDATE_CON);
			driver.findElement(By.xpath("//*[@id=\"sb_login_submit\"]")).click();
			(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.findElement(By.xpath("/html/body/section/div/div/div/div[2]/div/div/div[1]/div[2]/h4"))
							.getText().equals("EDUARDO");
				}
			});
			driver.findElement(By.xpath("//*[@id=\"menu-1\"]/section/div/ul[3]/li/a")).click();
			driver.findElement(By.xpath(
					"/html/body/div[4]/section[3]/div/div/div/div/div/section/div/div/div[2]/div/div[1]/div/div[2]/a"))
					.click();
			(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div/h4")).getText()
							.startsWith("Cart");
				}
			});
			Assert.assertEquals(driver
					.findElement(
							By.xpath("/html/body/section[1]/div/div/div/div/div/div[1]/form/table/tbody/tr[1]/td[3]/a"))
					.getText(), "Silver Package");
			Assert.assertEquals(driver
					.findElement(By.xpath(
							"/html/body/section[1]/div/div/div/div/div/div[1]/form/table/tbody/tr[1]/td[6]/span/bdi"))
					.getText(), "$10.00");
			driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div/div[1]/div[2]/div/div/a")).click();
			(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div/h4")).getText()
							.startsWith("Checkout");
				}
			});
			driver.findElement(By.xpath("//*[@id=\"billing_first_name\"]")).sendKeys("TEST");
			driver.findElement(By.xpath("//*[@id=\"billing_last_name\"]")).sendKeys("TEST");
			driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]")).sendKeys("TEST");
			driver.findElement(By.xpath("//*[@id=\"billing_city\"]")).sendKeys("TEST");
			driver.findElement(By.xpath("//*[@id=\"select2-billing_state-container\"]")).click();
			driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Alabama");
			driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]")).sendKeys("88888");
			driver.findElement(By.xpath("//*[@id=\"billing_phone\"]")).sendKeys("88888888");
			driver.findElement(By.xpath("//*[@id=\"payment\"]/ul")).getText().contains("Método de Pago");
			driver.findElement(By.xpath("//*[@id=\"payment\"]/ul")).click();
			driver.findElement(By.xpath("//*[@id=\"payment\"]/ul")).getAttribute("aria-activedescendant")
					.equals("Visa");
			driver.findElement(By.xpath("//*[@id=\"place_order\"]")).click();

			tiempoPrueba4 = (int) ((finalPrueba.getTime() - inicioPrueba.getTime()) / 1000);
			driver.quit();
	}

	@Test
	public void ErroresLoginRegistro() {
		System.setProperty("webdriver.chrome.driver", "D:\\Google Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Date inicioCarga = new Date();
		driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("//*[@id=\"menu-1\"]/section/div/ul[2]/li[1]/a")).click();
		Date finalCarga = new Date();
		Date inicioPrueba = new Date();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(
						By.xpath("/html/body/div[4]/div/div/div/div/div/div/section[1]/div/div/div/div/h1")).getText()
						.startsWith("Account SignIn");
			}
		});
		driver.findElement(By.xpath("//*[@id=\"sb_reg_email\"]")).sendKeys("Error1");
		driver.findElement(By.xpath("//*[@id=\"sb_reg_password\"]")).sendKeys("Error1");
		driver.findElement(By.xpath("//*[@id=\"sb_login_submit\"]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"parsley-id-5\"]/li")).getText(),
				"Please enter your valid email.");
		Date finalPrueba = new Date();
		driver.get("https://sistemas.ufidelitas.ac.cr/nokri-demo2/");
		driver.findElement(By.xpath("//*[@id=\"menu-1\"]/section/div/ul[2]/li[2]/a")).click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(
						By.xpath("/html/body/div[4]/div/div/div/div/div/div/section[1]/div/div/div/div/h1")).getText()
						.startsWith("Account Register");
			}
		});
		driver.findElement(By.xpath("//*[@id=\"sb-signup-form\"]/div[1]/div/input")).sendKeys("Error1");
		driver.findElement(By.xpath("//*[@id=\"sb_reg_email\"]")).sendKeys("Error1");
		driver.findElement(By.xpath("//*[@id=\"sb_reg_password\"]")).sendKeys("Error1");
		driver.findElement(By.xpath("//*[@id=\"sb_reg_conf_password\"]")).sendKeys("Error1");
		driver.findElement(By.xpath("//*[@id=\"sb-signup-form\"]/div[7]/div/input")).sendKeys("88888888");
		driver.findElement(By.xpath("//*[@id=\"sb-signup-form\"]/div[8]/div/span/span[1]/span")).click();
		driver.findElement(By.xpath("/html/body/span[2]/span/span[1]/input")).sendKeys("USA");
		driver.findElement(By.xpath("/html/body/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("_custom_[Date]")).sendKeys("00/00/0000");
		driver.findElement(By.xpath("//*[@id=\"sb_register_submit\"]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"parsley-id-7\"]/li")).getText(),
				"Please enter your valid email.");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"parsley-id-multiple-icheck_box\"]/li")).getText(),
				"Please accept terms and conditions.");
		tiempoCarga5 = (int) ((finalCarga.getTime() - inicioCarga.getTime()) / 1000);
		tiempoPrueba5 = (int) ((finalPrueba.getTime() - inicioPrueba.getTime()) / 1000);
		driver.quit();

	}

	@Test
	public void mostrarTiempos() {
		System.out.println("---------------------------");
		System.out.println("Tiempo de Resultados");
		System.out.println("---------------------------");
		System.out
				.println("Tiempo de Espera para Resultados de Busqueda Perzonalizada: " + tiempoPrueba1 + " segundos");
		System.out.println(
				"Tiempo de Espera para Resultados de Exploracion de Categoria: " + tiempoPrueba2 + " segundos");
		System.out
				.println("Tiempo de Espera para Resultados de Exploracion de Perfiles: " + tiempoPrueba3 + " segundos");
		System.out.println("Tiempo de Espera para Resultados de Pagos: " + tiempoPrueba4 + " segundos");
		System.out.println(
				"Tiempo de Espera para Resultados de Errores de Login y Registro: " + tiempoPrueba5 + " segundos");
		System.out.println("---------------------------");
		System.out.println("Tiempos de Carga");
		System.out.println("---------------------------");
		System.out.println("Tiempo de Espera para Cargar Pagina en Prueba 1: " + tiempoCarga1 + " segundos");
		System.out.println("Tiempo de Espera para Cargar Pagina en Prueba 2: " + tiempoCarga2 + " segundos");
		System.out.println("Tiempo de Espera para Cargar Pagina en Prueba 3: " + tiempoCarga3 + " segundos");
		System.out.println("Tiempo de Espera para Cargar Pagina en Prueba 4: " + tiempoCarga4 + " segundos");
		System.out.println("Tiempo de Espera para Cargar Pagina en Prueba 5: " + tiempoCarga5 + " segundos");
		int tiempoPromedio = (tiempoCarga1 + tiempoCarga2 + tiempoCarga3 + tiempoCarga4 + tiempoCarga5) / 5;
		System.out.println("Tiempo de Espera Promedio: " + tiempoPromedio + " segundos");
	}

}
