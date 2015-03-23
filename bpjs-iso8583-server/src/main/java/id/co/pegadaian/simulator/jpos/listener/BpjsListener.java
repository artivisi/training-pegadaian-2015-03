package id.co.pegadaian.simulator.jpos.listener;

import id.co.pegadaian.simulator.BpjsConfig;
import id.co.pegadaian.simulator.entity.Tagihan;
import id.co.pegadaian.simulator.service.BpjsService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class BpjsListener implements ISORequestListener {

    private BpjsService bpjsService;
    
    public BpjsListener() {
        System.out.println("========== Menginstankan BpjsListener ===========");
        
        ApplicationContext ctx = SpringApplication.run(BpjsConfig.class);
        bpjsService = ctx.getBean(BpjsService.class);
        
        System.out.println("========== Menginstankan BpjsListener ===========");
    }

    @Override
    public boolean process(ISOSource isoSrc, ISOMsg isoMsg) {
        // coba untuk memanggil bpjs service
        
        List<Tagihan> dataTagihan = bpjsService.cariTagihan("1234567890");
        System.out.println("Jumlah Tagihan : "+dataTagihan.size());
        
        try {
            if (isoMsg.getMTI().equals("0800")) {
                ISOMsg reply = (ISOMsg) isoMsg.clone();
                reply.setResponseMTI();
                reply.set(39, "00");
                isoSrc.send(reply);
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(BpjsListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
