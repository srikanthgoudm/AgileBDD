package nopcommerce;

import org.openqa.selenium.WebDriver;

/**
 * Created by Srikanth on 23/01/2015.
 */
public class BasePage {
   protected static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }
}
