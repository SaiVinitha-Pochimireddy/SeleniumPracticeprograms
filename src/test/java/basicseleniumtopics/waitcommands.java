package basicseleniumtopics;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitcommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//launch browser
		WebDriver driver=new ChromeDriver();
		
		//maximizing window
		driver.manage().window().maximize();
		
		//open the webpage
		driver.get("https://www.w3schools.com/");
		
		//normally we use Thread.sleep(3000) - not preferred for automation
		//3 types of waits
		//1. Implicit wait - once declared applicable to all elements(most preferred)
		//dis adv- eventhogh ele found it will wait untill the waiting time completes
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//2. Explicit wait - write separate stmts for every element
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//above stmt will be applicable for all elements. below should be written separately for every element		
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='navbtn_tutorials']"))).click();
		
		
		//3. Fluient Wait - same like explicit but we have polling every and ignoring
		
		FluentWait flwait= new FluentWait(driver);
		flwait.withTimeout(Duration.ofSeconds(30));
		flwait.pollingEvery(Duration.ofSeconds(5));
		flwait.ignoring(NoSuchElementException.class);
		
		//here for every 5 sec it will start new cycle untill 30 seconds are completed.
		//it will repeat for 6 times 5*6=30.
		
		WebElement ele=(WebElement) flwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='navbtn_exercises']")));
        String str=ele.getText();
        System.out.println(str);
        
        driver.quit();
	}

}
