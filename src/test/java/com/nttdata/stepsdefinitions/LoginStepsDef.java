package com.nttdata.stepsdefinitions;

import com.nttdata.steps.StoreSteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class LoginStepsDef {

    private WebDriver driver;

    private StoreSteps inventorySteps(WebDriver driver){
        return new StoreSteps(driver);
    }

    @Dado("que me encuentro en la página de login de My Store")
    public void que_me_encuentro_en_la_página_de_login_de_My_Store() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fpe%2F");
        screenShot();
    }

    @Cuando("inicio sesión con las credenciales usuario: {string} y contraseña: {string}")
    public void inicio_sesión_con_las_credenciales_usuario_y_contraseña(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }

    @Y("navego a la categoría {string}")
    public void navego_a_la_categoria(String category) {
        // Llamamos al método en StoreSteps que hace clic en la categoría
        inventorySteps(driver).clickCategory(category);
        screenShot();
    }

    @Y("navego a la subcategoría {string}")
    public void navego_a_la_subcategoria(String subCategory) {
        // Llamamos al método en StoreSteps que hace clic en la subcategoría
        inventorySteps(driver).clickSubCategory(subCategory);
        screenShot();
    }
}

