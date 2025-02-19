package UI.Pages;

import UI.BaseObject.BaseSetUp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDetailPage extends BaseSetUp {

    @FindBy(xpath = "/html/body/div/div[4]/div[2]/div[1]/div/div/table/tbody/tr[1]/td")
    WebElement newUserLabel;

    @FindBy(xpath = "/html/body/div/div[4]/div[2]/div[1]/div/div/table/tbody/tr[2]/td")
    WebElement newEmailLabel;

    @FindBy(id = "users")
    WebElement userBtn;

    @FindBy(id = "page_title")
    WebElement pageLogo;


    public UserDetailPage() {
        PageFactory.initElements(dr, this);
    }

    public String validateNewUserDetailTitle() {
        return pageLogo.getText();

    }

    public void UserDetailClick(){
        userBtn.click();
    }

    public boolean validateTitleLogo() {
        return pageLogo.isDisplayed();
    }

    public String validateNewUserName(){
        return newUserLabel.getText();
    }

    public String validateNewUseEmail(){
        return newEmailLabel.getText();
    }
}
