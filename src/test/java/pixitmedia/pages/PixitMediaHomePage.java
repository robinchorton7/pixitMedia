package pixitmedia.pages;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static org.junit.Assert.*;

public class PixitMediaHomePage {
    private String menuItemLocator = "nav>ul>li>a>span";
    private String productLinkLocator = "div.elementor-container a";
    private String dataSheetButtonLocator = "div.elementor-button-wrapper a span span";
    private String submitSuccessfulLocator = "div.frm_message p";

    public void select(String menuItemText) {
        ElementsCollection menuItems = $$(By.cssSelector("nav > ul > li > a > span"));
        for ( SelenideElement menuItem : menuItems){
            if ( menuItem.getText().equals(menuItemText)) {
                menuItem.parent().click();
                break;
            }
        }
    }

    public void shouldBeDisplayed(String title) {
        assertTrue(Selenide.title().equals(title));

    }

    public void selectProduct(String product) {
        ElementsCollection productLinks =$$(productLinkLocator);
        for ( SelenideElement productLink : productLinks){
            if ( productLink.getText().equals(product)){
                productLink.click();
                break;
            }
        }
    }

    public void download(String buttonText) {
        $(dataSheetButtonLocator).shouldHave(text(buttonText)).click();
//        assertTrue(Selenide.title().endsWith("pdf"));
        Selenide.back();
        shouldBeDisplayed("PixStor – pixitmedia");
    }

    public void completeForm(String first, String last, String email, String org, String contactNumber, String subject, String message) {
        $(By.name("item_meta[6]")).sendKeys(first);
        $(By.name("item_meta[7]")).sendKeys(last);
        $(By.name("item_meta[8]")).sendKeys(email);
        $(By.name("item_meta[24]")).sendKeys(org);
        $(By.name("item_meta[23]")).sendKeys(contactNumber);
        $(By.name("item_meta[9]")).sendKeys(subject);
        $(By.name("item_meta[10]")).sendKeys(message);
    }

    public void submit() {
        $("button.frm_button_submit").click();
        $(By.cssSelector(submitSuccessfulLocator)).shouldHave(text("Your responses were successfully submitted. Thank you!"));
    }
}
