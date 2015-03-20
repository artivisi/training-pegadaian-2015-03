package id.co.pegadaian.simulator.bpjs.soap;

import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://pegadaian.co.id/bpjs")
public class InquiryRequest {
    private String idPelanggan;

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
}
