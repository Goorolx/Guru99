package Firefox;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import static Firefox.Utils.*;

public class Guru99TestSuite {

    @Test
    public void t01loginToGuruBankSuccessful() {
        WebDriver driver = webDriverStarter();
        WebDriverWait wait = waitStarter(driver);
        driver.get(BASE_URL);


        //waiting for login field to show up
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid"))).click();

        driver.findElement(By.name("uid")).sendKeys(USER_NAME); // type login
        driver.findElement(By.name("password")).sendKeys(PASSWD); // type password
        driver.findElement(By.name("btnLogin")).click();  //click login button

        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.equalsIgnoreCase("Guru99 Bank Manager HomePage"));

        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TestSetLogin1.csv", numLinesToSkip = 1)
    public void t02loginToGuruBankFail(String USER_NAME, String PASSWD) {
        WebDriver driver = webDriverStarter();
        WebDriverWait wait = waitStarter(driver);
        driver.get(BASE_URL);

        //waiting for login field to show up
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid"))).click();

        driver.findElement(By.name("uid")).sendKeys(USER_NAME); // type login
        driver.findElement(By.name("password")).sendKeys(PASSWD); // type password
        driver.findElement(By.name("btnLogin")).click();  //click login button

        String pageAlert = driver.switchTo().alert().getText(); //getting alert massage
        Assert.assertTrue(pageAlert.contains("User or Password is not valid"));
        driver.quit();
    }

    public WebDriver webDriverStarter(){
        System.setProperty(GECO_DRIV, GECO_PATH);
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public WebDriverWait waitStarter(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        return wait;
    }
}
