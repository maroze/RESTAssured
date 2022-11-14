package page;

import Data.DataUser;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private String baseUrl = "https://idemo.bspb.ru/";

    private SelenideElement loginInput = $(By.xpath("//input[@name='username']"));
    private SelenideElement passwordInput = $(By.xpath("//input[@name='password']"));
    private SelenideElement loginBtn = $(By.xpath("//button[@id='login-button']"));

    private SelenideElement codeInput = $(By.xpath("//input[@id='otp-code']"));
    private SelenideElement codeBtn = $(By.xpath("//button[@id='login-otp-button']"));

    private SelenideElement messageBtn = $(By.xpath("//a[@id='messages-button']"));
    private SelenideElement newMessageBtn = $(By.xpath("//a[@id='new-message-btn']"));
    private SelenideElement selectBtn = $(By.xpath("//select[@name='message.topicName']"));
    private SelenideElement text = $(By.xpath("//textarea[@name='message.text']"));
    private SelenideElement pushBtn = $(By.xpath("//button[@id='send-button']"));

    public LoginPage() {
        open(baseUrl);

        loginInput.should(Condition.visible);
        passwordInput.should(Condition.visible);
        loginBtn.should(Condition.visible);
    }

    public void move(DataUser user){
        loginInput.val(user.getLogin());
        passwordInput.val(user.getPassword());
        loginBtn.click();

        codeInput.should(Condition.visible);
        codeInput.val(user.getCode());
        codeBtn.should(Condition.visible);
        codeBtn.click();

        messageBtn.should(Condition.visible);
        messageBtn.click();
        newMessageBtn.should(Condition.visible);
        newMessageBtn.click();
        selectBtn.should(Condition.visible);
        selectBtn.selectOptionByValue(user.getItem());
        text.should(Condition.visible);
        text.should(Condition.visible).val(user.getText());
        pushBtn.should(Condition.visible);
    }
}
