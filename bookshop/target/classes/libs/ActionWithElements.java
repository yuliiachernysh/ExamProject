package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionWithElements {

    WebDriver webDriver;
    Logger logger=Logger.getLogger(getClass());
    WebDriverWait wait10, wait15;


    public ActionWithElements(WebDriver webDriver) {

        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 10);
        wait15 = new WebDriverWait(webDriver, 15);
    }


    public boolean isElementDispalyed(WebElement element) {

        try{
            return element.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean isElementDispalyed(String locator) {
        try{
            return isElementDispalyed(webDriver.findElement(By.xpath(locator)));

        }catch(Exception e){
            return false;
        }
    }

    public void clickOnElement(WebElement webElement) {
        try{
            wait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");

        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }

    public void clickOnElement(String locator){
        try{
            clickOnElement(webDriver.findElement(
                    By.xpath(locator)));
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void enterTextIntoInput(WebElement element, String text){
        try{

            element.clear();
            element.sendKeys(text);
            logger.info(text + "was inputted into input");
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }

    public void changeCheckboxState(String locator, boolean select){
        WebElement element = webDriver.findElement(By.xpath(locator));
        changeCheckboxState(element, select);
    }

    public void changeCheckboxState(WebElement locator, boolean select){
        if(select){
            if(!locator.isSelected()){
                clickOnElement(locator);
            }
        }else{
            if(locator.isSelected()){
                clickOnElement(locator);
            }
        }
    }






}
