package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage
{
    //Variable
    private WebDriver driver;

    //Locators
    private By customerLoginButton = By.xpath("//button[contains(text(),'Customer Login')]");
    private By bankMangerLoginButton = By.xpath("//button[contains(text(),'Bank Manager Login')]");

    //Constructor
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Actions
    public CustomerLoginPage clickCustomerLoginButton()
    {
        driver.findElement(customerLoginButton).click();
        return new CustomerLoginPage(driver);
    }

}
