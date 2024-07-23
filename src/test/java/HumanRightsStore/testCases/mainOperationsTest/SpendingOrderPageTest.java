package HumanRightsStore.testCases.mainOperationsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.mainOperations.SpendingOrderPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SpendingOrderPageTest extends TestBase {

    SpendingOrderPage spendingOrderPage ;
    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {"المستودع العام","الإدارة العامة للشؤون الإدارية والهندسية والمرافق/وحدة المستودعات","على سلطان عبدالعزيز أحمد", "شافعى ابراهيم فهد أحمد","11","1"}

        };

    }

    @Test(dataProvider="data",priority = 0)
    public void spendingOrderPageFlow(String storeName,String department ,String departmenManager, String receiverName , String itemNumber ,String ItemQty ) throws InterruptedException{

        spendingOrderPage = new SpendingOrderPage(driver);
        SoftAssert softAssert = new SoftAssert() ;

        spendingOrderPage
                .navigateToSpendingOrderPage()
                .selectStore(storeName)
                .selectDepartment(department)
                .selectDepartmentManager(departmenManager)
                .selectReceiver(receiverName)
                .scrollDown()
                .addItem(itemNumber,ItemQty)
                .clickOnSaveBtn()
                .clickOnFixedBtn();
        softAssert.assertTrue(spendingOrderPage.fixedBtnDisable());
        spendingOrderPage
                .navigateToSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDownForSearch()
                .clickOnSearchBtn();
        spendingOrderPage
                .navigateToSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDownForSearch()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();
        softAssert.assertTrue(spendingOrderPage.notFixedBtnDisable());

        spendingOrderPage
                .navigateToSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDownForSearch()
                .clickOnSearchBtn()
                .clickOnDeleteBtn() ;




    }


}
