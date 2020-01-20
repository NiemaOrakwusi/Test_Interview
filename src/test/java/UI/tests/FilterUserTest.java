/*
 Author: Dr. Niema C. Orakwusi
Created: January 18, 2020
This is a Maven, Testng, Rest Assured Api Testing Framework
Description : This project will test an api GET, POST, PUT
as well as from the UI Create a new User and Filter for that user

 */
package UI.tests;

import UI.BaseObject.BaseSetUp;
import UI.Pages.AddUserPage;
import UI.Pages.HomePage;
import UI.Pages.UserDetailPage;
import UI.Pages.UserPageHome;
import Utils.Listeners.Listener;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.Integer.parseInt;

//This test performs a search for the newly created user within the config.properties
@Listeners(Listener.class)
public class FilterUserTest extends BaseSetUp {

    AddUserPage addUserPage;
    HomePage homePage;
    UserPageHome userPageHome;
    UserDetailPage userDetailPage;
    DateTimeFormatter dsa = DateTimeFormatter.ofPattern("YYYYMMDD");
    LocalDate dt1 = LocalDate.now();
    String dts = dt1.minusDays(10).toString();
    LocalDate dt2 = LocalDate.now();
    String dtg = dt2.plusDays(2).toString();



    public FilterUserTest() {
        super();
    } // End of Object

    @BeforeMethod
    public void setUp() throws InterruptedException {
        init();
        addUserPage = new AddUserPage();
        homePage = new HomePage();
        userPageHome = new UserPageHome();
        userDetailPage = new UserDetailPage();

    } // End of Setup

    @AfterMethod
    //End the Suite
    public void tearDown() {
        if(null != dr) {
            dr.quit();
            dr = null;
        }
    }

    @Test(description = "Search for New Created User on User Page")
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
        userPageHome.UserInfo( pro.getProperty("name"), pro.getProperty("email"),dts, dtg);
        Reporter.log("Enter Filter Details and Dates");
        String NewUser = userPageHome.validateResultsUN();
        Assert.assertEquals(NewUser, pro.getProperty("name"));
        Reporter.log("Validate UserName");
        String NewEmail = userPageHome.validateResultsEmail();
        Assert.assertEquals(NewEmail, pro.getProperty("email"));
        Reporter.log("Validate Email");

    }

}
