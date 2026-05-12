import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {

    private WebDriver driver;

    // optional locator
    private By topResult = By.partialLinkText("Akmal");

    public ResultPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public boolean titleContains(String keyword){
        return driver.getTitle().contains(keyword);
    }

    public void clickTopResult(){
        driver.findElement(topResult).click();
    }
}