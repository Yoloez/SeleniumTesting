import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTest {
    WebDriver driver;

    @Test
    public void Positive(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement nama = driver.findElement(By.xpath("//input[@id='user-name']"));
        nama.sendKeys("error_user");
        WebElement pw = driver.findElement(By.id("password"));
        pw.sendKeys("secret_sauce");
        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", url);
    }

    @Test
    public void Negative(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement nama = driver.findElement(By.id("user-name"));
        nama.sendKeys("error_usersss");
        WebElement pw = driver.findElement(By.id("password"));
        pw.sendKeys("secret_sauce");
        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        String errorMessage = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals(
                "Epic sadface: Username and password do not match any user in this service"
                ,errorMessage
        );
    }
}
