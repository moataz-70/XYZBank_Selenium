package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CustomerAccountPage
{
    //Variables
    private WebDriver driver;

    //locators
    private By transactionsButton = By.xpath("//button[@ng-class='btnClass1']");
    private By depositButton = By.xpath("//button[@ng-class='btnClass2']");
    private By customerName = By.xpath("//span[@class='fontBig ng-binding']");
    private By withdrawlButton = By.xpath("//button[@ng-class='btnClass3']");

    //Constructor
    public CustomerAccountPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //////////Actions\\\\\\\\\\\
    public TransactionsPage clickTransactions()
    {
        driver.findElement(transactionsButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return new TransactionsPage(driver);
    }

    public DepositPage clickDeposit()
    {
        driver.findElement(depositButton).click();
        return new DepositPage(driver);
    }

    public String getCustomerName()
    {
        return driver.findElement(customerName).getText();
    }

    public WithdrawlPage clickWithdrawl()
    {
        driver.findElement(withdrawlButton).click();
        return new WithdrawlPage(driver);
    }


}
