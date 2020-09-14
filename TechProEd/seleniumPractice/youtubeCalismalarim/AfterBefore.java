package com.TechProEd.seleniumPractice.youtubeCalismalarim;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AfterBefore {

        @BeforeMethod
        public void beforeMethod() {
            System.out.println("beforeMethod");
        }
        @Test(priority = 3)
        public void testCase05(){
            System.out.println("test01");
        }
        @Test
        public void testCase02(){
            System.out.println("test02");
        }
        @Test
        public void testCase03(){
            System.out.println("test03");
        }


    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }
}


