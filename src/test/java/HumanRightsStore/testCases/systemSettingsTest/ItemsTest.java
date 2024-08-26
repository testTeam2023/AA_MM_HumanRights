package HumanRightsStore.testCases.systemSettingsTest;
import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.systemSettings.Items;
import HumanRightsStore.utils.RandomArItems;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ItemsTest extends TestBase {
    Items items ;
    @Test(priority = 0)
    public void createItem() throws InterruptedException {
     items = new Items(driver);
     items
             .navigateToItemsPage()
             .chooseItemClassification()
             .enterItemName(RandomArItems.randomItemsName())
             .chooseItemType()
             .chooseUnit()
             .chooseStore()
             .enterMaxQty()
             .scroll()
             .clickOnSaveBtn();
    }
    @Test(priority = 1)
    public void ItemsSearch()throws InterruptedException{
     items = new Items(driver);
     items
             .navigateToItemsPage()
             .clickOnSearchTab()
             .scrollDownForSearch()
             .clickOnSearchBtn();
    }

    @Test(priority = 2)
    public void itemsEdit()throws InterruptedException{
        items = new Items(driver);
        items
                .navigateToItemsPage()
                .clickOnSearchTab()
                .scrollDownForSearch()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollDown()
                .clickOnEditSaveBtn();
    }
    @Test(priority = 3)
    public void ItemsDelete()throws InterruptedException{
        items = new Items(driver);
        items
                .navigateToItemsPage()
                .clickOnSearchTab()
                .scrollDownForSearch()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();



    }








}
