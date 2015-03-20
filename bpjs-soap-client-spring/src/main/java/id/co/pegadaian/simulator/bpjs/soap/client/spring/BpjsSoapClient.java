package id.co.pegadaian.simulator.bpjs.soap.client.spring;

import id.co.pegadaian.simulator.soap.client.InquiryRequest;
import id.co.pegadaian.simulator.soap.client.InquiryResponse;
import id.co.pegadaian.simulator.soap.client.Tagihan;
import java.util.List;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class BpjsSoapClient extends WebServiceGatewaySupport {
    public void inquiry(){
        InquiryRequest req = new InquiryRequest();
        req.setIdPelanggan("1234567890");
        
        InquiryResponse resp = 
            (InquiryResponse) getWebServiceTemplate().marshalSendAndReceive(req);
        
        List<Tagihan> dataTagihan = resp.getDaftarTagihan().getTagihan();
        for (Tagihan tag : dataTagihan) {
            System.out.println("Nama : "+tag.getPeserta().getNama());
            System.out.println("Nilai : "+tag.getNilai());
            System.out.println("Jatuh Tempo : "+tag.getTanggalJatuhTempo());
        }
    }
}
