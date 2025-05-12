package Utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import java.io.File;


public class testDataManager {
    public WebDriver driver;
    public static File jsonFile;
    //public static String testDataForFields = "C:\\Users\\2269512\\IdeaProjects\\Gujay_Swiggy\\src\\main\\resources\\TestData";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public testDataManager(WebDriver driver) {
        this.driver =driver;
    }
    public static <T>T readTheData(String jsonFilePath, Class<T> className){
        try{
            jsonFile = new File(jsonFilePath);
            System.out.println(jsonFile);
            if (!jsonFile.exists()) {
                System.out.println("The Given path is incorrect");
            }return objectMapper.readValue(jsonFile,className);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }
}

