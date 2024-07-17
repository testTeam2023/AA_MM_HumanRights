package HumanRightsStore.testCases.procurementTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.procurement.PurOrderSummary;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurOrderSummaryTest extends TestBase {

    private PurOrderSummary purOrderSummary ;
    @Test
    public void setPurOrderSummary(){
        purOrderSummary = new PurOrderSummary(driver);
        purOrderSummary
                .navigateToPurOrderSummaryPage();
        Assert.assertTrue(purOrderSummary.purOrderSummaryIsDisplayed());
    }

}
