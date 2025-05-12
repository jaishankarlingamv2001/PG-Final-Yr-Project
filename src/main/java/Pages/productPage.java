package Pages;


import Setup.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.concurrent.TimeUnit;


public class productPage extends Base {


    WebDriver driver;
    private final By allTheProductsADDIcon = By.xpath("//*[contains(text(),'ADD')]");//*[contains(@aria-label,'Add to cart')]");
    private final By allTheProductsNames = By.xpath("//div[contains(@class,'style__pro-title')]");






    public productPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void setProductItems() {
        System.out.println("PRODUCT PAGE");
        List<WebElement> listOfAllProductsADDIcon =findElements(allTheProductsADDIcon);
        List<WebElement> listOFAllProductsNames=findElements(allTheProductsNames);
        int currentNumberOfTheProduct = 0;
        int TotalNumberOfTheProductsToBeADD = 3;
        for (WebElement filterFromTheMultipleItems : listOfAllProductsADDIcon) {
            if (currentNumberOfTheProduct < TotalNumberOfTheProductsToBeADD) {
                filterFromTheMultipleItems.click();
                currentNumberOfTheProduct++;
            }
        }
        System.out.println("Total Selected Item in product page:" + currentNumberOfTheProduct);
        System.out.println("------------");


        int currentNumberOfTheProductName = 0;
        int TotalNumberOfTheProductNamesToBeDisplayed = 3;
        for (WebElement filterFromTheMultipleNames : listOFAllProductsNames) {
            if (currentNumberOfTheProductName < TotalNumberOfTheProductNamesToBeDisplayed) {
                String text = filterFromTheMultipleNames.getText();
                System.out.println(text);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                currentNumberOfTheProductName++;
            }
        }
        System.out.println("-------------");
        System.out.println();
        //System.out.println("Total Selected Item Names : " + currentNumberOfTheProductName);
    }
//        public void processItemsAndNames() {
//            int limit = Math.min(3, Math.min(multipleItems.size(), multipleItemNames.size())); // Find the minimum of 3, items list size, and names list size.
//            for (int i = 0; i < limit; i++) {
//                WebElement item = multipleItems.get(i);
//                WebElement name = multipleItemNames.get(i);
//
//                item.click();
//               String text = name.getText();
//                System.out.println(text);
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt(); // Restore interrupted state
//                    throw new RuntimeException(e);
//                }
//            }
//            System.out.println("Total Items selected and Names displayed: " + limit);
//        }
}

