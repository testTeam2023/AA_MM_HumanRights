package HumanRightsStore.testCases.inventoryMonitorsTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.inventoryMonitors.Transform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TransformTest extends TestBase {

    private Transform transform ;
    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {"أمانة اللجنة الدائمة لمكافحة جرائم الاتجار بالأشخاص/وحدة المنع والوقاية ","الإدارة العامة لرأس المال البشري/إدارة عمليات الموارد البشرية","1211","1198"}
        };
    }
    @Test(dataProvider = "data")

    public void createTransformFlow( String departmentFromName , String departmentToName , String employee_From , String employee_To )throws InterruptedException{
        transform = new Transform(driver);
        SoftAssert softAssert = new SoftAssert() ;
        transform
                .navigateToTransformPage()
                .selectDepartmentFrom(departmentFromName)
                .selectDepartmentTom(departmentToName)
                .selectEmployeeFrom(employee_From)
                .selectEmployeeTo(employee_To)
                .scrollDown()
                .selectItems()
                .scrollToSaveBtn()
                .clickOnSaveBtn()
                .clickOnFixedBtn();
        softAssert.assertTrue(transform.fixedBtnDisable());

        //search
        transform
                .navigateToTransformPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn();
        softAssert.assertTrue(transform.searchResultIsDisplayed());
//Edit
        transform
                .navigateToTransformPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();
        softAssert.assertTrue(transform.notFixedBtnDisable());
        //Delete
        transform
                .navigateToTransformPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn();

    }
    }

