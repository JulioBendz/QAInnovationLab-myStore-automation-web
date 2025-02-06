package com.nttdata.page;

import org.openqa.selenium.By;

public class CartPage {
    public static By cartTitle = By.xpath("//*[@id='main']/div/div[1]/div/div[1]/h1");
    public static By productPriceInCart = By.xpath("//*[@id='main']/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");
    public static By productQuantityInCart = By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]");
    public static By totalPriceInCart = By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[2]");
}
