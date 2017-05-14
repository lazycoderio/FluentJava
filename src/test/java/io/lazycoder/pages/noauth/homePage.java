package io.lazycoder.pages.noauth;

import io.lazycoder.pages.basePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by andrew on 3/31/17.
 */
public class homePage extends basePage<homePage> {

    static String url = "";
    static String title = "Lazy Coder";


    @FindBy(how = How.ID, using = "nav-login")
    WebElement loginButton;

    public homePage() {
        super(url,title);
    }


}
