# language: en
Feature: Product - Store

  @valid_login
  Scenario: Validación del precio de un producto
    Given estoy en la página de la tienda
    And me logueo con mi usuario "<usuario>" y clave "<clave>"
    When navego a la categoría "<categoria>" y subcategoría "<subcategoria>"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el título de la página del carrito
    And vuelvo a validar el cálculo de precios en el carrito

    Examples:
      | usuario              | clave          | categoria | subcategoria  |
      | juliobendz13@gmail.com | Julio13jabg6* | Clothes   | Men          |
      | invalid_user          | invalid_pass  | Clothes   | Men           |
      | juliobendz13@gmail.com | Julio13jabg6* | Autos     | SUV         |