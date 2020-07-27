package serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

@DefaultUrl("https://bigenc.ru/")
public class BigencPage extends PageObject {

    @FindBy(xpath = "//a[text() = 'Поиск']")
    WebElementFacade searchButton;

    @FindBy(xpath = "//*[@id = 'search']")
    WebElementFacade searchField;

    @FindBy(xpath = "//*[@class = 'personals-list']//li[1]")
    WebElementFacade firstSearchResult;

    public String getFirstSearchResult(String keyword) {
        searchButton.waitUntilClickable().click();
        searchField.type(keyword);
        searchField.sendKeys(Keys.ENTER);
        return firstSearchResult.getText();
    }
}
