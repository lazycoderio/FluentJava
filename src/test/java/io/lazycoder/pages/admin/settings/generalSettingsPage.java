package io.lazycoder.pages.admin.settings;

import org.openqa.selenium.By;

public class generalSettingsPage extends settingsBase {

    private By changePasswordButton;
    private By oldPasswordField;
    private By newPasswordField;
    private By secondaryPasswordField;
    private By saveButton;

    public generalSettingsPage changePassword(String oldPassword, String newPassword, String secondaryPassword){
        clickOn(changePasswordButton);
        type(oldPassword, oldPasswordField);
        type(newPassword, newPasswordField);
        type(secondaryPassword, secondaryPasswordField);
        clickOn(saveButton);
        return this;
    }

    public generalSettingsPage changePassword(String oldPassword, String newPassword){
        return changePassword(oldPassword, newPassword, newPassword);
    }

}
