package ru.geekbrains.HW6;

import HW_06.*;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Story("Контактное лицо")
public class PageObjectCRM2Test extends BaseTest {

    @Test
    @Description("Тест логина и создания контактного лица")
    void createContactInCrmWithPageObjectTest() {
        driver.get("https://crm.geekbrains.space/");
        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Контрагенты");

        new ContractorSubMenu(driver).goToContactPage();

        new ContactRequestPage(driver)
                .createContact()
                .fillLastName("oleg")
                .fillFirstName("oleg")
                .fillContactOrganization("123test")
                .fillJobTitle("oleg")
                .saveAndCloseButton.click();


        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(text(), 'Загрузка')]")));
        assertThat(new CreateContactPage(driver).requestSavedSuccessfully, isDisplayed());
    }
}
