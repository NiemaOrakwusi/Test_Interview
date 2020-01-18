package UI.Pages;

import UI.BaseObject.BaseSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends BaseSetUp {


    @FindBy(id = "users")
    WebElement userBtn;

    @FindBy(id = "user_username")
    WebElement userName;

    @FindBy(id = "user_password")
    WebElement userPassword;

    @FindBy(id = "user_email")
    WebElement userEmail;

    @FindBy(name = "commit")
    WebElement userSubmit;

    @FindBy(id = "page_title")
    WebElement pageLogo;


    public AddUserPage() {
        PageFactory.initElements(dr, this);
    }

    public String validatePageTitle() {
        return dr.getTitle();
    }


    public void UserClick(){
        userBtn.click();
    }

    public boolean validateTitlePage() {
        return pageLogo.isDisplayed();
    }

    public void UserInfo(String un, String pwd) {
        userName.sendKeys(un);
        userPassword.sendKeys(pwd);
        userSubmit.click();

    }

}
