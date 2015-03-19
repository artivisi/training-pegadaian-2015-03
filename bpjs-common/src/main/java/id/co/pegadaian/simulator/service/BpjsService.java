package id.co.pegadaian.simulator.service;

import id.co.pegadaian.simulator.dao.PembayaranDao;
import id.co.pegadaian.simulator.dao.PesertaDao;
import id.co.pegadaian.simulator.dao.TagihanDao;
import id.co.pegadaian.simulator.entity.Pembayaran;
import id.co.pegadaian.simulator.entity.Peserta;
import id.co.pegadaian.simulator.entity.Tagihan;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class BpjsService {
    
    @Autowired private PesertaDao pesertaDao;
    @Autowired private TagihanDao tagihanDao;
    @Autowired private PembayaranDao pembayaranDao;
    
    public List<Tagihan> cariTagihan(String nomerPelanggan){
        if(nomerPelanggan == null || nomerPelanggan.isEmpty()){
            return new ArrayList<Tagihan>();
        }
        return tagihanDao.findByPesertaNomerOrderByTanggalTagihanDesc(nomerPelanggan);
    }

    public void simpan(Peserta p) {
        pesertaDao.save(p);
    }

    public Long hitungJumlahPeserta() {
        return pesertaDao.count();
    }
    
    public Pembayaran bayar(Tagihan t){
        return bayar(t, "lokettest", "usertest");
    }

    Pembayaran cariPembayaran(Tagihan t) {
        return pembayaranDao.findByTagihanId(t.getId());
    }

    public Tagihan cariTagihanById(String idTagihan) {
        return tagihanDao.findOne(idTagihan);
    }

    public Pembayaran bayar(Tagihan t, String kodeLoket, String userLoket) {
        t.setLunas(Boolean.TRUE);
        Pembayaran p = new Pembayaran();
        p.setTagihan(t);
        p.setUserLoket(userLoket);
        p.setKodeLoket(kodeLoket);
        
        tagihanDao.save(t);
        pembayaranDao.save(p);
        return p;

    }

    public Pembayaran cariPembayaranById(String id) {
        return pembayaranDao.findOne(id);
    }
}
