import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GitHubSelenideTest {
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys("MrDos180/qaguru_24_task12");
        $("#query-builder-test").submit();
        $(linkText("MrDos180/qaguru_24_task12")).click();
        $("#issues-tab").click();
        $(withText("Test Issue")).should(Condition.visible);
    }

}
