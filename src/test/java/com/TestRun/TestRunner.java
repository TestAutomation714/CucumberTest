package com.TestRun;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
//Register ExtentReports adapter alongside your standard pretty/html plugins
@ConfigurationParameter(
 key = "cucumber.plugin", 
 value = "pretty, html:target/cucumber-reports.html, com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)
@ConfigurationParameter(key = "cucumber.glue", value = "com.StepDef, com.hooks") 
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.StepDef, com.hooks")
public class TestRunner {
    /* 
     * Keep this class completely blank! 
     * Threading, glue paths, and plugins are handled inside the properties file.
     * This prevents configurations from clashing during parallel execution.
     */
}
