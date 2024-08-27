package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WithdrawlPage
{
    //Variable
    private WebDriver driver;

    //Constructor
    WithdrawlPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Locators
    private By withdrawlAmountField = By.xpath("//input[@placeholder=\"amount\"]");
    private By withdrawButton = By.xpath("//button[@type='submit']");
    private By withdrawMessage = By.xpath("//span[@class='error ng-binding']");


    ///Actions\\\
    public void enterAmountToBeWithdrawn(String amount)
    {

        driver.findElement(withdrawlAmountField).sendKeys(amount);
    }

    public void clickWithdrawButton()
    {
        driver.findElement(withdrawButton).click();
    }

    public String getWithdralMessage()
    {
        return driver.findElement(withdrawMessage).getText();
    }
}
