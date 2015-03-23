package id.co.pegadaian.simulator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.ISO87APackager;

public class App {
    public static void main( String[] args ) throws Exception {
        ASCIIChannel channel = new ASCIIChannel("localhost", 12345, new ISO87APackager());
        SimpleDateFormat formatterWaktu = new SimpleDateFormat("MMddHHmmss");
        
        echoTest(formatterWaktu, channel);
        
        inquiryTest(formatterWaktu, channel);
    }

    private static void inquiryTest(SimpleDateFormat formatterWaktu, ASCIIChannel channel) throws ISOException, IOException {
        ISOMsg inquiryRequest = new ISOMsg("0200");
        inquiryRequest.set(7, formatterWaktu.format(new Date()));
        inquiryRequest.set(11, "123456");
        inquiryRequest.set(102, "1234567890");
        
        channel.connect();
        channel.send(inquiryRequest);
        ISOMsg response = channel.receive();
        channel.disconnect();
        
        System.out.println("Response : "+new String(response.pack()));
    }

    private static void echoTest(SimpleDateFormat formatterWaktu, ASCIIChannel channel) throws IOException, ISOException {
        ISOMsg echoRequest = new ISOMsg("0800");
        echoRequest.set(7, formatterWaktu.format(new Date()));
        
        channel.connect();
        channel.send(echoRequest);
        ISOMsg response = channel.receive();
        System.out.println("Response : "+new String(response.pack()));
        channel.disconnect();
    }
}
