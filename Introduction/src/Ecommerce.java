import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ecommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		int j = 0;
		String[] itemsNeeded = {"Cucumber", "Brocolli", "Beans"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

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
				Thread.sleep(2000);
				if (j == itemsNeeded.length)
					break;
			}
		}

	}

}
