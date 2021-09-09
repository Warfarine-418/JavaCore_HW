package HW_06;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateContactPage extends BaseView {
    public CreateContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_contact[lastName]")
    public WebElement lastName;

    @Step("Заполнить фамилию")
    public CreateContactPage fillLastName(String name) {
        lastName.sendKeys(name);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    public WebElement firstName;

    @Step("Заполнить имя")
    public CreateContactPage fillFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement contactOrganization;

    @Step("Заполнить название организации")
    public CreateContactPage fillContactOrganization(String name) {
        contactOrganization.click();
        inputContactOrganization.sendKeys(name);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(RESULT_WINDOW_XPATH_LOCATOR)));
        inputContactOrganization.sendKeys(Keys.ENTER);
        return this;
    }

    public static final String RESULT_WINDOW_XPATH_LOCATOR = "//div[@class='select2-result-label']";

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement inputContactOrganization;


    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement jobTitle;

    @Step("Заполнить должность")
    public CreateContactPage fillJobTitle(String name) {
        jobTitle.sendKeys(name);
        return this;
    }

    @FindBy(xpath = SAVE_AND_CLOSE_BUTTON_XPATH_LOCATOR)
    public WebElement saveAndCloseButton;

    public static final String SAVE_AND_CLOSE_BUTTON_XPATH_LOCATOR = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(xpath = "//*[text()='Контактное лицо сохранено']")
    public WebElement requestSavedSuccessfully;

}
