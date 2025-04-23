
package runner.ecommerce.parallel;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("definition.steps")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value ="src/test/resources/SearchItems.feature")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value ="definition.steps")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value ="@edge and @remote")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value ="false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value ="pretty, html:target/cucumber-report/cucumber.html, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")

public class EdgeRemoteRunner {

}