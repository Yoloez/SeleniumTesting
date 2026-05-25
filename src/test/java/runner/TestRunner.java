package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Lokasi folder tempat file .feature kamu berada
        features = "src/test/resources/features",

        // Lokasi package tempat step definition kamu berada (misalnya package "stepdefinitions")
        glue = "stepDef",

        // INI CARA FILTER TAG-NYA:
        // Menentukan test mana yang akan dijalankan berdasarkan tag di file .feature
        tags = "@smoke",

        // (Opsional) Untuk membuat report/laporan HTML yang rapi di folder target/
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class TestRunner {
    // Class ini dibiarkan kosong saja
}