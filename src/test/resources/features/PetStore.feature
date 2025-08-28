@TestEjecucion
Feature:Crear y consultar los pedidos de la tienda de mascotas
  Como cliente de la tienda de mascotas
  Quiero crear y consultar pedidos mediante el API
  Para asegurar que el servicio funciona correctamente

  Background:
    Given la API de Petstore está configurada

  @TestPost
  Scenario Outline: Crear pedido para la compra de mascota
    When creo un nuevo order con id <id>, petId <petId>, quantity <quantity>, shipDate <shipDate>, status <status>, complete <complete>
    Then valido el codigo de respuesta sea <statusCode>
    And la respuesta debe contener el order creado con id <id>, petId <petId>, quantity <quantity>, shipDate <shipDateComp>, status <status>, complete <complete>
    Examples:
      | id   | petId | quantity | shipDate                   | status   | complete | statusCode | shipDate                       |shipDateComp                      |
      | 6001 | 501   | 2        | "2001-02-14T17:53:27.496Z" | "placed" | true     | 200        | "2001-02-14T17:53:27.496Z" | "2001-02-14T17:53:27.496+0000" |


  @ConsultarPedido
  Scenario Outline: Consulta de Order creado
    When consulto el pedido con id <id>
    Then valido el codigo de respuesta sea <statusCode>
    And la respuesta debe contener el order creado con id <id1>, petId <petId>, quantity <quantity>, shipDate <shipDate>, status <status>, complete <complete>
    Examples:
      | id  | statusCode | id1  | petId | quantity | shipDate                       | status   | complete |
      | 6001 | 200        | 6001 | 501   | 2        | "2001-02-14T17:53:27.496+0000" | "placed" | true     |





