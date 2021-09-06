package HW_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectRequestPage extends BaseView {
    public ProjectRequestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = createProjectXpathLocator)
    public WebElement createProjectButton;

    public CreateProjectPage createProject() {
        createProjectButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(CreateProjectPage.saveAndCloseButtonXpathLocator)));
        return new CreateProjectPage(driver);
    }

    public static final String createProjectXpathLocator = "//a[text()='Создать проект']";
}
