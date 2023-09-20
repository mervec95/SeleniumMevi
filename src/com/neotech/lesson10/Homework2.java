package com.neotech.lesson10;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.neotech.utils.BaseClass;
public class Homework2 extends BaseClass{
    public static void main(String[] args) throws InterruptedException {
        /*
         * TC: Delete Orders
         * 
         * 1) Open chrome browser 
         * 2) Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
         * 3) Login to the application 
         * 4) Click on the checkbox of all orders with product FamilyAlbum 
         * 5) Delete Selected orders 
         * 6) Verify the orders have been deleted 
         * 7) Quit the browser
         */
        setUp();
        
        //login
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        
        
        //get columns 3 of the table to use it for the if condition
        
        List<WebElement> col3Values = driver.findElements(By.xpath("//table"
                + "[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[3]"));
        
        for (int i = 0; i < col3Values.size(); i++)
        {
            String text = col3Values.get(i).getText();
            System.out.println("Columns 3 Text: " + text);
            
            if (text.equals("FamilyAlbum"))
            {
                //if the Value is FamilyAlbum, click on the same record but on the column 1
                
                
                //path for the checkbox
                String path = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+(i+2)+"]/td[1]";
                System.out.println(path);
                
                driver.findElement(By.xpath(path)).click();
                
            }
        }
        
        Thread.sleep(5000);
        
        tearDown();
        
        
        
        
        
        
    }
}