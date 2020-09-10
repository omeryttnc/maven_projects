package com.TechProEd.seleniumPractice.homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Main Page: https://s1.demo.opensourcecms.com/s/44
Admin Page: https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login
Username: opensourcecms
Password: opensourcecms
 */
public class opensourcecms {
    WebDriver driver;

    @Before
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCase() {
        driver.get("https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("(//input[@name = 'txtUsername'])"));
        username.sendKeys("opensourcecms");
        WebElement password = driver.findElement(By.xpath("(//input[@name = 'txtPassword'])"));
        password.sendKeys("opensourcecms" + Keys.ENTER);

    }



    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


}
