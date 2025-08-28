@TestEjecucion
Feature:Crear y consultar los pedidos de la tienda de mascotas
  Como cliente de la tienda de mascotas
  Quiero crear y consultar pedidos mediante el API
  Para asegurar que el servicio funciona correctamente

  Background:
    Given la API de Petstore está configurada

  @TestPost
  Scenario: Crear pedido para la compra de mascota

    When creo un nuevo order con id 6001, petId 501, quantity 2, shipDate "2025-08-27T23:57:56.776Z", status "placed", complete true
    Then valido el codigo de respuesta sea 200
    And la respuesta debe contener el order creado con id 6001, petId 501, quantity 2, shipDate "2025-08-27T23:57:56.776Z", status "placed", complete true



  @ConsultarPedido
  Scenario: Consulta de Order creado

    When consulto el pedido con id 600
    Then valido el codigo de respuesta sea 200
    And la respuesta debe contener el order creado con id 6001, petId 501, quantity 2, shipDate "2025-08-27T23:57:56.776Z", status "placed", complete true




  #@TestPostantiguo
  #Scenario: Crear mascota

   # When agrego un nueva nueva mascota de nombre "NuevoDoggie"
   # And valido el codigo de respuesta sea 200
   # And valido el nombre de la mascota sea <nombre>
  #  And valido el tipo de la mascota sea "perro"





  #@TestGet
  #Scenario Outline: Consultar mascota por ID

   # When consulto la mascota de ID <id>
    #And valido el codigo de respuesta sea <statusCodeEsperado>
    #And valido el nombre de la mascota sea <nombre>
    #And valido el tipo de la mascota sea "perro"
    #Examples:
    # | id  | statusCodeEsperado | nombre   |
    # | "1" | 200                | "doggie" |



