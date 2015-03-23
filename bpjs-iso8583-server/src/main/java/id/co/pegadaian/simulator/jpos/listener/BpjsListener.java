package id.co.pegadaian.simulator.jpos.listener;

import id.co.pegadaian.simulator.BpjsConfig;
import id.co.pegadaian.simulator.entity.Tagihan;
import id.co.pegadaian.simulator.service.BpjsService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.jpos.iso.ISOUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class BpjsListener implements ISORequestListener {

    private BpjsService bpjsService;
    private static final SimpleDateFormat formatterBlth = new SimpleDateFormat("yyyyMM");
    private static final SimpleDateFormat formatterJatuhTempo = new SimpleDateFormat("yyyyMMdd");
            
    public BpjsListener() {
        System.out.println("========== Menginstankan BpjsListener ===========");
        
        ApplicationContext ctx = SpringApplication.run(BpjsConfig.class);
        bpjsService = ctx.getBean(BpjsService.class);
        
        System.out.println("========== Menginstankan BpjsListener ===========");
    }

    @Override
    public boolean process(ISOSource isoSrc, ISOMsg isoMsg) {
        
        try {
            if (isoMsg.getMTI().equals("0800")) {
                ISOMsg reply = (ISOMsg) isoMsg.clone();
                reply.setResponseMTI();
                reply.set(39, "00");
                isoSrc.send(reply);
                return true;
            }
            
            if(isoMsg.getMTI().equals("0200")) {
                String idPel = isoMsg.getString(102);
                List<Tagihan> dataTagihan = bpjsService.cariTagihan(idPel);
                StringBuilder output = new StringBuilder();
                BigDecimal totalAmount = BigDecimal.ZERO;
                for (Tagihan tag : dataTagihan) {
                    totalAmount = totalAmount.add(tag.getNilai());
                    
                    String nama = tag.getPeserta().getNama();
                    String blth = formatterBlth.format(tag.getTanggalTagihan());
                    String jatuhTempo = formatterJatuhTempo.format(tag.getTanggalJatuhTempo());
                    String nilai = tag.getNilai().setScale(0, RoundingMode.HALF_EVEN).toPlainString();
                    
                    output.append(ISOUtil.padright(nama, 50, ' '));
                    output.append(blth);
                    output.append(jatuhTempo);
                    output.append(ISOUtil.padleft(nilai, 12, '0'));
                }
                
                ISOMsg reply = (ISOMsg) isoMsg.clone();
                reply.setResponseMTI();
                reply.set(4, totalAmount.setScale(0, RoundingMode.HALF_EVEN).toPlainString());
                reply.set(39, "00");
                reply.set(48, output.toString());
                isoSrc.send(reply);
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(BpjsListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
