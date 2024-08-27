package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DepositPage
{
    //Variable
    private WebDriver driver;

    //Constructor
    DepositPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Locators
    private By amountField = By.xpath("//input[@type='number']");
    private By depositButton = By.xpath("//button[@type='submit']");
    private By assertionMessage = By.xpath("//span[@ng-show='message']");
    private By withdrawlButton = By.xpath("//button[@ng-class='btnClass3']");
    private By homeButton = By.xpath("//button[@class='btn home']");


    //////////Actions\\\\\\\\\\
    public void enterDepositAmount(String amount)
    {
        driver.findElement(amountField).sendKeys(amount);
    }

    public void clickDepositButton()
    {
        driver.findElement(depositButton).click();
    }

    public String getAssertionMessage()
    {
        return driver.findElement(assertionMessage).getText();
    }

    public WithdrawlPage clickWithdrawl()
    {
        driver.findElement(withdrawlButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(withdrawlButton));
        return new WithdrawlPage(driver);
    }

    public HomePage clickHome()
    {
        driver.findElement(homeButton).click();
        return new HomePage(driver);
    }

}
