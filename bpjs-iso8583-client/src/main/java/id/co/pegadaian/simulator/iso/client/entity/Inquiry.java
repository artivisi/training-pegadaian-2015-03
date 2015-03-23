package id.co.pegadaian.simulator.iso.client.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name = "inquiry_bpjs")
public class Inquiry {
    
    @Id
    private String id;
    private BigDecimal nilai;
    private String idpel;    
    private String nama;    
    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_tagihan")
    private Date tanggalTagihan;
    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_jatuh_tempo")
    private Date tanggalJatuhTempo;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggalTagihan() {
        return tanggalTagihan;
    }

    public void setTanggalTagihan(Date tanggalTagihan) {
        this.tanggalTagihan = tanggalTagihan;
    }

    public Date getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public void setTanggalJatuhTempo(Date tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }

    public String getIdpel() {
        return idpel;
    }

    public void setIdpel(String idpel) {
        this.idpel = idpel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
