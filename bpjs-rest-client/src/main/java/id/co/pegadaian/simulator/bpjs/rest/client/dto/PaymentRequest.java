package id.co.pegadaian.simulator.bpjs.rest.client.dto;

public class PaymentRequest {
    private String userLoket;
    private String kodeLoket;
    private String idTagihan;

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

    public String getIdTagihan() {
        return idTagihan;
    }

    public void setIdTagihan(String idTagihan) {
        this.idTagihan = idTagihan;
    }
    
    
}
