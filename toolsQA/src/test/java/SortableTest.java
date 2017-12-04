import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class SortableTest {

    WebDriver webDriver;
    JavascriptExecutor js;
    private static ExtentReports report;
    String url = "http://demoqa.com/";

    @BeforeClass
    public static void init() {
        report = new ExtentReports();
        String fileName = "MyReport" + ".html";
        String filePath = System.getProperty("user.dir")
                + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
    }

    @AfterClass
    public static void cleanUp() {
        report.flush();
    }

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        if (webDriver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor) webDriver;
        }
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void defaultFun()
    {
        HomePage homepage = PageFactory.initElements(webDriver, HomePage.class);
        Sortable sortable = PageFactory.initElements(webDriver, Sortable.class);

        webDriver.manage().window().maximize();
        ExtentTest test = report.createTest("constrained");
        ScreenShot screenShot = new ScreenShot();


        webDriver.navigate().to(url);
        homepage.gotoSelectable();
        sortable.clickDefault();

        Actions builder = new Actions(webDriver);



    }
}
