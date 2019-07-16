package com.telRan.qa20.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Board board;
    SessionHelper session;
    WebDriver driver;

    public void init() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://trello.com");
        session = new SessionHelper(driver);
        session.login("narishka@walla.com", "202010Zxc");

        board = new Board(driver);
    }

    public void stop() {
        driver.quit();
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[name=add]"));
    }

    public void returnToHomePage() {
        click(By.cssSelector("[href='/']"));
    }

    public Board getBoard() {
        return board;
    }

    public SessionHelper getSession() {
        return session;
    }
}


