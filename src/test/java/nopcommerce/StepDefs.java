package nopcommerce;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Srikanth on 23/01/2015.
 */
public class StepDefs {

//    public static WebDriver driver;
     static WebDriver driver = BrowserFactory.getDriver();

    @Before
    public void startBrowser() throws MalformedURLException, InterruptedException {
        BrowserFactory.startBrowser(LoadProps.getProperty("browser"),LoadProps.getProperty("URL"));
        driver = BrowserFactory.driver;
//        driver=new FirefoxDriver();
//        driver.get("http://srikanthgoudm99-001-site1.smarterasp.net/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void stopBrowser()
    {
        driver.quit();
    }

    @Given("^user is on the '(.*)'$")
    public void verifyUserisOnHomePage(String homepage){

        Assert.assertTrue(this.isLinkTextPresent(homepage));
        Assert.assertTrue(driver.findElement(By.linkText("Log in")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("newsletter-subscribe-button")).isDisplayed());
    }

    @Then("^user should see '(.*)' header on the home page$")
    public void verifyUserCanSeeCategories(String categoryHeader){
        Assert.assertTrue(driver.findElement(By.xpath("dummylocator1")).getText().contains(categoryHeader));
    }

    @Then("^User should see the categories list as below$")
    public void verifyUserCanSeeCategories(DataTable arg1){
        List<String> catlist = Arrays.asList("Books", "Computers", "Electronics", "Apparel & Shoes", "Digital downloads", "Jewelry", "Gift Cards");

        for(int i=0;i>=catlist.size();i++)
        {
            Assert.assertTrue(driver.findElement(By.linkText(catlist.get(i))).isDisplayed());
            driver.findElement(By.linkText(catlist.get(i))).isEnabled();
        }

    }
    public static boolean isLinkTextPresent(String text)
    {
        return driver.findElement(By.linkText(text)).isDisplayed();
    }

    @Given("^User is on Homepage$")
    public void User_is_on_Homepage() {

    }

    @When("^he selects a \"([^\"]*)\" and \"([^\"]*)\"$")
    public void he_selects_a(String category,String subCategory) {
        driver.findElement(By.linkText(category)).click();
        if(!subCategory.equals(""))
        {
            driver.findElement(By.linkText(subCategory)).click();
        }
    }

    @Then("^he should be navigated to selected category page with header \"([^\"]*)\" or \"([^\"]*)\"$")
    public void he_should_be_navigated_to_selected_category_page(String category,String subCategory) {

        String expHeader;
        if(subCategory.equals(""))
            expHeader = category;
        else
            expHeader = subCategory;

        Assert.assertEquals("Checking the category header ",expHeader,driver.findElement(By.className("page-title")).getText());
    }

    @Then("^should have an option to apply the filter as \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void should_have_an_option_to_apply_the_filter_as_and(String arg1, String arg2, String arg3) {

        Assert.assertTrue("checking the option to order by ",driver.findElement(By.id("products-orderby")).isDisplayed());

        Assert.assertTrue("checking the option to change page size", driver.findElement(By.id("products-pagesize")).isDisplayed());

        Assert.assertTrue("checking the option to change view mode", driver.findElement(By.id("products-viewmode")).isDisplayed());
    }
}
