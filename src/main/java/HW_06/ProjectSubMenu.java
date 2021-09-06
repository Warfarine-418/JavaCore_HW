package HW_06;

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

    public void goToMyProjectPage() {
        myProjectMenuItem.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(ProjectRequestPage.createProjectXpathLocator)));
    }
}
