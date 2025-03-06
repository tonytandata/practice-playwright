package org.tonyyjt.testscripts;

import org.tonyyjt.pages.HomePage;
import org.testng.annotations.Test;
import org.tonyyjt.steps.HomePageSteps;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class ToolshopTest extends TestBase {

    public void verifySignInButton() {
        HomePage homePage = new HomePage()
                .navigate();
        assertThat(homePage.isSignInButtonDisplayed()).isTrue();
    }

    public void verifySignInButton_failOnPurpose() {
        HomePage homePage = new HomePage()
                .navigate();
        assertThat(homePage.isSignInButtonDisplayed()).isFalse();
    }

    public void verifyAnotherTest(){
        HomePageSteps homePageSteps = new HomePageSteps();
        homePageSteps.openHomepage();
        assertThat(1).isEqualTo(1);
    }
}
