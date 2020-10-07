package properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBegin {

    WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;

    public void start(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,15);
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait((long) 0.2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void stop(){
        driver.quit();
        driver = null;
    }

    public static void clickableElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollToElement(WebElement element){
        actions.moveToElement(element).build().perform();
    }

    public static boolean isElementVisible(WebElement element){
        return element.isDisplayed();
    }

    public static WebElement childOfParentElement(WebElement parent, By child) {
        return parent.findElement(child);
    }

    public static List<WebElement> childrenOfParentElement(WebElement parent, By child) {
        return parent.findElements(child);
    }

}
