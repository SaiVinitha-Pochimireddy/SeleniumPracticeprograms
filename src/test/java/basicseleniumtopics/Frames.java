package basicseleniumtopics;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		/*
		 * in eclipse we have diff windows right these are called frames
		 * frame contains inner frame. we can't go to them directly. go only through main frame
		 * every time we have come back to main frame. 
		 * driver.Switchto().defaultContent() - will redirect to main page
		 * 
		 * every frame is an individual webpage. 
		 * when we combine all of them in 1 page we call them as frames.
		 * In DOM frame contains src attribute we can copy that link and paste in new tab to open that page.
		 * For iframes we can find Xpath easily by opening them in new page.
		 * 
		 * we have 3 ways to switch to frame
		 * 
		 * 1. driver.switchTo().frame(name/ID); - we pass name/ID attr value
		 * 2. driver.switchTo().frame(WebElement); - store frame in webelement & pass it
		 * 3. driver.switchTo().frame(Index);- - its just our assumption it will be preferred when we have only 1 option
		 * we pass 0 here because index start from 0  
		 * 
		 * once we go to the frame then we can perform all actions in that.
		 */
		
		//switchin to frame 1 and passing value to its text box.
		WebElement frame1=driver.findElement(By.xpath("//frameset[1]/frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("frame 1");
		
		//going back to main page
		driver.switchTo().defaultContent();
		
		//switching to frame 3 and filling form
		WebElement frame3= driver.findElement(By.xpath("//frameset//frameset//frame[2]"));
		driver.switchTo().frame(frame3);
		
		//we have only 1 iframe inside frame 3 .So, directly we can use index number
		driver.switchTo().frame(0);
		
		//clicking on 2nd radio button & 1st checkbox & yes in the dropdown (open iframe src link in new tab to find xpath of form element)
		driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
		driver.findElement(By.xpath("//div[@id='i21']//div[@class='uHMk6b fsHoPb']")).click();
		//driver.findElement(By.xpath("//div[@class='e2CuFe eU809d']")).click();
		
		//using java script executor to select dropdown element
		//WebElement drpopt=driver.findElement(By.xpath("//span[normalize-space()='Well, now I know :-)']"));
		//JavascriptExecutor  js=(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click()",drpopt);
		
		//switching to 5th frame
		WebElement frame5= driver.findElement(By.xpath("//frameset[1]//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		
		driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='Ui.Vision by a9t9 software - Image-Driven Automation']"));
		System.out.println(logo.isDisplayed());

	}

}
