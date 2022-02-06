package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        //WebDriver driver = new ChromeDriver();
        
        WebDriver driver = new HtmlUnitDriver(); //selenium HtmlUnitDriver
        
        driver.get("http://localhost:4567");
        
        System.out.println(driver.getPageSource()); //selenium HtmlUnitDriver
        
        sleep(2);
        
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//        
//        System.out.println(driver.getPageSource()); //selenium HtmlUnitDriver
//
//        sleep(2);

        //ohtu alkuperainen koodi

//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
//        element = driver.findElement(By.name("login"));
        
        //correct credentials: user: testi, password: passu123
        //failed login, correct user, incorrect password
        
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("testi");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("incorrectPass123");
//        element = driver.findElement(By.name("login"));

        //create new user
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        System.out.println(driver.getPageSource()); //selenium HtmlUnitDriver
        sleep(2);
        
        Random r = new Random();
        element = driver.findElement(By.name("username"));
        element.sendKeys("user"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("password123");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("password123");
        
        sleep(2);
        element.submit();

        System.out.println(driver.getPageSource()); //selenium HtmlUnitDriver
        
        sleep(2);
        
        //after new user creation, log out process
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        System.out.println(driver.getPageSource()); //selenium HtmlUnitDriver
        
        sleep(2);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        System.out.println(driver.getPageSource()); //selenium HtmlUnitDriver
        
        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
