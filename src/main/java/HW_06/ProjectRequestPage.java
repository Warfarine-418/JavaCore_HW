package HW_06;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectRequestPage extends BaseView {
    public ProjectRequestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = CREATE_PROJECT_XPATH_LOCATOR)
    public WebElement createProjectButton;

    @Step("Создать проект")
    public CreateProjectPage createProject() {
        createProjectButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(CreateProjectPage.SAVE_AND_CLOSE_BUTTON_XPATH_LOCATOR)));
        return new CreateProjectPage(driver);
    }

    public static final String CREATE_PROJECT_XPATH_LOCATOR = "//a[text()='Создать проект']";
}
