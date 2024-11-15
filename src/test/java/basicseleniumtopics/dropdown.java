package basicseleniumtopics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		//driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		driver.get("https://www.google.com/");
		
		
		/*we have 3 types of dropdowns
		1.normal dropdown- dropdown with select tag
		we can select in 3 ways
		1.selectobj.SelectbyVisibleText("pass the text you want to select")
		2.selectobj.SelectbyValue("pass the value of value attribute")
		3.selectobj.SelectbyIndex(0) - if we have select an option thats index is 0
		all the above 3 ways are for deselection also
		and we can deselect all at a time 
		selectobj.deselectAll();
		*/
		
		/*
		//storing the dropdown in webelement
		WebElement drpele=driver.findElement(By.xpath("//select[@id='country-list']"));
		//creating select class obj
		Select selectobj=new Select(drpele);
		selectobj.selectByIndex(0);
		selectobj.selectByValue("3");
		selectobj.selectByVisibleText("India");
		selectobj.deselectAll();
		*/
		
		/* 2. Bootstrap dropdown- dropdown without select tag
		 * first click on dropdown then find xpath which selects all options under dropdown
		 * now use for loop to traverse and click on them
		 */
		/*
		driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
		Thread.sleep(5000);
		List<WebElement> drplist=driver.findElements(By.xpath("//div//div[@style='position: absolute; transform: translate3d(0px, 37px, 0px); top: 0px; left: 0px; will-change: transform;']//a[@class='dropdown-item']"));
		for(int i=0;i<drplist.size();i++)
		{
			//stroing item name into string
			String str=drplist.get(i).getText();
			
			//checking if the str is matching with give string and clicking on it
			if(str.equals("Another"))
			{
				drplist.get(i).click();
			}
			
		}*/

		
		/*3. Auto suggested dropdown - google
		 * here also we do same like bootstrap
		 * but here we don't have index. 
		 * list of items will be dynamic it keeps changing everytime
		 * 
		 */
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("java");
		List<WebElement> results=driver.findElements(By.xpath("//li//div[contains(@class,'wM6W7d')]"));
		for(WebElement str:results)
		{
			System.out.println(str.getText());
			if(str.getText().equals("java"))
			{
				str.click();
			}
		}
		driver.quit();
	}

}
