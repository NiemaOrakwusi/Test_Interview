/* Author: Dr. Niema C. Orakwusi
Created: January 18, 2020
This is a Maven, Testng, Rest Assured Api Testing Framework
Description : This project will test an api GET, POST, PUT
as well as from the UI Create a new User and Filter for that user
 */

package UI.BaseObject;

import UI.TestUtil.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class BaseSetUp {


    public static WebDriver dr;
    public static Properties pro;

    //Base Method to setup the config properties within the application
    public BaseSetUp() {
        try {

            InputStream fl = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/UI/config/config.properties");
            pro = new Properties();
            pro.load(fl);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Before each Suite this method will
    detemine the OS and provide the drivers
    base on the config.properties details.
     */
    @BeforeSuite
    public static void init() {
        String bwrName = pro.getProperty("browser");
        String OSNOW = pro.getProperty("PlatformType");

        if (bwrName != null)
            switch (OSNOW) {
                case "IOS":

                    if (bwrName.equals("chrome")) {

                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/driver-mac/chromedriver");
                        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("start-maximized"); // open Browser in maximized mode
                        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

                        dr = new ChromeDriver();

                        dr.manage().window().maximize();
                        dr.manage().deleteAllCookies();
                        dr.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
                        dr.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
                        dr.get(pro.getProperty("url"));


                    }
                    else { //FF
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers-mac/gecko");
                    dr = new FirefoxDriver();

                    dr.manage().window().maximize();
                    dr.manage().deleteAllCookies();
                    dr.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
                    dr.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
                    dr.get(pro.getProperty("url"));
                }
                break;
                case "windows":

                    if (bwrName.equals("chrome")) {

                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers-windows/chromedriver.exe");
                        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("start-maximized"); // open Browser in maximized mode
                        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

                        dr = new ChromeDriver();
                        dr.manage().window().maximize();
                        dr.manage().deleteAllCookies();
                        dr.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
                        dr.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
                        dr.get(pro.getProperty("url"));


                    }
                    else { // FF
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers-windows/gecko.exe");
                    dr = new FirefoxDriver();
                        dr.manage().window().maximize();
                        dr.manage().deleteAllCookies();
                        dr.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
                        dr.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
                        dr.get(pro.getProperty("url"));
                }
                break;
            }
    }

    //Return Driver for Retry Listener
    public WebDriver getDriver() {

        return dr;
    }
}
