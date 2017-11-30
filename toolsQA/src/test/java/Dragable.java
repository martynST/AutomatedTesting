import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.io.File;
import java.io.IOException;


public class Dragable {

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
    public void defaultFun() {
        HomePage homepage = PageFactory.initElements(webDriver, HomePage.class);
        Draggable draggable = PageFactory.initElements(webDriver, Draggable.class);
        int originalX;
        int originalY;

        webDriver.navigate().to(url);
        homepage.gotoDraggable();
        draggable.gotoDefaultFun();
        originalX = draggable.getDraggable().getLocation().getX();
        originalY = draggable.getDraggable().getLocation().getY();

        moveDraggable(draggable.getDraggable(), 400, 400);

        Assert.assertEquals(originalX + 400, draggable.getDraggable().getLocation().getX());
        Assert.assertEquals(originalY + 400, draggable.getDraggable().getLocation().getY());
    }

    private void moveDraggable(WebElement draggable, int x, int y) {
        Actions builder = new Actions(webDriver);
        builder.clickAndHold(draggable).moveByOffset(x, y).release().perform();
    }

    @Test
    public void contrained() {
        webDriver.manage().window().maximize();
        ExtentTest test = report.createTest("constrained");
        ScreenShot screenShot = new ScreenShot();
        HomePage homepage = PageFactory.initElements(webDriver, HomePage.class);
        Draggable draggable = PageFactory.initElements(webDriver, Draggable.class);
        int originalX;
        int originalY;
        WebElement box;

        webDriver.navigate().to(url);
        homepage.gotoDraggable();
        draggable.gotoContrained();
        //box 1
        box = draggable.getConstrainedDrag1();
        originalX = box.getLocation().getX();
        originalY = box.getLocation().getY();
        moveDraggable(box, 400, 400);
        Assert.assertEquals(originalX, box.getLocation().getX());
        Assert.assertEquals(originalY + 400, box.getLocation().getY());
        //box 2
        box = draggable.getConstrainedDrag2();
        originalX = box.getLocation().getX();
        originalY = box.getLocation().getY();
        moveDraggable(box, 400, 400);
        Assert.assertEquals(originalX + 400, box.getLocation().getX());
        Assert.assertEquals(originalY, box.getLocation().getY());

        //box 3
        box = draggable.getConstrainedDrag3();
        WebElement container = draggable.getContainer();
        int padBord = 2 * Integer.parseInt(container.getCssValue("padding").substring(0, 2)) + Integer.parseInt(container.getCssValue("border").substring(0, 1));
        originalX = box.getLocation().getX();
        originalY = box.getLocation().getY();
        moveDraggable(box, 600, 600);
        Assert.assertEquals(Math.min(originalX + 600, container.getLocation().getX() + (container.getSize().width - box.getSize().width) - padBord), box.getLocation().getX());
        Assert.assertEquals(Math.min(originalY + 600, container.getLocation().getY() + (container.getSize().height - box.getSize().height) - padBord), box.getLocation().getY());

        //Box 4
    }

    @Test
    public void cursorStyle() {
        webDriver.manage().window().maximize();
        ExtentTest test = report.createTest("cursorStyle");
        ScreenShot screenShot = new ScreenShot();
        HomePage homepage = PageFactory.initElements(webDriver, HomePage.class);
        Draggable draggable = PageFactory.initElements(webDriver, Draggable.class);

        int originalX;
        int originalY;
        int x = 400;
        int y = 400;
        WebElement box;

        webDriver.navigate().to(url);
        homepage.gotoDraggable();
        draggable.gotoCursor();

        //centerDrag
        box = draggable.getCenterDrag();
        originalX = box.getLocation().getX();
        originalY = box.getLocation().getY();
        moveDraggable(box, x, y);
        Assert.assertEquals(originalX + x - 6, box.getLocation().getX());
        Assert.assertEquals(originalY + y - 6, box.getLocation().getY());
    }

    @Test
    public void bottomDrag() {
        webDriver.manage().window().maximize();
        ExtentTest test = report.createTest("cursorStyle");
        ScreenShot screenShot = new ScreenShot();
        HomePage homepage = PageFactory.initElements(webDriver, HomePage.class);
        Draggable draggable = PageFactory.initElements(webDriver, Draggable.class);

        int originalX;
        int originalY;
        int x = 400;
        int y = 400;
        WebElement box;

        webDriver.navigate().to(url);
        homepage.gotoDraggable();
        draggable.gotoCursor();
        //bottomDrag
        box = draggable.getBottomDrag();
        originalX = box.getLocation().getX();
        originalY = box.getLocation().getY();
        moveDraggable(box, x, y);
        Assert.assertEquals(originalX + x, box.getLocation().getX());
        Assert.assertEquals(originalY + y - 50, box.getLocation().getY());
    }

    @Test
    public void topLeft() {
        webDriver.manage().window().maximize();
        ExtentTest test = report.createTest("cursorStyle");
        ScreenShot screenShot = new ScreenShot();
        HomePage homepage = PageFactory.initElements(webDriver, HomePage.class);
        Draggable draggable = PageFactory.initElements(webDriver, Draggable.class);

        int originalX;
        int originalY;
        int x = 400;
        int y = 400;
        WebElement box;

        webDriver.navigate().to(url);
        homepage.gotoDraggable();
        draggable.gotoCursor();

        //offsetDrag
        box = draggable.getOffsetDrag();
        originalX = box.getLocation().getX();
        originalY = box.getLocation().getY();
        moveDraggable(box, x, y);
        //(int) Math.floor((box.getSize().height)/2.0);
        Assert.assertEquals(originalX + x + 55, box.getLocation().getX());
        Assert.assertEquals(originalY + y + 55, box.getLocation().getY());
    }

    @Test
    public void event() {

    }

    @Test
    public void dragable() {

    }
}
