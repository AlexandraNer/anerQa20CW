package com.telRan.qa20.test;

import com.telRan.qa20.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    @BeforeClass
    public void logoutFromAcc() throws InterruptedException {
        if(app.getSession().isUserLoggedIn()){
            app.getSession().logOut();
        }
    }
    @AfterMethod
    public void returnBack(){
       app.getSession().returnBack();
    }
    @Test
    public void negativeTestWithoutPassword() throws InterruptedException {
        app.getSession().initLogin();
        app.getSession().fillLoginForm(new User().withEmail("cgjjj@bjn.com"));
        app.getHedBut().pause(3000);
        app.getSession().confirmLogin();
        app.getSession().pause(10000);

        app.getSession().getElementColor();
        Assert.assertTrue(app.getSession().isElementPresent1(By.xpath("//p[@class='error-message']")));
        Assert.assertTrue(app.getSession().isElementPresent1(By.cssSelector("#user.error")));
        //Assert.assertTrue(app.getSession().isUserLoggedIn());

    }
    @Test
    public void negativeTestWithoutEmail() throws InterruptedException {
        app.getSession().initLogin();
        app.getSession().fillLoginForm(new User().withPassword(" 12555A"));
        app.getHedBut().pause(3000);
        app.getSession().confirmLogin();
        app.getSession().pause(10000);
        //Assert.assertTrue(app.getSession().isElementPresent1(By.xpath("//p[@class='error-message']")));
        //Assert.assertTrue(app.getSession().isUserLoggedIn());

    }
}
