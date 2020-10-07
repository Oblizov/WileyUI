package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import properties.TestSettings;

import java.util.ArrayList;
import java.util.List;

import static properties.TestSettings.*;

public class MainHeader {


    private WebDriver driver;

    @FindBy(css="#main-header-navbar > ul > li.dropdown-submenu:nth-child(1)")
    private WebElement whoWeServe;

    @FindBy(css="#main-header-navbar > ul > li.dropdown-submenu:nth-child(2)")
    private WebElement subject;

    @FindBy(css="#Level1NavNode1 > ul > li > a[href]")
    private List<WebElement> allLinkWhoWeServe;

    @FindBy(css=".dropdown-submenu.hover")
    private WebElement board;

    @FindBy(css=".dropdown-item.dropdown-submenu.hover")
    private WebElement subBoard;

    @FindBy(css="#Level1NavNode2 > ul > li > a[href]")
    private List<WebElement> allLinkSubject;

    @FindBy(css=".dropdown-item.dropdown-submenu.hover .dropdown-item")
    private List<WebElement> listSubSubHeads;

    public MainHeader(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void clickToHeaderItem(WebElement elem) {
        clickableElement(elem);
        scrollToElement(elem);
    }

    private List<String> getListSubmenu(List<WebElement> list ){
        List<String> listTitles = new ArrayList<>();

        for(WebElement item : list){
            listTitles.add(item.getAttribute("innerText").trim());
        }
        return listTitles;
    }

    private WebElement getNeedElem(List<WebElement> list, String nameElem){

        WebElement res = list.get(0);

        for(WebElement item: list){
            if(nameElem.equals(item.getAttribute("innerText"))){
                res = item;
                break;
            }
        }
        return res;

    }

    public List<String> getSubmenuWhoWeServe() {
        clickToHeaderItem(whoWeServe);
        clickableElement(board);
        List<String> listTitles = getListSubmenu(allLinkWhoWeServe);
        return listTitles;
    }

    public void clickEducationSection() {
        clickToHeaderItem(subject);
        clickableElement(board);
        WebElement education = getNeedElem(allLinkSubject, "Education");

        clickableElement(education);
        scrollToElement(education);
        education.click();

    }


}
