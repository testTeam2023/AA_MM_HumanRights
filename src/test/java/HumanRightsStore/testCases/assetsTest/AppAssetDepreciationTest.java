package HumanRightsStore.testCases.assetsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.assets.AppAssetDepreciation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppAssetDepreciationTest extends TestBase {
    private AppAssetDepreciation appAssetDepreciation ;
    @Test
    public void setAppAssetDepreciation(){
        appAssetDepreciation = new AppAssetDepreciation(driver);
        appAssetDepreciation
                .navigateToAppAssetDepreciationPage();
        Assert.assertTrue(appAssetDepreciation.appAssetDepreciationIsDisplayed());

    }
}
