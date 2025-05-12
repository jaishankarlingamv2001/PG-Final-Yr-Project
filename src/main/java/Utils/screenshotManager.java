package Utils;


import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class screenshotManager {
    public WebDriver driver;


    public screenshotManager(WebDriver driver) {
        this.driver =driver;
    }
    public String screenshot(){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName =  timestamp + "_.png";
        File destination = new File(System.getProperty("user.dir")+"//src//main//resources//screenshots//" + screenshotName);
        //File destination = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\screenshots\\" + screenshotName);
        //File destination = new File("C:\\Users\\2269512\\IdeaProjects\\Gujay_Swiggy\\src\\main\\resources\\screenshots\\" + screenshotName);
        try {
            FileHandler.copy(screenshotFile, destination);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return screenshotName;
    }
    public String screenshotBASE64(){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        return screenshot.getScreenshotAs(OutputType.BASE64);
    }


}

