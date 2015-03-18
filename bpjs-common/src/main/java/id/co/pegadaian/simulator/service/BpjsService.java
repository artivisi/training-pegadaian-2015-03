package id.co.pegadaian.simulator.service;

import id.co.pegadaian.simulator.entity.Peserta;
import id.co.pegadaian.simulator.entity.Tagihan;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class BpjsService {
    @Autowired private EntityManager entityManager;
    
    public List<Tagihan> cariTagihan(String nomerPelanggan){
        if(nomerPelanggan == null || nomerPelanggan.isEmpty()){
            return new ArrayList<Tagihan>();
        }
        
        return entityManager.createQuery("select t from Tagihan t where t.peserta.nomer = :nomer order by t.tanggalTagihan")
                .setParameter("nomer", nomerPelanggan)
                .getResultList();
    }

    public void simpan(Peserta p) {
        entityManager.persist(p);
    }

    public Long hitungJumlahPeserta() {
        return (Long) entityManager.createQuery("select count(*) from Peserta p")
                .getSingleResult();
    }
}
