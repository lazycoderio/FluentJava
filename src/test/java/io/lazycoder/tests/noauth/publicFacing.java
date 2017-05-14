package io.lazycoder.tests.noauth;

import io.lazycoder.pages.noauth.homePage;
import io.lazycoder.tests.baseTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * Created by Andrew Krug on 1/16/2017.
 */
@Test
@Features("Public Facing Pages Load")
public class publicFacing extends baseTest {

    @Stories("Home Page Loads")
    public void homePageLoads(){
        homepage.navigateToThisPage().titleShouldBeExpected();
    }

    @Stories("About Page Loads")
    public void haboutPageLoads(){
        homePage page = new homePage();
        page.navigateToThisPage().titleShouldBeExpected();
    }
}