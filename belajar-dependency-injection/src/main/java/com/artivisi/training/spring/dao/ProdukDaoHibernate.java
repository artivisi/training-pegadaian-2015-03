package com.artivisi.training.spring.dao;

import com.artivisi.training.spring.Produk;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProdukDaoHibernate {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public void simpan(Produk p){
        sessionFactory.getCurrentSession().saveOrUpdate(p);
    }
}
