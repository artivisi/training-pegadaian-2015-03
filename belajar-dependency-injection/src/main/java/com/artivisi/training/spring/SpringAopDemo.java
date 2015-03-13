package com.artivisi.training.spring;

import com.artivisi.training.spring.dao.ProdukDao;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopDemo {
    public static void main(String[] args) {
        
        AbstractApplicationContext springContainer
                = new ClassPathXmlApplicationContext("belajar-aop.xml");
        
        
        Produk p = (Produk) springContainer.getBean("p");
        
        System.out.println("Kode Produk "+p.getKode());
        System.out.println("Nama Produk "+p.getNama());
        System.out.println("Harga Produk "+p.getHarga());
        
        ProdukDao pd = (ProdukDao) springContainer.getBean("pd");
        pd.simpan(p);
    }
}
