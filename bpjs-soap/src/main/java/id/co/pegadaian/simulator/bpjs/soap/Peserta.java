package id.co.pegadaian.simulator.bpjs.soap;

import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://pegadaian.co.id/bpjs", propOrder = {"id", "nomer", "nama"})
public class Peserta {
    
    private String id;
    private String nomer;
    private String nama;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
}
