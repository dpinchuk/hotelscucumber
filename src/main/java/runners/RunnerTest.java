package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepdefinitions"},
        tags = {"@hotel_search"},
        //dryRun = false,
        //strict = false,
        snippets = SnippetType.CAMELCASE
        //name = "^Успешное|Успешная.*"
)

public class RunnerTest {
}