package HW_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactRequestPage extends BaseView {
    public ContactRequestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = createContactXpathLocator)
    public WebElement createContactButton;

    public CreateContactPage createContact() {
        createContactButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(CreateProjectPage.saveAndCloseButtonXpathLocator)));
        return new CreateContactPage(driver);
    }

    public static final String createContactXpathLocator = "//a[text()='Создать контактное лицо']";
}
