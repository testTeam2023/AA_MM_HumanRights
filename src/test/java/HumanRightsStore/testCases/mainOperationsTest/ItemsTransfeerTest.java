package HumanRightsStore.testCases.mainOperationsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.mainOperations.ItemsTransfeer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ItemsTransfeerTest extends TestBase {

    private ItemsTransfeer itemsTransfeer ;

    @DataProvider
    public Object[][] data (){
        return new Object[][]{
                {"1","المستودع العام","مستودع الرجيع","ماجد عبدالله عبدالله أحمد","11","1"},
                {"2","المستودع العام","مستودع الرجيع","ماجد عبدالله عبدالله أحمد","11","1"},
                {"3","المستودع العام","المستودع العام","ماجد عبدالله عبدالله أحمد","11","1"},
                {"4","المستودع العام","مستودع الرجيع","ماجد عبدالله عبدالله أحمد","11","1"}
        };
    }
    @Test(dataProvider = "data", priority = 1)
    public void createItemsTransferFlow(String transferType,String storeFrom_name,String storeTo_name,String storeKeeperName,String itemNum ,String transQty   )throws  InterruptedException{
        itemsTransfeer = new ItemsTransfeer(driver);
        SoftAssert softAssert= new SoftAssert();
        itemsTransfeer
                .navigateToItemsTransferPage()
                .selectTransferType(transferType)
                .selectFromStore(storeFrom_name)
                .selectToStore(storeTo_name)
                .selectStoreKeeper(storeKeeperName)
                .scrollDown()
                .addItem(itemNum,transQty)
                .clickOnSaveBtn()
                .clickOnFixedBtn();
        softAssert.assertTrue(itemsTransfeer.fixedBtnDisable());
// Search
        itemsTransfeer
                .navigateToItemsTransferPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn();
        softAssert.assertTrue(itemsTransfeer.searchResultIsDisplayed());
//Edit
        itemsTransfeer
                .navigateToItemsTransferPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();
        softAssert.assertTrue(itemsTransfeer.notFixedBtnDisable());
//Delete
        itemsTransfeer
                .navigateToItemsTransferPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();
    }
}
