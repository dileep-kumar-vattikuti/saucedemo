package Testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:/Users/LENOVO/eclipse-workspace/saucedemo/src/test/resources/"
		,glue = "C:/Users/LENOVO/eclipse-workspace/saucedemo/src/test/java/stepdef/"
		,dryRun = true
		,monochrome = true
		,tags= "@login,@valid")

public class Testrunner {

}
