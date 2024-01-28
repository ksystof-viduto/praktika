import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Selectors {

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
    void registerCss() {

        WebElement firstName = driver.findElement(By.cssSelector("#input-firstname"));
        WebElement lastName = driver.findElement(By.cssSelector("#input-lastname"));
        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));

        WebElement subscribeYes = driver.findElement(By.cssSelector("#input-newsletter-yes"));
        WebElement subscribeNo = driver.findElement(By.cssSelector("#input-newsletter-no"));

        WebElement agreeCheckbox = driver.findElement(By.cssSelector("div[class='float-end text-right'] input.form-check-input"));
        WebElement continueButton = driver.findElement(By.cssSelector("div[class='float-end text-right'] button[class='btn btn-primary'"));

        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        email.sendKeys("a@email.com");
        password.sendKeys("password123");

        subscribeYes.click();
        agreeCheckbox.click();
        continueButton.click();

        String expectedWebpage = "https://demo.opencart.com/index.php?route=account/register&language=en-gb";
        String actualWebpage = driver.getCurrentUrl();

        assertEquals(expectedWebpage, actualWebpage, "The actual webpage is not as expected.");

        int countOfInputFields = driver.findElements(By.cssSelector("input")).size();
        System.out.println("Count of input fields: " + countOfInputFields);

        int inputCountYourPersonalDetails = driver.findElements(By.cssSelector("#account input")).size();
        System.out.println("Count of input fields in Your Personal Details: " + inputCountYourPersonalDetails);

//        int countOfClassAttr = driver.findElements(By.cssSelector("[class='form-control']")).size();
        int countOfClassAttr = driver.findElements(By.cssSelector(".form-control")).size();
        System.out.println("(cssSelector)Count of elements with class=form-control: " + countOfClassAttr);

//        driver.findElement(By.cssSelector("div.float-end div.form-check input.form-check-input")).click();
//        driver.findElement(By.cssSelector("div.float-end button")).click();
    }

    @Test
    void registerXpath() {

        WebElement firstName = driver.findElement(By.xpath("//div[@id='content']//input[@id='input-firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//div[@id='content']//input[@id='input-lastname']"));
        WebElement email = driver.findElement(By.xpath("//div[@id='content']//input[@id='input-email']"));
        WebElement password = driver.findElement(By.xpath("//div[@id='content']//input[@id='input-password']"));

        WebElement subscribeYes = driver.findElement(By.xpath("//div[@id='content']//input[@id='input-newsletter-yes']"));
        WebElement subscribeNo = driver.findElement(By.xpath("//div[@id='content']//input[@id='input-newsletter-no']"));

        WebElement agreeCheckbox = driver.findElement(By.xpath("//div[@id='content']//input[@class='form-check-input']"));
        WebElement continueButton = driver.findElement(By.xpath("//div[@id='content']//button[@class='btn btn-primary']"));

        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        email.sendKeys("a@email.com");
        password.sendKeys("password123");

        subscribeYes.click();
        agreeCheckbox.click();
        continueButton.click();

        int countOfInputFields = driver.findElements(By.xpath("//input")).size();
        System.out.println("Count of input fields: " + countOfInputFields);

        int inputCountYourPersonalDetails = driver.findElements(By.xpath("//*[@id='account']//input")).size();
        System.out.println("Count of input fields in Your Personal Details: " + inputCountYourPersonalDetails);


        int countOfClassAttr = driver.findElements(By.xpath("//*[contains(@class, 'form-control')]")).size();
//        int countOfClassAttr = driver.findElements(By.xpath("//*[@class='form-control']")).size();
        System.out.println("(xpath) Count of elements with class=form-control: " + countOfClassAttr);

        int countOfText = driver.findElements(By.xpath("//a[contains(text(), 'test')]")).size();
        System.out.println(countOfText);

    }
}
