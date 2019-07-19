package com.telRan.qa20.manager;

import com.telRan.qa20.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SessionHelper  extends HelperBase{

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void confirmLogin() {
        click(By.id("login"));
    }

    public void fillLoginForm(User user) {
        type(By.id("user"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void login(String email, String pwd) throws InterruptedException {
        initLogin();
        fillLoginForm(new User().withEmail(email).withPassword(pwd)); //"elena.telran@yahoo.com", "12345.com"
        pause(3000);
        confirmLogin();
        pause(10000);
    }

    public void initLogin() {
            click(By.xpath("//*[@href='/login']"));
        }


    public boolean isUserLoggedIn() {
        return isElementPresent2(By.cssSelector("[href='/']"));
    }

    public void clickLoginButton() {
        click(By.cssSelector("[href='/login']"));
    }

    public void logOut() throws InterruptedException {
       click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
       click((By.xpath("//button[@data-test-id='header-member-menu-logout']")));
       pause(3000);
    }
    public void getElementColor(){
        String color = driver.findElement(By.xpath("//p[@class='error-message']")).getCssValue("color");
        System.out.println(color);
    }
}
