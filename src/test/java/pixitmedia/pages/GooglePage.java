package pixitmedia.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GooglePage {

    private String googlePageLocator = "TZA4S";
    private String searchBoxLocator = "q";
    private String resultsLocator = "h3.r a";

    public void open(String url) {
        Selenide.open(url);
    }

    public void shouldBeDisplayed() {
        $(By.id(googlePageLocator)).shouldBe(visible);
    }

    public void search(String searchString) {

        $(By.name("q")).sendKeys(searchString + Keys.ENTER);
    }

    public void select(String url) {
        ElementsCollection results = $$(resultsLocator);
        for ( SelenideElement result:results) {
            if ( result.attr("href").contains(url)) {
                result.click();
                break;
            }
        }
    }
}
