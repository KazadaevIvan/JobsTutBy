import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By searchInput = By.cssSelector("[data-qa=search-input]");
    By searchButton = By.cssSelector("[data-qa=search-button]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchKeyWord(String keyWord) {
        driver.findElement(searchInput).sendKeys(keyWord);
        driver.findElement(searchButton).click();
    }
}
