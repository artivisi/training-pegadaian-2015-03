package id.co.pegadaian.simulator.bpjs.email.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
public class EmailIntegrationApp {
    public static void main(String[] args) {
        SpringApplication.run(EmailIntegrationApp.class, args);
    }
}
