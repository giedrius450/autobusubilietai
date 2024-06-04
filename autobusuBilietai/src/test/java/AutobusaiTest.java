import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class AutobusaiTest {
    private ChromeDriver chrome;

    @Before
    public void setUp() {
        // Nustatome kelionės nuorodą
        String kelionesNuoroda = "https://www.autobusubilietai.lt/";

        // Nustatome chromedriver kelio iš katalogo
        System.setProperty("webdriver.chromedriver125.exe",
                Paths.get("src/main/resources/drivers/chromedriver125.exe").toString());

        // Paleidžiame chromedriver
        chrome = new ChromeDriver();

        // Atidarome puslapį
        chrome.get(kelionesNuoroda);
    }

    @Test
    public void testArRandaKelione() {
        // Nustatome kelionės miestus
        String isKurKeliausime = "Vilnius";
        String iKurKeliausime = "Klaipeda";

        // Nustatome laukimų laiką
        Duration laukimoLaikas = Duration.ofSeconds(10);

        // Rasti laukus, kuriuose įvesime miestus
        chrome.findElement(By.id("route-from")).sendKeys(isKurKeliausime);
        chrome.findElement(By.id("route-to")).sendKeys(iKurKeliausime);

        // Paspaudžiame mygtuką ieškoti kelionės
        new WebDriverWait(chrome, laukimoLaikas)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#page-content > div.search-container > div > form > div.search-form-button > button")))
                .click();

        // Palaukiame kelias sekundes, kad puslapis atsakytų
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        // Uždaryti naršyklę
        chrome.quit();
    }
}

