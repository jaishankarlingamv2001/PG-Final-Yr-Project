package Setup;


import Utils.pageObjectManager;
import Utils.browserSetup;
import org.openqa.selenium.WebDriver;


public class GenericClass {
    public WebDriver driver;
    public pageObjectManager POM;




    public GenericClass(){
        this.driver =browserSetup.BrowserInitialization();
        POM = new pageObjectManager(driver);
    }


}

