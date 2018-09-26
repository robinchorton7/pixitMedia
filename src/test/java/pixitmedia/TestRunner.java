package pixitmedia;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\feature\\pixitMedia.feature"
        , glue = {"pixitMedia.stepdefs", "pixitMedia.hooks"}
)
public class TestRunner {

}
