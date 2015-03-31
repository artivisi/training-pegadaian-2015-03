package id.co.pegadaian.simulator.bpjs.email.integration;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.internet.MimeMultipart;
import org.springframework.stereotype.Service;

@Service
public class BpjsTagihanEmailHandler {
    public void importTagihan(Message email){
        try {
            System.out.println("Message Header : "+email.getSubject());
            System.out.println("Message Content Class : "+email.getContent().getClass());
            
            MimeMultipart body = (MimeMultipart) email.getContent();
            for(int i=0; i<body.getCount(); i++){
                System.out.println("Part "+(i+1)+" Type : "+body.getBodyPart(i).getContentType());
                System.out.println("Part "+(i+1)+" Content : "+body.getBodyPart(i).getContent());
            }
        } catch (Exception ex) {
            Logger.getLogger(BpjsTagihanEmailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
