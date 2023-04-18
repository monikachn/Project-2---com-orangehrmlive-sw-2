package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “Admin” username
        driver.findElement(By.name("username")).sendKeys("Admin");

        //Enter “admin123“ password
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();

        //Verify the ‘Dashboard’ text is display
        String expectedMessage = "Dashboard";
        WebElement actualTextElement = driver. findElement(By.xpath("//h6[text() = 'Dashboard']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Verify dashboard is displayed", expectedMessage, actualMessage);
    }
    public void closeBrowser(){
        driver.quit();
    }





    }


