package HumanRightsStore.testCases.inventoryMonitorsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.inventoryMonitors.ReceiptMemoMonitoring;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReceiptMemoMonitoringTest   extends TestBase {

    private ReceiptMemoMonitoring receiptMemoMonitoring ;
    @Test
    public void setClosingFinYear(){
        receiptMemoMonitoring = new ReceiptMemoMonitoring(driver);
        receiptMemoMonitoring
                .navigateToReceiptMemoMonitoringPage();
        Assert.assertTrue(receiptMemoMonitoring.receiptMemoMonitoringIsDisplayed());

    }

}
