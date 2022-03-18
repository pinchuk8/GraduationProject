import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
//        retryCount = 3,
//        detailedReport = true,
//        detailedAggregatedReport = true,
//        overviewReport = true,
//        coverageReport = true,
//        jsonUsageReport = "target/cucumber-usage.json",
//        usageReport = true,
//        toPDF = true,
//        excludeCoverageTags = {"@flaky" },
//        includeCoverageTags = {"@passed" },
//        outputFolder = "target")
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = "steps"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
