package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends ParentPage {
    @FindBy(xpath = ".//div[contains (@class,'button button-buy')]")
    WebElement sendBuyRequestButton;

    @FindBy(xpath = ".//i[@class='products__delete icon-letter-x']")
    WebElement deleteItemFromBasketButton;

    public BasketPage(WebDriver webDriver){
        super(webDriver,"/personal/order/make/");
    }

public boolean isPageElementsPresent(){
        return this.actionWithElements.isElementDispalyed(".//input[@name='ORDER_PROP_30']")
                && this.actionWithElements.isElementDispalyed(".//input[@name='ORDER_PROP_31']")
                && this.actionWithElements.isElementDispalyed(".//input[@name='ORDER_PROP_2']")
                && this.actionWithElements.isElementDispalyed(".//input[@name='ORDER_PROP_3']")
                && this.actionWithElements.isElementDispalyed(".//input[@name='location_search']")
                && this.actionWithElements.isElementDispalyed(".//textarea[@name='ORDER_DESCRIPTION']")
                && this.actionWithElements.isElementDispalyed(".//label[@for='radio9']")
                && this.actionWithElements.isElementDispalyed(".//label[@for='radio13']")
                && this.actionWithElements.isElementDispalyed(".//label[@for='radio11']")
                && this.actionWithElements.isElementDispalyed(".//label[@for='ID_PAY_SYSTEM_ID_6']")
                && this.actionWithElements.isElementDispalyed(".//label[@for='ID_PAY_SYSTEM_ID_13']")
                && this.actionWithElements.isElementDispalyed(".//label[@for='ID_PAY_SYSTEM_ID_1']")
                && this.actionWithElements.isElementDispalyed(".//label[@for='ORDER_PROP_15']");

}

public void isAllPageElementsDisplayed(){
    Assert.assertTrue("Not All elements are displayed", this.isPageElementsPresent());
}

public boolean isButtonBuyEnabled(){
       return !this.actionWithElements.isElementDisabled(this.sendBuyRequestButton);
}

public void deleteItemFromBasket(){this.actionWithElements.clickOnElement(this.deleteItemFromBasketButton);}


}
