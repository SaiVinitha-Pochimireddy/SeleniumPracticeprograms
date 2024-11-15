package basicseleniumtopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class firstseleniumscript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*
		 * first we should have manual testcases to write automation script
		 * 1. launch any browser   WebDriver driver obj name=new ChromeDriver()/EdgeDriver()/...
		 * 2. open URL you want to work     driver.get("urllink");
		 * 3. write all the script you want
		 * 4. close the browser  driver.quit() - close all browser windows, driver.close()- closes current working window
		 */
		WebDriver driver=new ChromeDriver();
		//maximizing the window size
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");
		//verifying the title
		WebElement titleimage=driver.findElement(By.xpath("//img[@title='Your Store']"));
		if(titleimage.isDisplayed())
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
		Thread.sleep(5000);
		driver.quit();

	}

}
