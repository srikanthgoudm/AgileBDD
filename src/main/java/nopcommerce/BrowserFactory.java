package nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Srikanth on 07/06/2015.
 */
public class BrowserFactory extends BasePage {
    public static WebDriver startBrowser(String Browser, String URL1) throws MalformedURLException, InterruptedException {
        if (driver == null || !isSessionActive()) {
            driver = startRemoteWebBrowser(Browser, URL1);
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static boolean isSessionActive() {
        try {

            return driver.findElements(By.tagName("body")).size() > 0;

        } catch (Exception e) {

        }
        return false;
    }


    public static void QuitBrowser() {
        getDriver().quit();
    }

    protected static WebDriver startRemoteWebBrowser(String browser, String URL1) {

        //Switch to on or off the selenium grid
        if (true) {
            try {

                System.out.println("grid started...");
//                 Selenium grid when accessed locally or form from Jenkins
//                DesiredCapabilities caps=DesiredCapabilities.firefox();
//                caps.setCapability("platform", Platform.VISTA);
//                caps.setCapability("version", "");

                //create desired capabilities object
                DesiredCapabilities caps = new DesiredCapabilities();
                //set capabilities (platform,browser and version)
                caps.setPlatform(Platform.VISTA);
                caps.setBrowserName("firefox");
                caps.setVersion("");
//                 Selenium grid URL
                driver = new RemoteWebDriver(new URL(LoadProps.getProperty("selgrid")), caps);
//                 Selenium grid on cloud (sauce labs) when accessed locally or from Jenkins
                // Create the connection to Sauce Labs to run the tests
//                DesiredCapabilities caps = DesiredCapabilities.firefox();
//                caps.setCapability("platform", Platform.WIN8_1);
//                caps.setCapability("version", "30.0");
//               SAUCE LABS URL   (Give your sauce labs grid link here)
//                driver=new RemoteWebDriver(new URL("http://kmadhu699:87624cd1-ca58-4b46-8452-4014c2bfe8dc@ondemand.saucelabs.com:80/wd/hub"),caps);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            try {
                if (browser.equalsIgnoreCase("Firefox")) {
                    FirefoxProfile firefoxprofile = new FirefoxProfile();
                    firefoxprofile.setAssumeUntrustedCertificateIssuer(true);
                    firefoxprofile.setAcceptUntrustedCertificates(true);
                    driver = new FirefoxDriver(firefoxprofile);
                } else if (browser.equalsIgnoreCase("Chrome")) {
                    System.setProperty("webdriver.chrome.driver", "src\\test\\BrowserFiles\\chromedriver.exe");
                    driver = new ChromeDriver();

                } else if (browser.equalsIgnoreCase("IE")) {
                    System.setProperty("webdriver.ie.driver", "C:\\Automation\\IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                } else if (browser.equalsIgnoreCase("Safari")) {
                    driver = new SafariDriver();
                } else {
                    throw new RuntimeException("Browser give " + browser + " did not load..");
                }
            } catch (Exception e) {
                throw new RuntimeException("Browser give " + browser + " did not load..");
            }
        }
        driver.get(URL1);
        return driver;
    }

}
