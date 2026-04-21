import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ChromeTest {
    WebDriver driver;

    @Test
    public void searchTest(){
        driver = new EdgeDriver();
        driver.get("https://www.bing.com/");

        WebElement search_bar = driver.findElement(By.id("sb_form_q"));
        search_bar.sendKeys("Akmal Manggala");

        WebElement search_form = driver.findElement(By.id("sb_form"));
        search_form.submit();

        String title = driver.getTitle();
//        Assertions.assertEquals("Akmal", title);

        WebElement topResult = driver.findElement(By.partialLinkText("Akmal"));
        topResult.click();
    }
}
