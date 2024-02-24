package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json","rerun:target/return.txt"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@FOX-1",
        dryRun = false,  // it will run unimplemented steps ,change  to true (to get snipped codes) or false
        publish=true
)



public class Runner {
}
