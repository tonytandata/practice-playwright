package org.tonyyjt.pages;

import org.tonyyjt.properties.Environment;
import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;
import org.tonyyjt.testscripts.TestBase;

public class HomePage extends AbstractPageBase {

    private final Locator signInButton;

    public HomePage() {
        super(TestBase.getPage());
        this.signInButton = page.locator("[data-test='nav-sign-in']");
    }

    @Step("Open the Candy mapper homepage")
    public HomePage navigate() {
        page.navigate(Environment.getProperties().url());
        return this;
    }

    @Step("Closes popup")
    public void closePopup() {
        page.locator("#popup-widget25042-close-icon").click();
    }

    @Step("Is Sign In button displayed")
    public boolean isSignInButtonDisplayed() {
        return signInButton.isDisabled();
    }

}
