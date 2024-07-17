package HumanRightsStore.testCases.mainOperationsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.mainOperations.SpendingorderRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpendingorderRequestTest extends TestBase {

   private SpendingorderRequest spendingorderRequest ;
    @Test
    public void setSpendingorderRequestTest(){
        spendingorderRequest = new SpendingorderRequest(driver);
        spendingorderRequest
                .navigateToSpendingorderRequestPage();
        Assert.assertTrue(spendingorderRequest.spendingorderRequestIsDisplayed());

    }
}
