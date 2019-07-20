package registrationTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class NegativeRegistrationTest extends ParentTest {
    String name, email, pass;

    public NegativeRegistrationTest(String name, String email, String pass){
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    @Parameterized.Parameters()
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Yuliia", "", ""}
                //{"Yuliia", "chernysh1993+test1@gmail.com",""},
                //{"", "chernysh1993+test1@gmail.com","password"}
        });
    }


    @Test
    public void negativeRegistration(){
        startPage.openPage();
        startPage.checkIsLogoDisplayed();
        startPage.isLogoPresent();

        registrationPage.clickOnEnterence();
        registrationPage.clickOnRegistaration();
        registrationPage.EnterNameToTheRegField(name);
        registrationPage.EnterEmailToTheField(email);
        registrationPage.EnterPassToTheRegField(pass);
        //registrationPage.ClickOnConfirmationButton();
        registrationPage.ClickOnButtonRegistrate();

        checkExpectedResult("Registration window should not be closed", false, registrationPage.RegFormIsDispalyed());
    }


}
