package serenity.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import serenity.pages.BigencPage;

public class UiSteps extends ScenarioSteps {

    protected BigencPage bigencPage;

    @Step
    public String openMainAndGetFirstSearchResult(String keyword) {
        bigencPage.open();
        return bigencPage.getFirstSearchResult(keyword);
    }
}
