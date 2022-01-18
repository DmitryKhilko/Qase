import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    String email, password;



    @BeforeMethod
    public void setUp(){
        Configuration.headless = true;
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));//"https://app.qase.io";
        email = System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));

        Configuration.browser = "chrome";
        Configuration.clickViaJs = true; // нажимает с помощью JS скриптов - быстрее, чем WebDriver
        Configuration.savePageSource = false;
        Configuration.timeout = 10000;
    }
    @AfterMethod(alwaysRun = true) //так как selenide (его особенность) закрывает в конце класса
    public void tearDown(){
        getWebDriver().quit();
    }
}
