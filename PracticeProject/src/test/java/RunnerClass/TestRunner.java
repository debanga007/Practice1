package RunnerClass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="feature"
					,glue={"stepDefinitions"}
					,plugin={"pretty","html:target/htmlreport","json:target/jsonreport/cuc1.json","junit:target/xmlreport/cuc2.xml"}
					,tags={"@regression"})
public class TestRunner 
{

}
