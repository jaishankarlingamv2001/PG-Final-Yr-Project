package Pages;


import Setup.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


import java.sql.Time;
import java.util.concurrent.TimeUnit;




public class homePage extends Base {
    private final By locationField = By.xpath("//input[@placeholder='Enter your city']");
    private final By medicineField = By.xpath("//*[@id='srchBarShwInfo']");
    private final By popupCancelButton = By.xpath("//*[contains(@class,'UpdateCityModal__cancel-btn')]");
    private final By randomAdCloseButton = By.xpath("(//*[@aria-label='Close Popup']//*[name()='svg'][@aria-label='Close'])[1]");
    private final By topAdCloseButton = By.xpath("//span[contains(@id,'notify-visitors-notification-close-button')]/*");
    private final By dropdown = By.xpath("//li[contains(text(),'Coimbatore')]");
    WebDriver driver;


    public homePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void clearPopups(){
        try {
            ElementToBeClickable(topAdCloseButton);
            ClickElement(topAdCloseButton);
        }catch(Exception e){
            System.out.println("Top popup close is not displayed");
            e.printStackTrace();
        }
        try {
            ElementToBeClickable(randomAdCloseButton);
            ClickElement(randomAdCloseButton);
        }catch (NoSuchElementException ignored){
            System.out.println("Random Ad is not displayed");
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            ElementToBeClickable(popupCancelButton);
            ClickElement(popupCancelButton);
        }catch (Exception e){
            System.out.println("City update field is not displayed");
            e.printStackTrace();
        }
    }


    public void setLocationField(String s) {
        ElementToBeClickable(locationField);
        driver.findElement(locationField).sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SendKey(locationField, s);
        ClickElement(By.xpath("//li[contains(text(),'"+s+"')]"));
        //enter(locationField);
    }


    public void setMedicineField(String s) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ElementToBeClickable(medicineField);
        enter(medicineField);
        SendKey(medicineField, s);
        enter(medicineField);
    }




}

