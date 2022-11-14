import Data.DataUser;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import page.LoginPage;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Selenide.open;

public class TestMessage {

    private String baseUrl = "https://idemo.bspb.ru/";
    private static final String login = "demo";
    private static final String password = "demo";
    private static final String code = "0000";
    private static final String item = "PRIV_AKKREDITIV";
    private static final String text = "Пришли как-то лупа и пупа получать зарплату";
    DataUser user = new DataUser();

    @AfterEach
    public void closeDriver() {
        Selenide.closeWebDriver();
    }

    @BeforeAll
    static void beforeConfig() {
        Configuration.timeout = Duration.of(1, ChronoUnit.MINUTES).toMillis();
        Configuration.browserSize = "1920x1080";
    }


    @BeforeEach
    public void before() {
        open(baseUrl);
    }

    @Test
    public void test() {
        user.setLogin(login);
        user.setPassword(password);
        user.setCode(code);
        user.setItem(item);
        user.setText(text);

       new LoginPage().move(user);
    }
}
