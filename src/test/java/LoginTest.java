import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest{
    @Test
    public void login(){
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit(); // submit - это отправка данных формы (чтобы не нажимать на кнопку)
        $(By.id("createButton")).shouldBe(visible);
    }

    @Test
    public void login1(){
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit(); // submit - это отправка данных формы (чтобы не нажимать на кнопку)
        $(By.id("createButton")).shouldBe(visible);
    }
}
