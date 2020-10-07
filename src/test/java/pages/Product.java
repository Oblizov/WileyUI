package pages;

import models.ParamProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

import static properties.TestSettings.*;

public class Product {
    WebDriver driver;

    public Product(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".product-item")
    List<WebElement> products;

    private By productTitle = By.cssSelector(".product-title a");

    private By buttonGroupName = By.cssSelector(".productButtonGroupName");

    private By productButton1 = By.cssSelector("#tabContentStyle .tab-pane.active tab-pane.active button");

    private By productButton2 = By.cssSelector("#tabContentStyle .tab-pane.active .product-button");


    private String getText(WebElement titleElement){
        return titleElement.getAttribute("innerText").trim();
    }

    private WebElement getProductButton(WebElement productItem){

        try{
            return childOfParentElement(productItem, productButton1);
        }
        catch (NoSuchElementException e){
            return childOfParentElement(productItem, productButton2);
        }
    }

    private Map<String, String> getNameProductButtons(WebElement productItem){

        Map<String, String> coupleButtons = new TreeMap<>();

        List<WebElement> groupButtons = childrenOfParentElement(productItem, buttonGroupName);

        for(WebElement groupButton : groupButtons){
            clickableElement(groupButton);
            groupButton.click();

            WebElement prodButton = getProductButton(productItem);

            coupleButtons.put(getText(groupButton), getText(prodButton));
        }
        return coupleButtons;
    }

    public List<ParamProduct> getProductModel(){

        List<ParamProduct> productModel = new ArrayList<>();
        for(WebElement productItem : products){

            scrollToElement(productItem);
            clickableElement(productItem);

            WebElement title = childOfParentElement(productItem, productTitle);

            productModel.add(new ParamProduct(getText(title), getNameProductButtons(productItem)));
        }

        return productModel;
    }


}
