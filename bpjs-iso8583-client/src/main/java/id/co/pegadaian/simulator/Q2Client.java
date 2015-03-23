package id.co.pegadaian.simulator;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.MUX;
import org.jpos.q2.Q2;
import org.jpos.util.NameRegistrar;

public class Q2Client {
    public static void main(String[] args) throws Exception {
        Q2 q2 = new Q2();
        q2.start();

        SimpleDateFormat formatterWaktu = new SimpleDateFormat("MMddHHmmss");
        
        ISOMsg inquiryRequest = new ISOMsg("0200");
        inquiryRequest.set(7, formatterWaktu.format(new Date()));
        inquiryRequest.set(11, "123456");
        inquiryRequest.set(102, "1234567890");
        
        
        System.out.println("Waiting startup");
        Thread.sleep(3000);
        
        System.out.println("Send inquiry");
        
        MUX mux = (MUX) NameRegistrar.get ("mux.bpjsmux");
        ISOMsg response = mux.request(inquiryRequest, 30000);
        System.out.println("Response : "+new String(response.pack()));
    }
}
