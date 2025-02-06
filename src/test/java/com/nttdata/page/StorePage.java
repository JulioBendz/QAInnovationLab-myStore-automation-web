package com.nttdata.page;

import org.openqa.selenium.By;

public class StorePage {

    // Título de la categoría de productos
    public static By categoryTitle = By.xpath("//*[@id=\"category-3\"]/a");

    // Elementos dentro de una subcategoría
    public static By subcategoryItems = By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a");
}

