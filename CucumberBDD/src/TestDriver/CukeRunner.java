package TestDriver;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"Features"},
	glue = {"stepDefinitions"},
	tags= "@tag1"
)

public class CukeRunner {
	
}
