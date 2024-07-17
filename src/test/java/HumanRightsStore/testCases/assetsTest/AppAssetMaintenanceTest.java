package HumanRightsStore.testCases.assetsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.assets.AppAssetMaintenance;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppAssetMaintenanceTest extends TestBase {

    private AppAssetMaintenance appAssetMaintenance ;
    @Test
    public void setAppAssetMaintenance(){
        appAssetMaintenance = new AppAssetMaintenance(driver);
        appAssetMaintenance
                .navigateToAppAssetMaintenancePage();
        Assert.assertTrue(appAssetMaintenance.appAssetMaintenanceIsDisplayed());

    }
}
