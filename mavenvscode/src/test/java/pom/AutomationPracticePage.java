package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticePage {
    WebDriver driver;
    WebDriverWait wait;

    public AutomationPracticePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddToCart() {
        driver.findElement(By.id("add_to_cart")).click();
    }

    public void clickShoppingCart(){
        driver.findElement(By.xpath("//div[@class='shopping_cart']//a")).click();
    }

    public void addItemToCart(String itemName) {
        driver.findElement(By.xpath("//a[@title ='"+itemName+"' and @class='product-name']")).click();
        clickAddToCart();
    }

    public void deleteItemFromCart(String itemName) {
        driver.findElement(By.xpath("//tr/td[@class='cart_description']/p/a[text()='"+itemName+"']/ancestor::tr/td[@data-title='Delete']")).click();
    }

    public void searchItem(String itemName){
        driver.findElement(By.id("search_query_top")).sendKeys(itemName);
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
    }
}

