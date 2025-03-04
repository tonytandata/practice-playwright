package org.tonyyjt.testscripts;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ExperimentMain {
    public static void main(String[] args){
        System.out.println("Hello world!");
        Playwright playwright = Playwright.create(); // returns playwright instance

//        Browser browser = playwright.chromium().launch(); // returns a browser, by default is headless. Also downloads browser binaries if first time.
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // head mode

        Page page = browser.newPage(); // in this browser start a page, this returns a page
        page.navigate("https://candymapper.com/"); // in this page, load url

        String title = page.title(); //get the title of current page
        System.out.println("title: " + title);
        String url = page.url(); //get the url of current page
        System.out.println("url: " + url);

        browser.close(); //close the browser
        playwright.close(); //close the Playwright instance, and clean up resources associated with this playwright session
    }
}
