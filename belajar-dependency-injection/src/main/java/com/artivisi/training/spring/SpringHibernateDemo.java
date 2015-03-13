package com.artivisi.training.spring;

import com.artivisi.training.spring.dao.ProdukDaoHibernate;
import java.math.BigDecimal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringHibernateDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext springContainer = 
                new AnnotationConfigApplicationContext(KonfigurasiAplikasi.class);
        
        Produk p = new Produk();
        p.setKode("P-003");
        p.setNama("Produk 003");
        p.setHarga(new BigDecimal("250000.00"));
        
        System.out.println("Kode Produk "+p.getKode());
        System.out.println("Nama Produk "+p.getNama());
        System.out.println("Harga Produk "+p.getHarga());
        
        ProdukDaoHibernate pd = (ProdukDaoHibernate) springContainer.getBean("produkDaoHibernate");
        System.out.println("ID Produk : "+p.getId());
        pd.simpan(p);
        System.out.println("ID Produk : "+p.getId());
    }
}
