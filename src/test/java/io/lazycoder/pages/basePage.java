package io.lazycoder.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.cropper.indent.IndentCropper;
import ru.yandex.qatools.ashot.util.ImageTool;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import static io.lazycoder.tests.baseTest.*;
import static ru.yandex.qatools.ashot.cropper.indent.IndentFilerFactory.blur;

/**
 * Created by Andrew Krug on 1/16/2017.
 */
public class basePage <P extends basePage<P>>{
    protected HashMap<String, Object> store;
    protected Properties _properties;
    protected WebDriver _driver;
    protected String _url;
    protected String title;

    /**
     * init base page
     * @param url the partial url to this page, if not matching current url then navigating to it
     * @param title the title of the page
     */
    public basePage(String url, String title){
        this._driver = getDriver();
        this._properties = getProperties();
        this.store = getStore();
        this._url = url;
        this.title = title;
        saveToReport("Current URL: " + _driver.getCurrentUrl());
        if(!_driver.getCurrentUrl().contains(url))
            navigateToThisPage();
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(_driver)), this);

    }

    /**
     * specific method that navigates to this page and leaves you in the same class for method chaining
     * @return the class that is called from
     */
    public P navigateToThisPage(){
        String u = _properties.getProperty("baseurl") + _url;
        saveToReport("Navigate Method call: " + u);
        navigate(u);
        return (P)this;
    }

    /**
     * Allure reporting step that does the navigation and screenshot directly into the test report
     * @param URL
     * @return
     */
    @Step("Navigate to {0}")
    private P navigate(String URL){
        _driver.navigate().to(URL);
        saveSceenShot();
        return (P)this;
    }

    /**
     * wrapper for getTitle
     * @return title
     */
    private String getTitle(){ return this._driver.getTitle(); }

    /**
     * Validates that the title contains the correct pattern for the title
     * @return the class that calls this method
     */
    @Step("Title should be correct")
    public P titleShouldBeExpected(){
        saveToReport("Asserting '" + getTitle() + "' is/contains '" + this.title + "'.");
        Assert.assertEquals(this.getTitle().contains(this.title), true);
        return (P)this;
    }
    /**
     * Takes a screenshot of the page.
     * @return the class that it is called from
     */
    @Step("Take Page Screenshot")
    public P saveSceenShot(){
        makeScreenshot();
        return (P)this;
    }
    /**
     * Method that actually takes a screenshot.
     * @return the screenshot as a Byte array
     */
    @Attachment("Page Screenshot")
    public byte[] makeScreenshot() {
        System.out.println("getting screenshot");
        return ((TakesScreenshot) _driver).getScreenshotAs(OutputType.BYTES);
    }
    /**
     * Takes a screenshot and gives it a scecific name in the report
     * @param name the title you want to give to the screenshot
     * @return the class that it is called from
     */
    @Step("Take {} Screenshot")
    public P saveSceenShot(String name){
        makeScreenshot(name);
        return (P)this;
    }
    /**
     * Actually takes the screenshot and attachs a specific name to it.
     * @param name
     * @return
     */
    @Attachment("{} Screenshot")
    public byte[] makeScreenshot(String name) {
        System.out.println("getting screenshot");
        return ((TakesScreenshot) _driver).getScreenshotAs(OutputType.BYTES);
    }
    /**
     * Saves the string to the test as a step so it is visible in the report
     * @param s
     */
    @Step("{0}")
    public P saveToReport(String s){
        System.out.println(s);
        return (P)this;
    }

    /**
     * wrapper for the click on element
     * @param element element to click
     * @return the class that this is called from
     */
    @Step("Click on {0}")
    public P clickOn(WebElement element){
        saveCroppedBlurredSS(element);
        element.click();
        return (P)this;
    }

    /**
     * wrapper for explicit wait and click on element
     * @param element element to click
     * @param timeout timeout in seconds to find the element
     * @return the class that this is called from
     */
    @Step("Click on {0}")
    public P clickOn(WebElement element, int timeout){
        new WebDriverWait(_driver, 5).until(ExpectedConditions.elementToBeClickable(element));
        saveCroppedBlurredSS(element);
        element.click();
        return (P)this;
    }

    /**
     * wrapper for click using the locator instead
     * @param locator locator to use
     * @return the class that this is called from
     */
    @Step("Click on {0}")
    public P clickOn(By locator){
        WebElement element = _driver.findElement(locator);
        saveCroppedBlurredSS(element);
        element.click();
        return (P)this;
    }

    /**
     * wrapper for explicit wait and click using the locator instead
     * @param locator locator to use
     * @param timeout timeout in seconds to find the element
     * @return the class that this is called from
     */
    @Step("Click on {0}")
    public P clickOn(By locator, int timeout){
        new WebDriverWait(_driver, 5).until(ExpectedConditions.elementToBeClickable(_driver.findElement(locator)));
        WebElement element = _driver.findElement(locator);
        saveCroppedBlurredSS(element);
        element.click();
        return (P)this;
    }

    /**
     * Saves the value to the key in the store, used to quickly retrieve the value for later assertions
     * @param key
     * @param value
     * @return
     */
    @Step("Save {1} as {0}")
    public P saveValues(String key, Object value){
        store.put(key, value);
        return (P)this;
    }

    /**
     * Saves a cropped and blurred screenshot of the element that is passed in
     * @param element what element you want a screenshot of
     * @return
     */
    //    @Attachment(value = "element clicked on", type = "image/png")
    public byte[] saveCroppedBlurredSS(WebElement element) {

        return saveCroppedBlurredSS(element, "element clicked on");
    }

    /**
     * Saves a cropped and blurred screenshot of the element that is passed in
     * @param element element you want a screenshot of
     * @param title title associated with the screenshot
     * @return byte[] of image, allure will automatically attach it to the image
     */
    @Attachment(value = "{1}", type = "image/png")
    public byte[] saveCroppedBlurredSS(WebElement element, String title) {

        Screenshot ss = new AShot().imageCropper(new IndentCropper().addIndentFilter(blur())).takeScreenshot(_driver, element);
        byte[] img = new byte[0];
        try {
            img = ImageTool.toByteArray(ss);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    /**
     * wrapper for refreshing the page
     * @return the class that calls this method
     */
    @Step("Refreshing the page")
    public P refreshPage(){
        _driver.navigate().refresh();
        saveSceenShot();
        return (P)this;
    }
}