package com.artivisi.training.jpos;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMUX;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.ISO87APackager;

public class ClientConnectionOriented {
    public static void main(String[] args) throws Exception {
        
        ASCIIChannel channel = new ASCIIChannel("localhost", 12345, new ISO87APackager()){
            SimpleDateFormat formatterBit7 = new SimpleDateFormat("MMddHHmmss");

            @Override
            public void connect() throws IOException {
                super.connect(); 
                if(isConnected()){
                    sendSignon();
                }
            }
            
            private void sendSignon(){
                try {
                    if(!isConnected()){
                        return;
                    }
                    ISOMsg signonRequest = new ISOMsg();
                    signonRequest.setMTI("0800");
                    signonRequest.set(7, formatterBit7.format(new Date()));
                    signonRequest.set(11, "123456");
                    signonRequest.set(33, "123");
                    signonRequest.set(70, "001");
                    System.out.println("Mengirim Signon");
                    send(signonRequest);
                    ISOMsg response = receive();
                    System.out.println("===== Signon Response =====");
                    response.dump(System.out, "");
                    System.out.println("===== Signon Response =====");
                } catch (Exception ex) {
                    Logger.getLogger(ClientConnectionless.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
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
        Integer ulangi = 10;
        
        for(int i=0; i<ulangi; i++){
            System.out.println("Kirim Echo "+ (i+1));
            kirimEcho(formatterBit7, mux);
            Thread.sleep(3000);
        }
        
        System.out.println("======= Selesai ==========");
        System.exit(0);
    }

    private static void kirimEcho(SimpleDateFormat formatterBit7, ISOMUX mux) throws ISOException {
        System.out.println("====== Mengirim Echo =========");
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
