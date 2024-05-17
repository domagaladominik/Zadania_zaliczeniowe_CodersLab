package zadaniezaliczeniowe01;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class AdddatesSteps {

    WebDriver driver = new ChromeDriver();

    @Given("you see empty fields to fill datas")
    public void youSeeEmptyFieldsToFillDatas() {
    }

    @And("you have completed the alias{string}, address{string} and city{string} fields")
    public void youHaveCompletedTheAliasAddressAndCityFields(String alias, String address, String city) {
        driver.findElement(By.id("field-alias")).sendKeys(alias);
        WebElement addressInput = driver.findElement(By.id("field-address1"));
        addressInput.sendKeys(address);
        WebElement cityInput = driver.findElement(By.id("field-city"));
        cityInput.sendKeys(city);
    }

    @When("you wrote zip{string} into field")
    public void youWroteZipIntoField(String zip) {
        WebElement zipInput = driver.findElement(By.id("field-postcode"));
        zipInput.sendKeys(zip);
    }

    @And("you chose field with country{string}")
    public void youChoseFieldWithCountry(String country) {
        WebElement countryInput = driver.findElement(By.id("field-id_country"));
        Select selectCountry = new Select(countryInput);
        selectCountry.selectByVisibleText("United Kingdom");
    }

    @Then("you should add yours phone{string}")
    public void youShouldAddYoursPhone(String phone) {
        WebElement phoneInput = driver.findElement(By.id("field-phone"));
        phoneInput.sendKeys(phone);
    }

    @And("click button {string}, yours datas should save")
    public void clickButtonSaveYoursDatasShouldSave() {
        WebElement saveButton = driver.findElement(By.cssSelector("btn btn-primary form-control-submit float-xs-right"));
        saveButton.click();
    }
    public void typeAlias (String alias){
        WebElement aliasInput = driver.findElement(By.id("field-alias"));
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }
}

