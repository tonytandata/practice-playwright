package org.tonyyjt.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.tonyyjt.properties.Environment;
import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;
import org.tonyyjt.testscripts.TestBase;

public class HomePage extends AbstractPageBase {

    private final Locator signInButton;
    private final static String CONTACT_FORM_MESSAGE_PLACEHOLDER = "Message";
    private final static String SUCCESS_TEXT = "Thank you for your inquiry!";

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

    public void fillContactFormLabel(String label, String text) {
        page.getByLabel(label).fill(text);
    }

    public void fillContactFormMessage(String text) {
        page.getByPlaceholder(CONTACT_FORM_MESSAGE_PLACEHOLDER).fill(text);
    }

    public void clickSubmitContactForm() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("submit")).click();
    }

    public String getSuccessMessage() {
        return page.getByText(SUCCESS_TEXT).textContent();
    }

    public void waitForCandyImage() {
//        String classes = page.locator("//img[contains(@src, 'Candy')]/parent::picture").getAttribute("class");
//        System.out.println("classes: " + classes);
        page.locator("//img[contains(@src, 'Candy')]/parent::picture").isVisible();
    }
}
