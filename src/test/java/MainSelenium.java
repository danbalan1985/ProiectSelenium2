import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class MainSelenium {

    private static void clickAnchor(ChromeDriver driver){
               driver.get("https://demoqa.com");
       // WebElement element1 = driver.findElement(By.xpath("//div[@class='home-banner']/a"));
        WebElement element2 = driver.findElement(By.cssSelector("div.home-banner a"));
       // element1.click();
        element2.click();

    }
    private static void clickByTagName(ChromeDriver driver){
        driver.get("https://demoqa.com");
        //By.tagName
         WebElement header = driver.findElement(By.tagName("header"));
         header.click();

    }
    private static void clickByID(ChromeDriver driver) {
        //by.id
        driver.get("https://demoqa.com/webtables");
        WebElement button=driver.findElement(By.id("addNewRecordButton"));
        button.click();
    }
    private static void clickByLinkText(ChromeDriver driver) {
        //By.linkText
        driver.get("https://demoqa.com/links");
        WebElement link = driver.findElement(By.linkText("Home"));
        link.click();

    }
    private static void clickByName(ChromeDriver driver) {
        //By.name
        driver.get("https://demoqa.com");
        WebElement meta = driver.findElement(By.name("viewport"));
        System.out.println(meta.getAttribute("content"));

    }
    private static void clickByPartialLinkTest(ChromeDriver driver) {
        // By.partialLinkText
        driver.get("https://demoqa.com/links");
        WebElement link = driver.findElement(By.partialLinkText("Content"));
        link.click();
    }
    private static void clickByClassName(ChromeDriver driver) {
        // By.className
        driver.get("https://demoqa.com/");
        driver.findElement(By.className("home-banner")).click();

    }

    private static void getTextParagraph(ChromeDriver driver) {
        //1. Basic Web Page Example
        driver.get("https://testpages.herokuapp.com/styled/basic-web-page-test.html");
        WebElement paragraph1 = driver.findElement(By.id("para1"));
        System.out.println("p1 "+paragraph1.getText());

        WebElement paragraph2 = driver.findElement(By.className("sub"));
        System.out.println("p2 "+paragraph2.getText());

    }
    private static void getTextParagraphFor(ChromeDriver driver) {
        //2. Element Attributes Examples
        driver.get("https://testpages.herokuapp.com/styled/attributes-test.html");

        WebElement paragraph3 = driver.findElement(By.xpath("//p[@class='class-attribute']"));
        System.out.println("p3 "+paragraph3.getText());


        WebElement paragraph4 = driver.findElement(By.id("jsattributes"));
        System.out.println("p4 init"+paragraph4.getText());
        WebElement button = driver.findElement(By.cssSelector(".styled-click-button"));

        for(int i=1;i<10;i++) {
            button.click();
            //paragraph4 = driver.findElement(By.id("jsattributes"));
            System.out.println("p4 after" + paragraph4.getText() + " " + paragraph4.getAttribute("custom-"+i));
        }

    }
    private static void getTextParagraph2(ChromeDriver driver) {
        //3.Find By Playground - Locator Examples
        driver.get("https://testpages.herokuapp.com/styled/find-by-playground-test.html");
        WebElement paragraph5 = driver.findElement(By.name("pName9"));
        WebElement anchor1 = paragraph5.findElement(By.cssSelector("a"));
        System.out.println("p5 anchor class "+ anchor1.getAttribute("class"));
        System.out.println("p5 " + paragraph5.getText());
        WebElement ul = driver.findElement(By.cssSelector("div ul"));
        WebElement link1 = ul.findElement(By.linkText("jump to para 11"));
        link1.click();
    }
    private static void getTable(ChromeDriver driver) {
        driver.get("https://testpages.herokuapp.com/styled/tag/table.html");

        WebElement table = driver.findElement(By.tagName("table"));
        System.out.println("tabel "+table.getText());

        WebElement tableCaption = table.findElement(By.cssSelector("caption"));
        System.out.println("table caption "+tableCaption.getText());


        java.util.List <WebElement> tableRows = table.findElements(By.cssSelector("tr"));

        for(WebElement row : tableRows){
            System.out.println("Row "+row.getText());
        }

        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
        WebElement summary = driver.findElement(By.cssSelector("details summary"));
        summary.click();

        WebElement inputCaption = driver.findElement(By.id("caption"));
        inputCaption.clear();
        inputCaption.sendKeys("Dynamic generated table");
        WebElement refreshButton = driver.findElement(By.id("refreshtable"));
        refreshButton.click();
    }
    private static void getScreenshot(ChromeDriver driver) {

        driver.get("https://demoqa.com");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> cards = driver.findElements(By.className("card"));
        WebElement card5 = cards.get(5);
        card5.click();

        File file = driver.getScreenshotAs(OutputType.FILE);
        File destFile = new File("d:\\testingjava\\test.png");
        try {
            FileUtils.copyFile(file,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void getButton(ChromeDriver driver) {

        driver.get("https://demoqa.com/buttons");
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        buttons.get(2).click();
        WebElement rightClkBtn =buttons.get(1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions actions = new Actions(driver);
        actions.contextClick(rightClkBtn).build().perform();
        WebElement doubleClkBtn =buttons.get(0);
        actions.doubleClick(doubleClkBtn).build().perform();

    }
    private static void getAlerts(ChromeDriver driver) {

        driver.get("https://demoqa.com/alerts");
        WebElement firstButton = driver.findElement(By.id("alertButton"));
        firstButton.click();

        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        WebElement thirdButton = driver.findElement(By.id("confirmButton"));
        thirdButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Alert alert3 = driver.switchTo().alert();
        // alert3.accept();
        alert3.dismiss();


//        WebElement fourthButton = driver.findElement(By.id("promtButton"));
//        fourthButton.click();
//        Alert alert4 = driver.switchTo().alert();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        alert4.sendKeys("Un text");
//        alert4.accept();

    }

    private static void getRadioButtons(ChromeDriver driver) {
        driver.get("http://demoqa.com/radio-button");
        WebElement yesRadioButton = driver.findElement(By.id("yesRadio"));
        WebElement noRadioButton = driver.findElement(By.id("noRadio"));

        // yesRadioButton.click(); - NU MERGE

        System.out.println("Radio yesRadioButton before isEnabled: "+ yesRadioButton.isEnabled()+" isSelected: "+yesRadioButton.isSelected());
        driver.executeScript("arguments[0].click()",yesRadioButton);
        System.out.println("Radio yesRadioButton after isEnabled: "+ yesRadioButton.isEnabled()+" isSelected: "+yesRadioButton.isSelected());

        System.out.println("Radio noRadioButton before isEnabled: "+ noRadioButton.isEnabled()+" isSelected: "+noRadioButton.isSelected());
        driver.executeScript("arguments[0].click()",noRadioButton);
        System.out.println("Radio noRadioButton after isEnabled: "+ noRadioButton.isEnabled()+" isSelected: "+noRadioButton.isSelected());

        WebElement yesImmpressiveLabel = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
        System.out.println("Radio yesImmpressiveLabel before isEnabled: "+ yesImmpressiveLabel.isEnabled()+" isSelected: "+yesImmpressiveLabel.isSelected());

        yesImmpressiveLabel.click();
        System.out.println("Radio yesImmpressiveLabel after isEnabled: "+ yesImmpressiveLabel.isEnabled()+" isSelected: "+ yesImmpressiveLabel.isSelected());


    }

    private static void windowHandlers() {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");


        WebElement tabButton = driver.findElement(By.id("tabButton"));
        tabButton.click();

        String parentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();



        for (String window : windowHandles){
            if(!window.equals(parentWindow)){
                driver.switchTo().window(window);
                break;
            }
        }

        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.close();

        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("windowButton")).click();
        Set<String> windowHandles2 = driver.getWindowHandles();


        for (String window : windowHandles2){
            if(!window.equals(parentWindow)){
                driver.switchTo().window(window);
                break;
            }
        }
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());

        driver.quit();
        System.out.println("Finish");

    }

    @Test
    public void primulTest() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.quit();
        throw new RuntimeException("Custom Exception");
    }

    @Test
    public void assertTest(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        List<WebElement> cards = driver.findElements(By.className("card"));
        assertEquals(cards.size(),6,"Wrong cart size");
        driver.quit();
    }

    @Test
    public void doubleClick() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).build().perform();
        WebElement message = driver.findElement(By.id("doubleClickMessage"));
        assertEquals(message.getText(),"You have done a double click","Double was not successful");
        driver.quit();
    }

    @Test
    public void rightClick() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        SoftAssert softAssert = new SoftAssert();
        WebElement rClick = driver.findElement(By.id("rightClickBtn"));

        softAssert.assertFalse(rClick.isDisplayed(),"Right click button is not displayed");

        Actions actions = new Actions(driver);
        actions.contextClick(rClick).build().perform();


        WebElement message = driver.findElement(By.id("rightClickMessage"));
        softAssert.assertEquals(message.getText(),"You have done a right clickx","R C was not successful");


        driver.quit();
        softAssert.assertAll();
    }
//
//
//        public static void main(String[] args) {
////        System.setProperty("webdriver.chrome.driver","src/test/chromedriver.exe");
////        ChromeDriver driver = new ChromeDriver();
//
//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
////        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
////        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
////        WebElement submitButton = driver.findElement(By.cssSelector("button[@type='submit']"));
////
////        username.clear();
////        username.sendKeys("Admin");
////        password.clear();
////        password.sendKeys("admin123");
////        submitButton.click();
//
//
////        System.out.println("");
////        WebElement ulOrange = driver.findElement(By.cssSelector("ul.oxd-main-menu"));
////        List<WebElement> lis = ulOrange.findElements(By.tagName("li"));
////        WebElement anchor = lis.get(1).findElement(By.cssSelector("a.oxd-main-menu-item"));
////        anchor.click();
////        WebElement div = driver.findElement(By.cssSelector("div.oxd-form-action"));
////        WebElement searchButton = div.findElement(By.cssSelector("button.orangehrm-left-space"));
////        button.click();
//
////        WebElement body = driver.findElement(By.tagName("body"));
////        System.out.println("BODY: "+body.getText()+body.getDomAttribute("div"));
////
////        WebElement div = body.findElement(By.id("app"));
////        WebElement h5 = div.findElement(By.tagName("h5"));
////        System.out.println("h5:"+h5.getText());
//
//
//            driver.quit();
//        System.out.println("Finish");
//    }
}
