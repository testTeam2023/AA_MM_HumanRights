package HumanRightsStore.pages.mainOperations;

import HumanRightsStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class ReceiptMemoPage {

    private WebDriver driver ;
    private final FluentWait<WebDriver>wait;

    public ReceiptMemoPage(WebDriver driver){
        this.driver=driver;
        this.wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
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

    public ReceiptMemoPage navigateToReceiptMemoPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReceiptMemoPage());
                Thread.sleep(2500);
                if (isElementDisplay(pageAssert)) {
                    return this;
                } else {
                    throw new RuntimeException("The specified element is not displayed");
                }
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to receipt memo page url ...");
            }
        }
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
    }

    private boolean isElementDisplay(By locator) {
        try {
            return waitForVisibilityElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private final By pageAssert = By.xpath("//*[@id=\"content\"]/div[1]/div/div/h1");

    // Select supplier from a list
    private final By selectSuppliers = By.xpath("//span[@id=\"select2-SuppID-container\"]");
    private final By suppliersParent = By.xpath("//ul[@id=\"select2-SuppID-results\"]");
    private final By suppliersChild = By.tagName("li");
    private final By unit = By.xpath("//*[@id=\"UnitID\"]");

    public ReceiptMemoPage enterUnit() throws InterruptedException {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                Select select = new Select(waitForClickableElement(unit));
                select.selectByValue("28");
                Thread.sleep(2000);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  enterUnit");
            }
        }
        throw new RuntimeException("failed to enterUnit ");
    }

    public ReceiptMemoPage selectSupplier() {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement supplier = waitForClickableElement(selectSuppliers);
                supplier.click();

                WebElement results = waitForVisibilityElement(suppliersParent);

                List<WebElement> child = results.findElements(suppliersChild);
                child.get(1).click();
                Thread.sleep(2000);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,30);");

                return this;
            } catch (Exception e) {
                System.out.println("retrying to select supplier");
                navigateToReceiptMemoPage();
            }
        }
        throw new RuntimeException("failed selecting supplier after " + maxAttempt);

    }

    // Select Stores from a list
    private final By selectStore = By.xpath("//span[@id=\"select2-StoreID-container\"]");
    private final By searchField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");

    public ReceiptMemoPage selectStore(String storeName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectStore);
                store.click();
                // Actions actions = new Actions(driver);
                // actions.moveToElement(store).click().build().perform();
                Thread.sleep(1500);

                WebElement storeSearch = waitForClickableElement(searchField);
                storeSearch.sendKeys(storeName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting store");
            }
        }
        throw new RuntimeException("failed selecting store after " + maxAttempt);

    }

    // Select an employee to receive the items
    private final By receiverSearch = By.xpath("//input[@id=\"LKEmployeesIDSearch\" and @onclick=\"LK_EmployeesIDSearch(2)\"]");
    private final By receiverSearchBtn = By.xpath("//*[@id=\"FormSearchLKEmployees\"]/div[1]/div[3]/input");
    private final By receiverSearchResultParent = By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[4]");
    private final By receiverSearchResultChild = By.tagName("a");


    public ReceiptMemoPage selectEmployeeName() throws InterruptedException {

        WebElement EmployeeSearchBtn = waitForClickableElement(receiverSearch);
        EmployeeSearchBtn.click();
        Thread.sleep(1000);
        WebElement searchBtn = waitForClickableElement(receiverSearchBtn);
        searchBtn.click();

        WebElement results = waitForVisibilityElement(receiverSearchResultParent);

        List<WebElement> child = results.findElements(receiverSearchResultChild);
        child.get(0).click();
        Thread.sleep(1500);

        return this;

    }

    public ReceiptMemoPage scrollDown() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000);");

        return this;
    }

    // Add an Item
    private final By itemNo = By.xpath("//*[@id=\"SearchKey\"]");
    private final By itemQty = By.xpath("//input[@id=\"Itemquantity\"]");
    private final By itemPrice = By.xpath("//input[@id=\"Itemprice\"]");
    private final By addBtn = By.xpath("//input[@id=\"btnAddNewItem\"]");
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\"]");
    private final By okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");
    private final By successMessageOfNotFixed = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم تثبيت الإلغاء\")]");
    private final By fixed = By.xpath("//input[@id=\"btnFixing\"]");
    private final By notFixed = By.xpath("//input[@id=\"btnCancelFixed\"]");
    private final By itemNoBtns = By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/form/div[1]/div/label[4]");
    private final By errorModal = By.xpath("//*[@id=\"btn-error-modal\"]");

    public ReceiptMemoPage addItems(String itemNum, String qty, String price) throws InterruptedException {

        WebElement itemNoBtn = waitForClickableElement(itemNoBtns);
        itemNoBtn.click();
        Thread.sleep(1500);

        WebElement itemNoField = waitForClickableElement(itemNo);
        itemNoField.sendKeys(itemNum, Keys.ENTER);
        Thread.sleep(1500);
        WebElement qtyField = waitForClickableElement(itemQty);
        qtyField.clear();
        qtyField.sendKeys(qty);
        Thread.sleep(1000);

        WebElement priceField = waitForClickableElement(itemPrice);
        priceField.clear();
        priceField.sendKeys(price);
        Thread.sleep(1000);

        Select select = new Select(waitForClickableElement(unit));
        select.selectByValue("28");
        Thread.sleep(2000);

        WebElement itemAdded = waitForClickableElement(addBtn);
        itemAdded.click();
        Thread.sleep(2000);


        return this;
    }

    public ReceiptMemoPage scrollDownC() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350);");
        return this ;
    }


    public ReceiptMemoPage clickOnSaveBtn() throws InterruptedException{

        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement saveButton = waitForClickableElement(saveBtn);
                saveButton.click();
                //Actions actions = new Actions(driver);
                // actions.moveToElement(saveButton).click().build().perform();
                Thread.sleep(2500);

                WebElement okButton = waitForClickableElement(okBtn);
                okButton.click();
                //Actions actions1 = new Actions(driver);
                //actions1.moveToElement(okButton).click().build().perform();
                Thread.sleep(1500);

                return this;
            }
            catch (ElementClickInterceptedException e){
                WebElement erModal = waitForPresenceElement(errorModal);
                erModal.click();
                System.out.println("Element Click Intercepted. Dismissing error modal and retrying...");

                // Decrement attempt to retry the current attempt
                attempt--;
            }
            catch (Exception e){
                System.out.println("Retrying click on save btn " + e.getMessage());
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

    public ReceiptMemoPage clickOnFixedBtn() throws InterruptedException{

        WebElement fixedButton = waitForClickableElement(fixed);
        fixedButton.click();
        Thread.sleep(2000);

        WebElement okButton = waitForClickableElement(okBtn);
        okButton.click();
        Thread.sleep(2000);


        return this ;
    }
    public ReceiptMemoPage clickOnNotFixedBtn() {
        try {

            WebElement notFixedButton = waitForClickableElement(notFixed);
            Actions actions = new Actions(driver);
            actions.moveToElement(notFixedButton).click().build().perform();
            Thread.sleep(2000);

            WebElement okButton = waitForClickableElement(okBtn);
            Actions actions1 = new Actions(driver);
            actions.moveToElement(okButton).click().build().perform();
            Thread.sleep(2000);

        }
        catch (Exception e){
            throw new RuntimeException("زر التثبيت مفعل ");
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
    private final By  searchBtn = By.xpath("//input[@class=\" btn-info btn-3d btn \" and contains(@value,\"بـحـث\")]");
    private final By  searchData = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody");

    public ReceiptMemoPage clickOnSearchTab()throws InterruptedException{
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
    public ReceiptMemoPage clickOnSearchBtn() throws InterruptedException{
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                // Attempt to click on the search button
                WebElement search= wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
                Actions actions = new Actions(driver);
                actions.moveToElement(search).click().build().perform();

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 250);");
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                // Refresh the page
                System.out.println("Page refreshed. Retrying click on search btn...");
                driver.navigate().refresh();
                Thread.sleep(2500);
                clickOnSearchTab();
            }
        }
        // If max attempts reached without success, throw a custom exception
        throw new RuntimeException("Failed to click on search button after " + maxAttempt + " attempts");
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

    private final By  editBtnParent = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[5]");
    private final By  editBtnChild = By.tagName("a");
    private final By  editBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"تعديل\")]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");

    public ReceiptMemoPage clickOnEditBtn() throws InterruptedException{
        int maxRetry = 5;
        for (int retry = 0; retry < maxRetry; retry++){
            try {
                WebElement parent = waitForVisibilityElement(editBtnParent);
                List<WebElement> child = parent.findElements(editBtnChild);
                child.get(0).click();

                Thread.sleep(2000);

                return this;
            }
            catch (Exception e){
                System.out.println("Re trying to click on edit btn ");
                driver.navigate().refresh();
                Thread.sleep(2500);
                clickOnSearchTab();
                clickOnSearchBtn();
            }}
        throw new RuntimeException("Failed to click on edit btn after all attempt");

    }
    public ReceiptMemoPage scrollToTheEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1250);");
        return this ;
    }

    public ReceiptMemoPage clickOnEditSaveBtn() throws InterruptedException{
        WebElement edit = waitForClickableElement(editBtn);
        Actions actions =new Actions(driver);
        actions.moveToElement(edit).click().build().perform();

        Thread.sleep(1500);

        WebElement ok = waitForClickableElement(okBtn);
        Actions actions1 =new Actions(driver);
        actions.moveToElement(ok).click().build().perform();
        return this;

    }

    public ReceiptMemoPage clickOnDeleteBtn() throws InterruptedException{

        int maxRetry = 5;
        for (int retry = 0; retry < maxRetry; retry++){
            try {
                WebElement parent = waitForVisibilityElement(editBtnParent);

                List<WebElement> child = parent.findElements(editBtnChild);
                child.get(1).click();

                try {
                    wait.until(ExpectedConditions.alertIsPresent());
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                    //WebElement ok = waitForClickableElement(okBtn);
                    // ok.click();
                    //  System.out.println(getDeleteSuccessMessage());

                } catch (Exception e) {
                    System.out.println("لا يمكن الحذف أو التعديل بعد التثبيت");
                }
                return this ;
            }
            catch (Exception e){
                System.out.println("Re trying to click on delete btn ");
                driver.navigate().refresh();
                Thread.sleep(2500);
                clickOnSearchTab();
                clickOnSearchBtn();
            }}
        throw new RuntimeException("Failed to click on delete btn after all attempt");

    }
    public boolean getDeleteSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();


    }
}
