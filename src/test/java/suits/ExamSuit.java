package suits;

import addingToBasket.NewItemOnBasketTest;
import catalogTest.CatalogTest;
import deleteItemTest.DeleteItemfromBasket;
import feedbackTest.NewFeedbackTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import registrationTest.NegativeRegistrationTest;
import registrationTest.PositiveRegistrationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {NegativeRegistrationTest.class, PositiveRegistrationTest.class, NewFeedbackTest.class, CatalogTest.class, NewItemOnBasketTest.class, DeleteItemfromBasket.class}
)
public class ExamSuit {

}
