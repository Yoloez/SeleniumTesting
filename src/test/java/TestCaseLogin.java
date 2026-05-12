import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseLogin {

    WebDriver driver;

    @Test
    public void Positive(){

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        Assertions.assertEquals(
                "Swag Labs",
                loginPage.getLogoText()
        );

        loginPage.inputUsername("error_user");
        loginPage.inputPassword("secret_sauce");

        InventoryPage inventoryPage = loginPage.clickLogin();

        Assertions.assertEquals(
                "https://www.saucedemo.com/inventory.html",
                inventoryPage.getCurrentURL()
        );

//        driver.quit();
    }

    @Test
    public void Negative(){

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUsername("error_usersss");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();

        Assertions.assertEquals(
                "Epic sadface: Username and password do not match any user in this service",
                loginPage.getErrorMessage()
        );

        driver.quit();
    }
}