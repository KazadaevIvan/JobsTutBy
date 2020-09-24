import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JobsTutByTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://jobs.tut.by/");
    }

    @Test
    public void JobsTutByTest() {
        WebElement searchInput = driver.findElement(By.cssSelector("[data-qa=search-input]"));
        searchInput.sendKeys("qa automation engineer");
        WebElement searchButton = driver.findElement(By.cssSelector("[data-qa=search-button]"));
        searchButton.click();
        List<WebElement> elements = driver.findElements(By.cssSelector("[data-qa=vacancy-serp__vacancy-employer]"));
        for (WebElement element: elements) {
            System.out.println(element.getText());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
