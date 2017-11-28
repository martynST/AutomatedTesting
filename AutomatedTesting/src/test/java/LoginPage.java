import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  Navigation{
    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
    private WebElement username;
    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
    private WebElement password;
    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
    private WebElement submit;
    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
    private WebElement status;

    public void setUsername (String username)
    {
        this.username.sendKeys(username);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void sendSubmit ()
    {
        submit.click();
    }
    public String getStatus()
    {
        return status.getText();
    }
}
