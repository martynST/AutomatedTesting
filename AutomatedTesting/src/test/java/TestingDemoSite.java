import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestingDemoSite {
    private WebDriver webDriver;
    private static ExtentReports report;
    private SpreadSheetReader spreadSheetReader;

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
        spreadSheetReader = new SpreadSheetReader("properties.xlsx");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void createAccount2() {
        ExtentTest test = report.createTest("MyFirstTest");
        ScreenShot screenShot = new ScreenShot();
        Homepage homepage = PageFactory.initElements(webDriver, Homepage.class);
        SignUpPage signUpPage = PageFactory.initElements(webDriver, SignUpPage.class);
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);


        List<String> inputList = new ArrayList<String>();
        inputList = spreadSheetReader.readRow(0, "Sheet1");
        String username = inputList.get(1);
        inputList = spreadSheetReader.readRow(1, "Sheet1");
        String password = inputList.get(1);
        inputList = spreadSheetReader.readRow(2, "Sheet1");
        String url = inputList.get(1);
        inputList = spreadSheetReader.readRow(2, "Sheet1");
        String expected = inputList.get(1);

        test.log(Status.INFO, "Opening chrome and going to website");
        webDriver.navigate().to(url);
        test.log(Status.INFO, "Going to sign up page");
        homepage.goToSignUp();
        test.log(Status.INFO, "enter username");
        signUpPage.setUsername(username);
        test.log(Status.INFO, "enter password");
        signUpPage.setPassword(password);
        test.log(Status.INFO, "make account");
        signUpPage.sendSubmit();
        test.log(Status.INFO, "go to log in page");
        signUpPage.goToLogin();
        test.log(Status.INFO, "enter username");
        loginPage.setUsername(username);
        test.log(Status.INFO, "enter password");
        loginPage.setPassword(password);
        test.log(Status.INFO, "login");
        loginPage.sendSubmit();
        try {
            String path = screenShot.take(webDriver, "image");
            test.addScreenCaptureFromPath(path);
        } catch (IOException e) {

        }
        Assert.assertEquals("login failed", loginPage.getStatus(), "**Successful Login**");
    }
}