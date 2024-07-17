package HumanRightsStore.testCases.inventoryMonitorsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.inventoryMonitors.ItemInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemInfoTest extends TestBase {

    private ItemInfo itemInfo;
    @Test
    public void itemInfoTest() throws InterruptedException{

        itemInfo = new ItemInfo(driver);
        itemInfo
                .navigateToItemInfoPage()
                .selectStore()
                .addNumberAndDisplayResults("199");
        Assert.assertTrue(itemInfo.resultsIsDisplayed());

    }

}
