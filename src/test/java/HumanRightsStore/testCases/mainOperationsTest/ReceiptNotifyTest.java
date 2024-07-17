package HumanRightsStore.testCases.mainOperationsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.mainOperations.ReceiptNotify;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReceiptNotifyTest extends TestBase {
    private  ReceiptNotify receiptNotify ;

    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {"المستودع العام","11","2","50"}
        } ;

        }
    @DataProvider
    public Object[][] dataForEdit(){
        return new Object[][]{
                {"11","3","50"}
        } ;

    }


    @Test(dataProvider = "data" , priority = 0 )
    public void createReceiptNotifyFlow(String storename,String itemNo , String qty , String price) throws InterruptedException{
        receiptNotify=new ReceiptNotify(driver);
        SoftAssert softAssert= new SoftAssert();
        receiptNotify
                .navigateToReceiptNotifyPage()
                .addStoreName(storename)
                .addSupplierName()
                .scrollDownc()
                .addItems(itemNo,qty,price)
                .clickOnSaveBtn();
        softAssert.assertTrue(receiptNotify.getSuccessMessage());
        // Search
        receiptNotify
                .navigateToReceiptNotifyPage()
                .clickOnSearchTab()
                .clickOnSearchBtn();

        Assert.assertTrue(receiptNotify.searchResultIsDisplayed());

        // Edit
        receiptNotify
                .navigateToReceiptNotifyPage()
                .clickOnSearchTab()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollDown()
                .clickOnEditSaveBtn();
        // Delete
        receiptNotify
                .navigateToReceiptNotifyPage()
                .clickOnSearchTab()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();
        Assert.assertTrue(receiptNotify.getDeleteSuccessMessage());

    }
/*
    @Test(priority = 1)
    public void receiptNotifySearch() throws InterruptedException{
        receiptNotify=new ReceiptNotify(driver);
        receiptNotify
                .navigateToReceiptNotifyPage()
                .clickOnSearchTab()
                .clickOnSearchBtn();

        Assert.assertTrue(receiptNotify.searchResultIsDisplayed());
    }

    @Test(dataProvider = "dataForEdit" ,priority = 2)
    public void ReceiptNotifyEdit(String itemNo , String qty , String price) throws InterruptedException{
        receiptNotify=new ReceiptNotify(driver);
        receiptNotify
                .navigateToReceiptNotifyPage()
                .clickOnSearchTab()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollDown()
                .addItems(itemNo,qty,price)
                .clickOnEditSaveBtn();
        Assert.assertTrue(receiptNotify.getSuccessMessage());

    }
    @Test(priority = 3)
    public void ReceiptNotifyDelete() throws InterruptedException{
        receiptNotify=new ReceiptNotify(driver);
        receiptNotify
                .navigateToReceiptNotifyPage()
                .clickOnSearchTab()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();
        Assert.assertTrue(receiptNotify.getDeleteSuccessMessage());
    }

 */


}
