import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerLoginPage;
import pages.HomePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class CustomerLoginTest
{
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void verifyCustomerLogin()
    {
       CustomerLoginPage customerLoginPage = homePage.clickCustomerLoginButton();
       customerLoginPage.selectName("Harry Potter");
       CustomerAccountPage customerAccountPage = customerLoginPage.clickLogin();

       String accountName = customerAccountPage.getCustomerName();
       assertEquals(accountName, "Harry Potter");
    }
}
