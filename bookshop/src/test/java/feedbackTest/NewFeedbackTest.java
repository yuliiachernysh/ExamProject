package feedbackTest;

import libs.Utils;
import org.junit.Test;
import parentTest.ParentTest;

public class NewFeedbackTest extends ParentTest {

    final String name = "Yuliia"+ Utils.getDateAndTimeFormated();
    final String email ="chernysh1993+"+Utils.getDateAndTimeFormated()+"@gamil.com";
    final String textOfFeedback = "This is test";

    @Test
    public void NewFeedback(){
        startPage.openPage();
        startPage.checkCurrentUrl();

        feedbackPage.clickOnFeedbackLink();
        feedbackPage.checkIsFeedbackModalWindowDisplayed();
        feedbackPage.selectReasonOfFeedback();

        feedbackPage.fillName(name);
        feedbackPage.fillEmail(email);
        feedbackPage.fillTextMessage(textOfFeedback);
        feedbackPage.clickOnSendFeedbackButton();

        feedbackPage.checkIsFeedbackModalWindowClosed();
    }
}
