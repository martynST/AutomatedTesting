import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Selectable {
    @FindBy(id = "ui-id-1")
    private WebElement defaultFun;
    @FindBy(id = "ui-id-2")
    private WebElement grid;
    @FindBy(id = "ui-id-3")
    private WebElement serielise;
    @FindBy(css = "#selectable > li:nth-child(1)")
    private WebElement selectable1;
    @FindBy(css = "#selectable > li:nth-child(2)")
    private WebElement selectable2;
    @FindBy(css = "#selectable > li:nth-child(3)")
    private WebElement selectable3;
    @FindBy(css = "#selectable > li:nth-child(4)")
    private WebElement selectable4;
    @FindBy(css = "#selectable > li:nth-child(5)")
    private WebElement selectable5;
    @FindBy(css = "#selectable > li:nth-child(6)")
    private WebElement selectable6;
    @FindBy(css = "#selectable > li:nth-child(7)")
    private WebElement selectable7;


    public void clickDefault()
    {
        defaultFun.click();
    }
    public void clickGrid()
    {
        grid.click();
    }
    public void clickSerielise()
    {
        serielise.click();
    }
    public void clickSelectable1()
    {
        selectable1.click();
    }
    public void clickSelectable2()
    {
        selectable2.click();
    }
    public void clickSelectable3()
    {
        selectable3.click();
    }
    public void clickSelectable4()
    {
        selectable4.click();
    }
    public void clickSelectable5()
    {
        selectable5.click();
    }
    public void clickSelectable6()
    {
        selectable6.click();
    }
    public void clickSelectable7()
    {
        selectable7.click();
    }

    public WebElement getSelectable1() {
        return selectable1;
    }

    public WebElement getSelectable2() {
        return selectable2;
    }

    public WebElement getSelectable3() {
        return selectable3;
    }

    public WebElement getSelectable4() {
        return selectable4;
    }

    public WebElement getSelectable5() {
        return selectable5;
    }

    public WebElement getSelectable6() {
        return selectable6;
    }

    public WebElement getSelectable7() {
        return selectable7;
    }
}
