import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.TransactionsPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TransactionTest
{
    //Variables
    WebDriver driver;
    HomePage homePage;
    TransactionsPage transactionsPage;


    ///Test Cases\\\
    @Test
    public void verifyThatTransactionsExist()
    {
        String transactionAmount = transactionsPage.getTransactionAmount("0",3);
        assertEquals(transactionAmount, "Credit");
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
        transactionsPage = customer_AccountPage.clickTransactions();

    }
}
