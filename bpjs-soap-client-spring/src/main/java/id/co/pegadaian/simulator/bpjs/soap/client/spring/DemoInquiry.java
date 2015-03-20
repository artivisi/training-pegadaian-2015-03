package id.co.pegadaian.simulator.bpjs.soap.client.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class DemoInquiry extends WebServiceGatewaySupport {
    public static void main(String[] args) {
        ApplicationContext springContainer = SpringApplication.run(SoapClientConfig.class, args);
        BpjsSoapClient client = springContainer.getBean(BpjsSoapClient.class);
        client.inquiry();
    }
}
