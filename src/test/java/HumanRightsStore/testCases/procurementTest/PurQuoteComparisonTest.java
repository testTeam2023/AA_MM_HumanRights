package HumanRightsStore.testCases.procurementTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.procurement.PurOrder;
import HumanRightsStore.pages.procurement.PurQuote;
import HumanRightsStore.pages.procurement.PurQuoteComparison;
import HumanRightsStore.pages.procurement.PurQuoteRequest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PurQuoteComparisonTest extends TestBase {
    private PurOrder purOrder ;
    private PurQuoteRequest purQuoteRequest ;
    private PurQuote purQuote ;
    private PurQuoteComparison purQuoteComparison ;

    @DataProvider
    public  Object[][] dataForPurOrder(){
        return new Object[][]{

                {"رئيس الهيئة ","دليل الاصناف","11","1"}
        };

    }

    @Test(dataProvider ="dataForPurOrder" )
    public void createPurQuoteComparisonFlow(String departmentName , String itemType, String itemNum,String itemQty) throws InterruptedException{
        purOrder = new PurOrder(driver);
        purQuoteRequest = new PurQuoteRequest(driver);
        purQuote = new PurQuote(driver);
        purQuoteComparison=new PurQuoteComparison(driver);
        SoftAssert softAssert = new SoftAssert();
        purOrder
                .navigateToPurOrderPage()
                .selectDepartment(departmentName)
                .scrollDown()
                .addItem(itemType,itemNum,itemQty)
                .clickOnSaveBtn();

        purQuoteRequest
                .navigateToPurQuoteRequestPage()
                .selectPurQuoteNumber()
                .clickOnSupplier()
                .clickOnSaveBtn();

        purQuote
                .navigateToPurQuotePage()
                .selectPurQuoteNumber()
                .selectSupplier()
                .scrollDown()
                .editPrice()
                .clickOnSaveBtn();

        purQuoteComparison
                .navigateToPurQuoteComparisonPage()
                .selectPurQuoteNumber()
                .clickOnSaveBtn();


        // Search
        purQuoteComparison
                .navigateToPurQuoteComparisonPage()
                .clickOnSearchTab()
                .clickOnSearchBtn();
        softAssert.assertTrue(purQuoteComparison.searchResultIsDisplayed());

        // Edit

        purQuoteComparison
                .navigateToPurQuoteComparisonPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnEditSaveBtn();
        softAssert.assertTrue(purQuoteComparison.getEditSuccessMessage());

        // Delete
        purQuoteComparison
                .navigateToPurQuoteComparisonPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();




    }



}
