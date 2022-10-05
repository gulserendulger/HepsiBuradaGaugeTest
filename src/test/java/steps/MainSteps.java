package steps;

import com.thoughtworks.gauge.Step;
import driver.Driver;
import methods.Methods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static constants.GuestConstants.*;
import static constants.MainConstants.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainSteps extends Driver {
    Actions actions=new Actions(driver);
    Methods methods;
    public MainSteps(){
        methods = new Methods();
    }

    @Step("Main sayfasının kontrol et")
    public void controlMainPage(){
        assertTrue(methods.isElementVisible(MYACCOUNT_CONTROL, 20));
        assertTrue(methods.isElementVisible(LOGO_CONTROL, 20));
        assertTrue(methods.isElementVisible(SEARCHTEXT_CONTROL, 20));
    }

    @Step("Aranacak kelimeyi gir")
    public void searchBoxClick(){
        WebElement text = driver.findElement(SEARCHBOX);
        text.sendKeys(SEARCH_KEYWORD);
        methods.clickElement(SEARCHBOX_SEARCHBUTTON);
    }

    @Step("Filtre seçme")
    public void controlSelectFilter() throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");
        WebElement searchCheckbox=driver.findElement(SEARCH_Mark);
        searchCheckbox.click();
        searchCheckbox.sendKeys(SEARCH_KEYWORD_MARK);
        Thread.sleep(2000);
        WebElement checkBox=driver.findElement(SEARCH_Mark_SELECT);
        actions.doubleClick(checkBox).perform();
        driver.navigate().refresh();
    }


}
