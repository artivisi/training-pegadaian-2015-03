package id.co.pegadaian.simulator;

import id.co.pegadaian.simulator.entity.Tagihan;
import id.co.pegadaian.simulator.service.BpjsService;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello Spring Boot!" );
        ApplicationContext springContainer = SpringApplication.run(App.class, args);
        
        BpjsService service = springContainer.getBean(BpjsService.class);
        List<Tagihan> data = service.cariTagihan("1234567890");
        
        System.out.println("Jumlah Data : "+data.size());
    }
}
