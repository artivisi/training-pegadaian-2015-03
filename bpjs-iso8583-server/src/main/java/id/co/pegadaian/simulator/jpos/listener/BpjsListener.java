package id.co.pegadaian.simulator.jpos.listener;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;

public class BpjsListener implements ISORequestListener {

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
        } catch (Exception ex) {
            Logger.getLogger(BpjsListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
