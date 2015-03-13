package com.artivisi.training.spring;

import com.artivisi.training.spring.dao.ProdukDao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {
    private static final String dbDriver = "com.mysql.jdbc.Driver";
    private static final String dbUrl = "jdbc:mysql://localhost/belajar";
    private static final String dbUsername = "root";
    private static final String dbPassword = "admin";
    
    private static Connection connectKeDb() {
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
    
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        
        Produk p = new Produk();
        p.setKode("P-001");
        p.setNama("Produk 001");
        p.setHarga(new BigDecimal("150.000,00"));
        
        ProdukDao pd = new ProdukDao(connectKeDb());
        pd.simpan(p);
    }
}
