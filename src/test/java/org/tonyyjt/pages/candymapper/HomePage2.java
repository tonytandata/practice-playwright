package org.tonyyjt.pages.candymapper;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import org.tonyyjt.pages.AbstractPageBase;
import org.tonyyjt.properties.Environment;
import org.tonyyjt.testscripts.TestBase;

public class HomePage2 extends AbstractPageBase {

    private final static String CONTACT_FORM_MESSAGE_PLACEHOLDER = "Message";

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
        fillInToElement(page.getByPlaceholder(label), text);
    }

    public void fillContactFormMessage(String text) {
        fillInToElement(page.getByPlaceholder(CONTACT_FORM_MESSAGE_PLACEHOLDER), text);
    }

    public void clickSubmitContactForm() {
        clickOnElement(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")));
    }

    public void scrollIntoViewSubmitButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("submit")).scrollIntoViewIfNeeded();
    }
}
