package com.artivisi.training.spring;

import com.artivisi.training.spring.dao.ProdukDao;
import java.math.BigDecimal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDIAnnotation {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext springContainer = 
                new AnnotationConfigApplicationContext(KonfigurasiAplikasi.class);
        
        Produk p = new Produk();
        p.setKode("P-002");
        p.setNama("Produk 002");
        p.setHarga(new BigDecimal("250000.00"));
        
        System.out.println("Kode Produk "+p.getKode());
        System.out.println("Nama Produk "+p.getNama());
        System.out.println("Harga Produk "+p.getHarga());
        
        ProdukDao pd = (ProdukDao) springContainer.getBean("pd");
        pd.simpan(p);
    }
}
