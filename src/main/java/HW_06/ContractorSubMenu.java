package HW_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContractorSubMenu extends BaseView {
    public ContractorSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement contactMenuItem;

    public void goToContactPage() {
        contactMenuItem.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(ContactRequestPage.createContactXpathLocator)));
    }
}
