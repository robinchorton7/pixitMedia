package pixitmedia.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pixitmedia.pages.GooglePage;
import pixitmedia.pages.PixitMediaHomePage;

public class pixitmedia {
    private GooglePage googlePage = new GooglePage();
    private PixitMediaHomePage pixitMediaHomePage = new PixitMediaHomePage();

    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String url){
        googlePage.open(url);
//        googlePage.shouldBeDisplayed();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String searchString) {
        googlePage.search(searchString);
        googlePage.select("www." + searchString + ".com");
    }

    @And("^I select the \"([^\"]*)\" menu$")
    public void iSelectTheMenu(String menuItem){
        pixitMediaHomePage.select(menuItem);
    }

    @Then("^the \"([^\"]*)\" button returns a pdf download$")
    public void theButtonReturnsAPdfDownload(String buttonText){
        pixitMediaHomePage.download(buttonText);
    }

    @And("^I select the \"([^\"]*)\" menu link$")
    public void iSelectTheMenuLink(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I complete the form with \"([^\"]*)\", \"([^\"]*)\">, \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void iCompleteTheFormWithAnd(String first, String last, String email, String org, String contactNumber, String subject, String message) {
        pixitMediaHomePage.completeForm(first,last,email,org,contactNumber,subject,message);
    }

    @Then("^I can submit the form$")
    public void iCanSubmitTheForm(){
        pixitMediaHomePage.submit();
    }

    @And("^I select the \"([^\"]*)\" product link$")
    public void iSelectTheProductLink(String product){
        pixitMediaHomePage.selectProduct(product);
    }
}
