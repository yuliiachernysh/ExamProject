package catalogTest;

import org.junit.Test;
import parentTest.ParentTest;

public class CatalogTest extends ParentTest {

    @Test
    public void CatalogTest(){
        startPage.openPage();
        startPage.checkCurrentUrl();

        catalogPage.clickOnGeneralCatalog();
        catalogPage.clickOnNonfictionSection();
        catalogPage.checkCurrentUrl();

        legalLiteraturePage.clikOnLegalLiteraturePage();
        legalLiteraturePage.checkCurrentUrl();


        constitutionalRighPage.clickOnConstitutionalRight();
        constitutionalRighPage.checkCurrentUrl();
        constitutionalRighPage.sortPriceToLower();
        constitutionalRighPage.chooseUkrainianLanguage();

        checkExpectedResult("Test book is not displayed", true, constitutionalRighPage.isTestBookPresent());




    }
}
