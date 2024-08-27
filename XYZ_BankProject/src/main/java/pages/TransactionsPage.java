package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionsPage
{
    //Variable
    private WebDriver driver;

    //Constructor
    TransactionsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Locators
    private By transactionRow(String idNum)
    {
        return  By.xpath("//tr[@id='anchor"+idNum+"']//td[@class='ng-binding']");
    }

    ///Actions\\\

    /**
    @param index start at 1, id start at 0
     * enter the number of transaction, then:
     * to get the date of transaction enter 1
     * to get the amount of the transaction enter 2
     * to get the transaction type enter 3
     */
    public String getTransactionDate(String transactionId, int index)
    {
      WebElement transaction = driver.findElements(transactionRow(transactionId)).get(index-1);
      return transaction.getText();
    }

    public String getTransactionAmount(String transactionId, int index)
    {
        WebElement transaction = driver.findElements(transactionRow(transactionId)).get(index-1);
        return transaction.getText();
    }

    public String getTransactionType(String transactionId, int index)
    {
        WebElement transaction = driver.findElements(transactionRow(transactionId)).get(index-1);
        return transaction.getText();
    }
}
