package HumanRightsStore.testCases.assetsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.assets.AppAssetDisposal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppAssetDisposalTest  extends TestBase {

    private AppAssetDisposal appAssetDisposal ;
    @Test
    public void setAppAssetDisposal(){
        appAssetDisposal = new AppAssetDisposal(driver);
        appAssetDisposal
                .navigateToAppAssetDisposalPage();
        Assert.assertTrue(appAssetDisposal.appAssetDisposalIsDisplayed());

    }
}
