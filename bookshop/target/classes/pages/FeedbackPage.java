package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeedbackPage extends ParentPage {

    @FindBy(xpath = ".//a[@data-target='#feedback-form']")
    private WebElement feedbackLink;

    @FindBy(xpath=".//p[text()=\"Форма зворотнього зв’язку\"]")
    private WebElement feedbackModalWindow;

    @FindBy(xpath =".//form[@class='form js-callback-form']//input[@name='name']")// ".//input[@class='input form__input required']"
    private WebElement customerName;

    @FindBy(xpath = ".//form[@class='form js-callback-form']//input[@name='email']")
    private WebElement customerEmail;

    @FindBy(xpath = ".//form[@class='form js-callback-form']/textarea[@name='textteria']")
    private WebElement textMessage;

    @FindBy(xpath = ".//form[@class='form js-callback-form']/button[@class='button form__btn']")
    private WebElement sendFeedback;

    public FeedbackPage(WebDriver webDriver){
        super(webDriver, "/");
    }

    public void clickOnFeedbackLink(){
        this.actionWithElements.clickOnElement(this.feedbackLink);

    }

    public boolean isFeedbackModalWindowPresent(){
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='feedback-form']/div[@class='modal-dialog modal-dialog--big']")));
        return this.actionWithElements.isElementDispalyed(".//div[@id='feedback-form']/div[@class='modal-dialog modal-dialog--big']");
    }


    public boolean isPostFeedbackModalWindowPresent(){
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//form[@class='form js-callback-form']")));
        return this.actionWithElements.isElementDispalyed(".//form[@class='form js-callback-form']");
    }

    public void checkIsFeedbackModalWindowDisplayed(){
        Assert.assertTrue("Modal window with feedback form is not displayed", this.isFeedbackModalWindowPresent());
    }



    public void selectReasonOfFeedback(){
        Select select = new Select(webDriver.findElement(By.xpath(".//form[@class='form js-callback-form']/div/div/span/select[@name='reason']")));
        select.selectByValue("15431");
    }

    public void fillName(String name){
        this.actionWithElements.enterTextIntoInput(this.customerName, name);
    }

    public void fillEmail(String email){
        this.actionWithElements.enterTextIntoInput(this.customerEmail, email);
    }

    public void fillTextMessage(String textOfFeedback){
        this.actionWithElements.enterTextIntoInput(this.textMessage, textOfFeedback);
    }

    public void clickOnSendFeedbackButton(){
        this.actionWithElements.clickOnElement(this.sendFeedback);
    }

    public void checkIsFeedbackModalWindowClosed(){
        Assert.assertTrue("Modal window with feedback form should be displayed", this.isPostFeedbackModalWindowPresent());
    }



}
