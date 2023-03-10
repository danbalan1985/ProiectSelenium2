import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
@Test
public class SeleniumTests {

    ChromeDriver driver ;

    @BeforeMethod
    public void beforeMethod(){
         driver = WebdriverManager.getChromeDriverByManager();

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        if(driver !=null){
            driver.quit();
        }
    }

    @Test
    public void primulTest() {
        driver.get("https://demoqa.com/browser-windows");
        throw new RuntimeException("Custom Exception");
    }

    @Test
    public void assertTest(){
        driver.get("https://demoqa.com/");
        List<WebElement> cards = driver.findElements(By.className("card"));
        assertEquals(cards.size(),6,"Wrong cart size");
    }

    @Test
    public void doubleClick() {
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).build().perform();
        WebElement message = driver.findElement(By.id("doubleClickMessage"));
        assertEquals(message.getText(),"You have done a double click","Double was not successful");
    }

    @Test
    public void rightClick() {
        driver.get("https://demoqa.com/buttons");
        SoftAssert softAssert = new SoftAssert();
        WebElement rClick = driver.findElement(By.id("rightClickBtn"));

        softAssert.assertFalse(rClick.isDisplayed(),"Right click button is not displayed");

        Actions actions = new Actions(driver);
        actions.contextClick(rClick).build().perform();


        WebElement message = driver.findElement(By.id("rightClickMessage"));
        softAssert.assertEquals(message.getText(),"You have done a right clickx","R C was not successful");


        softAssert.assertAll();
    }
}
