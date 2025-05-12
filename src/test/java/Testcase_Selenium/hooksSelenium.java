package Testcase_Selenium;


import Setup.GenericClass;
import Utils.screenshotManager;
import Utils.extentReportManager;
import Utils.wordDocumentManager;
import Utils.pageObjectManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


public class hooksSelenium {


    public screenshotManager screenshotManager;


    public extentReportManager extentReportManager;
    public wordDocumentManager wordDocumentManager;
    public pageObjectManager pageObjectManager;
    public GenericClass genericClass;
    //    public hooksSelenium() {
//        this.pageObjectManager = new pageObjectManager();
//        this.screenshotManager =pageObjectManager.getScreenshotManager();
//        this.extentReportManager=pageObjectManager.getextentReportManager();
//        this.wordDocumentManager=pageObjectManager.getWordDocumentManager();
//    }
    public hooksSelenium() {
        this.genericClass= new GenericClass();
        this.screenshotManager =genericClass.POM.getScreenshotManager();
        this.extentReportManager=genericClass.POM.getextentReportManager();
        this.wordDocumentManager=genericClass.POM.getWordDocumentManager();
    }




    @BeforeClass
    public void reportCreation() {
        extentReportManager.extentReportCreation();
        wordDocumentManager.wordDocCreation();
    }


    @AfterMethod
    public void getScreenshot(ITestResult result) {
        screenshotManager.screenshot();
//        extentReportManager.createTest(result.getMethod().getMethodName());
//        extentReportManager.eachTest(result.getMethod().getMethodName());
        wordDocumentManager.copyAndPasteScreenshot();
    }


    @AfterClass
    public void ReportClosure() {
        extentReportManager.flushTest();
        wordDocumentManager.flushTheWordDocument();
        genericClass.driver.quit();
    }
}

