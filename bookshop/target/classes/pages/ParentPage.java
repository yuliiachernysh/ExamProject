package pages;

import libs.ActionWithElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.regex.Pattern;

public abstract class ParentPage{
    WebDriver webDriver;
    ActionWithElements actionWithElements;

    Logger logger=Logger.getLogger(getClass());


    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);
    String baseURL;
    String expectedURL;


    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;
        baseURL = configProperties.base_url();
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)), this);
        actionWithElements = new ActionWithElements(webDriver);
        expectedURL = baseURL + partUrl;
    }

    public void checkCurrentUrl(){
        try{
            logger.info(expectedURL);
            logger.info(webDriver.getCurrentUrl());
            Assert.assertEquals("URL is not expected", Pattern.matches(expectedURL,webDriver.getCurrentUrl()), true);
        } catch (Exception e){
            logger.error("Can not get URL" + e);
            Assert.fail("Can not get URL");
        }
    }
}
