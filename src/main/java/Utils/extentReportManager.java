package Utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class extentReportManager {
    public WebDriver driver;
    public ExtentReports extentReporter;
    public  ExtentSparkReporter sparkReporter;
    public ExtentTest extentTest;
    public screenshotManager screenshotManager;


    public extentReportManager(WebDriver driver) {
        this.driver=driver;
        screenshotManager = new screenshotManager(this.driver);
    }
    public void extentReportCreation(){
        extentReporter = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//src//main//resources//Reports//Extent Report.html");
        //sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\main\\resources\\Reports\\Extent Report.html");
        //sparkReporter = new ExtentSparkReporter("C:\\\\Users\\\\2269512\\\\IdeaProjects\\\\Gujay_Swiggy\\\\src\\\\main\\\\resources\\\\Reports\\\\Extent Report.html");
        extentReporter.attachReporter(sparkReporter);
    }
        public void createTest(Scenario scenario){
       extentTest = extentReporter.createTest(scenario.getName());
    }
    public void eachTest(Scenario scenario){
        if (scenario.isFailed()){
            extentTest.fail(scenario+ "is Failed").addScreenCaptureFromBase64String(screenshotManager.screenshotBASE64());
        }
        else {
            extentTest.pass(scenario + "is Passed").addScreenCaptureFromBase64String(screenshotManager.screenshotBASE64());
        }

    }
//    public void createTest(String result){
//        extentTest = extentReporter.createTest(result);
//    }
//    public void eachTest(String result){
//        if (result.equalsIgnoreCase("pass")){
//            extentTest.fail(result+ "is Passed").addScreenCaptureFromBase64String(screenshotManager.screenshotBASE64());
//        }
//        else {
//            extentTest.pass(result + "is Failed").addScreenCaptureFromBase64String(screenshotManager.screenshotBASE64());
//        }
//
//
//    }
    public void flushTest(){
        extentReporter.flush();
    }
}

