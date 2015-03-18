package id.co.pegadaian.simulator.service;

import id.co.pegadaian.simulator.dao.PesertaDao;
import id.co.pegadaian.simulator.dao.TagihanDao;
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
}
