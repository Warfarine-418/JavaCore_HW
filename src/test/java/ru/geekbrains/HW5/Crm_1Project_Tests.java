package ru.geekbrains.HW5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Crm_1Project_Tests {
    static WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://crm.geekbrains.space/";
    private static final String MYPROJECT_URL = "https://crm.geekbrains.space/project/my";
    private static final String NEWPROJECT_URL = "https://crm.geekbrains.space/project/create/";
    private static final String USER = "Юзеров Юзер";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        loginToCrm();
    }
    @Test
    void verificationAuthorizationTest() {
        driver.get(BASE_URL);
        loginToCrm();
        Assertions.assertEquals(BASE_URL,driver.getCurrentUrl());
    }

    @Test
    void transitionToTheMyProjectPageTest() {
        Actions actions = new Actions(driver);
        WebElement projectElement = driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"));
        actions.moveToElement(projectElement).perform();
        driver.findElement(By.xpath("//li[@data-route=\"crm_project_my\"]/a")).click();
        Assertions.assertEquals(MYPROJECT_URL,driver.getCurrentUrl());
    }
    @Test
    void clickingOnTheCreateProjectButtonTest() {
        driver.get(MYPROJECT_URL);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Создать проект\"]")));
        driver.findElement(By.xpath("//a[text()=\"Создать проект\"]")).click();
        Assertions.assertEquals(NEWPROJECT_URL, driver.getCurrentUrl());
    }

    @Test
    void fillingInTheRequiredFieldsAndClickingOnTheSaveButtonTest() {
        driver.get(NEWPROJECT_URL);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("test1231231231234");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();

        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("test");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='select2-result-label']")));
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-container select2']")));
        driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select2-drop']//input")));
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("1111");
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys(Keys.ENTER);

        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select curatorSelect = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorSelect.selectByVisibleText(USER);

        Select rpSelect = new Select(driver.findElement(By.name("crm_project[rp]")));
        rpSelect.selectByVisibleText(USER);

        Select administratorSelect = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administratorSelect.selectByVisibleText(USER);

        Select managerSelect = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerSelect.selectByVisibleText(USER);
        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        Assertions.assertEquals(NEWPROJECT_URL, driver.getCurrentUrl());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
    public static void loginToCrm(){
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }
}
