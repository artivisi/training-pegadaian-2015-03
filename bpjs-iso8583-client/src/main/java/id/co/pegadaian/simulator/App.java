package id.co.pegadaian.simulator;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.ISO87APackager;

public class App {
    public static void main( String[] args ) throws Exception {
        ASCIIChannel channel = new ASCIIChannel("localhost", 12345, new ISO87APackager());
        
        SimpleDateFormat formatterWaktu = new SimpleDateFormat("MMddHHmmss");
        
        ISOMsg echoRequest = new ISOMsg("0800");
        echoRequest.set(7, formatterWaktu.format(new Date()));
        
        channel.connect();
        channel.send(echoRequest);
        ISOMsg response = channel.receive();
        System.out.println("Response : "+new String(response.pack()));
    }
}
