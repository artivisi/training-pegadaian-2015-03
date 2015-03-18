package id.co.pegadaian.simulator.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;


@Entity @Table(name = "pembayaran")
public class Pembayaran {
    
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @OneToOne
    @JoinColumn(name = "id_tagihan", nullable = false)
    private Tagihan tagihan;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "waktu_transaksi")
    private Date waktuTransaksi = new Date();
    
    @Column(nullable = false, name = "user_loket")
    private String userLoket;
    @Column(nullable = false, name = "kode_loket")
    private String kodeLoket;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tagihan getTagihan() {
        return tagihan;
    }

    public void setTagihan(Tagihan tagihan) {
        this.tagihan = tagihan;
    }

    public Date getWaktuTransaksi() {
        return waktuTransaksi;
    }

    public void setWaktuTransaksi(Date waktuTransaksi) {
        this.waktuTransaksi = waktuTransaksi;
    }

    public String getUserLoket() {
        return userLoket;
    }

    public void setUserLoket(String userLoket) {
        this.userLoket = userLoket;
    }

    public String getKodeLoket() {
        return kodeLoket;
    }

    public void setKodeLoket(String kodeLoket) {
        this.kodeLoket = kodeLoket;
    }
    
    
}
