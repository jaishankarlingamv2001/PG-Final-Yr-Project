package StepDefinition;


import Pages.cartPage;
import Setup.GenericClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class cartPageSD {


    public GenericClass genericClass;
    public cartPage cartPage;
    public cartPageSD (GenericClass genericClass) {
        this.genericClass = genericClass;
        this.cartPage=genericClass.POM.getCartPage();
    }
    @And("user should be able to navigate to the cart Page")
    public void user_should_be_able_to_navigate_to_the_cart_Page(){
        cartPage.cartIcon();


    }
    @And("product And Price Validation Before Discount")
    public void product_And_Price_Validation_Before_Discount(){
        cartPage.setProductNames();
        cartPage.setProductAmount();
        cartPage.priceDisplayedBeforeApplyingDiscount();
    }
    @Then("product And Price Validation After Discount")
    public void product_And_Price_Validation_After_Discount(){
        //cartPage.setApplyCoupon("TATA1MGNEW");
        cartPage.discountAmount();
        cartPage.expectedAndActualPriceValidation();
    }


}

