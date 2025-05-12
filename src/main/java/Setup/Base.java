package Setup;


import Utils.pageObjectManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.List;


public class Base {
    public pageObjectManager POM;
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;




    public Base(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        POM = new pageObjectManager(driver);
        action = new Actions(driver);
    }


    public void ClickElement(By by) {
        driver.findElement(by).click();
    }


    public void driverClose() {
        driver.quit();
    }


    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }


    public void clearText(By by) {
        driver.findElement(by).clear();
    }


    public void enter(By by) {
        driver.findElement(by).sendKeys(Keys.ENTER);
    }


    public void SendKey(By by, String key) {
        driver.findElement(by).sendKeys(key);
    }


    public String GetText(By by) {
        return driver.findElement(by).getText();
    }


    public void ElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public void PresenceOfElementLocated(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public void SelectByText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }


    public boolean isDisplayed(By by) {
        return driver.findElement(by).isDisplayed();
    }




    public boolean isElementPresent(By by) {
        boolean ispresent = false;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return ispresent=true;
        } catch (Exception e) {
            //
        } return ispresent;
    }




}

