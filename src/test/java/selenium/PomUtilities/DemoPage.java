package selenium.PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage {
    WebDriver driver;
    public DemoPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //declare 
    @FindBy(id="small-searchterms")
    private WebElement stf;

    @FindBy(css="[value='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[text()='Register']")
    private WebElement register;

    @FindBy(id = "FirstName")
    private WebElement fn;

    @FindBy(xpath = "//a[text()='Log in']")
    private WebElement login;

    public void getSearchtf(String value)
    {
        stf.sendKeys(value);
    }
    public void getSearchButton()
    {
        searchButton.click();
    }
    public void getRegister()
    {
       register.click();
    }
    public void getFn(String value)
    {
        fn.sendKeys(value);
    }
    public void getLogin()
    {
        login.click();
    }
    //business logic 


}
