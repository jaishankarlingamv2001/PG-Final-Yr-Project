package StepDefinition;


import Setup.GenericClass;
import Utils.extentReportManager;
import Utils.screenshotManager;
import Utils.wordDocumentManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {
    public GenericClass genericClass;
    public screenshotManager screenshotManager;


    public extentReportManager extentReportManager;
    public wordDocumentManager wordDocumentManager;


    public Hooks(GenericClass genericClass) {
        this.genericClass = genericClass;
        this.screenshotManager = this.genericClass.POM.getScreenshotManager();
        this.extentReportManager = this.genericClass.POM.getextentReportManager();
        this.wordDocumentManager=this.genericClass.POM.getWordDocumentManager();
    }


    @Before
    public void reportCreation() {
        extentReportManager.extentReportCreation();
        wordDocumentManager.wordDocCreation();
    }


    @AfterStep
    public void getScreenshot(Scenario scenario) {
        screenshotManager.screenshot();
        extentReportManager.createTest(scenario);
        extentReportManager.eachTest(scenario);
        wordDocumentManager.copyAndPasteScreenshot();
    }


    @After
    public void ReportClosure() {
        extentReportManager.flushTest();
        wordDocumentManager.flushTheWordDocument();
        genericClass.driver.quit();
    }
}

