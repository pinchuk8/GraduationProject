import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"@target/rerun.txt"},
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty",
                "rerun:target/rerun.txt"},
        glue = "steps"
)

public class FailedRun extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
