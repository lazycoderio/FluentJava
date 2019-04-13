package io.lazycoder.tests.admin;

import io.lazycoder.helpers.User;
import io.lazycoder.tests.baseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class settings extends baseTest {

    User user = new User(false);









    public void settingsLevelSwitching(){

        user.setNewPassword(RandomStringUtils.randomAlphabetic(7));
        homepage.loginAs(user)
                .switchToSettings()
                .switchToCallSettingsTab()
                .switchToVideoSettings()
                .changeSettings().switchToAudioSettings()
                .switchToCallSettingsTab()
                .switchToGeneralSettingsTab().switchToCallSettingsTab().switchToAudioSettings();

    }














    @Test
    public void TabsSwitching(){

        user.setNewPassword(RandomStringUtils.randomAlphabetic(7));
        homepage
                .loginAs(user)
                .switchToSettings();

    }









































    public void fillInfo(){
        User self = new User();
        User spouse = new User();
        homepage
                .loginAs(self)
                .completeUserProfile()
                .firstName(self.firstName)
                .lastName(self.lastName)
                .birthDate(self.birthdate)
                .next()
                .firstName(spouse.lastName)
                .lastName(spouse.lastName)
                .birthDate(spouse.birthdate)
                .next();

    }









    public void fillhealthcare(){
        User self = new User();
        User spouse = new User();
        homepage
                .loginAs(self)
                .switchToComplexForm()
                .fillRequiredFields(self, spouse);

    }

    public void fillhealthcare(){
        User self = new User();
        User spouse = new User();
        homepage
                .loginAs(self)
                .switchToComplexForm()
                .fillRequiredFields(self, spouse);

    }
}
