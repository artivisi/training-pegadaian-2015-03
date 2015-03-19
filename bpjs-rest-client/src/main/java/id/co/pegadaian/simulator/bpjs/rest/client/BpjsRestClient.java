package id.co.pegadaian.simulator.bpjs.rest.client;

import id.co.pegadaian.simulator.bpjs.rest.client.dto.PaymentRequest;
import id.co.pegadaian.simulator.bpjs.rest.client.dto.PaymentResponse;
import id.co.pegadaian.simulator.bpjs.rest.client.dto.Tagihan;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class BpjsRestClient {
    private String server = "http://localhost:10000";
    private RestTemplate restClient;
    
    public BpjsRestClient(){
        BasicCredentialsProvider basicAuth = new BasicCredentialsProvider();
        basicAuth.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("lukman", "123"));
        HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(basicAuth).build();
        ClientHttpRequestFactory clientFactory = new HttpComponentsClientHttpRequestFactory(client);
        restClient = new RestTemplate(clientFactory);
    }
    
    public List<Tagihan> inquiry(String idpel) throws RestClientException {
        String url = "/inquiry/kesehatan/";
        
        // mengambil response berupa map
        ResponseEntity<Tagihan[]> hasil2 = restClient.getForEntity(server + url + idpel, Tagihan[].class);
        Tagihan[] data = hasil2.getBody();
        
        return Arrays.asList(data);
    }
    
    public PaymentResponse payment(Tagihan t, String user, String loket){
        PaymentRequest payReq = new PaymentRequest();
        payReq.setIdTagihan(t.getId());
        payReq.setUserLoket(user);
        payReq.setKodeLoket(loket);
        
        String url = "/payment/kesehatan";
        
        URI lokasi = restClient.postForLocation(server + url, payReq);
        PaymentResponse resp = restClient.getForObject(lokasi, PaymentResponse.class);
        return resp;
    }
}
