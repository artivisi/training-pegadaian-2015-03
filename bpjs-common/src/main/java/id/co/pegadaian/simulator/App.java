package id.co.pegadaian.simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello Spring Boot!" );
        SpringApplication.run(App.class, args);
    }
}
