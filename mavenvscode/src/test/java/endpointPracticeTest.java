
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pom.AutomationEndpointPractice;
import java.util.List;

import pojo.CharacterPojo;

public class endpointPracticeTest {
    WebDriver driver;
    String page = "https://breakingbadapi.com/";

    @Test
    public void getBirthdayByName() {
        AutomationEndpointPractice endpointPractice = new AutomationEndpointPractice(this.page);
        String name = "Walter White";
        System.out.println(endpointPractice.returnBirthday(name));
    }

    @Test
    public void getCharaceters() {
        AutomationEndpointPractice endpointPractice = new AutomationEndpointPractice(this.page);
        List<CharacterPojo> listCharacters = endpointPractice.returnCharacters();
        for (CharacterPojo characterPojo : listCharacters) {
            System.out.println("Character name: "+ characterPojo.returName());
            System.out.println("Portrayed: "+ characterPojo.returnPortrayed());
            System.out.println("--------------------------------------------");
        }
    }

}