package id.co.pegadaian.simulator.bpjs.soap.endpoint;

import id.co.pegadaian.simulator.bpjs.soap.InquiryRequest;
import id.co.pegadaian.simulator.bpjs.soap.InquiryResponse;
import id.co.pegadaian.simulator.bpjs.soap.Tagihan;
import java.math.BigDecimal;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

@Endpoint
public class InquiryEndpoint {
    private static final String NAMESPACE_BPJS = "http://pegadaian.co.id/bpjs";
    
    @PayloadRoot(namespace = NAMESPACE_BPJS, localPart = "InquiryRequest")
    public InquiryResponse inquiry(InquiryRequest req){
        System.out.println("Inquiry untuk idpel "+req.getIdPelanggan());
        InquiryResponse resp = new InquiryResponse();
        Tagihan t = new Tagihan();
        t.setNilai(new BigDecimal(100000));
        resp.setTagihan(t);
        return resp;
    }
}
