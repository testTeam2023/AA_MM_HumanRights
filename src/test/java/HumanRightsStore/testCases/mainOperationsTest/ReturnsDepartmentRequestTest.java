package HumanRightsStore.testCases.mainOperationsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.mainOperations.ReturnsDepartmentRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReturnsDepartmentRequestTest extends TestBase {
    private ReturnsDepartmentRequest returnsDepartmentRequest ;
    @Test
    public void setReturnsDepartmentRequest() throws InterruptedException{
        returnsDepartmentRequest = new ReturnsDepartmentRequest(driver);
        returnsDepartmentRequest
                .navigateToReturnsDepartmentRequestPage();
        Assert.assertTrue(returnsDepartmentRequest.returnDepartmentRequestIsDisplayed());

    }

}
