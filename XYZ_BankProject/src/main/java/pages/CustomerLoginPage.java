package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerLoginPage
{
    //Variable
    private WebDriver driver;

    //Locators
    private By nameField= By.id("userSelect");
    private By loginButton = By.xpath("//button[@type='submit']");

    public CustomerLoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //////////Actions\\\\\\\\\\
    public Select findDropdownElement()
    {
        return new Select(driver.findElement(nameField));
    }

    public void selectName(String name)
    {
        findDropdownElement().selectByVisibleText(name);
    }

    public CustomerAccountPage clickLogin()
    {
        driver.findElement(loginButton).click();
        return new CustomerAccountPage(driver);
    }


}
