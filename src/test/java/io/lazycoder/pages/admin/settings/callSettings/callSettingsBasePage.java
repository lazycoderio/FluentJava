package io.lazycoder.pages.admin.settings.callSettings;

import io.lazycoder.pages.admin.settings.settingsBase;
import org.openqa.selenium.By;

public class  callSettingsBasePage extends settingsBase {

    By audioSettingsLink = By.cssSelector("");
    By videoSettingsLink = By.cssSelector("");


    public audioCallPage switchToAudioSettings(){
        clickOn(audioSettingsLink);
        return new audioCallPage();
    }

    public videoCallPage switchToVideoSettings(){
        clickOn(videoSettingsLink);
        return new videoCallPage();
    }
}
