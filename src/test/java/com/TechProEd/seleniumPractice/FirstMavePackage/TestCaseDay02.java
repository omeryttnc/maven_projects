package com.TechProEd.seleniumPractice.FirstMavePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseDay02 {
    WebDriver driver;


    @Before
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }


    @Test
    public void testCase01() {
        driver.get("https://www.thetrainline.com/");
        WebElement returnbutton = driver.findElement(By.id("return"));
        returnbutton.click();

        Assert.assertTrue(returnbutton.isSelected());

        WebElement returnDate = driver.findElement(By.xpath("//*[@id=\"page.journeySearchForm.inbound.title\"]"));
        Assert.assertTrue(returnDate.isEnabled());

        //(//input[@data-test='date-input-field'])[1]

        WebElement oneDAte = driver.findElement(By.xpath("(//input[@data-test='date-input-field'])[1]"));
        Assert.assertTrue(oneDAte.isDisplayed());
    }


    @After
    public void closeBrowser() throws InterruptedException {
//     Thread.sleep(5000);
//        driver.quit();
    }


}
