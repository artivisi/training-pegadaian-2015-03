package id.co.pegadaian.simulator.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.GenericGenerator;

@Entity @Table(name = "tagihan")
@XmlType(namespace = "http://www.artivisi.com/bpjs", propOrder = {"id", "tanggalTagihan", "tanggalJatuhTempo", "nilai", "lunas", "peserta"})
public class Tagihan {
    
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "id_peserta", nullable = false)
    private Peserta peserta;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_tagihan", nullable = false)
    private Date tanggalTagihan;
    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_jatuh_tempo", nullable = false)
    private Date tanggalJatuhTempo;
    @Column(nullable = false)
    private BigDecimal nilai;
    @Column(nullable = false)
    private Boolean lunas = Boolean.FALSE;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Peserta getPeserta() {
        return peserta;
    }

    public void setPeserta(Peserta peserta) {
        this.peserta = peserta;
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

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }

    public Boolean getLunas() {
        return lunas;
    }

    public void setLunas(Boolean lunas) {
        this.lunas = lunas;
    }
    
}
