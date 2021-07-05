import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section12_89_practise_exercide {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//1. Counts of links on page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. Count of links on footer
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//3. Count of links on footer 1st column	
		WebElement footerColumn1Driver = driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
		System.out.println(footerColumn1Driver.findElements(By.tagName("a")).size());

		//4. Click on each link and check whether pages are loading (open link in new tab)
		//open link in new tab
		for (int i=1; i<footerColumn1Driver.findElements(By.tagName("a")).size(); i++) {
			
		String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		footerColumn1Driver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
		Thread.sleep(5000);
		}
		
		//get title of each new tab
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while(it.hasNext()) {
				
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		
			}
		
	}

}
