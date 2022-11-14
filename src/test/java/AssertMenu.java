
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.Matchers.hasItem;

public class AssertMenu {
    private static String baseUrl = "https://idemo.bspb.ru/";

    private SelenideElement loginInput = $(By.xpath("//input[@name='username']"));
    private SelenideElement passwordInput = $(By.xpath("//input[@name='password']"));
    private SelenideElement loginBtn = $(By.xpath("//button[@id='login-button']"));

    private SelenideElement codeInput = $(By.xpath("//input[@id='otp-code']"));
    private SelenideElement codeBtn = $(By.xpath("//button[@id='login-otp-button']"));

    private SelenideElement bankOverview = $(By.xpath("//a[@id='bank-overview']"));
    private SelenideElement accountOverview = $(By.xpath("//a[@id='accounts-index']"));
    private SelenideElement paymentsOverview = $(By.xpath("//a[@id='payments-form']"));
    private SelenideElement cardOverview = $(By.xpath("//a[@id='cards-overview-index']"));
    private SelenideElement depositOverview = $(By.xpath("//a[@id='deposits-index']"));
    private SelenideElement loansOverview = $(By.xpath("//a[@id='loans-index']"));
    private SelenideElement externaltraderoomOverview = $(By.xpath("//a[@id='externaltraderoom-index']"));
    private SelenideElement insuranceOverview = $(By.xpath("//a[@id='insurance-travel']"));

    @BeforeEach
    public void before() {
        open(baseUrl);
    }

    @BeforeAll
    static void beforeConfig() {

        Configuration.timeout = 3000;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void test() {
       before();
       loginInput.should(Condition.visible).val("demo");
       passwordInput.should(Condition.visible).val("demo");
       loginBtn.should(Condition.visible).click();

       codeInput.should(Condition.visible).val("0000");
       codeBtn.should(Condition.visible).click();

        Assertions.assertEquals(textElement(bankOverview), "ОБЗОР");
        Assertions.assertEquals(textElement(accountOverview), "СЧЕТА");
        Assertions.assertEquals(textElement(paymentsOverview), "ПЛАТЕЖИ И ПЕРЕВОДЫ");
        Assertions.assertEquals(textElement(cardOverview), "КАРТЫ");
        Assertions.assertEquals(textElement(externaltraderoomOverview), "ВАЛЮТА");
        Assertions.assertEquals(textElement(insuranceOverview), "СТРАХОВАНИЕ");
        Assertions.assertEquals(textElement(depositOverview), "ВКЛАДЫ");
        Assertions.assertEquals(textElement(loansOverview), "КРЕДИТЫ");
    }

    public String textElement(SelenideElement sel){
        String text = sel.should(Condition.visible).getText();
        return text;
    }
    @AfterEach
    public void after() {
        Selenide.closeWebDriver();
    }
}
