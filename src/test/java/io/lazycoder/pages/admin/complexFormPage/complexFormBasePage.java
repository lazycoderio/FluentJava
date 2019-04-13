package io.lazycoder.pages.admin.complexFormPage;

import io.lazycoder.helpers.User;
import io.lazycoder.pages.admin.adminBase;

import java.util.Map;

public class complexFormBasePage extends adminBase {

    UserInfoSection userInfoSection = new UserInfoSection();
    SpouseInfoSection spouseInfoSection = new SpouseInfoSection();

    public complexFormBasePage fillRequiredFields(User self, User spouse){
        userInfoSection.fillFields(self);
        spouseInfoSection.fillFields(spouse);
        return this;
    }
}
