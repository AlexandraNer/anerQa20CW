package com.telRan.qa20.test;

import com.telRan.qa20.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(app.getSession().isUserLoggedIn()){
            app.getSession().logOut();

        }
    }
    @Test
    public void positiveLoginTest() throws InterruptedException {
        app.getSession().initLogin();
        app.getSession().fillLoginForm(new User()
                .withEmail("narishka@walla.com ")
                .withPassword("202010Zxc "));
        app.getHedBut().pause(3000);
        app.getSession().confirmLogin();
        app.getSession().pause(10000);
        Assert.assertTrue(app.getSession().isUserLoggedIn());

    }

}
