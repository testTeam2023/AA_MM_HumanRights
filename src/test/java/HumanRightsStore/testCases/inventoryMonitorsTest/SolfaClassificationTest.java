package HumanRightsStore.testCases.inventoryMonitorsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.inventoryMonitors.SolfaClassification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SolfaClassificationTest extends TestBase {

    private SolfaClassification solfaClassification ;
    @Test
    public void setClosingFinYear(){
        solfaClassification = new SolfaClassification(driver);
        solfaClassification
                .navigateToSolfaClassificationPage();
        Assert.assertTrue(solfaClassification.solfaClassificationIsDisplayed());

    }

}
