package week4.day1.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaleForce {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		ChromeDriver driver=new ChromeDriver();
		
		//Load the url as " https://login.salesforce.com/ "
		driver.get("https://login.salesforce.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter the username as " ramkumar.ramaiah@testleaf.com "
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		//Enter the password as " Password$123 "
		driver.findElement(By.id("password")).sendKeys("Password$123");
		
		//.click on the login button
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		
		//click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		
		//Switch to the next window using Windowhandles.
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowsLst=new ArrayList<String>(windowHandles);
		String firstWindow=windowsLst.get(0);
		String secondWindow=windowsLst.get(1);
		driver.switchTo().window(secondWindow);
		
		//click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		String newWindowTitle = driver.getTitle();
		
		//Get the title
		System.out.println("Title of new window : " + newWindowTitle);
		
		//Get back to the parent window
		driver.switchTo().window(firstWindow);
		String parentTitle = driver.getTitle();
		System.out.println("Parent window Title" + parentTitle);
		
		//close the browser
		driver.quit();
		

	}

}
