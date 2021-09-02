package ru.geekbrains.HW5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProjectTests {
    static WebDriver driver;
    static WebDriverWait webDriverWait;
    private static final String MYBASE_URL = "https://mail.ru/";
    private static final String MYMAIL_URL= "https://e.mail.ru/inbox/?back=1";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
    }

    @Test
    void verificationAuthorization() {
        driver.get(MYBASE_URL);
        driver.findElement(By.xpath("//input[contains(@class, 'email')]")).sendKeys("yuzer.yuzerov.91");
        driver.findElement(By.xpath("//select")).click();
        driver.findElement(By.xpath("//option[contains(@value, '@bk.ru')]")).click();
        driver.findElement(By.xpath("//button[contains(@data-testid, 'enter-password')]")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class, 'password-input')]")));
        driver.findElement(By.xpath("//input[contains(@class, 'password-input')]")).sendKeys("pAOUM21y)iou");
        driver.findElement(By.xpath("//button[contains(@class, 'second-button')]")).click();

        //Assertions.assertEquals(MYBASE_URL, driver.getCurrentUrl());
    }

    @Test
    void createADraft() {
        loginToMail();
        driver.get(MYMAIL_URL);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'compose-button')]")));
        driver.findElement(By.xpath("//span[contains(@class, 'compose-button')]")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class, 'container')]")));
        driver.findElement(By.xpath("//input[contains(@class, 'container')]")).sendKeys("Test@mail.ru");
        driver.findElement(By.xpath("//input[contains(@name, 'Subject')]")).sendKeys("Test");
        driver.findElement(By.xpath("//span[contains(@data-title-shortcut, 'Ctrl+S')]")).click();

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
    public static void loginToMail() {
        driver.get(MYBASE_URL);
        driver.findElement(By.xpath("//input[contains(@class, 'email')]")).sendKeys("yuzer.yuzerov.91");
        driver.findElement(By.xpath("//select")).click();
        driver.findElement(By.xpath("//option[contains(@value, '@bk.ru')]")).click();
        driver.findElement(By.xpath("//button[contains(@data-testid, 'enter-password')]")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class, 'password-input')]")));
        driver.findElement(By.xpath("//input[contains(@class, 'password-input')]")).sendKeys("pAOUM21y)iou");
        driver.findElement(By.xpath("//button[contains(@class, 'second-button')]")).click();
    }
}
