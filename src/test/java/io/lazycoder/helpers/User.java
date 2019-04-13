package io.lazycoder.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {

    private static final String FIRSTNAME_PROPERTY = "firstname";
    private static final String LASTNAME_PROPERTY = "lastname";
    private static final String USERNAME_PROPERTY = "username";
    private static final String PASSWORD_PROPERTY = "password";
    private static final String BIRTHDATE_PROPERTY = "birthdate";


    public String lastName;
    public String firstName;
    public String userName;
    public String password;
    public Date birthdate;

    public HashMap<String, Object> changedValues;

    public User(){
        this.firstName = RandomStringUtils.randomAlphabetic(7);
        this.lastName = RandomStringUtils.randomAlphabetic(7);
        this.userName = RandomStringUtils.randomAlphabetic(7);
        this.password = RandomStringUtils.randomAlphabetic(7);
        this.birthdate = new Random().Date();
        this.changedValues = new HashMap<String, Object>();
    }

    public User(Boolean reuse){
        if(reuse){
            new DB().GetUser();
        }
        else {
            new User();
        }
    }

    public User(String id){

    }


    public User(Map<String, Object> map){
        firstName = (String)map.get(FIRSTNAME_PROPERTY);
        lastName = (String)map.get(LASTNAME_PROPERTY);
        userName = (String)map.get(USERNAME_PROPERTY);
        password = (String)map.get(PASSWORD_PROPERTY);
        birthdate = (Date)map.get(BIRTHDATE_PROPERTY);

    }

    public String getFirstName(){
        return firstName;
    }

    public User setFirstName(String name){
        changedValues.put(FIRSTNAME_PROPERTY, firstName);
        firstName = name;
        return this;
    }

    public User setNewPassword(String newPassword){
        changedValues.put(PASSWORD_PROPERTY, password);
        password = newPassword;
        return this;
    }

    public String getOldPassword(){
        return changedValues.get(PASSWORD_PROPERTY).toString();
    }

    public String getBirthdate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(birthdate);
    }

    public User setBirthDate(Date date){
        if(doesFieldExist("birthdate")){
            changedValues.put(BIRTHDATE_PROPERTY, birthdate);
        }
        birthdate = date;
        return this;
    }

    public User setBirthDate(){
        return setBirthDate(new Random().Date());
    }

    public Map<String, Object> exportUser(){
        return new ObjectMapper().convertValue(this, Map.class);
    }

    public boolean doesFieldExist(String field){
        return new General().doesObjectContainField(this, field);
    }
}
