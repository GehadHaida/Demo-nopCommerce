package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P02_login;

public class D02_loginStepDef {

    P02_login login = new P02_login();


    @Given("user go to login page")
    public void userOpenLoginPage(){
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }

    @When("user login with \"valid\" \"test@example.com\" and \"P@ssw0rd\"")
    public void userEnterEmail(){
        login.enterMail().sendKeys("testGGG@example.com");
        login.enterPass().sendKeys("P@ssword");
    }

    @And("user press on login button")
    public void userPressLoginBtn(){
        login.loginClickBtn().click();
    }

    @Then("user login to the system successfully")
    public void VerifyIAMLogged(){
        login.lgnAssertion();

    }

    @When("user login with \"invalid\" \"wrong@example.com\" and \"P@ssw0rd\"")
    public void useEnterInvalidInfo(){
        login.enterMail().sendKeys("wrong@example.com");
        login.enterPass().sendKeys("P@ssword");
    }

    @Then("user could not login to the system")
    public void VerifyIAMNotLogged(){
        login.notLogged();
    }
}
