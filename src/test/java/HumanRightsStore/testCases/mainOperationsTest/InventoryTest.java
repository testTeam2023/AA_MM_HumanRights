package HumanRightsStore.testCases.mainOperationsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.mainOperations.Inventory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends TestBase {

    private Inventory inventory ;
    @Test
    public void setInventoryTest(){
        inventory = new Inventory(driver);
        inventory
                .navigateToInventoryPage();
        Assert.assertTrue(inventory.inventoryIsDisplayed());

    }
}
