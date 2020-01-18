package UI.Pages;

import UI.BaseObject.BaseSetUp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTestPage  extends BaseSetUp {

    @FindBy(xpath = "/html/body/div/div[4]/div[2]/div[1]/div/div/table/tbody/tr[1]/td")
    WebElement newUserLabel;

    @FindBy(xpath = "/html/body/div/div[4]/div[2]/div[1]/div/div/table/tbody/tr[2]/td")
    WebElement newEmailLabel;

    @FindBy(id = "users")
    WebElement userBtn;

    @FindBy(id = "page_title")
    WebElement pageLogo;


    public UserTestPage() {
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
}
