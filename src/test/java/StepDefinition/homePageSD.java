package StepDefinition;


import Pages.homePage;
import Setup.Base;
import Setup.GenericClass;
import Utils.screenshotManager;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;


public class homePageSD {
    public GenericClass genericClass;
    public homePage homePage;
    public screenshotManager screenshotManager;


    public homePageSD(GenericClass genericClass) {
        this.genericClass = genericClass;
        this.homePage = this.genericClass.POM.getHome_Page();


    }


    @When("User should be able to close all pop-ups")
    public void User_should_be_able_to_close_all_pop_ups() {
        homePage.clearPopups();


    }


    @And("User should be able to provide details to the required Fields")
    public void User_should_be_able_to_provide_details_to_the_required_Fields() {
        homePage.setLocationField("Coimbatore");
        homePage.setMedicineField("accu-check");
    }
}

