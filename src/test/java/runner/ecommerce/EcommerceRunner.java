package runner.ecommerce;

import org.junit.platform.suite.api.*;
import io.cucumber.junit.platform.engine.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("definition.steps")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value ="src/test/resources/SearchItems.feature")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value ="definition.steps")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value ="@kids")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value ="false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value ="pretty, html:target/cucumber-report/cucumber.html")

public class EcommerceRunner {

}
