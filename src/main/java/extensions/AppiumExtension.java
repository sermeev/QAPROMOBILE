package extensions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.AppiumSelenideDriver;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class AppiumExtension implements BeforeEachCallback, AfterEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Configuration.browser = AppiumSelenideDriver.class.getName();
        Configuration.browserSize = null;
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        Selenide.closeWebDriver();
    }
}
