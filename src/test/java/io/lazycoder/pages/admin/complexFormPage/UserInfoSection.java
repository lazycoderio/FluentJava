package io.lazycoder.pages.admin.complexFormPage;

import io.lazycoder.helpers.User;
import io.lazycoder.pages.basePage;
import org.openqa.selenium.By;

import java.util.Date;

public class UserInfoSection extends basePage {

    By field1 = By.className("");
    By continueButton = By.cssSelector("");

    public UserInfoSection fillField1(String value){
        type(value, field1);
        return this;
    }
    public SpouseInfoSection fillFields(User user){
        return this.firstName(user.firstName)
                .lastName(user.lastName)
                .birthDate(user.birthdate)
                .next();
    }

    public UserInfoSection firstName(String value){
        type(value, field1);
        return this;
    }
    public UserInfoSection lastName(String value){
        type(value, field1);
        return this;
    }
    public UserInfoSection birthDate(Date value){
        type(value.toString(), field1);
        return this;
    }

    public SpouseInfoSection next(){
        clickOn(continueButton);
        return new SpouseInfoSection();
    }
}
