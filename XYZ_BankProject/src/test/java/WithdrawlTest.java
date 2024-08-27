import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.WithdrawlPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class WithdrawlTest
{
    //Variables
    private WebDriver driver;
    private HomePage homePage;
    private WithdrawlPage withdrawlPage;

    ///Test Cases\\\
    @Test
    public void verifySuccessfulWithdrawl()
    {
        withdrawlPage.enterAmountToBeWithdrawn("100000");
        withdrawlPage.clickWithdrawButton();

        String resultMessage = withdrawlPage.getWithdralMessage();
        assertEquals(resultMessage, "Transaction successful");
    }

    ///Configuration\\\
    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        CustomerLoginPage customerLoginPage = homePage.clickCustomerLoginButton();
        customerLoginPage.selectName("Harry Potter");
        CustomerAccountPage customerAccountPage = customerLoginPage.clickLogin();

        var depositPage = customerAccountPage.clickDeposit();
        depositPage.enterDepositAmount("500000");
        depositPage.clickDepositButton();

        var homePage = depositPage.clickHome();

        var customer_LoginPage = homePage.clickCustomerLoginButton();
        customer_LoginPage.selectName("Harry Potter");

        var customer_AccountPage = customer_LoginPage.clickLogin();
        withdrawlPage = customer_AccountPage.clickWithdrawl();

    }

    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }

}
