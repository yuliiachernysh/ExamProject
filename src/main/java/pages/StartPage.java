package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends ParentPage {

    @FindBy(xpath = ".//*[@class='header__logo-link']")
    private WebElement logo;


    public StartPage(WebDriver webDriver){
        super(webDriver, "/");

    }

    public void openPage() {
        try {
            this.webDriver.get("https://book-ye.com.ua");
            this.logger.info("Start page was opened");
        } catch (Exception var2) {
            this.logger.error("Unexpected problem. Cann`t open page");
            Assert.fail("Unexpected problem. Cann`t open page");
        }

    }


    public boolean isLogoPresent(){
        return this.actionWithElements.isElementDispalyed(this.logo);
    }

    public void checkIsLogoDisplayed(){
        Assert.assertTrue("Logo is not displayed", this.isLogoPresent());
    }




}
