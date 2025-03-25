package org.tonyyjt.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import org.tonyyjt.properties.Environment;
import org.tonyyjt.testscripts.TestBase;

public class HomePage2 extends AbstractPageBase {

    private final static String CONTACT_FORM_MESSAGE_PLACEHOLDER = "Message";
    private final static String SUCCESS_TEXT = "Thank you for your inquiry!";

    public HomePage2() {
        super(TestBase.getPage());
    }

    @Step("Open the Candy mapper homepage")
    public HomePage2 navigate() {
        page.navigate(Environment.getProperties().url2());
        return this;
    }

    @Step("Closes popup")
    public void closePopup() {
        page.getByLabel("Back to site").click();
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
