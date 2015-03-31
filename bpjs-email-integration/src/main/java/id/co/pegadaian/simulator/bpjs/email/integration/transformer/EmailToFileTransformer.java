package id.co.pegadaian.simulator.bpjs.email.integration.transformer;

import com.google.common.io.CharStreams;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.internet.MimeMultipart;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmailToFileTransformer {
    
    @Transformer(inputChannel = "incomingMail", outputChannel = "tagihanString")
    public org.springframework.messaging.Message<String> convertEmailAttachmentToString(Message msg){
        
        try {
            if(!MimeMultipart.class.isAssignableFrom(msg.getContent().getClass())){
                System.out.println("Format Email tidak disupport");
                return null;
            }
            
            MimeMultipart body = (MimeMultipart) msg.getContent();
            for(int i=0; i<body.getCount(); i++){
                System.out.println("Part "+(i+1)+" Type : "+body.getBodyPart(i).getContentType());
                System.out.println("Part "+(i+1)+" Content : "+body.getBodyPart(i).getContent());
                if(!body.getBodyPart(i).getContentType().contains("text/csv")){
                    System.out.println("Tipe data "+body.getBodyPart(i).getContentType()+" tidak disupport, lanjut");
                    continue;
                }
                
                String output = CharStreams.toString(new InputStreamReader(body.getBodyPart(i).getInputStream()));
                System.out.println("Isi file csv : "+output);
                
                org.springframework.messaging.Message<String> fileMessage = MessageBuilder.withPayload(output)
                        .setHeader(FileHeaders.FILENAME, msg.getSubject()+".csv").build();
                return fileMessage;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(EmailToFileTransformer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
