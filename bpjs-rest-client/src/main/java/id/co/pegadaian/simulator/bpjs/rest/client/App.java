package id.co.pegadaian.simulator.bpjs.rest.client;

import id.co.pegadaian.simulator.bpjs.rest.client.dto.PaymentResponse;
import id.co.pegadaian.simulator.bpjs.rest.client.dto.Tagihan;
import java.util.List;

public class App {
    public static void main(String[] args) {
        BpjsRestClient bpjsClient = new BpjsRestClient();
        
        String idpel = "1234567890";
        List<Tagihan> dataTagihan = bpjsClient.inquiry(idpel);
        for (Tagihan t : dataTagihan) {
            System.out.println("ID : "+t.getId());
            System.out.println("Nomer : "+t.getPeserta().getNomer());
            System.out.println("Nama : "+t.getPeserta().getNama());
            System.out.println("Nilai : "+t.getNilai());
            System.out.println("Tanggal Jatuh Tempo : "+t.getTanggalJatuhTempo());
            
            PaymentResponse resp = bpjsClient.payment(t, "restclientuser", "restclientloket");
            System.out.println("ID Pembayaran : "+resp.getId());
            System.out.println("Waktu lunas : "+resp.getWaktuTransaksi());
        }
    }

    
}
