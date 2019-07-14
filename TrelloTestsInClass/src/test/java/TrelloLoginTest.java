import org.testng.annotations.Test;

public class TrelloLoginTest  extends  TestBase{

    @Test
    public void loginTest() throws InterruptedException {
        app.getSession().clickLoginButton();
        app.getSession().fillLoginForm("narishka@walla.com", "202010Zxc");
        app.getSession().pause(3000);
        app.getSession().confirmLogin();
        app.getSession().pause(10000);


    }

}
