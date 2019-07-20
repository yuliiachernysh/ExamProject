package registrationTest;

import libs.Utils;
import org.junit.Test;
import parentTest.ParentTest;

public class PositiveRegistrationTest extends ParentTest {
    final String name = "Yuliia"+ Utils.getDateAndTimeFormated();
    final String email ="chernysh1993+"+Utils.getDateAndTimeFormated()+"@gamil.com";
    final String pass = "passsword";

    @Test
    public void PositiveRegistrationTest(){
        startPage.openPage();
        startPage.checkIsLogoDisplayed();
        startPage.isLogoPresent();

        registrationPage.clickOnEnterence();
        registrationPage.clickOnRegistaration();
        registrationPage.EnterNameToTheRegField(name);
        registrationPage.EnterEmailToTheField(email);
        registrationPage.EnterPassToTheRegField(pass);
        registrationPage.ClickOnConfirmationButton();
        registrationPage.ClickOnButtonRegistrate();

        checkExpectedResult("Registration window should be closed", true, registrationPage.RegFormIsDispalyed());
    }


}
