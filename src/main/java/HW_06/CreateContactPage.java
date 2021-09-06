package HW_06;

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

    public CreateContactPage fillLastName(String name) {
        lastName.sendKeys(name);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    public WebElement firstName;

    public CreateContactPage fillFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement contactOrganization;

    public CreateContactPage fillContactOrganization(String name) {
        contactOrganization.click();
        inputContactOrganization.sendKeys(name);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(resultWindowXpathLocator)));
        inputContactOrganization.sendKeys(Keys.ENTER);
        return this;
    }

    public final String resultWindowXpathLocator = "//div[@class='select2-result-label']";

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement inputContactOrganization;


    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement jobTitle;

    public CreateContactPage fillJobTitle(String name) {
        jobTitle.sendKeys(name);
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(xpath = "//*[text()='Контактное лицо сохранено']")
    public WebElement requestSavedSuccessfully;

}
