package io.lazycoder.pages.admin;

import io.lazycoder.pages.admin.complexFormPage.UserInfoSection;
import io.lazycoder.pages.admin.complexFormPage.complexFormBasePage;
import io.lazycoder.pages.admin.settings.callSettings.callSettingsBasePage;
import io.lazycoder.pages.admin.settings.generalSettingsPage;
import io.lazycoder.pages.admin.settings.settingsBase;
import io.lazycoder.pages.basePage;
import io.lazycoder.pages.noauth.logOutPage;
import org.openqa.selenium.By;

public class adminBase  extends basePage {

    By settingsButton = By.id("settings");

    By personalSettings = By.cssSelector("");

    public adminBase() {
        super("/admin", "");
    }

    public complexFormBasePage switchToComplexForm(){
        clickOn(personalSettings);
        return new complexFormBasePage();
    }

    public settingsBase switchToSettings() {
        clickOn(settingsButton);
        return new settingsBase();
    }
    public UserInfoSection completeUserProfile(){
        clickOn(personalSettings);
        return new UserInfoSection();
    }
}
