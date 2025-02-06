package com.nttdata.stepsdefinitions;

import com.nttdata.core.DriverManager;
import com.nttdata.page.CategoryPage;
import com.nttdata.steps.CategorySteps;
import com.nttdata.steps.CartSteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.es.*;
import org.openqa.selenium.WebDriver;
import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class StoreStepsDef {
    private WebDriver driver;
    private LoginSteps loginSteps;
    private CategorySteps categorySteps;
    private CartSteps cartSteps;

    @Dado("estoy en la página de la tienda")
    public void estoy_en_la_página_de_la_tienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void me_logueo_con_mi_usuario_y_clave(String user, String password) {
        loginSteps = new LoginSteps(driver);
        loginSteps.navigateToLoginPage();
        loginSteps.login(user, password);
        screenShot();
    }

    @Cuando("navego a la categoría {string} y subcategoría {string}")
    public void navego_a_la_categoría_y_subcategoría(String category, String subcategory) {
        categorySteps = new CategorySteps(driver);
        categorySteps.navigateToCategory(category);
        categorySteps.navigateToSubCategory(subcategory);
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agrego_unidades_del_primer_producto_al_carrito(int quantity) {
        categorySteps.addProductToCart(quantity);
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void valido_en_el_popup_la_confirmación_del_producto_agregado() {
        categorySteps.validateCartPopup();
    }

    @Entonces("valido en el popup que el monto total sea calculado correctamente")
    public void valido_en_el_popup_que_el_monto_total_sea_calculado_correctamente() {
        categorySteps.validateCartPopup();
    }

    @Cuando("finalizo la compra")
    public void finalizo_la_compra() {
        driver.findElement(CategoryPage.finalizePurchaseButton).click();
    }

    @Entonces("valido el título de la página del carrito")
    public void valido_el_título_de_la_página_del_carrito() {
        cartSteps = new CartSteps(driver);
        cartSteps.validateCartTitle();
    }
    @Entonces("vuelvo a validar el cálculo de precios en el carrito")
    public void vuelvo_a_validar_el_cálculo_de_precios_en_el_carrito() {
        cartSteps = new CartSteps(driver);
        cartSteps.validatePriceCalculation();
    }
}