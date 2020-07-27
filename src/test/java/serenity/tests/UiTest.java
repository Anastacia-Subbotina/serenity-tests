package serenity.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenity.steps.UiSteps;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class UiTest {

    @Managed(driver = "chrome")
    protected WebDriver webdriver;

    @Steps
    UiSteps uiSteps;

    @Test
    public void check_search() {
        String result = uiSteps.openMainAndGetFirstSearchResult("ЭНЦИКЛОПЕДИЯ");

        assertThat(result).as("Не смогли найти в результате поиска ключевое слово")
                .contains("ЭНЦИКЛОПЕДИЯ");
    }
}
