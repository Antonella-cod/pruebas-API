package com.nttdata.services;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;




public class PedidoMascotaService {

    private final String baseUrl;

    public PedidoMascotaService(String baseUrl) {
        this.baseUrl = baseUrl;
        RestAssured.baseURI = baseUrl;
    }

    public Response crearPedido(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        Map<String, Object> body = new HashMap<>();
        body.put("id", id);
        body.put("petId", petId);
        body.put("quantity", quantity);
        body.put("shipDate", shipDate);
        body.put("status", status);
        body.put("complete", complete);

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/store/order")
                .then()
                .extract().response();

    }

    public Response consultarPedido(int id) {
        return RestAssured.given()
                .when()
                .get("/store/order/" + id)
                .then()
                .extract().response();
    }
}