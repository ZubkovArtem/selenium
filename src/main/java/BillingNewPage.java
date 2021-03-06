import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BillingNewPage extends GeneralPage{

    public BillingNewPage(WebDriver driver) {
        super(driver);
    }

    private By customerField = By.xpath("//h3[text()='Customer Information']/../following-sibling::div//td//label[text()='Customer']/../../following-sibling::td//span/input");
    private By postingStatusField = By.xpath("//label[text()='Posting Status']/../../following-sibling::td//select");
    private By newButton = By.xpath("//*[@id='topButtonRow']/input[1]");
    private By billingNewHeader = By.xpath("//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2");

    public String getPostingStatusBefore (){
        wait.until(ExpectedConditions.presenceOfElementLocated(billingNewHeader));
        return new Select(driver.findElement(postingStatusField)).getFirstSelectedOption().getText();
    }


    public BillingDetailPage createBilling(String customer){
        wait.until(ExpectedConditions.presenceOfElementLocated(billingNewHeader));
        driver.findElement(customerField).sendKeys(customer);
        driver.findElement(newButton).click();
        return new BillingDetailPage(driver);
    }



}
