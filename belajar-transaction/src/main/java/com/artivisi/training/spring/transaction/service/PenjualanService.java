package com.artivisi.training.spring.transaction.service;

import com.artivisi.training.spring.transaction.entity.RunningNumber;
import com.artivisi.training.spring.transaction.entity.Tagihan;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PenjualanService {
    
    @Autowired private EntityManager entityManager;
    @Autowired private RunningNumberService runningNumberService;
    
    @Transactional
    public void create(Tagihan t){
        RunningNumber rn = runningNumberService.nomerTerakhir("tagihan");
        
        t.setNomerTagihan("T-"+rn.getTerakhir());
        
        entityManager.persist(t);
        
        throw new IllegalStateException("Pura-puranya error di sini");
    }
}
