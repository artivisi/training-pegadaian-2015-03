package id.co.pegadaian.simulator;

import org.jpos.q2.Q2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootIsoGateway {
    public static void main(String[] args) throws Exception {
        Q2 q2 = new Q2();
        q2.start();
        
        System.out.println("Menunggu inisialisasi Q2 ..... ");
        Thread.sleep(3000);
        
        System.out.println("Inisialisasi Spring Boot");
        SpringApplication.run(SpringBootIsoGateway.class, args);
    }
}
