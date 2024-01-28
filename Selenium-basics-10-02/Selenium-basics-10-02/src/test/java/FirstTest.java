import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
        String website = "https://demo.opencart.com/index.php?route=account/register&language=en-gb";
        driver = new FirefoxDriver();
        driver.get(website);
        driver.manage().window().maximize();
    }

    @AfterEach
    void exit() {
        driver.quit();
    }

    @Test
    void assertTest() {
        int expectedSearchBoxAmount = 1;
        int amountOfSearchBoxes = driver.findElements(By.name("search")).size();

        assertEquals(expectedSearchBoxAmount, amountOfSearchBoxes, "Count of search boxes is incorrect.");
//        assertThat(amountOfSearchBoxes).as("Count of search boxes is incorrect.").isEqualTo(expectedSearchBoxAmount);

        driver.findElement(By.id("wishlist-total")).click();
        driver.findElement(By.linkText("Continue")).click();

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        WebElement cartElement = driver.findElement(By.id("header-cart"));
        WebElement agreeCheckbox = driver.findElement(By.cssSelector("div[class='float-end text-right'] input.form-check-input"));

        agreeCheckbox.click();

        boolean isPasswordEnabled = password.isEnabled();
        boolean isCartElementDisplayed = cartElement.isDisplayed();
        boolean isAgreeCheckboxSelected = agreeCheckbox.isSelected();

        assertTrue(password.isEnabled(), "Password field is not enabled.");
//        assertThat(isPasswordEnabled).isTrue();
        assertTrue(cartElement.isDisplayed(), "Cart element is not displayed.");
//        assertThat(isCartElementDisplayed).isTrue();
        assertTrue(agreeCheckbox.isSelected(), "Agree checkbox is not selected.");
//        assertThat(isAgreeCheckboxSelected).isFalse();

        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Show All Desktops")).click();

        Select showItemsPerPage = new Select(driver.findElement(By.id("input-limit")));
        showItemsPerPage.selectByVisibleText("25");

        showItemsPerPage = new Select(driver.findElement(By.id("input-limit")));
        String expectedSelectedOption = "25";
        String actualSelectedOption = showItemsPerPage.getFirstSelectedOption().getText();

        assertEquals(expectedSelectedOption, actualSelectedOption, "Selected option is incorrect.");
//        assertThat(actualSelectedOption).as("Selected option is incorrect.").isEqualTo(expectedSelectedOption);
    }

    @Test
    void ex1() {
//        3. Click on a wishlist
        driver.findElement(By.id("wishlist-total")).click();

//        4. Count and print a number of search boxes
        int searchBoxesAmount = driver.findElements(By.name("search")).size();
        System.out.println("Amount of search boxes: " + searchBoxesAmount);

//        5. Find element of email input field and enter email “email@email.com”
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("email@email.com");

//        6. Clear previous field
        emailInput.clear();

//        7. Click Login
//        driver.findElement(By.cssSelector("#form-login button")).click();

        driver.findElement(By.linkText("Login")).click();

//        8. Click on register a new customer
        driver.findElement(By.linkText("Continue")).click();

//        9. Check if the field to input password is enabled and print the result
        System.out.println("Password input field enabled: " + driver.findElement(By.id("input-password")).isEnabled());

//        10. Check if cart element is displayed and print the result
        System.out.println("Cart element displayed: " + driver.findElement(By.id("header-cart")).isDisplayed());

//        11. Check if agree checkbox is selected and print the result
        System.out.println("Agree checkbox selected: " + driver.findElement(By.name("agree")).isSelected());

//        12. Go to top menu -> Desktops
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Show All Desktops")).click();

//        13. Select to show 25 items per page
        Select showItemsPerPage = new Select(driver.findElement(By.id("input-limit")));
        showItemsPerPage.selectByVisibleText("25");

//        14. Print selected option from the dropbox
        showItemsPerPage = new Select(driver.findElement(By.id("input-limit")));
        System.out.println("Selected option text: " + showItemsPerPage.getFirstSelectedOption().getText());

//        15. Select 4th option in show items per page dropbox
        showItemsPerPage = new Select(driver.findElement(By.id("input-limit")));
        showItemsPerPage.selectByIndex(3);

//        16. Print selected option
        showItemsPerPage = new Select(driver.findElement(By.id("input-limit")));
        System.out.println("Selected option text: " + showItemsPerPage.getFirstSelectedOption().getText());


//        17. Close the window
//        driver.close();
    }

    @Test
    void exCorrect() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://demo.opencart.com/");
        driver.findElement(By.id("wishlist-total")).click();
        //Count and print a number of search boxes
        int searchBoxesSize = driver.findElements(By.name("search")).size();
        System.out.println("search boxes count: " + searchBoxesSize);
        //Find element of email input field and enter email “email@email.com”
        driver.findElement(By.id("input-email")).sendKeys("email@email.com");
        //Clear previous field
        driver.findElement(By.id("input-email")).clear();
        //Click Login
        driver.findElement(By.cssSelector("#form-login button")).click();
        Thread.sleep(1000);
        //Click on register a new customer
        driver.findElement(By.linkText("Continue")).click();
        //Check if the field to input password is enabled and print the result
        System.out.println("password input is enabled?" + driver.findElement(By.id("input-password")).isEnabled());
        boolean isCartDisplayed = driver.findElement(By.id("header-cart")).isDisplayed();
        System.out.println("is cart displayed?: " + isCartDisplayed);
        System.out.println("is cart agree selected?: " + driver.findElement(By.name("agree")).isSelected());
        //Click Desktops
        driver.findElement(By.linkText("Desktops")).click();
        //Click show All Desktops
        driver.findElement(By.linkText("Show All Desktops")).click();
        //Select to show 25 items per page
        Select select = new Select(driver.findElement(By.id("input-limit")));
        select.selectByVisibleText("25");
        //Print selected option from the dropbox
        select = new Select(driver.findElement(By.id("input-limit")));
        System.out.println("selected option text: " + select.getFirstSelectedOption().getText());
        //Select 4th option in show items per page dropbox
        select = new Select(driver.findElement(By.id("input-limit")));
        select.selectByIndex(3);
//        driver.close();


    }
}
