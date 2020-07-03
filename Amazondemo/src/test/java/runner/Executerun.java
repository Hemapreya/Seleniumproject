package runner;



import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java"
,glue= {"stepdefinition"}
)

public class Executerun {

}
