package Tutorial.FF;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class MToursTest {

    @Test
    public void shouldOpenWebsiteGood() {
        //given
        System.setProperty("webdriver.gecko.driver", "c://selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        String baseUrl = "http://demo.guru99.com/test/newtours/";

        driver.get(baseUrl);
//when
        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome: Mercury Tours";
//then
        boolean test = actualTitle.equals(expectedTitle);
        if(test)
            System.out.println("Titles Match");
        else
            System.out.println("Titles don't match");

        Assert.assertTrue(test);
        driver.quit();
    }

    @Test
    public void shouldGetFBTag(){
        //given
        System.setProperty("webdriver.gecko.driver", "c://selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://facebook.com/");

        String tagName = driver.findElement(By.id("email")).getTagName();
        System.out.println(tagName);

    }
}
