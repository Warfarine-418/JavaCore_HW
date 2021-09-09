package HW_06;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactRequestPage extends BaseView {
    public ContactRequestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = CREATE_CONTACT_XPATH_LOCATOR)
    public WebElement createContactButton;

    @Step("Создать контактное лицо")
    public CreateContactPage createContact() {
        createContactButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(CreateProjectPage.SAVE_AND_CLOSE_BUTTON_XPATH_LOCATOR)));
        return new CreateContactPage(driver);
    }

    public static final String CREATE_CONTACT_XPATH_LOCATOR = "//a[text()='Создать контактное лицо']";
}
