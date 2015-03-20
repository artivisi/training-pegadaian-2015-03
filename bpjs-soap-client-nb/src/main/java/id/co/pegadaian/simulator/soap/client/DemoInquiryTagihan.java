package id.co.pegadaian.simulator.soap.client;

public class DemoInquiryTagihan {
    public static void main(String[] args) {
        
        try { // Call Web Service Operation
            BpjsService service = new BpjsService();
            Bpjs port = service.getBpjsSoap11();
            // TODO initialize WS operation arguments here
            InquiryRequest inquiryRequest = new InquiryRequest();
            inquiryRequest.setIdPelanggan("1234567890");
            
            // TODO process result here
            InquiryResponse result = port.inquiry(inquiryRequest);
            
            InquiryResponse.DaftarTagihan data = result.getDaftarTagihan();
            for (Tagihan t : data.getTagihan()) {
                System.out.println("Nama : "+t.getPeserta().getNama());
                System.out.println("Nilai : "+t.getNilai());
                System.out.println("Jatuh Tempo : "+t.getTanggalJatuhTempo());
            }
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            ex.printStackTrace();
        }

        

    }
}
