package pixitmedia.hooks;

import com.codeborne.selenide.Configuration;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

        @Before
        public void beforeScenario(){
            System.setProperty("selenide.browser","Chrome");
            Configuration.timeout = 20000;
        }

        @After
        public void afterScenario(){
        }
}
