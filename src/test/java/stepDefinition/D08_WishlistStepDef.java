package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P03_homePage;

public class D08_WishlistStepDef {

    P03_homePage homePage = new P03_homePage();

    @When("user click on the wishlist button on a product")
    public void userClickOnWishListBtn(){
        homePage.clickOnWishListButton().click();
    }

    @Then(("verify success message is displayed"))
    public void verifyWishListAssertion() throws InterruptedException {
        homePage.wishListAssertion();
    }

    @Then("user wait until the green success message disappear")
    public void userWaitSuccessMsgToDisappear(){
        homePage.successMessageDisappear();
    }

    @And("verify if the wishlist quantity value is more than 0")
    public void verifyWishListQuantity(){
        homePage.wishListQuantity();
    }
}
