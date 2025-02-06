package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    private WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    // Método para navegar a la página de inicio de sesión
    public void navigateToLoginPage() {
        driver.findElement(LoginPage.iniciarSesionLink).click();
    }

    // Método para iniciar sesión con usuario y contraseña
    public void login(String user, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(LoginPage.userInput).sendKeys(user);
        driver.findElement(LoginPage.passInput).sendKeys(password);
        driver.findElement(LoginPage.loginButton).click();

        // Verifica si hay un mensaje de error
        try {
            WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(LoginPage.errorMessage));
            if (errorMessage.isDisplayed()) {
                throw new RuntimeException("Error de autenticación: " + errorMessage.getText());
            }
        } catch (org.openqa.selenium.TimeoutException e) {
            // No hay mensaje de error, lo cual significa que el inicio de sesión fue exitoso
            System.out.println("Inicio de sesión exitoso.");
        }
    }
}