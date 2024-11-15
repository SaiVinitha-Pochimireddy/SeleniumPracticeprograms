package basicseleniumtopics;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class Browsermethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		/*
		 * here we can switch from 1 window to another
		 * 1st open all windows by clicking on links
		 * then find their ids and store them in set
		 * for 2 browsers - covert set to list to find parent/child browser id
		 * multiple browsers- use for loop for set
		 */
		
		//handling multiple browsers
		//openings all browser windows
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("browser");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> links=driver.findElements(By.xpath("//div//div[@id='wikipedia-search-result-link']//a"));
		for(int i=0;i<links.size();i++)
		{
			links.get(i).click();
		}
		
		Set<String> winids=driver.getWindowHandles();
		
		for(String id:winids)
		{
			String title=driver.switchTo().window(id).getTitle();
			if(title.equals("Browser game"))
			{
				driver.findElement(By.xpath("//a[normalize-space()='video game']")).click();
			}
		}
		

	}

}
