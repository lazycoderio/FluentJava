package io.lazycoder.pages.noauth;

import io.lazycoder.pages.basePage;

public class logOutPage extends basePage {
    /**
     * init base page
     *
     * @param url   the partial url to this page, if not matching current url then navigating to it
     * @param title the title of the page
     */
    public logOutPage() {
        super("/logged out", "Logged Out");
    }
}
