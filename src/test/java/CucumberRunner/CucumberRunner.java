package CucumberRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/FeatureFile", glue = "StepDefinition",
        monochrome = true, plugin = {"html:target/cucumberReports/report.html"})
public class CucumberRunner extends AbstractTestNGCucumberTests{


}

