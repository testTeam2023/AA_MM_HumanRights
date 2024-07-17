package HumanRightsStore.testCases.inventoryMonitorsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.inventoryMonitors.SpendingOrderMonitoring;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpendingOrderMonitoringTest extends TestBase {

    private SpendingOrderMonitoring spendingOrderMonitoring ;
    @Test
    public void setClosingFinYear(){
        spendingOrderMonitoring = new SpendingOrderMonitoring(driver);
        spendingOrderMonitoring
                .navigateToSpendingOrderMonitoringPage();
        Assert.assertTrue(spendingOrderMonitoring.spendingOrderMonitoringIsDisplayed());

    }


}
