package UI.tests;

import UI.BaseObject.BaseSetUp;
import UI.Pages.AddUserPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestProject extends BaseSetUp {
    AddUserPage addUserPage;

  public TestProject() {
       super();
    }

    @BeforeSuite
    public void setUp() {
        init();
        addUserPage = new AddUserPage();
    }

    @Test
    public void AddUserTest() {
        String titlePageName = addUserPage.validatePageTitle();
        Assert.assertEquals(titlePageName, "Dashboard | Active Admin Depot");

        boolean flg = addUserPage.validateTitlePage();
        Assert.assertTrue(flg);

        addUserPage.UserClick();

    }



    @AfterSuite
    public void tearDown() {
        if(null != dr) {
            dr.quit();
            dr = null;
        }
    }



}
