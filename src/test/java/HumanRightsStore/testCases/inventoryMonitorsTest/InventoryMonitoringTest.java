package HumanRightsStore.testCases.inventoryMonitorsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.inventoryMonitors.InventoryMonitoring;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryMonitoringTest extends TestBase {

    private InventoryMonitoring inventoryMonitoring ;
    @Test
    public void setClosingFinYear(){
        inventoryMonitoring = new InventoryMonitoring(driver);
        inventoryMonitoring
                .navigateToInventoryMonitoringPage();
        Assert.assertTrue(inventoryMonitoring.inventoryMonitoringIsDisplayed());

    }

}
