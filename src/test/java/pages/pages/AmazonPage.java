package pages.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.BaseClass;

import java.util.List;

public class AmazonPage extends BaseClass {
    @FindBy(id = "nav-hamburger-menu")
    public WebElement navigationMenu;

    @FindBy(xpath = "//ul[@class = 'hmenu hmenu-visible']/li")
    public List <WebElement> menuList;

    @FindBy(xpath = "//ul[@class = 'hmenu hmenu-visible hmenu-translateX']/li")
    public List <WebElement> tvAudioMenuList;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    public List<WebElement> brandsCheckboxes;

    @FindBy(xpath = "//span[text() = 'Samsung']")
    public WebElement samsungCheckBox;

    @FindBy(xpath = "//*[@id = 'a-autoid-0-announce']")
    public WebElement sortByBtn;

    @FindBy(xpath = "//div[@class = 'a-popover-inner']/ul/li")
    public List <WebElement> sortByDropdownValuesList;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    public List <WebElement> allPricesList;

    @FindBy(xpath = "//h1[text() = ' About this item ']")
    public WebElement aboutItemText;

    @FindBy(xpath = "//*[@class = 'a-unordered-list a-vertical a-spacing-mini']/li")
    public List<WebElement> textLinksList;
    public AmazonPage() {
        PageFactory.initElements(driver, this);
    }
}
