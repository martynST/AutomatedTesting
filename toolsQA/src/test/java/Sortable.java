import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sortable {
    @FindBy(id = "ui-id-1")
    private WebElement defaultFun;
    @FindBy(id = "ui-id-2")
    private WebElement connect;
    @FindBy(id = "ui-id-3")
    private WebElement grid;
    @FindBy(id = "ui-id-4")
    private WebElement portlets;

    public void clickDefault()
    {
        defaultFun.click();
    }
    public void clickConnect()
    {
        connect.click();
    }
    public void clickGrid()
    {
        grid.click();
    }
    public void clickPortles()
    {
        portlets.click();
    }
}
