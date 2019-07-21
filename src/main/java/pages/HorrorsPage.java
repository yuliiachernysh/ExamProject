package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HorrorsPage extends ParentPage {

    @FindBy(xpath = ".//input[@id='title-search-input']")
    private WebElement searchLine;

    @FindBy(xpath = ".//input[@class='header__search-submit']")
    private WebElement searchButton;

    @FindBy(xpath = ".//a[@class='button product__btn']")
    private WebElement buyButton;

    @FindBy(xpath = ".//a[@class='modal-content__btn-secondary btn--broad btn--active pull-right button']")
    private WebElement confirmOrderButton;

    public HorrorsPage(WebDriver webDriver){
        super(webDriver, "/catalog/zhakhy-trylery/");
    }

    public void searchOnThePage(String nameOfBook){
        this.actionWithElements.enterTextIntoInput(this.searchLine, nameOfBook);
    }

    public void clickOnearchButton(){this.actionWithElements.clickOnElement(this.searchButton);}

    public boolean isSearchedBookPresent(){
        //WebDriverWait wait= new WebDriverWait(webDriver, 5);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='bx_3966226736_68690']")));
        return this.actionWithElements.isElementDispalyed(".//div[@id='bx_3966226736_68690']");
    }

    public boolean isModalOrderWindowPresent(){
        WebDriverWait wait= new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='modal-content modal-content--padding']")));
        return this.actionWithElements.isElementDispalyed(".//div[@class='modal-content modal-content--padding']");
    }

    public void isSearchedBookDisplayed(){
        Assert.assertTrue("Book is not displayed", this.isSearchedBookPresent());

    }

    public void isModalOrderWindowDisplayed(){
        Assert.assertTrue("Order`s window is not displayed", this.isModalOrderWindowPresent());

    }

    public void clickToBuy(){this.actionWithElements.clickOnElement(this.buyButton);}

    public void clickToConfirmOrder(){this.actionWithElements.clickOnElement(this.confirmOrderButton);}





}
