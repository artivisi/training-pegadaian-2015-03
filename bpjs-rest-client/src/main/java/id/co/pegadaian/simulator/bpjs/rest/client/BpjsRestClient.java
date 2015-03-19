package id.co.pegadaian.simulator.bpjs.rest.client;

import id.co.pegadaian.simulator.bpjs.rest.client.dto.PaymentRequest;
import id.co.pegadaian.simulator.bpjs.rest.client.dto.PaymentResponse;
import id.co.pegadaian.simulator.bpjs.rest.client.dto.Tagihan;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class BpjsRestClient {
    private String server = "http://localhost:10000";
    RestTemplate restClient = new RestTemplate();
    
    public List<Tagihan> inquiry(String idpel) throws RestClientException {
        String url = "/inquiry/kesehatan/";
        
        // mengambil response berupa string
        String hasil = restClient.getForObject(server + url + idpel, String.class);
        System.out.println("Hasil : "+hasil);
        
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
