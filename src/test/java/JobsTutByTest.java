import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JobsTutByTest {

    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://jobs.tut.by/");
    }

    @Test
    public void getCompaniesByIndexTest() {
        homePage = new HomePage(driver);
        homePage.searchKeyWord("qa automation engineer");
        searchPage = new SearchPage(driver);
        searchPage.getCompany(1);
        searchPage.getCompany(2);
        searchPage.getCompany(3);
    }

    @Test
    public void getCompaniesByNameTest() {
        homePage = new HomePage(driver);
        homePage.searchKeyWord("qa automation engineer");
        searchPage = new SearchPage(driver);
        searchPage.getCompany("SaM Solutions Самсолюшнс");
        searchPage.getCompany("РОВЕНСИС");
        searchPage.getCompany("Andersen");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
