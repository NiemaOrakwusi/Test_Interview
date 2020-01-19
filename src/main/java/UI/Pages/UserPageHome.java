package UI.Pages;

import UI.BaseObject.BaseSetUp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;

public class UserPageHome extends BaseSetUp {


    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/span/a")
    WebElement newUserBtn;

    @FindBy(id = "page_title")
    WebElement pageLogo;

    @FindBy(id = "q_username")
    WebElement filterUN;

    @FindBy(id = "q_email")
    WebElement filterEmail;

    @FindBy(name = "commit")
    WebElement filterBtn;

    @FindBy(xpath = "/html/body/div/div[4]/div[1]/div/form/div[2]/div[1]/div/div/table/tbody/tr/td[3]")
    WebElement filterResultUN;

    @FindBy(xpath = "/html/body/div/div[4]/div[1]/div/form/div[2]/div[1]/div/div/table/tbody/tr/td[4]")
    WebElement getFilterResultEmail;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div[2]/div[1]/div/form/div[3]/input[1]")
    WebElement startDate;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div[2]/div[1]/div/form/div[3]/input[2]")
    WebElement endDate;




    public UserPageHome() {
        PageFactory.initElements(dr, this);
    }

    public String validateUserPageHomeTitle() {

        return dr.getTitle();
    }
    public void UserPageHomeNewClick(){

        newUserBtn.click();
    }

    public boolean validateUserPageLogo() {

        return pageLogo.isDisplayed();
    }

    public void UserInfo(String un, String em, String stDate, String edDate) {

        filterUN.sendKeys(un);
        filterEmail.sendKeys(em);
        startDate.sendKeys(stDate);
        endDate.sendKeys(edDate);
        filterBtn.click();

    }

    public String validateResultsUN() {
        return filterResultUN.getText();
    }
    public String validateResultsEmail() {
        return getFilterResultEmail.getText();
    }
}
