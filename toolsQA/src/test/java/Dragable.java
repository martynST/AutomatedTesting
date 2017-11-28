import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class Dragable {

    WebDriver webDriver;
    JavascriptExecutor js;
    String url  = "http://demoqa.com/";

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

        moveDraggable(draggable.getDraggable(),400,400);

        Assert.assertEquals(originalX+400,draggable.getDraggable().getLocation().getX());
        Assert.assertEquals(originalY+400,draggable.getDraggable().getLocation().getY());
    }
    private void moveDraggable(WebElement draggable, int x, int y)
    {
        Actions builder = new Actions(webDriver);
        builder.clickAndHold(draggable).moveByOffset(x,y).release().perform();
    }
    @Test
    public void contrained() {

    }

    @Test
    public void event() {

    }

    @Test
    public void dragable() {

    }
}
