package com.TechProEd.seleniumPractice.homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookAccount {

    WebDriver driver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.facebook.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testCase4() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='u_0_2']")).click();

       Thread.sleep(2000);
      //  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.name("firstname")).
                sendKeys("Alex", Keys.TAB, "de Souza",
                        Keys.TAB, "alexdesouza@gmail.com",
                        Keys.TAB, "alexdesouza@gmail.com",
                        Keys.TAB, "alexdesouza",
                        Keys.TAB, "J",
                        Keys.TAB, "11",
                        Keys.TAB, "1990");
        WebElement genderMale = driver.findElement(By.xpath("//input[@value='2']"));
        genderMale.click();
        Assert.assertTrue(genderMale.isSelected());
        WebElement genderFemale = driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertFalse(genderFemale.isSelected());
    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}