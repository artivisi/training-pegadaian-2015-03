package id.co.pegadaian.simulator.iso.client;

import id.co.pegadaian.simulator.iso.client.dao.InquiryDao;
import id.co.pegadaian.simulator.iso.client.entity.Inquiry;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.MUX;
import org.jpos.util.NameRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class InquiryProcessor {

    @Autowired
    private InquiryDao inquiryDao;

    private SimpleDateFormat formatterWaktu = new SimpleDateFormat("MMddHHmmss");

    @Scheduled(fixedRate = 5000, initialDelay = 5000)
    public void proses() {
        try {
            List<Inquiry> yangBelumDiproses = inquiryDao.findByStatus("BARU");
            System.out.println("Jumlah inquiry : " + yangBelumDiproses.size());

            for (Inquiry tag : yangBelumDiproses) {
                ISOMsg inquiryRequest = new ISOMsg("0200");
                inquiryRequest.set(7, formatterWaktu.format(new Date()));
                inquiryRequest.set(11, "123456");
                inquiryRequest.set(102, tag.getIdpel());

                MUX mux = (MUX) NameRegistrar.get("mux.bpjsmux");
                ISOMsg response = mux.request(inquiryRequest, 30000);
                tag.setStatus("SENT");
                inquiryDao.save(tag);
                if(response != null){
                    System.out.println("Parsing ISO Message");
                    tag.setNilai(new BigDecimal(response.getString(4)));
                    tag.setStatus("DONE");
                    inquiryDao.save(tag);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(InquiryProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
