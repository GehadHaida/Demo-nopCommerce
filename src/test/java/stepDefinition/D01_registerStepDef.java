package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P01_registerPage;

public class D01_registerStepDef {

    P01_registerPage register = new P01_registerPage();


    @Given("user go to register page")
    public void userClickRegister(){
        register.registerLink().click();
    }

    @When("user select gender type")
    public void UserChooseMale(){

        register.chooseGender().click();
    }

    @And("user enter first name \"automation\" and last name \"tester\"")
    public void userEnterName(){
        register.firstName().sendKeys("automation");
        register.lastName().sendKeys("tester");
    }

    @And("user enter date of birth")
    public void userEnterDate()
    {
        register.birthDay();
        register.birthMonth();
        register.birthYear();
    }

    @And("user enter email \"test@example.com\" field")
    public void userEnterEmail(){
        register.email().sendKeys("testGGG@example.com");
    }

    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void userEnterPass(){
        register.pass().sendKeys("P@ssword");
        register.conPass().sendKeys("P@ssword");
    }

    @And("user clicks on register button")
    public void userClickRegisterButton(){
        register.clickRegister().click();
    }

    @Then("success message is displayed")
    public void userLoggedIn(){
        register.registerAssertion();




    }
}
