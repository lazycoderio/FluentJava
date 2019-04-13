package io.lazycoder.tests.noauth;

import io.lazycoder.pages.noauth.homePage;
import io.lazycoder.tests.baseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;


/**
 * Created by Andrew Krug on 1/16/2017.
 */
@Test
@Feature("Public Facing Pages Load")
public class publicFacing extends baseTest {

    @Story("Home Page Loads")
    public void homePageLoads(){
        homepage.navigateToThisPage().titleShouldBeExpected();
    }

    @Story("Blog Page Loads")
    public void BlogPageLoads(){

        homepage.GoToBlog().titleShouldBeExpected();
    }

    @Story("Mobile Blog Page Loads")
    public void MobileBlogPageLoads(){
        _driver.manage().window().setSize(new Dimension(800, 600));
        homepage.GoToBlog().titleShouldBeExpected();
    }


    @Story("Chat Loads")
    public void ChatLoads(){
        homePage page = new homePage();
        page.openChat();
    }


}