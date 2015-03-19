package id.co.pegadaian.simulator.bpjs.rest.client.dto;

import java.math.BigDecimal;
import java.util.Date;

public class Tagihan {
    
    private String id;
    private Peserta peserta;
    private Date tanggalTagihan;
    private Date tanggalJatuhTempo;
    private BigDecimal nilai;
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
