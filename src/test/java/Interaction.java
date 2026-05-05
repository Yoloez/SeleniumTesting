import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Interaction {
    WebDriver driver;

    @Test
    public void Hover(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement hover1 = driver.findElement(By.xpath("//div[@class='example']//div[1]//img[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(hover1).perform();

        WebElement hasilHover = driver.findElement(By.xpath("//h5[normalize-space()='name: user1']"));
        String teks = hasilHover.getText();
        Assertions.assertEquals("name: user1", teks);

    }

    @Test
    public void shift(){
        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");

        WebElement input = driver.findElement(By.id("target"));
        input.click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.SHIFT).perform();

        WebElement hasil = driver.findElement(By.id("result"));
        String output = hasil.getText();
        Assertions.assertEquals("You entered: SHIFT", output);

    }

    @Test
    public void DragAndDrop(){
        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement boxA = driver.findElement(By.id("column-a"));
        WebElement boxB = driver.findElement(By.id("column-b"));

        Actions action = new Actions(driver);
        action.dragAndDrop(boxA, boxB).perform();

        WebElement headerB = boxA.findElement(By.tagName("header"));
        String header = headerB.getText();
        Assertions.assertEquals("B", header);
    }


}
