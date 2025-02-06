package com.nttdata.steps;

import com.nttdata.page.CartPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartSteps {
    private WebDriver driver;

    public CartSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void validateCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String cartTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.cartTitle)).getText();
        Assertions.assertEquals("Carrito", cartTitle, "El título del carrito es incorrecto");

        String productPrice = driver.findElement(CartPage.productPriceInCart).getText();
        String productQuantity = driver.findElement(CartPage.productQuantityInCart).getAttribute("value");
        String totalPrice = driver.findElement(CartPage.totalPriceInCart).getText();

        double expectedTotal = Double.parseDouble(productPrice.replace("S/&nbsp;", "")) * Integer.parseInt(productQuantity);
        Assertions.assertEquals(expectedTotal, Double.parseDouble(totalPrice.replace("S/&nbsp;", "")), "El cálculo del total es incorrecto");
    }
}