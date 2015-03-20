package id.co.pegadaian.simulator.bpjs.soap.endpoint;

import id.co.pegadaian.simulator.bpjs.soap.BpjsConstants;
import id.co.pegadaian.simulator.bpjs.soap.InquiryRequest;
import id.co.pegadaian.simulator.bpjs.soap.InquiryResponse;
import id.co.pegadaian.simulator.bpjs.soap.Tagihan;
import java.math.BigDecimal;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class InquiryEndpoint {
    
    @PayloadRoot(namespace = BpjsConstants.NAMESPACE, localPart = "inquiryRequest")
    @ResponsePayload
    public InquiryResponse inquiry(@RequestPayload InquiryRequest req){
        System.out.println("Inquiry untuk idpel "+req.getIdPelanggan());
        InquiryResponse resp = new InquiryResponse();
        Tagihan t = new Tagihan();
        t.setNilai(new BigDecimal(100000));
        resp.setTagihan(t);
        
        return resp;
    }
}
