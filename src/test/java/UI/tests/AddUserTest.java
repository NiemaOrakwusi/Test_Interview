/*Created Jan 18, 2020
 Author: Dr. Niema C. Orakwusi, MISM
 - Test will create a new user and validate the new user -
 */
package UI.tests;

import UI.BaseObject.BaseSetUp;
import UI.Pages.AddUserPage;
import UI.Pages.HomePage;
import UI.Pages.UserDetailPage;
import UI.Pages.UserPageHome;
import UI.Report.Listener;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

@Listeners(Listener.class)
public class AddUserTest extends BaseSetUp  {
    AddUserPage addUserPage;
    HomePage homePage;
    UserPageHome userPageHome;
    UserDetailPage userDetailPage;


  public AddUserTest() {
       super();
    } // End of Object

    @BeforeMethod
    public void setUp() {
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

    @Test
    public void AddUserTest() throws InterruptedException {

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
        userPageHome.UserPageHomeNewClick();
        Reporter.log("Click New User");
        String titleAddUser = addUserPage.validatePageTitle();
        Assert.assertEquals(titleAddUser, "New User | Active Admin Depot");
        Reporter.log("Validate Add User Title");
        addUserPage.validateNewUserLogo();
        Reporter.log("Validate Logo is Displayed");
        addUserPage.UserInfo(pro.getProperty("name"), pro.getProperty("password"), pro.getProperty("email"));
        Reporter.log("Enter Info");
        String titleNewUser = userDetailPage.validateNewUserDetailTitle();
        Assert.assertEquals(titleNewUser, pro.getProperty("name"));
        Reporter.log("Validate User Name Detail Title");
        String titleUserName = userDetailPage.validateNewUserName();
        Assert.assertEquals(titleUserName, pro.getProperty("name"));
        Reporter.log("Validate User Info Panel Name");
        String titleUserEmail = userDetailPage.validateNewUseEmail();
        Assert.assertEquals(titleUserEmail, pro.getProperty("email"));
        Reporter.log("Validate Email Info Panel Email");
    }
} // End of Class
