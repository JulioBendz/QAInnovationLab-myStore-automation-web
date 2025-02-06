package com.nttdata.steps;

import com.nttdata.page.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StoreSteps {

    private WebDriver driver;

    // Constructor
    public StoreSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Hace clic en la categoría de productos (por ejemplo, "CLOTHES")
     * @param category Nombre de la categoría
     */
    public void clickCategory(String category) {
        By categoryLocator = By.xpath("//a[text()='" + category + "']");
        this.driver.findElement(categoryLocator).click();
    }

    /**
     * Hace clic en la subcategoría dentro de la categoría seleccionada
     * @param subCategory Nombre de la subcategoría
     */
    public void clickSubCategory(String subCategory) {
        By subCategoryLocator = By.xpath("//a[text()='" + subCategory + "']");
        this.driver.findElement(subCategoryLocator).click();
    }
}
