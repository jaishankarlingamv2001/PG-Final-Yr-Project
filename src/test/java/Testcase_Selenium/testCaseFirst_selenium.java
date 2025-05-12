package Testcase_Selenium;


import Pages.cartPage;
import Pages.homePage;
import Pages.productPage;
import Setup.GenericClass;
import TestData.TC_01TestData;
import Utils.testDataManager;
import org.testng.annotations.Test;


public class testCaseFirst_selenium extends Testcase.hooksSelenium {
    public GenericClass genericClass;
    public cartPage cartPage;
    public homePage homePage;
    public productPage productPage;
    private TC_01TestData testData;
    String jsonPath = System.getProperty("user.dir")+"//src//main//resources//TestData//TestData.json";
   // String jsonPath = System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\TestData.json";
    //String jsonPath = "C:\\\\Users\\\\2269512\\\\IdeaProjects\\\\Gujay_Swiggy\\\\src\\\\main\\\\resources\\\\TestData\\\\TestData.json";
    public testCaseFirst_selenium() {
        genericClass = super.genericClass;
        this.homePage = genericClass.POM.getHome_Page();
        this.cartPage = genericClass.POM.getCartPage();
        this.productPage = genericClass.POM.getProduct_Page();
        this.testData = testDataManager.readTheData(jsonPath, TC_01TestData.class);
    }
    @Test
    public void homePageFlow1(){
        homePage.clearPopups();
//        homePage.setLocationField(testData.getLocation());
//        homePage.setMedicineField(testData.getMedicine());
//        productPage.setProductItems();
//        cartPage.cartIcon();
//        cartPage.setProductNames();
//        cartPage.setProductAmount();
//        cartPage.priceDisplayedBeforeApplyingDiscount();
//        cartPage.setApplyCoupon(testData.getCouponCode());
    }
    @Test
    public void homePageFlow2(){
        homePage.setLocationField(testData.getLocation());
    }
    @Test
    public void homePageFlow3(){
        homePage.setMedicineField(testData.getMedicine());
    }
    @Test
    public void homePageFlow4(){
        productPage.setProductItems();
        cartPage.cartIcon();
        cartPage.setProductNames();
        cartPage.setProductAmount();
        cartPage.priceDisplayedBeforeApplyingDiscount();
        cartPage.setApplyCoupon(testData.getCouponCode());
    }




}

