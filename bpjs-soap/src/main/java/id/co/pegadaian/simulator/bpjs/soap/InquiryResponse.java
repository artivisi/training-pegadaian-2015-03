package id.co.pegadaian.simulator.bpjs.soap;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(namespace = BpjsConstants.NAMESPACE)
public class InquiryResponse {
    private Tagihan tagihan;

    public Tagihan getTagihan() {
        return tagihan;
    }

    public void setTagihan(Tagihan tagihan) {
        this.tagihan = tagihan;
    }
}
