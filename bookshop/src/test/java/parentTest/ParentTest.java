package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected StartPage startPage;
    protected RegistrationPage registrationPage;
    protected FeedbackPage feedbackPage;
    protected CatalogPage catalogPage;
    protected LegalLiteraturePage legalLiteraturePage;
    protected ConstitutionalRighPage constitutionalRighPage;

    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        startPage = new StartPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        feedbackPage = new FeedbackPage(webDriver);
        catalogPage = new CatalogPage(webDriver);
        legalLiteraturePage = new LegalLiteraturePage(webDriver);
        constitutionalRighPage = new ConstitutionalRighPage(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    public void checkExpectedResult(String message,boolean expectedResult, boolean actualResult){
        Assert.assertEquals(message, expectedResult, actualResult);
    }

}
