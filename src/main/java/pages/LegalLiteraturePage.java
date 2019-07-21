package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LegalLiteraturePage extends ParentPage {

    @FindBy(xpath = ".//ul[@class='catalog__menu-list bx_sitemap_ul']/li[@id='bx_1847241719_484']")
    private WebElement legalLiterature;

    public LegalLiteraturePage(WebDriver webDriver){
        super(webDriver, "/catalog/yurydychna-literatura/");
    }


    public void clikOnLegalLiteraturePage(){
        this.actionWithElements.clickOnElement(this.legalLiterature);
    }



}
