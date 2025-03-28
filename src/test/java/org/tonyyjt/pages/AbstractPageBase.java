package org.tonyyjt.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public abstract class AbstractPageBase {
    public Page page;

    public AbstractPageBase(Page page) {
        this.page = page;
    }

    public void clickOnElement(Locator locator){
        locator.hover();
        locator.click();
    }

    public void fillInToElement(Locator locator, String value){
        locator.hover();
        locator.fill(value);
    }
}
