package com.TechProEd.seleniumPractice.youtubeCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class rightClick {
    WebDriver driver;
    @Before
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void testCase() {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        Actions act = new Actions(driver);
        act.contextClick(driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"))).perform();
        driver.findElement(By.xpath("//span[text()='Copy']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }
}
