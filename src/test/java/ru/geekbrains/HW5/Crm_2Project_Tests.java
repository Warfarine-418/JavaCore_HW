package ru.geekbrains.HW5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Crm_2Project_Tests {
    static WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://crm.geekbrains.space/";
    private static final String CONTACT_URL = "https://crm.geekbrains.space/contact/";
    private static final String NEWCONTACT_URL = "https://crm.geekbrains.space/contact/create";

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
    void transitionToTheContactPageTest() {
        Actions actions = new Actions(driver);
        WebElement projectElement = driver.findElement(By.xpath("//span[text()='Контрагенты']/ancestor::a"));
        actions.moveToElement(projectElement).perform();
        driver.findElement(By.xpath("//li[@data-route=\"crm_contact_index\"]/a")).click();
        Assertions.assertEquals(CONTACT_URL,driver.getCurrentUrl());
    }
    @Test
    void clickingOnTheCreateContactButtonTest() {
        driver.get(CONTACT_URL);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Создать контактное лицо\"]")));
        driver.findElement(By.xpath("//a[text()=\"Создать контактное лицо\"]")).click();

        Assertions.assertEquals(NEWCONTACT_URL, driver.getCurrentUrl());
    }

    @Test
    void fillingInTheRequiredFieldsAndClickingOnTheSaveButtonTest() {
        driver.get(NEWCONTACT_URL);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_contact[lastName]")));
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Юзеров");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_contact[firstName]")));
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("ЮзерЮзер");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("test");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='select2-result-label']")));
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_contact[jobTitle]")));
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Юзер");

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        Assertions.assertEquals(NEWCONTACT_URL, driver.getCurrentUrl());
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
