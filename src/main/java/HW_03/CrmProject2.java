package HW_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrmProject2 {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        //1 шаг авторизация
        loginToCrm();
        //2 шаг - перейти в контактные лица
        Actions actions = new Actions(driver);
        WebElement projectElement = driver.findElement(By.xpath("//span[text()='Контрагенты']/ancestor::a"));
        actions.moveToElement(projectElement).perform();

        driver.findElement(By.xpath("//li[@data-route=\"crm_contact_index\"]/a")).click();

        //3 шаг - создать контактное лицо
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Создать контактное лицо\"]")));

        driver.findElement(By.xpath("//a[text()=\"Создать контактное лицо\"]")).click();

        //4 шаг - заполнить обязательные поля
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

        //5 шаг - сохранить и закрыть
        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        Thread.sleep(5000);
        driver.quit();
    }

    public static void loginToCrm(){
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }
}
