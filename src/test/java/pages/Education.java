package pages;

import models.ParamEducation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import properties.TestSettings;

import java.util.ArrayList;
import java.util.List;

public class Education {

    WebDriver driver;

    public Education(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".wiley-slogan h1:nth-child(3) span")
    private WebElement titlePage;

    @FindBy(css=".hero-banner")
    private WebElement headerPage;

    @FindBy(css=".side-panel")
    private WebElement leftPanel;

    @FindBy(css=".side-panel li a")
    private List<WebElement> listLeftPanel;

    private String getTitlePage(){
        String title = titlePage.getAttribute("innerText").trim();
        return title;
    }

    private List<String> getListLeftPanel(){
        List<String> list = new ArrayList<>();
        for(WebElement item : listLeftPanel){
            list.add(item.getAttribute("innerText").trim());
        }
        return list;
    }


    public ParamEducation getEducationModel(){
        TestSettings.clickableElement(titlePage);

        boolean isheaderVisible = TestSettings.isElementVisible(titlePage);

        TestSettings.scrollToElement(leftPanel);
        TestSettings.clickableElement(leftPanel);

        List<String> listLeftPanel = getListLeftPanel();
        ParamEducation educModel = new ParamEducation(listLeftPanel, isheaderVisible) ;

        return educModel;
    }
}
