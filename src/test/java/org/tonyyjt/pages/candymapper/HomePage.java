package org.tonyyjt.pages.candymapper;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.tonyyjt.pages.AbstractPageBase;
import org.tonyyjt.properties.Environment;
import io.qameta.allure.Step;
import org.tonyyjt.testscripts.TestBase;

public class HomePage extends AbstractPageBase {

    private final static String CONTACT_FORM_MESSAGE_PLACEHOLDER = "Message";
    private final static String SUCCESS_TEXT = "Thank you for your inquiry!";

    public HomePage() {
        super(TestBase.getPage());
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

    public void fillContactFormLabel(String label, String text) {
        page.getByLabel(label).hover();
//        page.getByLabel(label).scrollIntoViewIfNeeded();
        page.getByLabel(label).fill(text);
    }

    public void fillContactFormMessage(String text) {
//        page.getByPlaceholder(CONTACT_FORM_MESSAGE_PLACEHOLDER).scrollIntoViewIfNeeded();
        page.getByPlaceholder(CONTACT_FORM_MESSAGE_PLACEHOLDER).hover();
        page.getByPlaceholder(CONTACT_FORM_MESSAGE_PLACEHOLDER).fill(text);
    }

    public void clickSubmitContactForm() {
//        scrollIntoViewSubmitButton();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("submit")).hover();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("submit")).click();
    }

    public String getSuccessMessage() {
        return page.getByText(SUCCESS_TEXT).textContent();
    }

    public void scrollIntoViewSubmitButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("submit")).scrollIntoViewIfNeeded();
    }
}
