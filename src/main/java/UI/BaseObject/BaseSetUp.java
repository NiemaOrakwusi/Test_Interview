package UI.BaseObject;

import UI.TestUtil.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class BaseSetUp {

    public static WebDriver dr;
    public static Properties pro;


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


    @BeforeSuite
    public static void init()  {
        String bwrName = pro.getProperty("browser");

       if(bwrName.equals("chrome")) {

           System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chrome/chromedriver");
           DesiredCapabilities capabilities = DesiredCapabilities.chrome();
           capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

           ChromeOptions options = new ChromeOptions();
           options.addArguments("start-maximized"); // open Browser in maximized mode
           capabilities.setCapability(ChromeOptions.CAPABILITY, options);

           dr = new ChromeDriver();


        }
        else if (bwrName.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "//usr//local//bin//geckodriver");
            dr = new FirefoxDriver();
        }

        dr.manage().window().maximize();
        dr.manage().deleteAllCookies();
        dr.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME,  TimeUnit.SECONDS);
        dr.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,  TimeUnit.SECONDS);
        dr.get(pro.getProperty("url"));


    }


}
