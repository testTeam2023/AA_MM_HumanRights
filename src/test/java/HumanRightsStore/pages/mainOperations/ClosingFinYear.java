package HumanRightsStore.pages.mainOperations;

import HumanRightsStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ClosingFinYear {

    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public ClosingFinYear (WebDriver driver){
        this.driver=driver;
        this.wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement waitForClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForVisibilityElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForPresenceElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public ClosingFinYear navigateToClosingFinYearPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getClosingFinYearPage());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to ClosingFinYear page url ...");
            }
        }
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
    }

    private final By closingFinYear = By.xpath("//*[@id=\"content\"]/div[1]/div/div/h6") ;

    public boolean closingFinYearIsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(closingFinYear).isDisplayed();
            } catch (Exception e) {
                System.out.println("retrying open the page ");
                navigateToClosingFinYearPage();
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues");
    }


}
