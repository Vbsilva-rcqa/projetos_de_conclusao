package br.com.projetoconclusao.saucedemo.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "br.com.projetoconclusao.saucedemo.steps",
    plugin = {"pretty"},
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunCucumberTest {
}