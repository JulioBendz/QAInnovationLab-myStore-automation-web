package com.nttdata.steps;

import com.nttdata.page.CartPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
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

    /**
     * Valida que el título de la página del carrito sea correcto.
     */
    public void validateCartTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Espera hasta que el título de la página del carrito sea visible
        WebElement cartTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.cartTitle));
        Assertions.assertEquals("SHOPPING CART", cartTitle.getText().toUpperCase(), "El título de la página del carrito es incorrecto");
    }

    /**
     * Valida el cálculo de precios en el carrito.
     */
    public void validatePriceCalculation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Espera hasta que el campo de cantidad esté presente
        WebElement quantityInput = wait.until(ExpectedConditions.presenceOfElementLocated(CartPage.productQuantityInCart));

        // Desplaza el elemento a la vista
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", quantityInput);

        // Espera a que el elemento sea visible
        wait.until(ExpectedConditions.visibilityOf(quantityInput));

        // Obtiene el valor del campo de cantidad
        String productQuantityText = quantityInput.getAttribute("value");
        if (productQuantityText == null || productQuantityText.trim().isEmpty()) {
            throw new RuntimeException("El campo de cantidad está vacío o no contiene un valor válido");
        }
        int productQuantity = Integer.parseInt(productQuantityText.trim());

        // Obtiene el precio del producto en el carrito
        String productPriceText = driver.findElement(CartPage.productPriceInCart).getText();
        String cleanedProductPrice = productPriceText.replaceAll("[^0-9.]", ""); // Limpia el texto del precio
        double productPrice = Double.parseDouble(cleanedProductPrice);

        // Calcula el total esperado
        double expectedTotal = productPrice * productQuantity;

        // Obtiene el total mostrado en el carrito
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.totalPriceInCart));
        String totalPriceText = totalElement.getText();
        String cleanedTotalPrice = totalPriceText.replaceAll("[^0-9.]", ""); // Limpia el texto del total
        double actualTotal = Double.parseDouble(cleanedTotalPrice);

        // Compara el total esperado con el total mostrado
        Assertions.assertEquals(expectedTotal, actualTotal, "El cálculo del total es incorrecto");
    }
}