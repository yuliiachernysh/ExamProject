package addingToBasket;

import org.junit.Test;
import parentTest.ParentTest;

public class NewItemOnBasketTest extends ParentTest {

    final String nameOfBook = "Дівчина, яку ми вбили";



    @Test
    public void NewItemAdd(){
        startPage.openPage();
        startPage.checkCurrentUrl();

        catalogPage.clickOnGeneralCatalog();
        catalogPage.clickOnFictionSection();
        fictionLiteraturePage.checkCurrentUrl();
        fictionLiteraturePage.clickOnHorrorsBooks();

        horrorsPage.checkCurrentUrl();
        horrorsPage.searchOnThePage(nameOfBook);
        horrorsPage.clickOnearchButton();
        horrorsPage.isSearchedBookDisplayed();
        horrorsPage.clickToBuy();
        horrorsPage.isModalOrderWindowDisplayed();
        horrorsPage.clickToConfirmOrder();

        basketPage.checkCurrentUrl();
        basketPage.isAllPageElementsDisplayed();

        checkExpectedResult("Button is enabled", false, basketPage.isButtonBuyEnabled());







    }
}
