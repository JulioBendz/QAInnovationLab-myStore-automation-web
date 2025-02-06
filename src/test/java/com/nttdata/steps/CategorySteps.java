package com.nttdata.steps;

import com.nttdata.page.CategoryPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CategorySteps {
    private WebDriver driver;

    public CategorySteps(WebDriver driver) {
        this.driver = driver;
    }

    // Método para navegar a una categoría específica
    public void navigateToCategory(String category) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        try {
            // Construye el localizador dinámicamente basado en el nombre de la categoría
            By categoryLocator = CategoryPage.getCategoryLocator(category);

            // Espera hasta que la categoría sea clickeable y haz clic
            WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(categoryLocator));
            categoryElement.click();

            System.out.println("Navegación a la categoría '" + category + "' exitosa.");
        } catch (org.openqa.selenium.TimeoutException e) {
            // Si no se encuentra la categoría, lanza una excepción con un mensaje claro
            throw new RuntimeException("Error: La categoría '" + category + "' no existe o no es accesible.", e);
        } catch (Exception e) {
            // Captura otros errores inesperados
            throw new RuntimeException("Error inesperado al navegar a la categoría '" + category + "'.", e);
        }
    }

    // Método para navegar a una subcategoría específica
    public void navigateToSubCategory(String subCategory) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement subCategoryElement = wait.until(ExpectedConditions.elementToBeClickable(CategoryPage.subcategoryMen));
        subCategoryElement.click();
    }

    // Método para agregar un producto al carrito
    public void addProductToCart(int quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(CategoryPage.firstProductImage)).click();
        WebElement quantityInput = wait.until(ExpectedConditions.elementToBeClickable(CategoryPage.quantityInput));
        // Usa JavaScript para establecer el valor del campo
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", quantityInput, String.valueOf(quantity));

        driver.findElement(CategoryPage.addToCartButton).click();
    }

    // Método para validar el popup del carrito
    public void validateCartPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popupTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(CategoryPage.cartPopupTitle));
        Assertions.assertTrue(popupTitle.isDisplayed(), "El popup no aparece");

        String productPriceText = driver.findElement(CategoryPage.productPriceInPopup).getText();
        String productQuantityText = driver.findElement(CategoryPage.productQuantityInPopup).getText();

        // Limpia el texto del precio para eliminar el símbolo de moneda y otros caracteres no numéricos
        String cleanedProductPrice = productPriceText.replaceAll("[^0-9.]", ""); // Elimina todo excepto números y puntos
        double productPrice = Double.parseDouble(cleanedProductPrice);

        // Convierte la cantidad a entero
        int productQuantity = Integer.parseInt(productQuantityText);

        // Calcula el total esperado
        double expectedTotal = productPrice * productQuantity;

        // Obtiene el total mostrado en el popup
        String totalPriceText = driver.findElement(CategoryPage.totalPriceInPopup).getText();
        String cleanedTotalPrice = totalPriceText.replaceAll("[^0-9.]", ""); // Limpia el texto del total
        double actualTotal = Double.parseDouble(cleanedTotalPrice);

        // Compara el total esperado con el total mostrado
        Assertions.assertEquals(expectedTotal, actualTotal, "El cálculo del total es incorrecto");
    }
}