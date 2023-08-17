package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.P03_homePage;

public class D04_searchStepDef {

    P03_homePage search = new P03_homePage();

    @When("^user search using product (.*)$")
    public void searchFeature(String productName){
        search.searchByProductName(productName);
    }

    @And("user clicks search")
    public void clickSearch(){
        search.clickSearchButton();

    }

    @Then("user could find results")
    public void user_could_find_results() {
        SoftAssert softAssert = new SoftAssert();
        search.assertSearchResultsExist(softAssert);
        softAssert.assertAll();
    }

    @And("user could find (.*) relative results$")
    public void user_could_find_relative_results(String productName) {
        SoftAssert softAssert = new SoftAssert();
        search.assertSearchResultsContainProductName(productName, softAssert);
        softAssert.assertAll();
    }


    @When("user uses product SKU to search (.*)$")
    public void user_search_using_product_sku(String sku){
        search.searchByProductSku(sku);

    }

    @And("user click on the product in search result")
    public void user_click_on_the_product_in_search_result(){
        search.clickOnTheProduct();

    }

    @Then("user could find (.*) contains the sku in search$")
    public void userCouldFindSKU(String sku){
        search.verifyProductGotSkuCode(sku);
    }


}




