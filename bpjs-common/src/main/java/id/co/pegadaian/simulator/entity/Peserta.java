package id.co.pegadaian.simulator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.GenericGenerator;

@Entity @Table(name = "peserta")
@XmlType(namespace = "http://pegadaian.co.id/bpjs", propOrder = {"id", "nomer", "nama"})
public class Peserta {
    
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = true, unique = true)
    private String nomer;
    
    @Column(nullable = true)
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
