package HW_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class MyProject {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();
        //1 сценарий авторизация
        driver.get("https://mail.ru");
        driver.findElement(By.xpath("//input[contains(@class, 'email')]")).sendKeys("yuzer.yuzerov.91");
        driver.findElement(By.xpath("//select")).click();
        driver.findElement(By.xpath("//option[contains(@value, '@bk.ru')]")).click();
        driver.findElement(By.xpath("//button[contains(@data-testid, 'enter-password')]")).click();
        driver.findElement(By.xpath("//input[contains(@class, 'password-input')]")).sendKeys("pAOUM21y)iou");
        driver.findElement(By.xpath("//button[contains(@class, 'second-button')]")).click();
        //2 сценарий

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(@class, 'compose-button')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[contains(@class, 'container')]")).sendKeys("Test@mail.ru");
        driver.findElement(By.xpath("//input[contains(@name, 'Subject')]")).sendKeys("Test");

        //не получилось найти путь к области ввода текста письма, поэтому просто сохраняем пустой черновик

        driver.findElement(By.xpath("//span[contains(@data-title-shortcut, 'Ctrl+S')]")).click();
    }
}
