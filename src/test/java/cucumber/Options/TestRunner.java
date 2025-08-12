package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",plugin ="json:target/jsonReports/cucumber-report.json",glue= {"stepDefinations"})
public class TestRunner {
//tags= {"@DeletePlace"}  compile test verify
}
//run and get all stepdefinations steps 


// if we have more feature file - we just have to add features="src/test/java/features/placeValidations
// to get reports plugin ="json:target/jsonReports/cucumber-report.json"