package com.artivisi.training.spring;

import com.artivisi.training.spring.dao.ProdukDao;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 * Hello world!
 *
 */
public class ManualDI {
    private static final String dbDriver = "com.mysql.jdbc.Driver";
    private static final String dbUrl = "jdbc:mysql://localhost/belajar";
    private static final String dbUsername = "root";
    private static final String dbPassword = "admin";
    
    private static DataSource connectKeDb() {
        try {
            Class.forName(dbDriver);
            MysqlDataSource c = new MysqlDataSource();
            c.setUrl(dbUrl);
            c.setUser(dbUsername);
            c.setPassword(dbPassword);
            return c;
        } catch (ClassNotFoundException ex) {
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
        
        System.out.println("Kode Produk "+p.getKode());
        System.out.println("Nama Produk "+p.getNama());
        System.out.println("Harga Produk "+p.getHarga());
        
        ProdukDao pd = new ProdukDao();
        pd.setDataSource(connectKeDb());
        pd.simpan(p);
    }
}
