package zadaniezaliczeniowe01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Exercise01 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?");

        WebElement signInButton = driver.findElement(By.xpath("//span[@class='hidden-sm-down']"));
        signInButton.click();
        try {
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field-email")));
            emailInput.clear();
            emailInput.sendKeys("fnbraiqgpvqjcgzkdw@cazlg.com");

            Thread.sleep(1000);

            WebElement passwordInput = driver.findElement(By.id("field-password"));
            passwordInput.clear();
            passwordInput.sendKeys("123456");

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        WebElement signinButton = driver.findElement(By.id("submit-login"));
        signinButton.click();

        WebElement addressesLink = driver.findElement(By.cssSelector("a[title='Addresses']"));
        addressesLink.click();

        WebElement creNewAddress = driver.findElement(By.xpath("//*[text()='Create new address']"));
        creNewAddress.click();

        try {

            WebElement aliasInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field-alias")));
            aliasInput.sendKeys(alias);
            Thread.sleep(1000);
            driver.findElement(By.id("field-address1")).sendKeys(address);
            Thread.sleep(1000);
            driver.findElement(By.id("field-city")).sendKeys(city);
            Thread.sleep(1000);
            driver.findElement(By.id("field-postcode")).sendKeys(zip);
            Thread.sleep(1000);
            WebElement countryInput = driver.findElement(By.id("field-id_country"));
            Select selectCountry = new Select(countryInput);
            selectCountry.selectByVisibleText(country);
            driver.findElement(By.id("field-phone")).sendKeys(phone);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            WebElement saveButton = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/footer/button"));
            saveButton.click();

            driver.quit();
        }
    }
}
