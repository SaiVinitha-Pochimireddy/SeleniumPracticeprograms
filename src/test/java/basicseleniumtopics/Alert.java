package basicseleniumtopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		//driver.get("admin:admin@https://the-internet.herokuapp.com/basic_auth");
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		/*
		 * Alert with ok
		 * Alert with ok and Cancel
		 * Alert with textbox, ok & cancel
		 * Alert with no buttons
		 * for some websites we need to pass username &pswd while passing the url itself
		 * 
		 * we can't inspect alert bcs it is popup but button we can
		 * click on button then do Accept() and dismiss()
		 * 
		 * we can create alert class obj/ use it directly
		 * we can use explicit wait also
		 */
		//creating alert obj
		org.openqa.selenium.Alert alertobj=driver.switchTo().alert();
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(5000);
		
		//alertobj.accept();
		//accept() and dismiss() both will do the same if we have only Ok button
		alertobj.dismiss();
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).sendKeys("alert text");
		String Actual_txt=driver.findElement(By.xpath("//p[@id='result']")).getText();
		String Expected_txt="alert text";
		if(Actual_txt.equals(Expected_txt))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
		
		
		driver.quit();

	}

}
