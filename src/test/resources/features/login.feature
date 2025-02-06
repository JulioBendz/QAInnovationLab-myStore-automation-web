#language: es
@testfeature
Característica: Product - Store
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para agregar productos al carrito de compras

  @valid_login
  Escenario: Validación del precio de un producto
    Dado que me encuentro en la página de login de My Store
    Cuando inicio sesión con las credenciales usuario: "juliobendz13@gmail.com" y contraseña: "Julio13jabg6*"
    Entonces navego a la categoría "CLOTHES"
    Y navego a la subcategoría "MEN"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el título de la página del carrito
    Y vuelvo a validar el cálculo de precios en el carrito


