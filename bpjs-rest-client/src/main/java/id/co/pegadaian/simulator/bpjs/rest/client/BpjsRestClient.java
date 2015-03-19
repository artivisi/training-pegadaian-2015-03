package id.co.pegadaian.simulator.bpjs.rest.client;

import id.co.pegadaian.simulator.bpjs.rest.client.dto.Tagihan;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class BpjsRestClient {
    private String server = "http://localhost:10000";
    
    public List<Tagihan> inquiry(String idpel) throws RestClientException {
        String url = "/inquiry/kesehatan/";
        
        // mengambil response berupa string
        RestTemplate restClient = new RestTemplate();
        String hasil = restClient.getForObject(server + url + idpel, String.class);
        System.out.println("Hasil : "+hasil);
        
        // mengambil response berupa map
        ResponseEntity<Tagihan[]> hasil2 = restClient.getForEntity(server + url + idpel, Tagihan[].class);
        Tagihan[] data = hasil2.getBody();
        
        return Arrays.asList(data);
    }
}
