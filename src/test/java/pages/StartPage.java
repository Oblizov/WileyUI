package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import properties.TestSettings;

public class StartPage {

    private WebDriver driver;

    @FindBy(css=".modal-footer > button:nth-child(2)")
    private WebElement buttonYes;

    public StartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goMainPage(){
        driver.get("https://www.wiley.com/en-us");
    }

    public void closeModalContent(){
        TestSettings.clickableElement(buttonYes);
        buttonYes.click();

    }


}
