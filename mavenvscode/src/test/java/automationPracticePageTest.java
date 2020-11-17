

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import pom.AutomationPracticePage;
import general.GeneralAsserts;

public class automationPracticePageTest {

    WebDriver driver;
    GeneralAsserts general;
    AutomationPracticePage automationPage;
    String page = "http://automationpractice.com/index.php?";
    
    //CR: There should be a BaseTest so this setup method should be reusable across all Classes and avoid DRY anti-pattern
    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        general = new GeneralAsserts(driver);
        automationPage = new AutomationPracticePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void add_items_to_cart() {
        String textExpected = "There is 1 item in your cart";
        String item = "Blouse";
        driver.get(this.page);  //CR: This should be part of setup method       
        automationPage.addItemToCart(item);
        Assert.assertTrue(general.isTextPresent(textExpected));
    }

    @Test
    public void remove_item_from_cart() throws InterruptedException {
        String textExpected = "Your shopping cart is empty.";
        String item = "Blouse";
        driver.get(this.page); //CR: This should be part of setup method       
        automationPage.clickShoppingCart();
        automationPage.deleteItemFromCart(item);
        Assert.assertTrue(general.isTextPresent(textExpected));       
    }

    @Test
    public void search_invalid_item() throws InterruptedException {
        String searchItem = "invalidItem";
        String textExpected = "0 results have been found.";
        driver.get(this.page);   //CR: This should be part of setup method       
        automationPage.searchItem(searchItem);
        Assert.assertTrue(general.isTextPresent(textExpected));
    }

    @Test
    public void search_valid_item() {
        String searchItem = "Blouse";
        driver.get(this.page);  //CR: This should be part of setup method       
        automationPage.searchItem(searchItem);
        Assert.assertTrue(general.isTextDisplayed("//div[@class='product-container']//a[@class='product-name' and @title='"+searchItem+"']"));
    }

    @Test
    public void check_store_information() {
        String[] urls = {"https://www.facebook.com/groups/525066904174158/", "https://twitter.com/seleniumfrmwrk", "https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA"};
        driver.get(this.page); //CR: This should be part of setup method       
        general.scrollToBottomPage();
        String fbUrl = driver.findElement(By.xpath("//li[@class='facebook']/a")).getAttribute("href");
        String twUrl = driver.findElement(By.xpath("//li[@class='twitter']/a")).getAttribute("href");
        String ytUrl = driver.findElement(By.xpath("//li[@class='youtube']/a")).getAttribute("href");
        Assert.assertEquals(fbUrl, urls[0]);
        Assert.assertEquals(twUrl, urls[1]);
        Assert.assertEquals(ytUrl, urls[2]);
    }


}
