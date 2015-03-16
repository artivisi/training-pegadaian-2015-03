package com.artivisi.training.spring.transaction.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name = "tagihan")
public class Tagihan {
    
    @Id @GeneratedValue
    private Integer id;
    
    @Column(name = "nomer_tagihan", nullable = false, unique = true)
    private String nomerTagihan;
    
    @Column(name = "waktu_transaksi", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuTransaksi;
    
    @Column(nullable = false)
    private String pelanggan;
    
    @Column(nullable = false)
    private String keterangan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomerTagihan() {
        return nomerTagihan;
    }

    public void setNomerTagihan(String nomerTagihan) {
        this.nomerTagihan = nomerTagihan;
    }

    public Date getWaktuTransaksi() {
        return waktuTransaksi;
    }

    public void setWaktuTransaksi(Date waktuTransaksi) {
        this.waktuTransaksi = waktuTransaksi;
    }

    public String getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(String pelanggan) {
        this.pelanggan = pelanggan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    
}
