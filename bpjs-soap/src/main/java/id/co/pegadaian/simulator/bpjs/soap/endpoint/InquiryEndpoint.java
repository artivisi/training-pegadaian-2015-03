package id.co.pegadaian.simulator.bpjs.soap.endpoint;

import id.co.pegadaian.simulator.bpjs.soap.BpjsConstants;
import id.co.pegadaian.simulator.bpjs.soap.InquiryRequest;
import id.co.pegadaian.simulator.bpjs.soap.InquiryResponse;
import id.co.pegadaian.simulator.entity.Tagihan;
import id.co.pegadaian.simulator.service.BpjsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class InquiryEndpoint {
    
    @Autowired private BpjsService bpjsService;
    
    @PayloadRoot(namespace = BpjsConstants.NAMESPACE, localPart = "inquiryRequest")
    @ResponsePayload
    public InquiryResponse inquiry(@RequestPayload InquiryRequest req){
        System.out.println("Inquiry untuk idpel "+req.getIdPelanggan());
        InquiryResponse resp = new InquiryResponse();
        
        List<Tagihan> dataTagihan = bpjsService.cariTagihan(req.getIdPelanggan());
        resp.setDaftarTagihan(dataTagihan);
        
        return resp;
    }
}
