import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.DepositPage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DepositTest
{
    //Variables
    private WebDriver driver;
    private HomePage homePage;
    private DepositPage depositPage;


    //Test Cases
    @Test
    public void verifyAddedDeposit()
    {
        depositPage.enterDepositAmount("25000");
        depositPage.clickDepositButton();
        String assertionMessage = depositPage.getAssertionMessage();
        assertEquals(assertionMessage, "Deposit Successful");
    }


    ///Configuration\\\
    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        var customerLoginPage = homePage.clickCustomerLoginButton();
        customerLoginPage.selectName("Harry Potter");
        CustomerAccountPage customerAccountPage =  customerLoginPage.clickLogin();
        depositPage = customerAccountPage.clickDeposit();

    }
}
