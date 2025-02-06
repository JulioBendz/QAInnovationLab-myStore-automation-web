package com.nttdata.page;

import org.openqa.selenium.By;

public class CategoryPage {
    public static By getCategoryLocator(String category) {
        switch (category.toLowerCase()) {
            case "clothes":
                return By.xpath("//header/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]");
            case "autos":
                return By.xpath("//a[contains(text(), 'Autos')]");
            default:
                throw new IllegalArgumentException("Categoría no soportada: " + category);
        }
    }
    public static By subcategoryMen = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]");
    public static By firstProductImage = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[2]/section[1]/section[1]/div[3]/div[1]/div[1]/article[1]/div[1]/div[1]/a[1]/picture[1]/img[1]");
    public static By quantityInput = By.xpath("//input[@id='quantity_wanted']");
    public static By addToCartButton = By.xpath("//*[@id='add-to-cart-or-refresh']/div[2]/div/div[2]/button");
    public static By cartPopupTitle = By.xpath("//*[@id='myModalLabel']");
    public static By productPriceInPopup = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[1]/div/div[2]/p");
    public static By productQuantityInPopup = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong");
    public static By totalPriceInPopup = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/p[3]/span[2]");
    public static By finalizePurchaseButton = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/div/a");
}