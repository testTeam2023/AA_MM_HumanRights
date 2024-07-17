package HumanRightsStore.testCases.assetsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.assets.AppAssetDaftar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppAssetDaftarTest extends TestBase {
    private AppAssetDaftar appAssetDaftar ;
    @Test
    public void setAppAssetDaftar() throws InterruptedException{
        appAssetDaftar = new AppAssetDaftar(driver);
        appAssetDaftar
                .navigateToAppAssetDaftarPage();
        Assert.assertTrue(appAssetDaftar.appAssetDaftarIsDisplayed());

    }
}
