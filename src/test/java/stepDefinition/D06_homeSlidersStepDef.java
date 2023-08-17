package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P03_homePage;

public class D06_homeSlidersStepDef {

    P03_homePage homePage = new P03_homePage();

    @When("user click on Galaxy S22 Ultra")
    public void userClickOnGalaxySlider(){
        homePage.homeSliderGalaxy();
    }

    @Then("verify correct Galaxy webpage opened")
    public void verifyGalaxyPageOpened(){
        homePage.galaxyS22SliderAssertion();
    }

    @When("user click on Iphone 14")
    public void userClickOnIphoneSlider(){
        homePage.homeSliderIphone();
    }

    @Then("verify correct Iphone webpage opened")
    public void verifyIphonePageOpened(){
        homePage.iphone14SliderAssertion();
    }
}
