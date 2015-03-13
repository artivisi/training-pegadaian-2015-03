package com.artivisi.training.spring.dao;

import com.artivisi.training.spring.Produk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdukDao {
    
    private static final String SQL_SIMPAN = "insert into produk (kode, nama, harga) values (?,?,?)";
    private Connection koneksi;

    // constructor injection
    public ProdukDao(Connection koneksi) {
        this.koneksi = koneksi;
    }

    // setter injection
    public void setKoneksi(Connection koneksi) {
        this.koneksi = koneksi;
    }
    
    public void simpan(Produk p){
        try {
            koneksi.setAutoCommit(false);
            
            PreparedStatement ps = koneksi.prepareStatement(SQL_SIMPAN);
            ps.setString(1, p.getKode());
            ps.setString(2, p.getNama());
            ps.setBigDecimal(3, p.getHarga());
            ps.executeUpdate();
            koneksi.commit();
            
        } catch (SQLException ex) {
            try {
                koneksi.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public List<Produk> cariSemuaProduk(){
        List<Produk> hasil = new ArrayList<Produk>();
        
        return hasil;
    }
}
