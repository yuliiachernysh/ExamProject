package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends ParentPage{

    @FindBy(xpath = ".//a[@class='header-bottom__login header-bottom__link']")
    private WebElement enterenceButton;

    @FindBy(id = "register-modal")
    private WebElement regButton;

    @FindBy(name = "REGISTER[EMAIL]")
    private WebElement emailRegField;

    @FindBy(name="REGISTER[NAME]")
    private WebElement nameRegField;

    @FindBy(name="REGISTER[PASSWORD]")
    private WebElement passRegField;

    @FindBy(xpath = ".//input[@value='Зареєструватись']")
    private WebElement buttonReg;

    @FindBy(id="login-remember-check2")
    private WebElement confirmButton;

    @FindBy (id="register-modal")
    private WebElement regModalWindow;

    public RegistrationPage(WebDriver webDriver){
       super(webDriver, "/");
    }


    public void clickOnEnterence(){
        this.actionWithElements.clickOnElement( ".//a[@class='header-bottom__login header-bottom__link']");
    }


    public void clickOnRegistaration(){
        this.actionWithElements.clickOnElement(".//a[@class='auth-popup__bottom-link login-to-register']");
    }

    public void EnterNameToTheRegField(String name){
        this.actionWithElements.enterTextIntoInput(this.nameRegField, name);
    }

    public void EnterEmailToTheField(String email){
        this.actionWithElements.enterTextIntoInput(this.emailRegField, email);
    }

    public void EnterPassToTheRegField(String pass){
        this.actionWithElements.enterTextIntoInput(this.passRegField, pass);
    }

    public void ClickOnConfirmationButton(){
        this.actionWithElements.changeCheckboxState(".//input[@id='login-remember-check2']",true);
    }

    public void ClickOnButtonRegistrate(){
        this.actionWithElements.clickOnElement(".//input[@class='auth-popup__submit auth-popup__submit--reg button']");
    }

    public boolean RegFormIsDispalyed(){
       return this.actionWithElements.isElementDispalyed(this.regModalWindow);
    }





}
