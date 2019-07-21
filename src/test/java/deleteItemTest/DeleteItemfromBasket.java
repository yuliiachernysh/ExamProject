package deleteItemTest;

import org.junit.Test;
import parentTest.ParentTest;

public class DeleteItemfromBasket extends ParentTest {
    final String nameOfBook = "Дівчина, яку ми вбили";

    @Test
    public void DeleteItemfromBasket(){
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
        basketPage.deleteItemFromBasket();
        basketPage.checkCurrentUrl();

        checkExpectedResult("Item is present on the basket", false, horrorsPage.isSearchedBookPresent());



    }
}
