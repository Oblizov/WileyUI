package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import properties.TestBegin;
import properties.TestSettings;

import static properties.TestBegin.clickableElement;
import static properties.TestSettings.*;

public class Search {

    WebDriver driver;

    @FindBy(css="#js-site-search-input")
    private WebElement searchInput;

    @FindBy(css=".input-group-btn > button")
    private WebElement searchButton;

    @FindBy(css=".ui-menu-item-wrapper")
    private WebElement boardResult;

    public Search(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void input(String word){
        clickableElement(searchInput);
        searchInput.click();
        searchInput.sendKeys(word);
    }

    private void clickSearchButton(){
        clickableElement(searchButton);
        scrollToElement(searchButton);
        searchButton.click();
    }


    public boolean enterWord(String word){
        input(word);
        TestBegin.clickableElement(boardResult);
        return isElementVisible(boardResult);
    }

    public void enterWordAndPressButton(String word){
        input(word);
        clickableElement(boardResult);
        clickSearchButton();
    }
}
