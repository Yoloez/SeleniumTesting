import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitStrategies {
    WebDriver driver;


    @Test
    public void TestCase1() throws InterruptedException {
        driver = new EdgeDriver();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        WebElement btn = driver.findElement(By.id("add_btn"));
        btn.click();
//        Solusi
        Thread.sleep(5000);
        WebElement row2 = driver.findElement(By.xpath("//div[@id='row2']//input[@type='text']"));
        Assertions.assertTrue(row2.isDisplayed());

    }

    @Test
    public void TestCase5(){
        driver = new EdgeDriver();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        solusi
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement btn = driver.findElement(By.id("add_btn"));
        btn.click();
        WebElement row2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']//input[@type='text']")));
        Assertions.assertTrue(row2.isDisplayed());

    }
}
