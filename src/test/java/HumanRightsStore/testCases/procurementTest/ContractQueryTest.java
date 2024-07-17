package HumanRightsStore.testCases.procurementTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.procurement.ContractQuery;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContractQueryTest extends TestBase {
    private ContractQuery contractQuery ;
    @Test
    public void setCompetitionReqTest()throws InterruptedException{
        contractQuery = new ContractQuery(driver);
        contractQuery
                .navigateToContractQueryPage();
        Assert.assertTrue(contractQuery.contractQueryIsDisplayed());
    }


}
