package id.co.pegadaian.simulator.bpjs.rest.client;

import id.co.pegadaian.simulator.bpjs.rest.client.dto.PaymentRequest;
import id.co.pegadaian.simulator.bpjs.rest.client.dto.PaymentResponse;
import id.co.pegadaian.simulator.bpjs.rest.client.dto.Tagihan;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class BpjsRestClient {
    private String server = "http://localhost:10000";
    RestTemplate restClient = new RestTemplate();
    
    private HttpHeaders createAuthenticationHeader(){
        String userpass = "user:test123";
        String base64encoded = Base64Utils.encodeToString(userpass.getBytes());
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "Basic "+base64encoded);
        return header;
    }
    
    
    public List<Tagihan> inquiry(String idpel) throws RestClientException {
        String url = "/inquiry/kesehatan/";
        
        // mengambil response berupa map
        HttpEntity<String> request = new HttpEntity<>(createAuthenticationHeader());
        ResponseEntity<Tagihan[]> hasil2 = restClient.exchange(server+url+idpel, HttpMethod.GET, request, Tagihan[].class);
        Tagihan[] data = hasil2.getBody();
        
        return Arrays.asList(data);
    }
    
    public PaymentResponse payment(Tagihan t, String user, String loket){
        PaymentRequest payReq = new PaymentRequest();
        payReq.setIdTagihan(t.getId());
        payReq.setUserLoket(user);
        payReq.setKodeLoket(loket);
        
        String url = "/payment/kesehatan";
        
        HttpEntity<PaymentRequest> request = new HttpEntity<>(payReq, createAuthenticationHeader());
        URI lokasi = restClient.postForLocation(server + url, request);
        
        
        HttpEntity<String> paymentResultRequest = new HttpEntity<>(createAuthenticationHeader());
        ResponseEntity<PaymentResponse> resp = restClient.exchange(lokasi, HttpMethod.GET, paymentResultRequest, PaymentResponse.class);
        return resp.getBody();
    }
}
