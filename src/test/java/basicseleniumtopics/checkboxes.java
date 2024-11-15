package basicseleniumtopics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//launch webbrowser
		WebDriver driver=new ChromeDriver();
		
		//maximize browser
		driver.manage().window().maximize();
		
		//adding implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//open Url
		driver.get("https://www.qa-practice.com/elements/checkbox/mult_checkbox");
		
		//we create xpath that will show all checkboxes and store it in list
		List<WebElement> chkbox=driver.findElements(By.xpath("//input[@class='form-check-input']"));
		
		//use for loop to traverse and click on check boxes
		
		for(int i=0;i<chkbox.size();i++)
		{
			//we use click() for selecting & unselecting the checkbox
			chkbox.get(i).click();
		}
		for(WebElement ele:chkbox)
		{
			if(ele.isSelected())
			{
				//clicking on the selected checkboxes
				ele.click();
			}
		}
		
		for(int i=0;i<chkbox.size();i++)
		{
			if(i==1)
			{
				//clicking only perticular element
				chkbox.get(i).click();
			}
		}
		
		driver.quit();

	}

}
