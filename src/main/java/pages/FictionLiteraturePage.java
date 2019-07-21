package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FictionLiteraturePage extends ParentPage {
    @FindBy(xpath = ".//ul[@class='catalog__menu-list bx_sitemap_ul']/li[@id='bx_1847241719_544']")
    private WebElement horrorsBooks;

    public  FictionLiteraturePage(WebDriver webDriver){
        super(webDriver,"/catalog/khudozhnya-literatura/");
    }

    public void clickOnHorrorsBooks(){
        this.actionWithElements.clickOnElement(this.horrorsBooks);
    }




}
