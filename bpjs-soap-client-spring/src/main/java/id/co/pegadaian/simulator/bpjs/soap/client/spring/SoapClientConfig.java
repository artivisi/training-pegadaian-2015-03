package id.co.pegadaian.simulator.bpjs.soap.client.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("id.co.pegadaian.simulator.soap.client");
        return marshaller;
    }
    
    @Bean
    public BpjsSoapClient client(Jaxb2Marshaller mars){
        BpjsSoapClient client = new BpjsSoapClient();
        client.setDefaultUri("http://localhost:10000/soap");
        client.setMarshaller(mars);
        client.setUnmarshaller(mars);
        return client;
    }
}
