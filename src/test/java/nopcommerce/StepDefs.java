package nopcommerce;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.table.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Srikanth on 23/01/2015.
 */
public class StepDefs {
    public static WebDriver driver;
    @Before
    public void startBrowser()
    {
        driver=new FirefoxDriver();
        driver.get("http://srikanthgoudm99-001-site1.smarterasp.net/");
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
}
