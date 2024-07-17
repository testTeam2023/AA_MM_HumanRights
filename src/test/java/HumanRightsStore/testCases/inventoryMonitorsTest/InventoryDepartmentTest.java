package HumanRightsStore.testCases.inventoryMonitorsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.inventoryMonitors.InventoryDepartment;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryDepartmentTest extends TestBase {

    private InventoryDepartment inventoryDepartment ;
    @Test
    public void setInventoryDepartment(){
        inventoryDepartment = new InventoryDepartment(driver);
        inventoryDepartment
                .navigateToInventoryDepartmentPage();
        Assert.assertTrue(inventoryDepartment.inventoryDepartmentIsDisplayed());

    }
}
