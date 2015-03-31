package id.co.pegadaian.simulator.bpjs.email.integration;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:id/co/pegadaian/simulator/bpjs/email/integration/bpjs-integration.xml")
public class KonfigurasiAplikasi {
    
    @Bean
    public Properties mailProperties(){
        Properties mailConfig = new Properties();
        mailConfig.put("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        mailConfig.put("mail.imap.socketFactory.fallback", false);
        mailConfig.put("mail.store.protocol", "imaps");
        mailConfig.put("mail.imaps.ssl.trust", "*");
        mailConfig.put("mail.debug", true);
        return mailConfig;
    }
    
}
