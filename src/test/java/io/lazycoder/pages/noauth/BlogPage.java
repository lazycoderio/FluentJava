package io.lazycoder.pages.noauth;

import io.lazycoder.pages.basePage;

public class BlogPage extends basePage<BlogPage> {
    static String title = "Blog";
    static String url = "";

    public BlogPage() {
        super(url,title);
        if(!_driver.getCurrentUrl().contains("lazycoder.io")){
            _driver.get(_properties.getProperty("baseurl"));
        }
    }
}
