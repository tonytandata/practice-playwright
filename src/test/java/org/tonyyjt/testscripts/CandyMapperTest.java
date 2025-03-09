package org.tonyyjt.testscripts;

import org.testng.annotations.Test;
import org.tonyyjt.pages.HomePage;

@Test
public class CandyMapperTest extends TestBase{
    public void verifyContactUsSubmission() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.navigate();
        homePage.closePopup();

        homePage.fillContactFormLabel("First Name", "Tony");
        homePage.fillContactFormLabel("Last Name", "Tester");
        homePage.fillContactFormLabel("Email*", "tonytandata@gmail.com");
        homePage.fillContactFormLabel("By entering a Phone Number", "0451548884");
        homePage.fillContactFormMessage("Tonys test message to contact us form");
        homePage.clickSubmitContactForm();

        // TODO: Something flaky

        // TODO: Verify success
    }
}
