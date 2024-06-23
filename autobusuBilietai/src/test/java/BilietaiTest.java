import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class BilietaiTest {
    static ChromeDriver chrome;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chromedriver126.exe",
                Paths.get("src/main/resources/drivers/chromedriver126.exe").toString());

        chrome = new ChromeDriver();
        chrome.get("https://www.autobusubilietai.lt/");

        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement miestasIsKurKeliausime = chrome.findElement(By.cssSelector("#route-from"));
        WebElement miestasIKurKeliausime = chrome.findElement(By.xpath("//*[@id=\"route-to\"]"));

        miestasIsKurKeliausime.sendKeys("Vilnius");
        miestasIKurKeliausime.sendKeys("Klaipeda");



        WebElement ieskotiKeliones = new WebDriverWait(chrome, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#page-content > div.search-container > div > form > div.search-form-button > button")));

        ieskotiKeliones.click();



        Thread.sleep(5000);

        //chrome.quit();
    }
}
