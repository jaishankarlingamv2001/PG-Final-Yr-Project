package Pages;


import Setup.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class cartPage extends Base {
    private final By cartIcon = By.xpath("//*[contains(@aria-label,'Go to Cart')]");
    private final By displayedAllProductNames = By.xpath("//*[contains(@class,'bodySemiBold textPrimary')]");
    private final By displayedAllProductAmount = By.xpath("//*[contains(@class,'flexColumn alignEnd')]//span[1]");
    private final By applyCouponIcon = By.xpath("//div[text()='Apply coupon']");
    private final By couponApplyField = By.xpath("//input[@placeholder='Enter Coupon Code']");
    private final By couponApplyButton = By.xpath("//span[text()='Apply' and contains(@class,' Button__buttonText')]");
    private final By platFormFee = By.xpath("//*[text()=' Platform fee ']//ancestor::div[4]/div[2]");
    private final By discountAmount = By.xpath("//*[contains(@class,'flex justifyBetween alignCenter marginTop-8')]//div[contains(@class,'textSecondary smallRegular undefined ApplyCoupon')]//b");
    private final By ToBePaidAmountAfterDiscountApplied = By.xpath("//*[contains(text(),'To be paid')]/parent::*/div[2]");
    private final By addMembershipCoupon = By.xpath("//span[text()='Add membership']");
    private final By defaultDiscountAppliedAmount = By.xpath("//div[text()='Discount applied:']/parent::*/div[2]");
    private final By carePlan = By.xpath("//*[text()=' Platform fee ']//ancestor::div[6]//div[3]/div/div[2]/p/font");

    //    private final By invalidCoupon1 = By.xpath("//h2[contains(@class,'Coupon code not applicable on the item(s) in the cart')]");
//    private final By invalidCoupon2 = By.xpath("//h1[contains(@class,'No such active coupons exist')]");
    private final By invalidCoupon1 = By.xpath("//span[contains(text(),'Coupon code not applicable on the item(s) in the cart')]");
    private final By invalidCoupon2 = By.xpath("//span[contains(text(),'No such active coupons exist')]");
    private final By invalidCoupon3 = By.xpath("//span[contains(text(),'Coupons not found')]");


    private final By wrongCoupon = By.xpath("//div[contains(text(),'Available coupons')]");




    List<WebElement> listOfDisplayedAllProductNames, listOfDisplayedAllProductAmount;
    List<String> storeAllProductNames, storeAllProductAmounts;
    int temporary, actualAmount, totalAmountPlatFormFeeIsNotIncluded, finalCheckOutAmount, actualDiscountAmount, expectedAmountTobePaid, actualAmountIsDisplayed, ExactDiscountAmount, ExactCarePlanAmount;


    WebDriver driver;


    public cartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void cartIcon() {
        PresenceOfElementLocated(cartIcon);
        ClickElement(cartIcon);
    }


    public void setProductNames() {
        System.out.println("CART PAGE");
        PresenceOfElementLocated(displayedAllProductNames);
        listOfDisplayedAllProductNames = findElements(displayedAllProductNames);
        int limit = listOfDisplayedAllProductNames.size();
        System.out.println("Total Item displayed in cart Page :" + limit);
        System.out.println("----------");
        storeAllProductNames = new ArrayList<String>();
        for (int i = 0; i < limit; i++) {
            WebElement productNames = listOfDisplayedAllProductNames.get(i);
            storeAllProductNames.add(productNames.getText());
            System.out.println(storeAllProductNames.get(i));
        }
        System.out.println("-----------");
    }


    public void setProductAmount() {
        PresenceOfElementLocated(displayedAllProductAmount);
        listOfDisplayedAllProductAmount = findElements(displayedAllProductAmount);
        int limit = listOfDisplayedAllProductAmount.size();
        storeAllProductAmounts = new ArrayList<>();
        System.out.println();
        System.out.println("The below amounts are respective to above added products");
        for (int i = 0; i < limit; i++) {
            WebElement productAmount = listOfDisplayedAllProductAmount.get(i);
            storeAllProductAmounts.add(productAmount.getText());
            System.out.println(storeAllProductAmounts.get(i));
        }
        System.out.println("------------");
    }


    public void priceDisplayedBeforeApplyingDiscount() {
        int limit = storeAllProductAmounts.size();
        temporary = 0;
        for (int i = 0; i < limit; i++) {
            String justGetTheAmount = (storeAllProductAmounts.get(i));
            String replaceTheSymbolForTheAmount = justGetTheAmount.replaceAll("[^\\d.]+", "").trim();
            actualAmount = Integer.parseInt(replaceTheSymbolForTheAmount);
            totalAmountPlatFormFeeIsNotIncluded = temporary + actualAmount;
            temporary = totalAmountPlatFormFeeIsNotIncluded;
        }
        System.out.println();

        try{
            PresenceOfElementLocated(addMembershipCoupon);
            ClickElement(addMembershipCoupon);
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            System.out.println(e);
        }

        String carePlanAmount = driver.findElement(carePlan).getText();
        String replaceTheSymbolForTheCarePlanAmount = carePlanAmount.replaceAll("[^\\d.]+","").trim();
        ExactCarePlanAmount = Integer.parseInt(replaceTheSymbolForTheCarePlanAmount);




        String justGetThePlatformFee = driver.findElement(platFormFee).getText();
        String replaceTheSymbolForTheFee = justGetThePlatformFee.replaceAll("[^\\d.]+", "").trim();
        finalCheckOutAmount = Integer.parseInt(replaceTheSymbolForTheFee) + temporary + ExactCarePlanAmount;


        System.out.println("VALIDATION FOR COUPON AMOUNT");
        System.out.println("--------");
        System.out.println("The final checkout price before discount applied: " + finalCheckOutAmount);
    }



    public void setApplyCoupon(String s) {


//        PresenceOfElementLocated(applyCouponIcon);
//        ClickElement(applyCouponIcon);
//        Assert.assertTrue(isDisplayed(couponApplyField));
//        SendKey(couponApplyField, s);
//        ClickElement(couponApplyButton);
//        boolean check1 = isElementPresent(invalidCoupon1);
//        boolean check2 = isElementPresent(invalidCoupon2);
//        boolean check3 = isElementPresent(invalidCoupon3);
//
//
//        if (check1 || check2 || check3) {
//            System.out.println("The given coupon is not valid");
//        } else {
//            discountAmount();
//            expectedAndActualPriceValidation();
        //}
    }


    public void discountAmount() {

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String defaultDiscountAmount = driver.findElement(defaultDiscountAppliedAmount).getText();
        String replaceTheSymbolForTheDefaultDiscount = defaultDiscountAmount.replaceAll("[^\\d.]+","").trim();
        ExactDiscountAmount = Integer.parseInt(replaceTheSymbolForTheDefaultDiscount);


//        String justGetTheDiscountAmount = GetText(discountAmount);
//        String replaceTheSymbolForTheDiscountAmount = justGetTheDiscountAmount.replaceAll("[^\\d.]+", "").trim();
//        actualDiscountAmount = Integer.parseInt(replaceTheSymbolForTheDiscountAmount);
        //System.out.println("Discount Amount " + actualDiscountAmount);
        System.out.println("Discount Amount " + ExactDiscountAmount);
    }


    public void expectedAndActualPriceValidation() {
//        expectedAmountTobePaid = finalCheckOutAmount - actualDiscountAmount;
//        System.out.println();
//        System.out.println("The actual amount is :" + finalCheckOutAmount + " MINUS the discount amount is :" + actualDiscountAmount);
//        System.out.println();
//        System.out.println("To be paid amount is :" + finalCheckOutAmount + " - " + actualDiscountAmount);
//        System.out.println("To be paid amount is :" + expectedAmountTobePaid);

        expectedAmountTobePaid = finalCheckOutAmount - ExactDiscountAmount;
        System.out.println();
        System.out.println("The actual amount is :" + finalCheckOutAmount + " MINUS the discount amount is :" + ExactDiscountAmount);
        System.out.println();
        System.out.println("To be paid amount is :" + finalCheckOutAmount + " - " + ExactDiscountAmount);
        System.out.println("To be paid amount is :" + expectedAmountTobePaid);



        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String justGetTheToBePaidAmount = GetText(ToBePaidAmountAfterDiscountApplied);
        String replaceTheSymbolForToBePaidAmount = justGetTheToBePaidAmount.replaceAll("[^\\d.]+", "").trim();
        actualAmountIsDisplayed = Integer.parseInt(replaceTheSymbolForToBePaidAmount);
        System.out.println("To be paid displayed amount is : " + actualAmountIsDisplayed);
        Assert.assertEquals(expectedAmountTobePaid, actualAmountIsDisplayed);
        System.out.println();
        System.out.println("The apply coupon validation is worked correctly");




    }




}

