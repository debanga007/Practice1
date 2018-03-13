package RunnerClass;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="feature"
					,glue={"stepDefinitions"}
					,plugin={"pretty","html:target/htmlreport",
							"json:target/jsonreport/cuc1.json",
							"junit:target/xmlreport/cuc2.xml",
							"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent-report/report.html"}
					,tags={"@regression"})

public class TestRunner 
{
	@AfterClass
	public static void reportsetup()
	{
		Reporter.loadXMLConfig(new File("/PracticeProject/extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10 64 bit");
		Reporter.setSystemInfo("Selenium", "2.53");
		Reporter.setSystemInfo("Java version", "1.8");
		Reporter.setTestRunnerOutput("Cucumber Test Runner");
	}

}
