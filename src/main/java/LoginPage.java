import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

        private WebDriver driver;

        // Locator
        private By logoText = By.className("login_logo");
        private By usernameField = By.id("user-name");
        private By passwordField = By.id("password");
        private By loginButton = By.id("login-button");
        private By errorMessage = By.tagName("h3");

        // Constructor
        public LoginPage(WebDriver driver){
            this.driver = driver;
        }

        // Actions
        public String getLogoText(){
            return driver.findElement(logoText).getText();
        }

        public void inputUsername(String username){
            driver.findElement(usernameField).clear();
            driver.findElement(usernameField).sendKeys(username);
        }

        public void inputPassword(String password){
            driver.findElement(passwordField).clear();
            driver.findElement(passwordField).sendKeys(password);
        }

        public InventoryPage clickLogin(){
            driver.findElement(loginButton).click();
            return new InventoryPage(driver);
        }

        public String getErrorMessage(){
            return driver.findElement(errorMessage).getText();
        }
    }

