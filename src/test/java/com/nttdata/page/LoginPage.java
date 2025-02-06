package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {
    public static By iniciarSesionLink = By.xpath("//*[@id='_desktop_user_info']/div/a");
    public static By userInput = By.xpath("//*[@id='field-email']");
    public static By passInput = By.xpath("//*[@id='field-password']");
    public static By loginButton = By.xpath("//*[@id='submit-login']");
    public static By errorMessage = By.xpath("//div[@class='alert alert-danger']");
    public static By dashboardTitle = By.xpath("//*[@id='_desktop_user_info']//a[contains(@class, 'logout')]");
}