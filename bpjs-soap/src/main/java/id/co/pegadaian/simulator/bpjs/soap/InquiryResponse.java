package id.co.pegadaian.simulator.bpjs.soap;

import id.co.pegadaian.simulator.entity.Tagihan;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(namespace = BpjsConstants.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
public class InquiryResponse {
    
    @XmlElementWrapper(name="daftarTagihan")
    @XmlElement(name="tagihan")
    private List<Tagihan> daftarTagihan;

    public List<Tagihan> getDaftarTagihan() {
        return daftarTagihan;
    }

    public void setDaftarTagihan(List<Tagihan> daftarTagihan) {
        this.daftarTagihan = daftarTagihan;
    }
    
}
