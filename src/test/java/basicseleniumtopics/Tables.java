package basicseleniumtopics;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/?");
		
		/*
		 * we have 3 types of tablea
		 * 1.static - normal table contains rows & cols (some contain thead, tbody)
		 * 2.dynamic/pagination - contains page numbers
		 * 
		 * 1 table - 1st find no.of rows with <tr> & cols with <th> tagname
		 * mutiple tables - use xpath and store in list to find no.of rows & cols
		 * then use for loop to traverse
		 * here index start from 1. but for rows if we have heading col use 2 as starting index
		 * we can get particular value/ do any action
		 * 
		 * 
		 * for Dynamic table 1st find no.of pages
		 * we can see "showing 1 to 5 of 148 pages" take this str
		 * get the substring (148) from above str.
		 * str.substring(str.index("f")+2,str.index("p")-1)  - customize accordingly
		 * store this substring in another str1 and conert it into int - Ineger.parseInt(str1)
		 * 
		 * then use for loop and use xpath that changes page number everytime and perform action.
		 */
		List<WebElement> rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		List<WebElement> cols=driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		for(int r=2;r<rows.size();r++)
		{
			for(int c=1;c<cols.size();c++)
			{
				String data= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(data+"\t");
			}
			System.out.println();
		}
		
		//finding authors whose but cost is in 3 series
		
		for(int r=2;r<rows.size();r++)
		{
			//getting only cost from every row
			String Cost= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			if(Cost.contains("30"))
			{
				String author_name=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
				System.out.println(author_name+"  "+Cost);
			}
		}
		
		

	}

}
