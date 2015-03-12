package com.artivisi.training.jpos;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.jpos.iso.BaseChannel;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.ISO87APackager;

public class App {
    public static void main( String[] args ) throws Exception {
        SimpleDateFormat formatterBit7 = new SimpleDateFormat("MMddHHmmss");
        
        ISOMsg echoRequest = new ISOMsg();
        echoRequest.setMTI("0800");
        echoRequest.set(7, formatterBit7.format(new Date()));
        echoRequest.set(11, "123456");
        echoRequest.set(33, "123");
        //echoRequest.set(39, "00");
        echoRequest.set(70, "301");
        
        echoRequest.setPackager(new ISO87APackager());
        byte[] messageYangSudahDipack = echoRequest.pack();
        System.out.println("Message Stream : ["+new String(messageYangSudahDipack)+"]");
        
        // implementasi connectionless
        BaseChannel channel = new ASCIIChannel("localhost", 12345, new ISO87APackager());
        channel.connect();
        channel.send(echoRequest);
        ISOMsg resp = channel.receive();
        channel.disconnect();
        
        
        System.out.println("======= Response ==========");
        System.out.println("MTI : "+resp.getMTI());
        resp.dump(System.out, " ");
    }
}
