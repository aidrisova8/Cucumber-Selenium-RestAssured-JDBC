package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json","rerun:target/return.txt"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@PTB-2",
        dryRun = false, // it will run unimplemented steps ,change  to true or false
        publish=true
)



public class Runner {
}
