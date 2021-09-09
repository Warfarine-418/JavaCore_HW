package HW_06;

import io.qameta.allure.Step;
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

    @Step("Заполнить название")
    public CreateProjectPage fillName(String name) {
        projectCreateName.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement projectOrganization;

    @FindBy(xpath = inputWindowXpathLocator)
    public WebElement inputWindow;

    @Step("Заполнить название организации")
    public CreateProjectPage fillOrganization(String name) {
        projectOrganization.click();
        inputWindow.sendKeys(name);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(resultWindowXpathLocator)));
        inputWindow.sendKeys(Keys.ENTER);
        return this;
    }

    public static final String resultWindowXpathLocator = "//div[@class='select2-result-label']";
    public static final String inputWindowXpathLocator = "//div[@id='select2-drop']//input";

    @FindBy(xpath = MAIN_CONTACT_INPUT_XPATH_LOCATOR)
    public WebElement projectMainContact;

    @FindBy(xpath = MAIN_CONTACT_XPATH_LOCATOR)
    public WebElement mainContact;

    @Step("Заполнить имя основного контактного лица")
    public CreateProjectPage fillMainContact(String name) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MAIN_CONTACT_XPATH_LOCATOR)));
        projectMainContact.click();
        inputWindow.sendKeys(name);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputWindowXpathLocator)));
        inputWindow.sendKeys(Keys.ENTER);
        return this;
    }

    public static final String MAIN_CONTACT_INPUT_XPATH_LOCATOR = "//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a";
    public static final String MAIN_CONTACT_XPATH_LOCATOR = "//div[@class='select2-container select2']";

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitSelect;

    @Step("Выбрать бизнес юнит")
    public CreateProjectPage selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement curatorSelect;

    @Step("Выбрать куратора")
    public CreateProjectPage selectCurator(String curator) {
        new Select(curatorSelect).selectByVisibleText(curator);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement rpSelect;

    @Step("Выбрать руководителя проекта")
    public CreateProjectPage selectRP(String rp) {
        new Select(rpSelect).selectByVisibleText(rp);
        return this;
    }

    @FindBy(name = "crm_project[administrator]")
    public WebElement administratorSelect;

    @Step("Выбрать администратора")
    public CreateProjectPage selectAdministrator(String administrator) {
        new Select(administratorSelect).selectByVisibleText(administrator);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement managerSelect;

    @Step("Выбрать менеджера")
    public CreateProjectPage selectManager(String manager) {
        new Select(managerSelect).selectByVisibleText(manager);
        return this;
    }

    @FindBy(xpath = SAVE_AND_CLOSE_BUTTON_XPATH_LOCATOR)
    public WebElement saveAndCloseButton;

    public static final String SAVE_AND_CLOSE_BUTTON_XPATH_LOCATOR = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(xpath = "//*[text()='Проект сохранен']")
    public WebElement requestSavedSuccessfully;

}
