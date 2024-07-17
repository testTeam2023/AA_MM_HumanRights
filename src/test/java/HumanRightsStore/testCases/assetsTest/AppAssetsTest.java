package HumanRightsStore.testCases.assetsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.assets.AppAssets;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppAssetsTest extends TestBase {


    private AppAssets appAssets ;
    @Test
    public void setAppAssets(){
        appAssets = new AppAssets(driver);
        appAssets
                .navigateToAppAssetsPage();
        Assert.assertTrue(appAssets.appAssetsIsDisplayed());

    }
}
