package UI.Pages;

import UI.BaseObject.BaseSetUp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends BaseSetUp {

    @FindBy(id = "users")
    WebElement userBtn;

    @FindBy(id = "page_title")
    WebElement pageLogo;


    public HomePage() {
        PageFactory.initElements(dr, this);
    }

    public String validateHomePageTitle() {
        return dr.getTitle();
    }

    public void homePageUserClick(){
        userBtn.click();
    }

    public boolean homePageLogo() {
        return pageLogo.isDisplayed();

    }


}
