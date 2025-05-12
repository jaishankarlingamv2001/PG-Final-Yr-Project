package StepDefinition;


import Pages.productPage;
import Setup.GenericClass;
import io.cucumber.java.en.And;


public class productPageSD {
    public GenericClass genericClass;
    public productPage productPage;
    public productPageSD(GenericClass genericClass) {
        this.genericClass = genericClass;
        this.productPage=genericClass.POM.getProduct_Page();
    }
    @And("User should be able to select expected products")
    public void User_should_be_able_to_select_expected_products(){
        productPage.setProductItems();
    }
}

