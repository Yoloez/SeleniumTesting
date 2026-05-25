package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.InventoryPage;
import org.example.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    // Deklarasi di tingkat kelas agar bisa diakses oleh semua step
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);

        // Memasukkan assertion logo yang ada di kode Anda sebagai validasi awal
        Assertions.assertEquals("Swag Labs", loginPage.getLogoText());
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.inputUsername("error_user");
        loginPage.inputPassword("secret_sauce");
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        loginPage.inputUsername("error_usersss");
        loginPage.inputPassword("secret_sauce");
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        // Karena clickLogin() Anda mereturn org.example.InventoryPage, kita simpan ke variabel
        inventoryPage = loginPage.clickLogin();
    }

    @Then("user should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        Assertions.assertEquals(
                "https://www.saucedemo.com/inventory.html",
                inventoryPage.getCurrentURL()
        );
    }

    @Then("user should see an error message")
    public void user_should_see_an_error_message() {
        Assertions.assertEquals(
                "Epic sadface: Username and password do not match any user in this service",
                loginPage.getErrorMessage()
        );
    }

    /**
     * @After adalah Cucumber Hook.
     * Ini akan dieksekusi secara otomatis setiap kali satu skenario (Positive/Negative) selesai.
     * Sangat penting untuk menutup browser agar memori komputer Anda tidak penuh oleh browser zombie.
     */
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}