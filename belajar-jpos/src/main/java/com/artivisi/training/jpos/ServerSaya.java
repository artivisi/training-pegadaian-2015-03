package com.artivisi.training.jpos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOServer;
import org.jpos.iso.ISOSource;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.ISO87APackager;

public class ServerSaya {
    public static void main(String[] args) throws Exception {
        
        ISOServer server = new ISOServer(12345, new ASCIIChannel(new ISO87APackager()), null);
        
        server.addISORequestListener(new ISORequestListener() {

            public boolean process(ISOSource pengirim, ISOMsg request) {
                try {
                    // tampilkan isi request
                    request.dump(System.out, "");
                    
                    if("0800".equals(request.getMTI())){
                        ISOMsg response = (ISOMsg) request.clone();
                        response.setMTI("0810");
                        response.set(39, "00");
                        //response.set(7, "1234567890");
                        pengirim.send(response);
                        System.out.println("Mengirim response : ");
                        response.setPackager(new ISO87APackager());
                        response.dump(System.out, "");
                        return true;
                    }
                    
                    System.out.println("Tipe message "+request.getMTI()+" tidak disupport");
                    
                } catch (Exception ex) {
                    Logger.getLogger(ServerSaya.class.getName()).log(Level.SEVERE, null, ex);
                }
                return false;
            }
        });
        
        System.out.println("Menjalankan server di port "+12345);
        
        new Thread(server).start();
        
    }
}
