package basicseleniumtopics;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigateMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1. navigate().to("url"/url) - it will accept string and url both
		//drivet.get("url")- it will accept only string
		
		//URL pageurl=new URL("https://demo.opencart.com/");
		driver.navigate().to("https://demo.opencart.com/");
		
		//2. naviagete().forward() - goes to next page
		driver.navigate().forward();
		
		//3. naviagte().back()- goes to previous page
		driver.navigate().back();
		
		//4. navigate().refresh() - refresh the present page
		driver.navigate().refresh();
		
		driver.quit();
	}

}
