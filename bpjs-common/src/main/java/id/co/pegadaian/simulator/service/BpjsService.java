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
        t.setLunas(Boolean.TRUE);
        Pembayaran p = new Pembayaran();
        p.setTagihan(t);
        p.setUserLoket("usertest");
        p.setKodeLoket("lokettest");
        
        tagihanDao.save(t);
        pembayaranDao.save(p);
        return p;
    }

    Pembayaran cariPembayaran(Tagihan t) {
        return pembayaranDao.findByTagihanId(t.getId());
    }
}
