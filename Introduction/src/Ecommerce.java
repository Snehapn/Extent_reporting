import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//implicit wait
	//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//explicit wait
		WebDriverWait w = new WebDriverWait(driver,5);
		
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beans" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(2000);
		addItems (driver,itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
	//	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
	
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}
	
	//create method
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int j = 0;
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			// Format it to get actual vegetable name

			/*
			 * if(name.contains("Cucumber")) { //click on add to cart
			 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(
			 * ); break; }
			 */

			// convert array into arrayList for easy search
			List itemsNeededList = Arrays.asList(itemsNeeded);

			// check whether name you extracted is present in arrayList or not
			if (itemsNeededList.contains(formattedName)) {

				j++;
				// click on add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length)
					break;
			}
		}

	}
	
	
}
