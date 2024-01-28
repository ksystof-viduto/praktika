import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ExerciseTwo {


    @Test
    void ex2() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        String website = "https://demo.opencart.com/";

//        Open https://demo.opencart.com/
        driver.get(website);

//        Enter wrong product name in Search field
        WebElement searchField = driver.findElement(By.name("search"));
        searchField.sendKeys("Macbook");

//       Click search button
        WebElement searchButton = driver.findElement(By.className("fa-search"));
        searchButton.click();

        driver.navigate().back();

        searchButton = driver.findElement(By.className("fa-search"));
        searchButton.isDisplayed();

        WebElement phones = driver.findElement(By.linkText("Phones & PDAs"));
        phones.click();

        WebElement sortSelectWebElement = driver.findElement(By.id("input-sort"));
        sortSelectWebElement.click();

        driver.findElements(By.cssSelector("#input-sort option")).get(3).click();

        int numberOfItems = driver.findElements(By.className("price-new")).size();
        System.out.println("Number of shown items: " + numberOfItems);

        Select sortSelect = new Select(driver.findElement(By.id("input-sort")));
        sortSelect.selectByVisibleText("Price (Low > High)");

//        WebElement components = driver.findElement(By.linkText("Components"));
//        components.click();
//
//        WebElement componentsMonitors = driver.findElement(By.partialLinkText("Monitors"));
//        componentsMonitors.click();
//
//        int numberOfItems = driver.findElements(By.className("price-new")).size();
//        System.out.println("Number of shown items: " + numberOfItems);
//
//        Select sortSelect = new Select(driver.findElement(By.id("input-sort")));
//
//        sortSelect.selectByVisibleText("Price (Low > High)");
//
//        Select selectedOption = new Select(driver.findElement(By.id("input-sort")));
//
//        System.out.println(selectedOption.getFirstSelectedOption().getText());

        driver.quit();
    }

}
