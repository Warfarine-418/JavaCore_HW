package HW_06;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectSubMenu extends BaseView {
    public ProjectSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Мои проекты']")
    public WebElement myProjectMenuItem;

    @Step("Перейти на страницу 'Мои проекты'")
    public void goToMyProjectPage() {
        myProjectMenuItem.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(ProjectRequestPage.CREATE_PROJECT_XPATH_LOCATOR)));
    }
}
