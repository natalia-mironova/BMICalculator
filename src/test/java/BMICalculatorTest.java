import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class BMICalculatorTest {
    @Test
    public void categoryNormal() {
        // WebDriver - interface from Selenium Library
        //Может инициализироваться несколькими способами. В себе может хранить ChromeDriver, FireFoxDriver,
        // EdgeDriver, AppiumDriver (for mobiles) etc.
        //Next Line is copied from Homework page
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        //Open the page (.get)
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("60");
        browser.findElement(By.name("ht")).sendKeys("175");
        browser.findElement(By.name("cc")).click();
        // 2 способа взять значение из тега
        // .getText(); OR .getAttribute("value");
//        String category = browser.findElement(By.name("desc")).getText();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        //System.out.println(category);
        // сравниваем (что ожидаем, что если не нашли)
        assertEquals(category, "Your category is Normal", "Категория неверная");
        browser.quit();
    }

    @Test
    public void categoryObese() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("100");
        browser.findElement(By.name("ht")).sendKeys("160");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Obese", "Категория неверная");
        browser.quit();
    }

    @Test
    public void categoryOverweight() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("80");
        browser.findElement(By.name("ht")).sendKeys("175");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Overweight", "Категория неверная");
        browser.quit();
    }
    //Branch created
}
