package com.artivisi.training.spring.transaction.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name = "running_number")
public class RunningNumber {
    
    @Id @GeneratedValue
    private Integer id;
    
    @Column(nullable = false)
    private String pemakaian;
    
    @Column(nullable = false, name = "tanggal_transaksi")
    @Temporal(TemporalType.DATE)
    private Date tanggalTransaksi;
    
    @Column(nullable = false)
    private Integer terakhir = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPemakaian() {
        return pemakaian;
    }

    public void setPemakaian(String pemakaian) {
        this.pemakaian = pemakaian;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public Integer getTerakhir() {
        return terakhir;
    }

    public void setTerakhir(Integer terakhir) {
        this.terakhir = terakhir;
    }
    
    
}
