package week4.day1.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		
		//open new window 
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winLst=new ArrayList<String>(windowHandles);
		String mainPage=winLst.get(0);
		String newWindow = winLst.get(1);
		driver.switchTo().window(newWindow);
		String title = driver.getTitle();
		System.out.println("New window Title : " + title);
		driver.close();
		driver.switchTo().window(mainPage);
		
		//find number of open windows 
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		int size = windowHandles2.size();
		System.out.println("The number of open windows are " + size);
		List<String> winLst1=new ArrayList<String>(windowHandles2);
		driver.switchTo().window(winLst1.get(1));
		driver.close();
		driver.switchTo().window(winLst1.get(2));
		driver.close();
		driver.switchTo().window(winLst1.get(0));
		
		
		//Close me 
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
	    List<String> winLst2=new ArrayList<String>(windowHandles3);
		for (int i=1;i<winLst2.size();i++) {
		driver.switchTo().window(winLst2.get(i));
		driver.close();
		}
		driver.switchTo().window(winLst2.get(0));
		
		
		//wait for 2 window 
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Thread.sleep(6000);
		Set<String> wait5sec = driver.getWindowHandles();
		System.out.println("Number of windows after waiting for 5 seconds :" + wait5sec.size());
		

	}

}
