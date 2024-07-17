package HumanRightsStore.testCases.mainOperationsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.mainOperations.SpendingOrder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SpendingOrderTest extends TestBase {

    private SpendingOrder spendingOrder ;
   @DataProvider

   public Object[][]data(){
       return new Object[][]{
               {"المستودع العام","عمرو عبدالعزيز حسن كمال","الإدارة العامة للشؤون الإدارية والهندسية والمرافق/وحدة المستودعات\n","خالد راشد  عاضه أحمد", "شافعى ابراهيم فهد أحمد","11","1"}
       } ;
   }
    @Test(dataProvider = "data" , priority = 1)
    public void createSpendingOrderFlow(String storeName,String storeKeeper, String department , String departmenManager , String receiver , String itemNum , String qty) throws InterruptedException{
// عاوز اعمل e2e  من الاصناف لها رقم تسلسلي ومحضر ب رقم تسلسلي ثم عمل امر صرف ثم عمل رجيع للصنف ثم صرف صنف رجيع
       spendingOrder = new SpendingOrder(driver);
       SoftAssert softAssert = new SoftAssert();
       spendingOrder
               .navigateToSpendingOrderPage()
               .selectStore(storeName)
               .scrollDown()
               .selectDepartment(department)
               .selectDepartmentManager(departmenManager)
               .selectReceiver(receiver)
               .scrollDown()
               .addItem(itemNum,qty)
               .clickOnSaveBtn()
               .clickOnFixedBtn();
        softAssert.assertTrue(spendingOrder.getSuccessMessage());
        softAssert.assertTrue(spendingOrder.fixedBtnDisable());
  //search
        spendingOrder
                .navigateToSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDownForSearch()
                .clickOnSearchBtn();
//Edit
        spendingOrder
                .navigateToSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDownForSearch()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();
        softAssert.assertTrue(spendingOrder.notFixedBtnDisable());
        //Delete
        spendingOrder
                .navigateToSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDownForSearch()
                .clickOnSearchBtn()
                .clickOnDeleteBtn()
        ;

    }
  /*
    @Test(priority = 2)
    public void spendingOrderSearch() throws InterruptedException{
        spendingOrder = new SpendingOrder(driver);
        spendingOrder
                .navigateToSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn();
        Assert.assertTrue(spendingOrder.searchResultIsDisplayed());
    }
    @Test(priority = 3 , dependsOnMethods = "createSpendingOrder")
    public void spendingOrderEdit() throws InterruptedException{
        spendingOrder = new SpendingOrder(driver);
        spendingOrder
                .navigateToSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();

    }

    @Test(priority = 4, dependsOnMethods = "spendingOrderEdit")
    public void spendingOrderDelete() throws InterruptedException{
        spendingOrder = new SpendingOrder(driver);
        spendingOrder
                .navigateToSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();

    }

   */



}
