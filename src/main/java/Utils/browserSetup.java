package Utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import java.util.concurrent.TimeUnit;


public class browserSetup {
    public static WebDriver driver;


    public browserSetup(WebDriver driver) {
        browserSetup.driver=driver;
    }


    public static WebDriver BrowserInitialization() {
        String userDirectory = System.getProperty("user.dir")+"//src//test//resources//Config.properties";
        //String userDirectory = System.getProperty("user.dir")+"\\src\\test\\resources\\Config.properties";
        //String userDirectory = "C:\\\\Users\\\\2269512\\\\IdeaProjects\\\\Gujay_Swiggy\\\\src\\\\test\\\\resources\\\\config.properties";
        String browser = fileManagerReader.FileReader(userDirectory, "browser");
        System.out.println(browser);
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
        String url = fileManagerReader.FileReader(userDirectory, "url");
        driver.get(url);
        System.out.println(url);
        return driver;
    }
}

