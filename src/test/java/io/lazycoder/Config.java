package io.lazycoder;

import java.io.*;
import java.util.Properties;

/**
 * Created by Andrew Krug on 1/16/2017.
 */
public class Config {
    Properties prop;


    /***
     * This method reads in the config.properties file. This is great for constants that are going to be used in every test environment.
     * @return properties
     */
    public Properties getPropertiesFromFile() {
        prop = new Properties();
        try {
            String propFileName = "config.properties";

            InputStream inputStream = getClass().
                    getClassLoader().
                    getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                try {
                    throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /***
     * This will write the config.properties and anything that gets passed in the suite XML files.
     */
    public void saveParamChanges() {
        try {
            File f = new File("target/allure-results/environment.properties");
            OutputStream out = new FileOutputStream( f );
            prop.store(out, "This is an optional header comment string");
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }
}