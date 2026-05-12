import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestPage {

    @Test
    public void searchTest(){

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.bing.com/");

        String keys = "Akmal Manggala";

        SearchPage searchPage = new SearchPage(driver);
        searchPage.setSearch_bar(keys);

        ResultPage resultPage = searchPage.submitForm();

        Assertions.assertTrue(
                resultPage.titleContains(keys)
        );

        // optional
        // resultPage.clickTopResult();

        driver.quit();
    }
}