package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstitutionalRighPage extends ParentPage {
    @FindBy(xpath = ".//ul[@class='catalog__menu-list bx_sitemap_ul']/li[@id='bx_1847241719_491']")
    private WebElement constitutionalRigh;

    @FindBy(xpath = ".//form[@id='sorterForm']//div[@class='catalog-right__sorting-active']")
    private WebElement ddForSorting;

    @FindBy(xpath = ".//fieldset[@class='filter__fieldset ']/label[@for='arrFilter_79_1184059268']")
    private WebElement languageUkrainian;


    public  ConstitutionalRighPage(WebDriver webDriver){
        super(webDriver, "/catalog/konstytutsijne-pravo/");
    }

    public void clickOnConstitutionalRight(){
        this.actionWithElements.clickOnElement(this.constitutionalRigh);
    }


    public void sortPriceToLower(){
        this.actionWithElements.clickOnElement(this.ddForSorting);
        WebElement optionForSorting = this.webDriver.findElement(By.xpath(".//div[@class='catalog-right__sorting-drop active']/a[text()='Cпаданню ціни']"));
        this.actionWithElements.clickOnElement(optionForSorting);
    }

    public void chooseUkrainianLanguage(){
        this.actionWithElements.clickOnElement(this.languageUkrainian);
    }

    //let's assume that is test entity should be present in the sorting result
    public boolean isTestBookPresent(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='bx_3966226736_62849']")));
        return this.actionWithElements.isElementDispalyed(".//div[@id='bx_3966226736_62849']");
    }



}
