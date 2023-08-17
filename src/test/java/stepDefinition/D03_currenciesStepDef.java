package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P03_homePage;

public class D03_currenciesStepDef {

    P03_homePage homePage = new P03_homePage();

    @When("user select euro sign from the dropdown menu")
    public void userChooseCurrency()
    {
        homePage.currency();
    }

    @Then("all 4 products switch to euro sign")
    public void verifyCurrencyCHanged()
    {
        homePage.assertCurrency();
    }
}
