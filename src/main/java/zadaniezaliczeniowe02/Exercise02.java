package zadaniezaliczeniowe02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Exercise02 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
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
            passwordInput.sendKeys("123456");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception occured:" + e.getMessage());
        }

        WebElement signinButton = driver.findElement(By.id("submit-login"));
        signinButton.click();

        WebElement searchInput = driver.findElement(By.className("ui-autocomplete-input"));
        searchInput.sendKeys("Hummingbird Printed Sweater" + Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div[1]/article/div/div[1]/a/img")).click();
        WebElement regularPrice = driver.findElement(By.cssSelector(".regular-price"));
        WebElement discountPrice = driver.findElement(By.cssSelector(".current-price-value"));
        String regularPriceText = regularPrice.getText().replace("€", "").trim();
        String discountPriceText = discountPrice.getText().replace("€", "").trim();
        double regularPrices = Double.parseDouble(regularPriceText);
        double discountPrices = Double.parseDouble(discountPriceText);
        double discount = ((regularPrices - discountPrices) / regularPrices) * 100;
        if (Math.round(discount) == 20) {
            System.out.println("The discount is 20%");
        } else {
            System.out.println("The discount isn't 20%, actual discount: " + discount + "%");
        }
        WebElement sizeSelection = driver.findElement(By.id("group_1"));
        Select sizeselect = new Select(sizeSelection);
        sizeselect.selectByVisibleText("M");

        driver.get("https://mystore-testlab.coderslab.pl/index.php?id_product=2&id_product_attribute=10&rewrite=brown-bear-printed-sweater&controller=product#/2-size-m");

        WebElement quantitySelection = driver.findElement(By.cssSelector("#quantity_wanted"));
        quantitySelection.clear();
        quantitySelection.sendKeys(Keys.BACK_SPACE);
        quantitySelection.sendKeys("5");

        WebElement AddToCartButton = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button"));
        AddToCartButton.click();

        WebElement proToCheck = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cart-content-btn']/a[@class='btn btn-primary']")));
        proToCheck.click();

        WebElement proceedToCheck = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a")));
        proceedToCheck.click();

        WebElement Contiadres = driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button"));
        Contiadres.click();

        WebElement Selfpick = driver.findElement(By.cssSelector("#js-delivery > div > div.delivery-options > div:nth-child(1)"));
        Selfpick.click();

        WebElement ContiShi = driver.findElement(By.cssSelector("#js-delivery > button"));
        ContiShi.click();

        WebElement PayElement = driver.findElement(By.id("payment-option-1"));
        PayElement.click();

        WebElement agreecheBox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        agreecheBox.click();

        WebElement orderButton = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button"));
        orderButton.click();
    }
}

