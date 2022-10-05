package steps;

import com.thoughtworks.gauge.Step;
import driver.Driver;
import methods.Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static constants.LoginConstants.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps extends Driver {
    Actions actions = new Actions(driver);
    Methods methods;

    public LoginSteps() {
        methods = new Methods();
    }

    @Step("Login sayfasını kontrol et")
    public void controlEmailPage() {
        assertTrue(methods.isElementVisible(ACCOUNTTEXT_CONTROL, 20));
        assertTrue(methods.isElementVisible(LOGIN_BUTTON, 20));
        assertTrue(methods.isElementVisible(GOOGLELOGIN_BUTTON, 20));
    }

    @Step("Google ile giriş yap tıkla")
    public void loginGoogle() {
        methods.clickElement(GOOGLELOGIN_BUTTON);
    }

    @Step("Email sayfasını kontrol et")
    public void emailGoogle() {
        assertTrue(methods.isElementVisible(GOOGLE_EMAIL, 20));
        assertTrue(methods.isElementVisible(GOOGLE_EMAIL_NEXT, 20));
    }
    @Step("Email gir")
    public void loginGoogleEmail() {
        WebElement sendText = driver.findElement(GOOGLE_EMAIL);
        sendText.sendKeys(EMAIL);
        methods.clickElement(GOOGLE_EMAIL_NEXT);
    }

    @Step("Password sayfasını kontrol et")
    public void controlGooglePage() {
        assertTrue(methods.isElementVisible(GOOGLE_PASSWORD_NEXT, 20));
        assertTrue(methods.isElementVisible(GOOGLE_PASSWORD, 20));
    }

    @Step("Password gir")
    public void loginGooglePassword() {
        WebElement passwordText = driver.findElement(GOOGLE_PASSWORD);
        passwordText.sendKeys(PASSWORD);
        methods.clickElement(GOOGLE_PASSWORD_NEXT);
    }


}
