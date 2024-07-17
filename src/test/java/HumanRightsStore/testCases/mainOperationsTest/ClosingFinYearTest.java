package HumanRightsStore.testCases.mainOperationsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.mainOperations.ClosingFinYear;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClosingFinYearTest extends TestBase {

    private ClosingFinYear closingFinYear ;
    @Test
    public void setClosingFinYear(){
        closingFinYear = new ClosingFinYear(driver);
        closingFinYear
                .navigateToClosingFinYearPage();
        Assert.assertTrue(closingFinYear.closingFinYearIsDisplayed());

    }

}
