package UI.Pages;

import UI.BaseObject.BaseSetUp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPageHome extends BaseSetUp {


    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/span/a")
    WebElement newUserBtn;

    @FindBy(id = "page_title")
    WebElement pageLogo;


    public UserPageHome() {
        PageFactory.initElements(dr, this);
    }

    public String validatePageTitle() {
        return dr.getTitle();
    }
    public void UserClick(){
        newUserBtn.click();
    }

    public boolean validateTitlePage() {
        return pageLogo.isDisplayed();
    }
}
