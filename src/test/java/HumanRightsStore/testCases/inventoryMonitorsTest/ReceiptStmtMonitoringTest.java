package HumanRightsStore.testCases.inventoryMonitorsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.inventoryMonitors.ReceiptStmtMonitoring;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReceiptStmtMonitoringTest extends TestBase {

    private ReceiptStmtMonitoring receiptStmtMonitoring ;
    @Test
    public void setReceiptStmtMonitoring(){
        receiptStmtMonitoring = new ReceiptStmtMonitoring(driver);
        receiptStmtMonitoring
                .navigateToReceiptStmtMonitoringPage();
        Assert.assertTrue(receiptStmtMonitoring.receiptStmtMonitoringIsDisplayed());

    }

}
