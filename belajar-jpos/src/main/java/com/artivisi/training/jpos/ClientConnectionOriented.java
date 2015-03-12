package com.artivisi.training.jpos;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMUX;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.ISO87APackager;

public class ClientConnectionOriented {
    public static void main(String[] args) throws Exception {
        
        ASCIIChannel channel = new ASCIIChannel("localhost", 12345, new ISO87APackager());
        ISOMUX mux = new ISOMUX(channel){

            @Override
            protected String getKey(ISOMsg m) throws ISOException {
                return m.getString(7);
            }
            
        };
        
        //mux.setISORequestListener(null);
        
        System.out.println("Starting ISOMux");
        new Thread(mux).start();
        
        SimpleDateFormat formatterBit7 = new SimpleDateFormat("MMddHHmmss");
        ISOMsg echoRequest = new ISOMsg();
        echoRequest.setMTI("0800");
        echoRequest.set(7, formatterBit7.format(new Date()));
        echoRequest.set(11, "123456");
        echoRequest.set(33, "123");
        echoRequest.set(70, "301");
        ISOMsg response = mux.request(echoRequest, 60000);
        if(response != null){
            System.out.println("========= Response =========");
            response.dump(System.out, "");
        } else {
            System.out.println("Tidak mendapat response sampai timeout");
        }
    }
}
