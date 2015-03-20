package id.co.pegadaian.simulator.bpjs.soap;

import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://pegadaian.co.id/bpjs")
public class InquiryResponse {
    private Tagihan tagihan;

    public Tagihan getTagihan() {
        return tagihan;
    }

    public void setTagihan(Tagihan tagihan) {
        this.tagihan = tagihan;
    }
}
