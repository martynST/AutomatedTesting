import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Draggable extends Navigation{
    @FindBy(id = "draggable")
    private WebElement draggable;
    @FindBy(id = "ui-id-1")
    private WebElement defaultFun;
    @FindBy(id = "ui-id-2")
    private WebElement contrained;
    @FindBy(id = "ui-id-3")
    private WebElement cursor;
    @FindBy(id = "ui-id-4")
    private WebElement Events;
    @FindBy(id = "io-id-5")
    private WebElement dragSort;

    public void gotoDragSort() {
        dragSort.click();
    }

    public void gotoContrained() {
        contrained.click();
    }

    public void gotoCursor() {
        cursor.click();
    }

    public void gotoDefaultFun() {
        defaultFun.click();
    }

    public void gotoEvents() {
        Events.click();
    }

    public WebElement getDraggable() {
        return draggable;
    }
}
