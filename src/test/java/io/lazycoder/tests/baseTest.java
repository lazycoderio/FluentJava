package io.lazycoder.tests;

import io.lazycoder.Config;
import io.lazycoder.pages.noauth.homePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

/**
 * Created by Andrew Krug on 1/13/2017.
 */
public class baseTest <Test extends baseTest<Test>> {

    protected static WebDriver _driver;
    protected static Properties _properties;
    protected static HashMap<String, Object> store;
    private Config config;
    public homePage homepage;

    public baseTest(){
        this.store = new HashMap<String, Object>() ;
        config = new Config();
        this._properties = config.getPropertiesFromFile();
    }

    /***
     * This is the test setup that read-ins the properties that are in the suite XML files and attaches them to the properties.
     * The @Parameters is from TestNG and it pulls in the parameters that are defined in the suite XML files.
     * @param base The
     * @param pass
     */
    @Parameters({"baseurl", "admin_password"})
    @BeforeMethod
    public void setup(@Parameter String base, @Parameter String pass)
    {
        _properties.put("baseurl", base);
        _properties.put("admin_password", pass);
        saveToReport(_properties.toString());
        saveToReport("new driver");
        _driver = new ChromeDriver();
        _driver.manage().window().maximize();
        this.homepage = new homePage();
    }


    /**
     * Closing the test and taking the final screenshot
     */
    @AfterMethod
    public void teardown()
    {
        saveSceenShot("Test Complete");
        saveToReport("closing driver");
        _driver.quit();
    }

    public static WebDriver getDriver(){ return _driver;}

    public static Properties getProperties(){ return _properties; }

    public static HashMap<String, Object> getStore(){ return store;}

    /**
     * Saves the string to the test as a step so it is visible in the report
     * @param s
     */
    @Step("{0}")
    public void saveToReport(String s){
        System.out.println(s);
    }

    /**
     * Takes a screenshot of the page.
     * @return the class that it is called from
     */
    @Step("Take Screenshot")
    public Test saveSceenShot(){
        makeScreenshot();
        return (Test) this;
    }

    /**
     * Method that actually takes a screenshot.
     * @return the screenshot as a Byte array
     */
    @Attachment("Screenshot")
    public byte[] makeScreenshot() {
        System.out.println("getting screenshot");
        return ((TakesScreenshot) _driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Takes a screenshot and gives it a scecific name in the report
     * @param name the title you want to give to the screenshot
     * @return the class that it is called from
     */
    @Step("Take Screenshot {}")
    public Test saveSceenShot(String name){
        makeScreenshot(name);
        return (Test) this;
    }

    /**
     * Actually takes the screenshot and attachs a specific name to it.
     * @param name
     * @return
     */
    @Attachment("{} Screenshot")
    public byte[] makeScreenshot(String name) {
        System.out.println("getting screenshot " + name);
        return ((TakesScreenshot) _driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * After the suite the properties needs to be written to a properties file.
     * Any properties that have the name 'test' in them will be removed since those are for specific files.
     */
    @AfterSuite
    public void afterSuite(){
        List<String> ar = new ArrayList<String>();
        for( Object key :_properties.keySet()){
            if(key.toString().toLowerCase().contains("test"))
                ar.add(key.toString());
        }
        for (String remove : ar) {
            _properties.remove(remove);
        }
        config.saveParamChanges();
    }

    /**
     * A generic assertion comparing two objects are equal
     * @param expected The expected object
     * @param actual The actual object
     * @return this class so method chaining can occur
     */
    @Step("{} {}")
    public Test assertThatTheseAreEqual(Object expected, Object actual)
    {
        assertTrue("these are not equal", expected == actual);
        return (Test) this;
    }

}