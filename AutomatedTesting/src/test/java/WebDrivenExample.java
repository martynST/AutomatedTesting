import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDrivenExample {

    private String url = "https://github.com/login";
    private WebDriver webDriver;

    @Before
    public void setUp()
    {
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }

    @Test
    public void githubLogin()
    {
        webDriver.navigate().to(url);
        webDriver.findElement(By.cssSelector("#login_field")).sendKeys("MST1995222017");
        webDriver.findElement(By.cssSelector("#password")).sendKeys("damsmells28\n");
        String expectedUrl = "https://github.com/";
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals("login failed",expectedUrl,currentUrl);
    }

}
