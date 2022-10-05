package steps;

import com.thoughtworks.gauge.Step;
import driver.Driver;
import methods.Methods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

import static constants.ProductsConstants.*;

public class ProductsSteps extends Driver {
    Actions actions=new Actions(driver);
    Methods methods;
    public ProductsSteps(){
        methods = new Methods();
    }

    @Step("Random ürün seçme")
    public void controlSelectProducts(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");

        List<WebElement> productElems = driver.findElements(PRODUCTS_ELEMENTS);
        int maxProducts = productElems.size();
        System.out.println(maxProducts);
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        productElems.get(randomProduct).click();
    }

    @Step("Random seçilen ürünü sepete ekleme")
    public void controlAddToCart(){
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);}

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");

        WebElement addToCart=driver.findElement(ADD_TO_CART);
        addToCart.click();
    }

    @Step("Sepete git")
    public void controlShoppingCart()throws InterruptedException{
        WebElement closePopUp=driver.findElement(POPUP);
        closePopUp.click();

        WebElement shoppingCart=driver.findElement(SHOPPING_CART);
        shoppingCart.click();
    }

    @Step("Ürün sayısını 1 arttır")
    public void controlProductIncrease()throws InterruptedException{
        WebElement shoppingCartPlus=driver.findElement(PRODUCT_INCREASE);
        shoppingCartPlus.click();
        Thread.sleep(3000);
    }

    @Step("Alışverişi tamamla")
    public void controlShoppingDone(){
        WebElement shopping=driver.findElement(SHOPPING_DONE_BUTTON);
        shopping.click();
    }

}
