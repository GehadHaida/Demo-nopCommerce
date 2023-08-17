package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import stepDefinition.Hooks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P03_homePage {

    private String fbSecondTabHandleURL;
    private String twSecondTabHandleURL;
    private String rssSecondTabHandleURL;
    private String youtubeSecondTabHandleURL;
    private String selectedSubCategoryText;

    public void currency(){
        Select select = new Select(Hooks.driver.findElement(By.id("customerCurrency")));
        select.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
    }

    public void assertCurrency()
    {
        List<WebElement> euro = Hooks.driver.findElements(By.className("actual-price"));
        for (WebElement priceElement : euro) {
            String priceText = priceElement.getText();
            Assert.assertTrue(priceText.contains("€"), "Euro symbol (€) is not shown on product price: " + priceText);
        }

    }

    public void searchByProductName(String productName)
    {
        WebElement searchBox = Hooks.driver.findElement(By.id("small-searchterms"));
        searchBox.sendKeys(productName);
    }

    public void clickSearchButton(){
        WebElement searchButton = Hooks.driver.findElement(By.className("button-1"));
        searchButton.click();
    }

    public void assertSearchResultsExist(SoftAssert softAssert) {
        List<WebElement> searchResults = Hooks.driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[1]/div/div[2]/h2/a"));
        softAssert.assertFalse(searchResults.isEmpty(), "No search results found.");
    }

    public void assertSearchResultsContainProductName(String productName, SoftAssert softAssert) {
        List<WebElement> searchResults = Hooks.driver.findElements(By.className("item-grid"));
        boolean hasRelativeResults = searchResults.stream()
                .map(WebElement::getText)
                .anyMatch(resultText -> resultText.toLowerCase().contains(productName.toLowerCase()));

        softAssert.assertTrue(hasRelativeResults, "No relative results found for product: " + productName);
    }

    public void searchByProductSku(String sku)
    {
        WebElement searchBox = Hooks.driver.findElement(By.id("small-searchterms"));
        searchBox.sendKeys(sku);
    }

    public void clickOnTheProduct(){
        WebElement clickOnProduct = Hooks.driver.findElement(By.className("product-title"));
        clickOnProduct.click();
    }

    public void verifyProductGotSkuCode(String sku){
        WebElement skuCodeElement = Hooks.driver.findElement(By.className("value"));
        String skuCode = skuCodeElement.getText();
        Assert.assertEquals(sku, skuCode);

    }

    public void clicksOnFacBookIcon() throws InterruptedException {
        String fbFirstTabHandle = Hooks.driver.getWindowHandle();
        WebElement facebookLink = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[1]/a"));
        facebookLink.click();
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        fbSecondTabHandleURL = Hooks.driver.getCurrentUrl();
        Thread.sleep(3000);
        Hooks.driver.close();

        Hooks.driver.switchTo().window(fbFirstTabHandle);   //Not needed (just in case if there were multiple windows not only these 2)

    }

    public void facebookAssertion(){
        Assert.assertEquals(fbSecondTabHandleURL,"https://www.facebook.com/nopCommerce");
    }

    public void clicksOnTwitterIcon() throws InterruptedException {
        WebElement twitterLink = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[2]/a"));
        twitterLink.click();
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        twSecondTabHandleURL = Hooks.driver.getCurrentUrl();
        Thread.sleep(3000);
        Hooks.driver.close();

        Hooks.driver.switchTo().window(tabs.get(0));   //Not needed (just in case if there were multiple windows not only these 2)

    }

    public void twitterAssertion(){
        Assert.assertEquals(twSecondTabHandleURL,"https://twitter.com/nopCommerce");
    }

    public void clicksOnRssIcon() throws InterruptedException {
        WebElement rssLink = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[3]/a"));
        rssLink.click();
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        rssSecondTabHandleURL = Hooks.driver.getCurrentUrl();
        Thread.sleep(3000);
        Hooks.driver.close();

        Hooks.driver.switchTo().window(tabs.get(0));   //Not needed (just in case if there were multiple windows not only these 2)

    }

    public void rssAssertion(){
        Assert.assertEquals(rssSecondTabHandleURL, "https://demo.nopcommerce.com/new-online-store-is-open");
    }

    public void clicksOnYoutubeIcon() throws InterruptedException {
        WebElement youtubeLink = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[4]/a"));
        youtubeLink.click();
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        youtubeSecondTabHandleURL = Hooks.driver.getCurrentUrl();
        Thread.sleep(3000);
        Hooks.driver.close();

        Hooks.driver.switchTo().window(tabs.get(0));   //Not needed (just in case if there were multiple windows not only these 2)

    }

    public void youtubeAssertion(){
        Assert.assertEquals(youtubeSecondTabHandleURL, "https://www.youtube.com/user/nopCommerce");
    }

    public WebElement clickOnWishListButton(){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]"));
    }

    public void wishListAssertion() throws InterruptedException{
        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/div")));

        String actualBgColor = successMessageElement.getCssValue("background-color");
        String expectedColor = "rgba(75, 176, 122, 1)";

        softAssert.assertTrue(successMessageElement.isDisplayed(), "Success message is not displayed.");
        softAssert.assertEquals(actualBgColor, expectedColor, "Error message color is not green.");

        softAssert.assertAll();
    }

    public void successMessageDisappear(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(100));
        WebElement wishlist = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(wishlist));


    }

    public void wishListQuantity(){
        Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[1]")).click();
        String count =   Hooks.driver.findElement(By.className("qty-input")).getAttribute("value");
        int countint=    Integer.parseInt(count);
        Assert.assertTrue(countint>0);
    }

    public void homeSliderGalaxy(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement galaxyS22Slider = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a[2]")));

        galaxyS22Slider.click();
    }

    public void galaxyS22SliderAssertion(){
        String currentURL = Hooks.driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/nokia-lumia-1020";

        Assert.assertEquals(currentURL, expectedURL, "The correct webpage did not open.");
    }

    public void homeSliderIphone(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement iphone14 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a[1]")));

        iphone14.click();
    }

    public void iphone14SliderAssertion(){
        String currentURL = Hooks.driver.getCurrentUrl();
        String expectedURL = " https://demo.nopcommerce.com/iphone-6";

        Assert.assertEquals(currentURL, expectedURL, "The correct webpage did not open.");
    }

    public void hoverMainCategory(){
        WebElement mainCategoryElement = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(mainCategoryElement).perform();
//        WebElement subCategoryElement = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[2]/li[1]/ul/li[2]/a"));
//        subCategoryElement.click();
    }

    public void randomSubCategoryAndAssertion(){
        List<WebElement> subCategoryElements = Hooks.driver.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul"));
        Random random = new Random();
        int randomIndex = random.nextInt(subCategoryElements.size());
        WebElement randomSubCategoryElement = subCategoryElements.get(randomIndex);
        String selectedSubCategoryText = randomSubCategoryElement.getText().toLowerCase().trim();
        randomSubCategoryElement.click();
        WebElement pageTitleElement = Hooks.driver.findElement(By.className("page-title"));
        String subCategoryPageMainTitle = pageTitleElement.getText().toLowerCase().trim();
        Assert.assertTrue(selectedSubCategoryText.contains(subCategoryPageMainTitle));

    }

}
