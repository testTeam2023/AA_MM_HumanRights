package HumanRightsStore.testCases.procurementTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.procurement.ClassifyItem;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassifyItemTest  extends TestBase {
    private ClassifyItem classifyItem ;
    @Test
    public void setClassifyItem() throws InterruptedException{
        classifyItem = new ClassifyItem(driver);
        classifyItem
                .navigateToClassifyItemPage();
        Assert.assertTrue(classifyItem.classifyItemIsDisplayed());

    }


}
