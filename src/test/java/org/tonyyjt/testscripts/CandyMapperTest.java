package org.tonyyjt.testscripts;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import org.tonyyjt.pages.HomePage;

@Test
public class CandyMapperTest extends TestBase{
    public void verifyContactUsSubmission() {
        HomePage homePage = new HomePage();
        homePage.navigate();
        homePage.closePopup();

        homePage.scrollIntoViewSubmitButton();
        homePage.fillContactFormLabel("First Name", "Tony");
        homePage.fillContactFormLabel("Last Name", "Tester");
        homePage.fillContactFormLabel("Email*", "tonytandata@gmail.com");
        homePage.fillContactFormLabel("By entering a Phone Number", "0451548884");
        homePage.fillContactFormMessage("Tonys test message to contact us form");
        homePage.clickSubmitContactForm();

        String expectedSuccessMessage = "Thank you for your inquiry! We will get back to you within 48 Years.";
        String actualSuccessMessage = homePage.getSuccessMessage();
        Assertions.assertThat(actualSuccessMessage).isEqualTo(expectedSuccessMessage);
    }
}
