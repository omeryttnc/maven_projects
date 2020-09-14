package com.TechProEd.seleniumPractice.homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class try01 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void alert1() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        WebElement clickMe = driver.findElement(By.id("button1"));
        clickMe.click();
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "I am an alert box!";
        Assert.assertEquals(actualMessage, expectedMessage);
        Thread.sleep(3000);
        alert.accept();
    }

    @Test
    public void alert2() {
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        WebElement clickMe = driver.findElement(By.id("button4"));
        clickMe.click();
        Alert popUp = driver.switchTo().alert();
        String actualMessage = popUp.getText();
        String expectedMessage = "Press a button!";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessage, expectedMessage);
        popUp.dismiss();
        WebElement confirmMessage = driver.findElement(By.id("confirm-alert-text"));
        softAssert.assertTrue(confirmMessage.isDisplayed());
        softAssert.assertAll();
    }
@Test(dependsOnMethods = "alert2")
public void deneme(){
    System.out.println("bitti cok sukur");
}
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}