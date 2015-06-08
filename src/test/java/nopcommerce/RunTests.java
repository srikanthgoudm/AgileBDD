package nopcommerce;


import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Srikanth on 23/01/2015.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(format = {"html:target/CucumberReports"},tags="@fil")
public class RunTests {
}
