package HumanRightsStore.pages.mainOperations;

import HumanRightsStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class SpendingOrderPage {
    private WebDriver driver ;
    private final FluentWait<WebDriver>wait ;

    public SpendingOrderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(35))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class) ;
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
    public SpendingOrderPage navigateToSpendingOrderPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getSpendingOrderPage());
                Thread.sleep(4000);
                if(isElementDisplay(pageAssert)) {
                    return this;
                }
                else {
                    throw new RuntimeException("The specified element is not displayed");
                }
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to spending order url ...");
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
    private final By pageAssert = By.xpath("//*[@id=\"content\"]/div[1]/div/div/h6");

    // Select Stores, Department, Department manager and receiver name  from a list
    private final By selectStore = By.xpath("//span[@id=\"select2-StoreID_from-container\"]");
    private final By searchField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");

    private final By selectStoreKeeper = By.xpath("//*[@id=\"select2-StoreCuratorId-container\"]");
    private final By searchFieldForStoreKeeper = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By selectDepartment = By.xpath("//*[@id=\"select2-DepartmentID_to-container\"]");
    private final By searchDepartmentField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By selectDepartmentManger = By.xpath("//*[@id=\"select2-EmployeeID_to-container\"]");
    private final By searchDepartmentMangerField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By selectReceiverName=By.xpath("//*[@id=\"select2-EmployeeID_Recieved-container\"]");
    private final By searchReceiverField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    public SpendingOrderPage selectStore(String storeName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectStore);
                store.click();
                Thread.sleep(1500);

                WebElement storeSearch = waitForClickableElement(searchField);
                storeSearch.sendKeys(storeName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting Store");
                navigateToSpendingOrderPage();
            }
        }
        throw new RuntimeException("failed selecting Store after " +maxAttempt);

    }
    public SpendingOrderPage selectStoreKeeper(String storeKeeper) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectStoreKeeper);
                store.click();
                Thread.sleep(1500);

                WebElement storeSearch = waitForClickableElement(searchFieldForStoreKeeper);
                storeSearch.sendKeys(storeKeeper, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying selecting StoreKeeper");
            }
        }
        throw new RuntimeException("failed selecting StoreKeeper after " +maxAttempt);

    }
    public SpendingOrderPage selectDepartment(String DepartmentName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectDepartment);
                store.click();
                Thread.sleep(1500);

                WebElement storeSearch = waitForClickableElement(searchDepartmentField);
                storeSearch.sendKeys(DepartmentName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting Department");
            }
        }
        throw new RuntimeException("failed selecting Department after " +maxAttempt);

    }

    public SpendingOrderPage selectDepartmentManager(String DepartmentManagerName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectDepartmentManger);
                store.click();
                Thread.sleep(1500);

                WebElement storeSearch = waitForClickableElement(searchDepartmentMangerField);
                storeSearch.sendKeys(DepartmentManagerName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting Department manager");
            }
        }
        throw new RuntimeException("failed selecting Department manager after " +maxAttempt);
    }
    public SpendingOrderPage selectReceiver(String ReceiverName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectReceiverName);
                store.click();
                Thread.sleep(1500);

                WebElement storeSearch = waitForClickableElement(searchReceiverField);
                storeSearch.sendKeys(ReceiverName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting receiver name");
            }
        }
        throw new RuntimeException("failed selecting receiver name after " +maxAttempt);
    }

    public SpendingOrderPage scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900);");
        return this ;
    }
    public SpendingOrderPage scrollDownForSearch()throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200);");
        Thread.sleep(1000);
        return this ;
    }

    // Add items and save
    private final By itemNumberBtn= By.xpath("//*[@id=\"FormAddOrEdit_SpendingOrderDtl\"]/div[1]/div/label[4]");
    private final By itemNum = By.xpath("//*[@id=\"SearchKey\"]");
    private final By itemQty = By.xpath("//*[@id=\"OrdQuantity\"]");
    private final By addBtn = By.xpath("//input[@id=\"btnAddNewItemm\"]");
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");
    private final By successMessageOfNotFixed = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم تثبيت الإلغاء\")]");
    private final By fixed = By.xpath("//input[@id=\"btnFixing\"]");
    private final By notFixed = By.xpath("//input[@id=\"btnCancelFixed\"]");

    public SpendingOrderPage addItem(String itemNumbers ,String itemqtys) throws InterruptedException{
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement itemNumBtn = waitForClickableElement(itemNumberBtn);
                itemNumBtn.click();

                WebElement itemNumber = waitForClickableElement(itemNum);
                itemNumber.sendKeys(itemNumbers, Keys.ENTER);
                Thread.sleep(1000);

                WebElement qty = waitForClickableElement(itemQty);
                qty.clear();
                qty.sendKeys(itemqtys);

                WebElement add = waitForClickableElement(addBtn);
                add.click();
                Thread.sleep(4000);
                return this;
            }
            catch (Exception e){
                System.out.println("try add item and click on btn ");
            }}
        throw new RuntimeException("failed to add item and btn check the test data");
    }


    public SpendingOrderPage clickOnSaveBtn() throws InterruptedException{

        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement saveButton = waitForClickableElement(saveBtn);
                Actions actions = new Actions(driver);
                actions.moveToElement(saveButton).click().build().perform();
                Thread.sleep(1500);
                WebElement okButton = waitForClickableElement(okBtn);
                Actions actions1 = new Actions(driver);
                actions1.moveToElement(okButton).click().build().perform();
                Thread.sleep(1500);
                return this;
            }
            catch (Exception e){
                System.out.println("Retrying click on save btn ");
                handleUnexpectedAlert();
            }
        }
        throw new RuntimeException(" failed to click on save btn after "+maxAttempt+ " attempt");
    }
    private void handleUnexpectedAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.dismiss();
        } catch (Exception e) {
            // If no alert is present, continue
            System.out.println("No alert present. Continuing...");
        }
    }

    public boolean getSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(successMessage)).isDisplayed();
    }

    public SpendingOrderPage clickOnFixedBtn()throws InterruptedException {

        WebElement fixedButton = waitForClickableElement(fixed);
        fixedButton.click();
        Thread.sleep(1500);

        WebElement okButton = waitForClickableElement(okBtn);
        okButton.click();

        return this ;
    }
    public SpendingOrderPage clickOnNotFixedBtn() {
        try {

            WebElement notFixedButton = waitForClickableElement(notFixed);
            Actions actions = new Actions(driver);
            actions.moveToElement(notFixedButton).click().build().perform();
            Thread.sleep(1500);

            WebElement okButton = waitForClickableElement(okBtn);
            Actions actions1 = new Actions(driver);
            actions.moveToElement(okButton).click().build().perform();

        }
        catch (Exception e){
            throw  new RuntimeException("زر التثبيت مفعل ");

        }
        return this ;
    }


    public boolean fixedBtnDisable(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(notFixed)).isEnabled();
    }

    public boolean notFixedBtnDisable(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fixed)).isEnabled();
    }


    public boolean notFixedMessageSuccess(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageOfNotFixed)).isDisplayed();
    }
    // Search Function
    private final By  searchTab = By.xpath("//a[@id=\"AnchorfirstTab\"]");
    private final By  searchBtn = By.xpath("//*[@id=\"FormSearch\"]/div[1]/div[9]/input");
    private final By  searchData = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody");

    public SpendingOrderPage clickOnSearchTab()throws InterruptedException{
        int maxAttempt = 3 ;
        for (int attempt=0; attempt<maxAttempt; attempt++) {
            try {
                //wait.until(ExpectedConditions.elementToBeClickable(searchTab)).click();
                //   JavascriptExecutor js = (JavascriptExecutor) driver;
                //  js.executeScript("window.scrollBy(0, 200);");
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchTab));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();
                Thread.sleep(2000);
                return this;
            } catch (Exception e) {
                System.out.println("Exception occured " + e.getMessage());
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying click...");

            }
        }
        throw new RuntimeException("Failed to click on search tab after " + maxAttempt + " attempts");

    }
    private static final Logger logger = LoggerFactory.getLogger(SpendingOrderPage.class);

    public SpendingOrderPage clickOnSearchBtn() throws InterruptedException {
   /*     int maxAttempts = 10;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                // Locate the element inside the loop to avoid stale element references
                WebElement search = wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
                // Scroll into view using JavascriptExecutor
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].scrollIntoView(true);", search);
                // Click on the element
                search.click();
                // Wait for some time to let the search results load
                Thread.sleep(3500);
                // Check if search data is displayed
                if (isElementDisplay(searchData)) {
                    return this;
                }
            } catch (Exception e) {
                System.out.println("Element not found or stale. Retrying click on search button..." + e.getMessage());
                // Handle the retry by navigating and preparing the page again
                navigateToSpendingOrderPage();
                clickOnSearchTab();
                scrollDownForSearch();
            }
        }
        // Throw an exception if all attempts fail
        throw new RuntimeException("Failed to click on search btn after all attempts");
    }

    */
        int maxAttempts = 10;
        int attempt = 0;

        while (attempt < maxAttempts) {
            try {
                WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].scrollIntoView(true);", search);
                search.click();
                Thread.sleep(2000); // Wait before retrying
                // Wait for search results to display
                wait.until(ExpectedConditions.visibilityOfElementLocated(searchData));

                return this; // Successful click

            } catch (NoSuchElementException | StaleElementReferenceException e) {
                logger.error("Element issue: ", e);
                handleNavigationAndRetry();
            } catch (Exception e) {
                logger.error("Unexpected error: ", e);
                handleNavigationAndRetry();
            }
            attempt++;
        }

        throw new RuntimeException("Failed to click on search button after " + maxAttempts + " attempts.");
    }
        private void handleNavigationAndRetry() throws InterruptedException{
            navigateToSpendingOrderPage();
            clickOnSearchTab();
            scrollDownForSearch();
        }
    public boolean searchResultIsDisplayed() throws InterruptedException{
        int maxRetry = 3;
        for (int retry = 0; retry < maxRetry; retry++){
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(searchData)).isDisplayed();
            }
            catch (Exception e){
                System.out.println("retrying.....");
                driver.navigate().refresh();
                Thread.sleep(2000);
                clickOnSearchTab().clickOnSearchBtn();
            }

        }
        throw new RuntimeException("failed to find element after" +maxRetry);
    }

    // Edit function

    private final By  editBtnParent = By.xpath("//*[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[11]");
    private final By  editBtnChild = By.xpath(".//a[@class=\"btn btn-warning btn-xs\"]");
    private final By  DeleteBtnChild = By.xpath(".//a[@class=\"btn btn-danger btn-xs\"]");
    private final By  editBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"تعديل\")]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");

    public SpendingOrderPage clickOnEditBtn() throws InterruptedException{

        int maxRetry = 5;
        for (int retry = 0; retry < maxRetry; retry++){
            try {
                WebElement parent = waitForVisibilityElement(editBtnParent);

                WebElement child = parent.findElement(editBtnChild);
                wait.until(ExpectedConditions.elementToBeClickable(child));
                child.click();
                Thread.sleep(2500);

                return this;
            }
            catch (Exception e){
                System.out.println("Re trying to click on edit btn " + e.getMessage());
                navigateToSpendingOrderPage();
                clickOnSearchTab();
                scrollDownForSearch();
                clickOnSearchBtn();
            }}
        throw new RuntimeException("Failed to click on edit btn after all attempt");

    }


    public SpendingOrderPage scrollToTheEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 850);");
        return this ;
    }

    public SpendingOrderPage clickOnEditSaveBtn() throws InterruptedException{
        WebElement edit = waitForClickableElement(editBtn);
        Actions actions =new Actions(driver);
        actions.moveToElement(edit).click().build().perform();

        Thread.sleep(1500);

        WebElement ok = waitForClickableElement(okBtn);
        Actions actions1 =new Actions(driver);
        actions.moveToElement(ok).click().build().perform();
        return this;

    }

    public SpendingOrderPage clickOnDeleteBtn() throws InterruptedException {

        int maxRetry = 5;
        for (int retry = 0; retry < maxRetry; retry++) {
            try {

                WebElement parent = waitForVisibilityElement(editBtnParent);
                WebElement child = parent.findElement(DeleteBtnChild);
                wait.until(ExpectedConditions.elementToBeClickable(child)).click();
                Thread.sleep(1500);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();

            WebElement ok = waitForClickableElement(okBtn);
            ok.click();
            System.out.println(getDeleteSuccessMessage());

        } catch (Exception e) {
            System.out.println("لا يمكن الحذف أو التعديل بعد التثبيت");
        }
        return this;
    }
    public boolean getDeleteSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();


    }



}
