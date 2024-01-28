import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

import static net.andreinc.mockneat.unit.text.Strings.strings;

public class Selectors {


    private final String website = "https://demo.opencart.com/index.php?route=account/register&language=en-gb";
    private final List<String> emails = new ArrayList<>();

    @Test
    void registerCss(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get(website);

        WebElement firstName = driver.findElement(By.cssSelector("#input-firstname"));
        WebElement lastName = driver.findElement(By.cssSelector("#input-lastname"));
        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));

        WebElement subscribeYes = driver.findElement(By.cssSelector("#input-newsletter-yes"));
        WebElement subscribeNo = driver.findElement(By.cssSelector("#input-newsletter-no"));

        String randomEmail;

        do {
            randomEmail = "testUser" + strings().size(5).get();
        } while (emails.contains(randomEmail));

        emails.add(randomEmail);

        WebElement agreeCheckbox = driver.findElement(By.cssSelector("div[class='float-end text-right'] input.form-check-input"));
        WebElement continueButton = driver.findElement(By.cssSelector("div[class='float-end text-right'] button[class='btn btn-primary'"));

        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        email.sendKeys(  randomEmail + "@email.com");
        password.sendKeys("password123");

        subscribeYes.click();
        agreeCheckbox.click();
        continueButton.click();

        int countOfInputFields =  driver.findElements(By.cssSelector("input")).size();
        System.out.println("Count of input fields: " + countOfInputFields);

        int inputCountYourPersonalDetails = driver.findElements(By.cssSelector("#account input")).size();
        System.out.println("Count of input fields in Your Personal Details: " + inputCountYourPersonalDetails );

//        int countOfClassAttr = driver.findElements(By.cssSelector("[class='form-control']")).size();
        int countOfClassAttr = driver.findElements(By.cssSelector(".form-control")).size();
        System.out.println("(cssSelector)Count of elements with class=form-control: " + countOfClassAttr);

        driver.quit();
    }

    @Test
    void registerXpath(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get(website);

        WebElement firstName = driver.findElement(By.xpath("//div[@id='content']//input[@id='input-firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//div[@id='content']//input[@id='input-lastname']"));
        WebElement email = driver.findElement(By.xpath("//div[@id='content']//input[@id='input-email']"));
        WebElement password = driver.findElement(By.xpath("//div[@id='content']//input[@id='input-password']"));

//        WebElement subscribeYes = driver.findElement(By.cssSelector("#input-newsletter-yes"));
        WebElement subscribeYes = driver.findElement(By.xpath("//div[@id='content']//input[@id='input-newsletter-yes']"));
//        WebElement subscribeNo = driver.findElement(By.cssSelector("#input-newsletter-no"));
        WebElement subscribeNo = driver.findElement(By.xpath("//div[@id='content']//input[@id='input-newsletter-no']"));


        String randomEmail;

        do {
            randomEmail = "testUser" + strings().size(5).get();
        } while (emails.contains(randomEmail));

        emails.add(randomEmail);

//        WebElement agreeCheckbox = driver.findElement(By.cssSelector("div[class='float-end text-right'] input.form-check-input"));
        WebElement agreeCheckbox = driver.findElement(By.xpath("//div[@id='content']//input[@class='form-check-input']"));
//        WebElement continueButton = driver.findElement(By.cssSelector("div[class='float-end text-right'] button[class='btn btn-primary'"));
        WebElement continueButton = driver.findElement(By.xpath("//div[@id='content']//button[@class='btn btn-primary']"));

        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        email.sendKeys(  randomEmail + "@email.com");
        password.sendKeys("password123");

        subscribeYes.click();
        agreeCheckbox.click();
        continueButton.click();

        int countOfInputFields =  driver.findElements(By.xpath("//input")).size();
        System.out.println("Count of input fields: " + countOfInputFields);

        int inputCountYourPersonalDetails = driver.findElements(By.xpath("//fieldset[@id='account']//input")).size();
        System.out.println("Count of input fields in Your Personal Details: " + inputCountYourPersonalDetails );

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        int countOfClassAttr = driver.findElements(By.xpath("//*[contains(@class, 'form-control')]")).size();
        int countOfClassAttr = driver.findElements(By.xpath("//*[@class='form-control']")).size();
        System.out.println("(xpath) Count of elements with class=form-control: " + countOfClassAttr);

        driver.quit();
    }


}
