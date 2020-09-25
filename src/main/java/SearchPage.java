import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

    WebDriver driver;
    By companies = By.cssSelector("[data-qa=vacancy-serp__vacancy-employer]");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getCompany(int index) {
        List<WebElement> elements = driver.findElements(companies);
        try {
            System.out.println(elements.get(index).getText());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no company with index " + index);
        }
    }

    public void getCompany(String name) {
        try {
            String companyName = driver.findElement(By.linkText(name)).getText();
            System.out.println("The company " + companyName + " is in the list of vacancies");
        } catch (NoSuchElementException e) {
            System.out.println("There is no company with name " + name);
        }
    }

}
