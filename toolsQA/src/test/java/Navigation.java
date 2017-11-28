import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigation {
    @FindBy(id = "menu-item-140")
    private WebElement draggable;
    @FindBy(id = "menu-item-142")
    private WebElement selectable;
    @FindBy(id = "menu-item-151")
    private WebElement sortable;
    @FindBy(id = "menu-item-99")
    private WebElement tooltip;
    @FindBy(id = "menu-item-97")
    private WebElement slider;
    @FindBy(id = "menu-item-146")
    private WebElement datePicker;

    public void gotoDraggable()
    {
        draggable.click();
    }
    public void gotoSelectable()
    {
        selectable.click();
    }
    public void gotoSortable()
    {
        sortable.click();
    }
    public void gotoTooltip()
    {
        tooltip.click();
    }
    public void gotoSlider()
    {
        slider.click();
    }
    public void gotoDatePicker()
    {
        datePicker.click();
    }
}
