package ru.geekbrains.HW6;

import HW_06.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class PageObjectCRM1Test extends BaseTest {

    @Test
    void createProjectInCrmWithPageObjectTest() {
        driver.get("https://crm.geekbrains.space/");
        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Проекты");

        new ProjectSubMenu(driver).goToMyProjectPage();

        new ProjectRequestPage(driver)
                .createProject()
                .fillName("test98799900gf")
                .fillOrganization("123test")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Юзеров Юзер")
                .selectRP("Юзеров Юзер")
                .selectAdministrator("Юзеров Юзер")
                .selectManager("Юзеров Юзер")
                .fillMainContact("Brown bob")
                .saveAndCloseButton.click();


        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(text(), 'Загрузка')]")));
        assertThat(new CreateProjectPage(driver).requestSavedSuccessfully, isDisplayed());
    }
}
