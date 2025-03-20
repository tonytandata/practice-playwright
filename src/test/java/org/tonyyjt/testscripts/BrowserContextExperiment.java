package org.tonyyjt.testscripts;

import com.microsoft.playwright.*;

public class BrowserContextExperiment {
    public static void main(String[] args){
        Playwright playwright = Playwright.create(); // returns playwright instance

        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context1 = browser.newContext(); // instead of new page from browser, we do new context
        Page page1 = context1.newPage(); // then we do the same to get new Page, except from the context
        page1.navigate("https://candymapper.com/");

        String title = page1.title();
        System.out.println("title: " + title);
        String url = page1.url();
        System.out.println("url: " + url);

        BrowserContext context2 = browser.newContext(); // another context
        Page page2 = context2.newPage();
        page2.navigate("https://www.google.com/travel/flights");
        String title2 = page2.title();
        System.out.println("title2: " + title2);
        String url2 = page2.url();
        System.out.println("url2: " + url2);

        browser.close();
        playwright.close(); //close the Playwright instance, and clean up resources associated with this playwright session
    }
}
