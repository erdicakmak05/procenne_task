package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"json:target/cucumber-test.json", "pretty","html:target/cucumber-reports-test.html"},
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@ts_002",
        dryRun = false
)
public class Runner {

}
