import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigation {
    @FindBy(css = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)")
    private WebElement signUp;
    @FindBy(css = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")
    private WebElement login;

    public void goToLogin ()
    {
        login.click();
    }
    public void goToSignUp()
    {
        signUp.click();
    }
}
