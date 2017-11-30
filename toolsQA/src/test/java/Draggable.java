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
    @FindBy(id = "draggabl")
    private WebElement constrainedDrag1;
    @FindBy(id = "draggabl2")
    private WebElement constrainedDrag2;
    @FindBy(id = "draggabl3")
    private WebElement constrainedDrag3;
    @FindBy(id = "drag")
    private WebElement centerDrag;
    @FindBy(id = "drag2")
    private WebElement offsetDrag;
    @FindBy(id = "drag3")
    private WebElement bottomDrag;
    @FindBy(id = "containment-wrapper")
    private WebElement container;
    @FindBy(id = "inside_contain")
    private WebElement insideContainer;


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

    public WebElement getConstrainedDrag1() {
        return constrainedDrag1;
    }

    public WebElement getConstrainedDrag2() {
        return constrainedDrag2;
    }

    public WebElement getConstrainedDrag3() {
        return constrainedDrag3;
    }

    public WebElement getContainer() {
        return container;
    }

    public WebElement getCenterDrag() {
        return centerDrag;
    }

    public WebElement getOffsetDrag() {
        return offsetDrag;
    }

    public WebElement getBottomDrag() {
        return bottomDrag;
    }

    public WebElement getInsideContainer() {
        return insideContainer;
    }
}
