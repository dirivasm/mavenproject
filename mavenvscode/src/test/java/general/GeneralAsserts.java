package general;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class GeneralAsserts {

    WebDriver driver;

    public GeneralAsserts(WebDriver driver){
        this.driver = driver;
    }

    public Boolean isTextPresent(String text) {
        try{
            boolean b = driver.getPageSource().contains(text);
            return b;
        }
        catch(Exception e){
            return false;
        }
    }

    public Boolean isTextDisplayed(String xpath){
        try{
            boolean b = driver.findElement(By.xpath(xpath)).isDisplayed();
            return b;
        }
        catch(Exception e){
            return false;
        }
    }

    public void scrollToBottomPage() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");       
    }

}