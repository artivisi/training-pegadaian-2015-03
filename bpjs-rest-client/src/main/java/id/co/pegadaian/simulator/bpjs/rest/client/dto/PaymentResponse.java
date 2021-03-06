package id.co.pegadaian.simulator.bpjs.rest.client.dto;

import java.util.Date;

public class PaymentResponse {
    private String id;
    private Tagihan tagihan;
    private Date waktuTransaksi = new Date();
    private String userLoket;
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
