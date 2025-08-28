package com.nttdata.glue;

import com.nttdata.steps.PedidoMascota;
import io.cucumber.java.en.*;
import io.cucumber.java.PendingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class PedidoMascotaStepDef {


    @Steps
    PedidoMascota pedido;

    @Given("la API de Petstore está configurada")
    public void configurarApi(){
        pedido.configurarApi();
    }

   @When("creo un nuevo order con id {int}, petId {int}, quantity {int}, shipDate {string}, status {string}, complete true")
   public void creoUnNuevoPedido(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
       pedido.crearPedido(id, petId, quantity, shipDate, status, complete);
   }




    @Then("valido el codigo de respuesta sea {int}")
    public void validarStatusCode(int statusCode) {
       pedido.validarStatusCode(statusCode);
    }



    @When("consulto el pedido con id {int}")
    public void consultoElPedidoConId(int id) {
         pedido.consultarPedido(id);
    }

    @And("la respuesta debe contener el order creado con id {int}, petId {int}, quantity {int}, shipDate {string}, status {string}, complete true")
    public void laRespuestaDebeContener(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        pedido.validarPedido(id, petId, quantity, shipDate, status, complete);
    }


}
