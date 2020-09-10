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

public class TestCaseDay01 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void FirstTestCase() {
//        Faker faker = new Faker();
//        faker.name().fullName()
        driver.navigate().to ("http://zero.webappsecurity.com/index.html");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"signin_button\"]"));
        signIn.click();
        WebElement userNameText = driver.findElement(By.id("user_login"));
        userNameText.sendKeys("username");
        WebElement passwordText = driver.findElement(By.id("user_password"));
        passwordText.sendKeys("password");
        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();

        WebElement payBills = driver.findElement(By.linkText("Pay Bills"));
        payBills.click();

        WebElement amount = driver.findElement(By.id("sp_amount"));
        amount.sendKeys("1000");

        WebElement date = driver.findElement(By.id("sp_date"));
        date.sendKeys("2020-08-23");

        WebElement payment = driver.findElement(By.xpath("//input[@value]"));
        payment.click();
        String expectedMessage = "The payment was successfully submitted.";
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"alert_content\"]/span")).getText();
        WebElement actMessage = driver.findElement(By.xpath("//*[@id=\"alert_content\"]/span"));

        //Assert.assertEquals(expectedMessage,actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
        Assert.assertTrue(actMessage.isDisplayed());

    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
