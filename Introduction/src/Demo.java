import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//chromedriver.exe
System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
WebDriver driver =new ChromeDriver();
driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //URL in the browser
// driver.findElement(By.id("email")).sendKeys("snehanatekar@whitehatjr.com");
// driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("Sneha@123");
// driver.findElement(By.linkText("Forgotten password?")).click();

	WebElement StaticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	Select dropdown = new Select(StaticDropdown);
	dropdown.selectByIndex(3);
	System.out.println(dropdown.getFirstSelectedOption().getText());
	dropdown.selectByVisibleText("AED");
	System.out.println(dropdown.getFirstSelectedOption().getText());
	dropdown.selectByValue("INR");
	System.out.println(dropdown.getFirstSelectedOption().getText());


driver.close();
}
}
