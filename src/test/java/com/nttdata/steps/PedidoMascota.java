package com.nttdata.steps;


import io.restassured.response.Response;
import org.junit.Assert;
import com.nttdata.services.PedidoMascotaService;

public class PedidoMascota {

    private PedidoMascotaService pedidoMascotaService;
    private Response response;

    public void configurarApi() {
        pedidoMascotaService = new PedidoMascotaService("https://petstore.swagger.io/v2/");
    }

    public void crearPedido(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        response = pedidoMascotaService.crearPedido(id, petId, quantity, shipDate, status, complete);
    }

    public void consultarPedido(int id) {
        response = pedidoMascotaService.consultarPedido(id);
    }

    public void validarStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    public void validarPedido(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        Assert.assertEquals(id, response.jsonPath().getInt("id"));
        Assert.assertEquals(petId, response.jsonPath().getInt("petId"));
        Assert.assertEquals(quantity, response.jsonPath().getInt("quantity"));
        Assert.assertEquals(shipDate, response.jsonPath().getString("shipDate"));
        Assert.assertEquals(status, response.jsonPath().getString("status"));
        Assert.assertEquals(complete, response.jsonPath().getBoolean("complete"));
    }
}