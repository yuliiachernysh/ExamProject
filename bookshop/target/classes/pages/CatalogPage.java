package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends ParentPage {

    @FindBy(xpath = ".//div[@class='header__catalog-wrap']")
    private WebElement generalCatalog;

    @FindBy(xpath = ".//ul[@class='ctlg-left__list']/li[@class='ctlg-left__item']/a[@data-section=\"373\"]")
    private WebElement nonFictionSection;

    public CatalogPage(WebDriver webDriver){
        super(webDriver, "/catalog/nekhudozhnya-literatura/");
    }

    public void clickOnGeneralCatalog(){
        this.actionWithElements.clickOnElement(this.generalCatalog);
    }

    public void clickOnNonfictionSection(){
        this.actionWithElements.clickOnElement(this.nonFictionSection);
    }




}
