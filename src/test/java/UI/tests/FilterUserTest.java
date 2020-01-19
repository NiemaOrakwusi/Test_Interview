package UI.tests;

import UI.BaseObject.BaseSetUp;
import UI.Pages.AddUserPage;
import UI.Pages.HomePage;
import UI.Pages.UserDetailPage;
import UI.Pages.UserPageHome;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sun.tools.tree.NewArrayExpression;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FilterUserTest extends BaseSetUp {

    AddUserPage addUserPage;
    HomePage homePage;
    UserPageHome userPageHome;
    UserDetailPage userDetailPage;
    DateTimeFormatter dsa = DateTimeFormatter.ofPattern("YYYYMMDD");
    String dt1 = "20200115";
    LocalDate dt2 = LocalDate.now();



    public FilterUserTest() {
        super();
    } // End of Object

    @BeforeSuite
    public void setUp() throws InterruptedException {
        init();
        addUserPage = new AddUserPage();
        homePage = new HomePage();
        userPageHome = new UserPageHome();
        userDetailPage = new UserDetailPage();

    } // End of Setup

    @AfterSuite
    //End the Suite
    public void tearDown() {
        if(null != dr) {
            dr.quit();
            dr = null;
        }
    }

    @Test
    public void FilterUserTest() {

        String titlePageName = homePage.validateHomePageTitle();
        Assert.assertEquals(titlePageName, "Dashboard | Active Admin Depot");
        Reporter.log("Validate Home Title");
        homePage.homePageUserClick();
        Reporter.log("Click User");
        String titleUserDetail = userPageHome.validateUserPageHomeTitle();
        Assert.assertEquals(titleUserDetail, "Users | Active Admin Depot");
        Reporter.log("Validate User Title");
        userPageHome.validateUserPageLogo();
        Reporter.log("Validate Logo is displayed");
        userPageHome.UserInfo(pro.getProperty("name"), pro.getProperty("email"),  dsa.format(dt2).toString(), dt1  );
        Reporter.log("Enter Filter Details and Dates");
        String NewUser = userPageHome.validateResultsUN();
        Assert.assertEquals(NewUser, pro.getProperty("name"));
        Reporter.log("Validate UserName");
        String NewEmail = userPageHome.validateResultsEmail();
        Assert.assertEquals(NewEmail, pro.getProperty("email"));
        Reporter.log("Validate Email");

    }

}
