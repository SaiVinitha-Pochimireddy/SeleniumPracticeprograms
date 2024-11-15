package basicseleniumtopics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//creating driver object- opening chrome
		WebDriver driver=new ChromeDriver();
		
		//open the website
		driver.get("https://demo.opencart.com/");
		
		//maximizing the window
		driver.manage().window().maximize();
		
		//1. ID - 
		//driver.findElement(By.id("menu")).click();
		
		//2.Name - 
		//driver.findElement(By.name("give value of name attribute"));
		
		//3.className - we can get group of elements with this
	    //WebElement shoppingcart=driver.findElement(By.className("btn btn-lg btn-inverse btn-block dropdown-toggle show"));
		//shoppingcart.click();
		
		
		//4.tagName - get all the images
		List<WebElement> imglist=driver.findElements(By.tagName("img"));
		int imgcount=imglist.size();
		System.out.println("no.of images are "+imgcount);
		
		//5.linkText - we give the text which is clickable on website
		//driver.findElement(By.linkText("iPhone")).click();
		
		
		//6.partialLinkText - we give only some part of linktext (not preferred)
		//driver.findElement(By.partialLinkText("Ph")).click();
		
		//7. cssSelector - customized locators
		//for all this tagname is not mandatory
		
		//1. tagname & ID - input#idvalve
		//driver.findElement(By.cssSelector("input#idvalue"));
		
		//2. tagname & classname - input.classvalve
		//driver.findElement(By.cssSelector("input.classvalue"));
		
		//3. tagname & attribute - input[atrname='atrvalue'] - use single quotes or \" \"
		//driver.findElement(By.cssSelector("input[atrname=\"atrvalue\"]"));
		
		//4. tagname, classname & attribute - input.classvalue[atrname='atrvalue'] - use single quotes or \" \"
		//driver.findElement(By.cssSelector("input.classvalue[atrname=\"atrvalue\"]"));
		
		
		//8. Xpath - Absolute and relative
		//absolute - rootnode to present node (not preferred)
		//driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/input"));
		
		//relative - start from that node or its parent node(* ->represents all nodes)
		driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
		

	}

}
