package com.nttdata.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "classpath:features",
        tags = "@TestPost"//"@TestPost" ////"@pruebaWorld"   //  ==> Definir el @tag  a ejecutar
)
public class TestRunner {
}
