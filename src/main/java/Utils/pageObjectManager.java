package Utils;


import Pages.homePage;
import Pages.productPage;
import Pages.cartPage;
import org.openqa.selenium.WebDriver;


public class pageObjectManager {


    WebDriver driver;
    testDataManager testDataManager;
    homePage homePage;
    productPage productPage;
    cartPage cartPage;
    screenshotManager screenshotManager;
    extentReportManager extentReportManager;
    wordDocumentManager wordDocumentManager;
    public pageObjectManager(WebDriver driver) {
        this.driver =driver;
    }
    public testDataManager getTestdata_Manager() {
        return testDataManager = new testDataManager(driver);
    }
    public homePage getHome_Page(){
        return homePage=new homePage(driver);
    }
    public productPage getProduct_Page(){
        return productPage= new productPage(driver);
    }


    public cartPage getCartPage(){
        return cartPage = new cartPage (driver);
    }
    public screenshotManager getScreenshotManager(){
        return screenshotManager=new screenshotManager(driver);
    }
    public extentReportManager getextentReportManager(){
        return extentReportManager=new extentReportManager(driver);
    }
    public wordDocumentManager getWordDocumentManager(){
        return wordDocumentManager=new wordDocumentManager(driver);
    }
}

