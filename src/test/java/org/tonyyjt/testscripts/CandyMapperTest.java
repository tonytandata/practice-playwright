package org.tonyyjt.testscripts;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import org.tonyyjt.pages.candymapper.HomePage;
import org.tonyyjt.pages.candymapper.HomePage2;

@Test
public class CandyMapperTest extends TestBase{
    public void verifyContactUsSubmission() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.navigate();
        homePage.closePopup();

        homePage.scrollIntoViewSubmitButton();
        homePage.fillContactFormLabel("First Name", "Tony");
        homePage.fillContactFormLabel("Last Name", "Tester");
        homePage.fillContactFormLabel("Email*", "tonytantech@gmail.com");
        homePage.fillContactFormLabel("By entering a Phone Number", "0451548884");
        homePage.fillContactFormMessage("Tonys test message to contact us form");
        Thread.sleep(3000); //guessing it needs some time to disable validation
        homePage.clickSubmitContactForm();

        String expectedSuccessMessage = "Thank you for your inquiry! We will get back to you within 48 Years.";
        String actualSuccessMessage = homePage.getSuccessMessage();
        Assertions.assertThat(actualSuccessMessage).isEqualTo(expectedSuccessMessage);
    }

    public void verifyContactUsSubmission2() throws InterruptedException {
        HomePage2 homePage2 = new HomePage2();
        homePage2.navigate();
        homePage2.closePopup();

        homePage2.scrollIntoViewSubmitButton();
        homePage2.fillContactFormLabel("First Name", "Tony");
        homePage2.fillContactFormLabel("Last Name", "Tester");
        homePage2.fillContactFormLabel("Email *", "tonytantech@gmail.com");
        homePage2.fillContactFormLabel("By entering a Phone Number", "0451548884");
        homePage2.fillContactFormMessage("Tonys test message to contact us form");
//        Thread.sleep(3000); //guessing it needs some time to disable validation
        homePage2.clickSubmitContactForm();
    }
}
