package HumanRightsStore.testCases.mainOperationsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.mainOperations.ReceiptMemoPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReceiptMemoPageTest extends TestBase {
    ReceiptMemoPage receiptMemoPage ;
    @DataProvider
    public Object[][] data(){
        return new Object[][] {

                {"المستودع العام","11","2","50"}
        } ;

    }

    @Test(dataProvider = "data" , priority = 0)
    public void ReceiptMemoPageFlow(String storeName , String itemNumber , String ItemQty , String ItemPrice) throws InterruptedException{
        receiptMemoPage = new ReceiptMemoPage(driver);
        SoftAssert softAssert = new SoftAssert();
        receiptMemoPage
                .navigateToReceiptMemoPage()
                .selectSupplier()
                .selectStore(storeName)
                .selectEmployeeName()
                .scrollDown()
                .addItems(itemNumber,ItemQty,ItemPrice)
                .scrollDownC()
                .clickOnSaveBtn()
                .clickOnFixedBtn() ;
        softAssert.assertTrue(receiptMemoPage.fixedBtnDisable());

        receiptMemoPage
                .navigateToReceiptMemoPage()
                .clickOnSearchTab()
                .clickOnSearchBtn();

        receiptMemoPage
                .navigateToReceiptMemoPage()
                .clickOnSearchTab()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();
        softAssert.assertTrue(receiptMemoPage.notFixedBtnDisable());

        receiptMemoPage
                .navigateToReceiptMemoPage()
                .clickOnSearchTab()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();




    }


}
