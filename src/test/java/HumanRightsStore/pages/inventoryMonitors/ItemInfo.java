package HumanRightsStore.pages.inventoryMonitors;

import HumanRightsStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ItemInfo {
    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public ItemInfo (WebDriver driver){
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
    public ItemInfo navigateToItemInfoPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getItemInfoPage());
                Thread.sleep(2500);
                if(isElementDisplay(pageAssert)) {
                    return this;
                }
                else {
                    throw new RuntimeException("The specified element is not displayed");
                }
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to ItemInfo page url ...");
            }
        }
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
    }
    private boolean isElementDisplay(By locator){
        try {
            return waitForVisibilityElement(locator).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
    private final By selectStores = By.xpath("//*[@id=\"StoreID\"]");
    public ItemInfo selectStore(){
        Select select = new Select(waitForClickableElement(selectStores));
        select.selectByValue("1");
        return this ;
    }

    private final By pageAssert = By.xpath("//*[@id=\"content\"]/div[1]/div/div/h1");

    private final By itemNumber= By.xpath("//*[@id=\"item_id\"]");
    private final By dataDisplayBtn = By.xpath("//*[@id=\"btnSave\"]");
    private final By results= By.xpath("//*[@id=\"viewTransInfoInfo\"]");

    public ItemInfo addNumberAndDisplayResults( String item_Number) throws InterruptedException {
        int maxRetry = 3;
        for (int retry = 0; retry < maxRetry; retry++) {
            try {
                WebElement itemNum = waitForClickableElement(itemNumber);
                itemNum.sendKeys(item_Number, Keys.ENTER);

                WebElement displayBtn = waitForClickableElement(dataDisplayBtn);
                displayBtn.click();

                Thread.sleep(1500);
                return this;
            } catch (Exception e) {
                System.out.println(" retrying add number and display results ");
                navigateToItemInfoPage();
            }
        }
            throw new RuntimeException(" fail to add number and display results after " + maxRetry + "Attempts") ;
        }

    public boolean resultsIsDisplayed()
    {

        return waitForVisibilityElement(results).isDisplayed();

    }







}
