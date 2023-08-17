package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P03_homePage;

public class D07_followUsStepDef {

    P03_homePage search = new P03_homePage();

    @When("user click facebook link")
    public void userClickOnFaceBookIcon() throws InterruptedException {
        search.clicksOnFacBookIcon();
    }

    @Then("facebook is opened in new tab")
    public void verifyFaceBookOpened(){
        search.facebookAssertion();
    }

    @When("user click twitter link")
    public void userClickOnTwitterIcon() throws InterruptedException {
        search.clicksOnTwitterIcon();
    }

    @Then("Twitter is opened in new tab")
    public void verifyTwitterOpened(){
        search.twitterAssertion();
    }

    @When("user click rss link")
    public void userClickOnRssIcon() throws InterruptedException {
        search.clicksOnRssIcon();
    }

    @Then("rss is opened in new tab")
    public void verifyRssOpened(){
        search.rssAssertion();
    }

    @When("user click youtube link")
    public void userClickOnYoutubeIcon() throws InterruptedException {
        search.clicksOnYoutubeIcon();
    }

    @Then("youtube is opened in new tab")
    public void verifyYoutubeOpened(){
        search.youtubeAssertion();
    }

}
