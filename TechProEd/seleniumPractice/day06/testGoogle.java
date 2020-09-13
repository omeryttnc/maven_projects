package com.TechProEd.seleniumPractice.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testGoogle {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.google.com/");
    }

    @Test
    public void testTitle (){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @Test
    public void picture(){
        WebElement picture = driver.findElement(By.id("hplogo"));
        Assert.assertTrue(picture.isDisplayed());
    }

    @Test
    public void gmail() {
        WebElement gmail = driver.findElement(By.linkText("Gmail"));
        Assert.assertTrue(gmail.isDisplayed());
    }
//    @Test(dependsOnMethods = "gmail")
//    public void deneme (){
//        System.out.println("pass");
//    }

        @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
}


}
