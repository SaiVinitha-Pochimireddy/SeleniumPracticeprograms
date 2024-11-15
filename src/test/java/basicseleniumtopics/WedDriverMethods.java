package basicseleniumtopics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WedDriverMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating driver object- opening chrome
		WebDriver driver=new ChromeDriver();
				
					
		//maximizing the window
		driver.manage().window().maximize();
		
		//Get methods
		//1. driver.ger("url") - opens the webpage
		driver.get("https://demo.opencart.com/"); 
		
		//2.driver.getTitile();- gives page title
		System.out.println(driver.getTitle());
		
		//3.driver.getCurrentUrl();- gives the present webpage url(print it)
		System.out.println(driver.getCurrentUrl());
		
		//4.driver.getPageSource(); - gives HTML code of that page(store it in string)
		String pagesource=driver.getPageSource();
		System.out.println(pagesource);
		if(pagesource.contains("cart"))
		{
			System.out.println("test passed");
		}
		else
		{
		System.out.println("test failed");
		}
		
		//5. driver.getWindowhandle()- gives unique id of webpage (everytime it generates diff id)
		String id=driver.getWindowHandle();
		System.out.println(id);
		
		//6. driver.gerWindowHandles()-gives ids of all pages which are opened through Automation
		//store them in set<Strings>. bcs, list will allow duplicates
		Set<String> idset= driver.getWindowHandles();
		//use enhanced for loop to get the ids
		for(String idvar:idset)
		{
			System.out.println(idvar);
		}
		//to get perticular page id we have to convert set to list. bcs, set don't have indexes.
		List<String> idlist=new ArrayList(idset);
		System.out.println("parent id is "+idlist.get(0));
		
		
		//Conditional Methods - give true/false
		//1. isDisplayed() - used for all elements
		driver.findElement(By.xpath("//img[@title='Your Store']")).isDisplayed();
		
		//2. isEnabled() - used for text boxes, checkboxes, buttons,...
		driver.findElement(By.xpath("//button[@class='btn btn-light btn-lg']")).isEnabled();
		
		//3. isSelected() - used for buttons, checkboxes, radiobuttons,...
		driver.findElement(By.xpath("//button[@class='btn btn-light btn-lg']")).isSelected();
		
		
		//browser methods 
		//1.driver.close()- closes only 1 window which is mostly opened with driver.get("url")
		//it may give an exception.
		//2. driver.quit()- closes all windows (no exception)
		driver.quit();
		

	}

}
