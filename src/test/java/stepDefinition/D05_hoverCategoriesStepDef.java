package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P03_homePage;

public class D05_hoverCategoriesStepDef {

    P03_homePage homePage = new P03_homePage();

    @When("user hover over computers")
    public void userHoverOverComputers(){
        homePage.hoverMainCategory();
    }

    @Then("user select random subcategory | verify if subtitle and page main title matches")
    public void userSelectRandomSubCategory(){
        homePage.randomSubCategoryAndAssertion();
    }

}
