
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pom.AutomationEndpointPractice;


public class endpointPracticeTest {
    WebDriver driver;
    String page = "https://breakingbadapi.com/";



    @Test
    public void getBirthdayByName() {
        AutomationEndpointPractice endpointPractice = new AutomationEndpointPractice(this.page);
        String name = "Walter White";
        System.out.println(endpointPractice.returnBirthday(name));

    }

}