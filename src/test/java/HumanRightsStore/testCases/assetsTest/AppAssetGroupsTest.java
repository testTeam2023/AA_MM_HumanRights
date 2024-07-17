package HumanRightsStore.testCases.assetsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.assets.AppAssetGroups;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppAssetGroupsTest extends TestBase {

    private AppAssetGroups appAssetGroups ;
    @Test
    public void setAppAssetGroups(){
        appAssetGroups = new AppAssetGroups(driver);
        appAssetGroups
                .navigateToAppAssetGroupsPage();
        Assert.assertTrue(appAssetGroups.appAssetGroupsIsDisplayed());

    }
}
