package org.tonyyjt.testscripts;

import com.microsoft.playwright.*;
import org.tonyyjt.utils.BrowserUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

public abstract class TestBase {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;

    private static final ThreadLocal<Page> page = new ThreadLocal<>();

    public static Page getPage() {
        return page.get();
    }

    @BeforeClass
    void launchBrowser() {
        final String browserName = System.getProperty("browser", "chromium_headed");
        playwright = Playwright.create();
        browser = BrowserUtil.createBrowser(browserName, playwright);
    }

    @AfterClass
    void closeBrowser() {
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();


        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        page.set(context.newPage());
    }

    @AfterMethod
    void closeContext() {
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
        context.close();
    }

}