package com.nttdata.page;

import org.openqa.selenium.By;

public class CartPage {
    public static By cartTitle = By.xpath("//*[@id='main']/div/div[1]/div/div[1]/h1");
    public static By productPriceInCart = By.xpath("//*[@id='main']/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");
    public static By productQuantityInCart = By.xpath("//*[@id='main']/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[1]/div/input");
    public static By totalPriceInCart = By.xpath("//*[@id='main']/div/div[2]/div[1]/div[1]/div[2]/div[1]/span[2]");
}