package HumanRightsStore.testCases.reportsTest.SpecialReportTest;

import HumanRightsStore.basess.TestBase;
import HumanRightsStore.pages.reports.SpecialReport.SpecialReports;
import org.testng.annotations.Test;

public class SpecialReportsTest extends TestBase {

    private SpecialReports specialReports ;

    @Test
    public void setSpecialReports(){

        specialReports=new SpecialReports(driver);
        specialReports.navigateToReport80Page()
                .report80IsDisplayed();
        specialReports.navigateToReport81Page()
                .report81IsDisplayed();
        specialReports.navigateToReport89Page()
                .report89IsDisplayed();
        specialReports.navigateToReport90Page()
                .report90IsDisplayed();
        specialReports.navigateToReport91Page()
                .report91IsDisplayed();


    }
}
