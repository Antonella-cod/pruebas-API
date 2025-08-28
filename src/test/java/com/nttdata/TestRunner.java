package com.nttdata;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/", //"classpath:features",
        tags ="@TestEjecucion"// "@TestPost"//"@ConsultarPedido" ////"@pruebaWorld"   //  ==> Definir el @tag  a ejecutar
)
public class TestRunner {
}
