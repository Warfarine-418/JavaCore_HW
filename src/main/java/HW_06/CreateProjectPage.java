package HW_06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectPage extends BaseView {
    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement projectCreateName;

    public CreateProjectPage fillName(String name) {
        projectCreateName.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement projectOrganization;

    @FindBy(xpath = inputWindowXpathLocator)
    public WebElement inputWindow;

    public CreateProjectPage fillOrganization(String name) {
        projectOrganization.click();
        inputWindow.sendKeys(name);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(resultWindowXpathLocator)));
        inputWindow.sendKeys(Keys.ENTER);
        return this;
    }

    public final String resultWindowXpathLocator = "//div[@class='select2-result-label']";
    public final String inputWindowXpathLocator = "//div[@id='select2-drop']//input";

    @FindBy(xpath = mainContactInputXpathLocator)
    public WebElement projectMainContact;

    @FindBy(xpath = mainContactXpathLocator)
    public WebElement mainContact;

    public CreateProjectPage fillMainContact(String name) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(mainContactXpathLocator)));
        projectMainContact.click();
        inputWindow.sendKeys(name);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputWindowXpathLocator)));
        inputWindow.sendKeys(Keys.ENTER);
        return this;
    }

    public final String mainContactInputXpathLocator = "//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a";
    public final String mainContactXpathLocator = "//div[@class='select2-container select2']";

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitSelect;

    public CreateProjectPage selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement curatorSelect;

    public CreateProjectPage selectCurator(String curator) {
        new Select(curatorSelect).selectByVisibleText(curator);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement rpSelect;

    public CreateProjectPage selectRP(String rp) {
        new Select(rpSelect).selectByVisibleText(rp);
        return this;
    }

    @FindBy(name = "crm_project[administrator]")
    public WebElement administratorSelect;

    public CreateProjectPage selectAdministrator(String administrator) {
        new Select(administratorSelect).selectByVisibleText(administrator);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement managerSelect;

    public CreateProjectPage selectManager(String manager) {
        new Select(managerSelect).selectByVisibleText(manager);
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(xpath = "//*[text()='Проект сохранен']")
    public WebElement requestSavedSuccessfully;

}
