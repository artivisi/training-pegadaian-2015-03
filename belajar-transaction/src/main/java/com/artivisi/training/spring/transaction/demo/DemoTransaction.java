package com.artivisi.training.spring.transaction.demo;

import com.artivisi.training.spring.transaction.entity.Tagihan;
import com.artivisi.training.spring.transaction.service.PenjualanService;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.artivisi.training.spring.transaction.entity")
@ComponentScan(basePackages = "com.artivisi.training.spring")
public class DemoTransaction {
    public static void main(String[] args) {
        System.out.println("Demo Transaction");
        ApplicationContext springContainer = SpringApplication.run(DemoTransaction.class, args);
        
        Tagihan t = new Tagihan();
        t.setKeterangan("Penjualan Kue");
        t.setPelanggan("Endy");
        t.setWaktuTransaksi(new Date());
        
        PenjualanService ps = springContainer.getBean(PenjualanService.class);
        ps.create(t);
        
        System.out.println("ID Tagihan : "+t.getId());
        System.out.println("Nomer Tagihan : "+t.getNomerTagihan());
    }
}
