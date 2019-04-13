package io.lazycoder.pages.admin.complexFormPage;

import io.lazycoder.helpers.User;
import io.lazycoder.pages.basePage;
import io.lazycoder.pages.noauth.homePage;
import org.openqa.selenium.By;

import java.util.Date;


public class SpouseInfoSection extends basePage {

    By field1 = By.className("");
    By continueButton = By.cssSelector("");


    public homePage fillFields(User user){
        return this.firstName(user.firstName).lastName(user.lastName).birthDate(user.birthdate).next();
    }

    public SpouseInfoSection fillField1(String value){
        type(value, field1);
        return this;
    }

    public SpouseInfoSection firstName(String value){
        type(value, field1);
        return this;
    }
    public SpouseInfoSection lastName(String value){
        type(value, field1);
        return this;
    }
    public SpouseInfoSection birthDate(Date value){
        type(value.toString(), field1);
        return this;
    }

    public homePage next(){
        clickOn(continueButton);
        return new homePage();
    }



}
