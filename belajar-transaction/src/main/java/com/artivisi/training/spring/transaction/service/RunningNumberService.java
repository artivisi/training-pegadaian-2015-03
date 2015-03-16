package com.artivisi.training.spring.transaction.service;

import com.artivisi.training.spring.transaction.entity.RunningNumber;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunningNumberService {

    @Autowired
    private EntityManager entityManager;
    
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public RunningNumber nomerTerakhir(String pemakaian) {
        List<RunningNumber> hasil = entityManager.createQuery("select r from RunningNumber r where r.pemakaian = :pemakaian")
                .setParameter("pemakaian", pemakaian)
                .getResultList();
        
        RunningNumber rn = null;
        
        if(hasil.isEmpty()){
            rn = new RunningNumber();
            rn.setPemakaian(pemakaian);
            rn.setTanggalTransaksi(new Date());
            entityManager.persist(rn);
        } else {
            rn = hasil.get(0);
        }
        
        rn.setTerakhir(rn.getTerakhir() + 1);
        entityManager.merge(rn);
        return rn;
    }
    
}
