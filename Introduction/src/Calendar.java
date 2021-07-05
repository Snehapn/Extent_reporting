import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions"); 
		Thread.sleep(5000);
		driver.findElement(By.id("travel_date")).click();
		
		List<WebElement> dates = driver.findElements(By.className("day"));
		int count = driver.findElements(By.className("day")).size();
		
		for (int i=0; i<count; i++) {
			
		String text = driver.findElements(By.className("day")).get(i).getText();
		
		if(text.equalsIgnoreCase("23")) {
			driver.findElements(By.className("day")).get(i).click();
			break;
			}
		}
		
	}

}
