package io.lazycoder.pages.noauth;

import io.lazycoder.helpers.User;
import io.lazycoder.pages.admin.ChatBox;
import io.lazycoder.pages.admin.adminBase;
import io.lazycoder.pages.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by andrew on 3/31/17.
 */
public class homePage extends basePage<homePage> {

    static String url = "";
    static String title = "Lazy Coder";

    By usernameField = By.cssSelector("");
    By passwordField = By.cssSelector("");

    By submitButton = By.cssSelector("");

    By chatButton = By.className("convertfox-chat");

    By BlogPageNavigation = By.cssSelector("a[href*='/blog']");
    By menuButton = By.cssSelector("#menu-toggle");
    @FindBy(how = How.ID, using = "nav-login")
    WebElement loginButton;

    public homePage() {
        super(url,title);
        if(!_driver.getCurrentUrl().contains("lazycoder.io")){
            _driver.get(_properties.getProperty("baseurl"));
        }
    }


    public adminBase loginAs(User user){
        type(user.userName, usernameField);
        type(user.password, passwordField);
        clickOn(submitButton);
        return new adminBase();
    }

    public ChatBox openChat(){
       isElementVisibleNow(chatButton, 10);
       clickOn(chatButton);
       return new ChatBox();
    }
    public BlogPage GoToBlog(){
        if(isMobile()){
            clickOn(menuButton);
        }
        clickOn(BlogPageNavigation, 1);
        return new BlogPage();
    }

}
