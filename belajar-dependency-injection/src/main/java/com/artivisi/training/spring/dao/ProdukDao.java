package com.artivisi.training.spring.dao;

import com.artivisi.training.spring.Produk;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdukDao {
    
    private static final String SQL_SIMPAN = "insert into produk (kode, nama, harga) values (?,?,?)";
    
    private final String dbDriver = "com.mysql.jdbc.Driver";
    private final String dbUrl = "jdbc:mysql://localhost/belajar";
    private final String dbUsername = "root";
    private final String dbPassword = "admin";
    
    private Connection connectKeDb() {
        try {
            Class.forName(dbDriver);
            Connection c = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            return c;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void simpan(Produk p){
        Connection c = connectKeDb();
        try {
            c.setAutoCommit(false);
            
            PreparedStatement ps = c.prepareStatement(SQL_SIMPAN);
            ps.setString(1, p.getKode());
            ps.setString(2, p.getNama());
            ps.setBigDecimal(3, p.getHarga());
            ps.executeUpdate();
            c.commit();
            
        } catch (SQLException ex) {
            try {
                c.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Produk> cariSemuaProduk(){
        List<Produk> hasil = new ArrayList<Produk>();
        
        return hasil;
    }
}
