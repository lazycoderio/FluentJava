package io.lazycoder.pages.admin.settings;

import io.lazycoder.pages.admin.adminBase;
import io.lazycoder.pages.admin.settings.callSettings.callSettingsBasePage;
import org.openqa.selenium.By;

public class settingsBase extends adminBase {
    /**
     * init base page
     *
     * @param url   the partial url to this page, if not matching current url then navigating to it
     * @param title the title of the page
     */

    By callSettingsTab = By.cssSelector("");
    By generalSettingsTab = By.cssSelector("");

    By tab1 = By.cssSelector("");
    By tab2 = By.cssSelector("");
    By tab3 = By.cssSelector("");
    By tab4 = By.cssSelector("");

    public settingsBase() {
        super();
    }

    public callSettingsBasePage switchToCallSettingsTab(){
        clickOn(callSettingsTab);
        return new callSettingsBasePage();
    }

    public generalSettingsPage switchToGeneralSettingsTab(){
        clickOn(generalSettingsTab);
        return new generalSettingsPage();
    }
}
