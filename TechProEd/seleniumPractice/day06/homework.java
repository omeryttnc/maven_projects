package com.TechProEd.seleniumPractice.day06;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
1. Create a class SignInHomework
2. Go to http://automationpractice.com/index.php
3. Click on sign in button
4.Send your email and click on create an account button
5.Verify the Text : CREATE AN ACCOUNT
6. Verify the Text : YOUR PERSONAL INFORMATION
7. Verify the Text : Title
8. Select your title
9. Enter your first name
10. Enter your last name
11. Enter your email
12. Enter your password
13. DO NOT ENTER DATE OF BIRTH-YOU DIDNT LEARN DROPDOWN YET
14. Click on Sign up for our newsletter!
15. Enter your first name
16. Enter your last lane
17. Enter your company
18. Enter your Address
19. Enter your City
20. DO NOT SELECT STATE-YOU DIDNT LEARN DROPDOWN YET
21. Enter Postal Code
22.DO NOT SELECT COUNTRY-
23. Enter additional information
24. Enter home phone
25. Enter mobile phone
26. Enter reference name
27. Click Register
THEN YOU SHOULD SEE SOME ERROR MESSAGE. TAKE A SCREENSHOT AND SHARE WITH ME
====
Be careful about putting some wait.
 */
public class homework {
    WebDriver driver;

    @Before
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCase() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.className("login")).click();
        Thread.sleep(5000);
        WebElement signIn = driver.findElement(By.name("email_create"));
        signIn.sendKeys("omeryttnc@gmail.com");
        WebElement submitEmail = driver.findElement(By.id("SubmitCreate"));
        submitEmail.click();
        Thread.sleep(5000);
        String actualPageTitle = driver.findElement(By.className("page-heading")).getText();
        String expectedPageTitle = "CREATE AN ACCOUNT";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        String actualsubPageTitle = driver.findElement(By.className("page-subheading")).getText();
        String expectedsubPageTitle = "YOUR PERSONAL INFORMATION";
        Assert.assertEquals(actualsubPageTitle, expectedsubPageTitle);

        driver.findElement(By.xpath("(//input[@name ='id_gender'])[1]")).click();

        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        WebElement lastname = driver.findElement(By.id("customer_lastname"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement emailAddress = driver.findElement(By.xpath("//input[@id='email']"));
        firstName.sendKeys(faker.name().firstName());
        lastname.sendKeys(faker.name().lastName());
        //emailAddress.sendKeys("omeryttnc@gmail.com");
        password.sendKeys(faker.name().nameWithMiddle());

        Select selectDays = new Select(driver.findElement(By.id("days")));
        selectDays.selectByValue("22");

        Select selectMonths = new Select(driver.findElement(By.id("months")));
        selectMonths.selectByVisibleText("December ");

        Select selectYears = new Select(driver.findElement(By.id("years")));
        selectYears.selectByValue("1987");

        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
        address.sendKeys("00000");

        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys(faker.address().city());

        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByValue("5");

        Select country = new Select(driver.findElement(By.id("id_country")));
       // country.selectByValue("5");

        WebElement phoneMobile = driver.findElement(By.id("phone_mobile"));
        phoneMobile.sendKeys(faker.phoneNumber().cellPhone());

        driver.findElement(By.xpath("//span[text()='Register']")).click();



    }


}



