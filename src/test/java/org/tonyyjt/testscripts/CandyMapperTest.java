package org.tonyyjt.testscripts;

import org.testng.annotations.Test;
import org.tonyyjt.pages.HomePage;

@Test
public class CandyMapperTest extends TestBase{
    public void verifyContactUsSubmission() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.navigate();
        homePage.closePopup();

        //TODO: Continue with filling up contact form and verify for success message
    }
}
