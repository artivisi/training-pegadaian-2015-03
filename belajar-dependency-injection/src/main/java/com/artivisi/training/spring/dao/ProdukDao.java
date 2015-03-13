package com.artivisi.training.spring.dao;

import com.artivisi.training.spring.Produk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ProdukDao {
    
    private static final String SQL_SIMPAN = "insert into produk (kode, nama, harga) values (?,?,?)";
    private DataSource dataSource;

    // constructor injection
    /*public ProdukDao(DataSource ds) {
        this.dataSource = ds;
    }*/

    // setter injection
    @Autowired
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
    }
    
    public void simpan(Produk p){
        Connection c = null;
        try {
            c = dataSource.getConnection();
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
        } 
    }
    
    public List<Produk> cariSemuaProduk(){
        List<Produk> hasil = new ArrayList<Produk>();
        
        return hasil;
    }
}
