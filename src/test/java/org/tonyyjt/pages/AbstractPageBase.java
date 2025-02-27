package org.tonyyjt.pages;

import com.microsoft.playwright.Page;

abstract class AbstractPageBase {
    protected Page page;

    public AbstractPageBase(Page page) {
        this.page = page;
    }
}
