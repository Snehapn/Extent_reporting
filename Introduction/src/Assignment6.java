import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption2")).click();
		String newValue = driver.findElement(By.xpath("//label[@for='benz']")).getText();		
		System.out.println(newValue);
		
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(newValue);
		
		driver.findElement(By.id("name")).sendKeys(newValue);
		driver.findElement(By.id("alertbtn")).click();
		
		Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();	
        System.out.println(driver.switchTo().alert().getText());
        String alertMessage = driver.switchTo().alert().getText();
        
        if (alertMessage.contains(newValue)) {
        	System.out.println("Alert message success");
        }
        
        else
            System.out.println("Something wrong with execution");

	
		driver.switchTo().alert().accept();

	}

}
