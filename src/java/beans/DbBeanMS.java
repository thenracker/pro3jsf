/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Petr
 */
@ManagedBean
@RequestScoped
public class DbBeanMS {

    /**
     * Creates a new instance of DbBean
     */
    private List<Zakaznik> zakaznici;
    
    public DbBeanMS() {
    }

    public Connection getConnection(){
        Connection con = null;
        String url = "jdbc:sqlserver://127.0.0.1:1433";
        String username = "sail-test";
        String password = "sail";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(url, username, password);
        }
        catch (Exception ex) {
            Logger.getLogger(DbBeanMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    /**
     * @return the zakaznici
     */
    public List<Zakaznik> getZakaznici() {
        zakaznici = new ArrayList<Zakaznik>();
        ResultSet rs = null;
        try{
            Connection conn = getConnection();
            Statement stm = conn.createStatement();
            String sql = "Select * from Zakaznik";
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Zakaznik z = new Zakaznik();
                z.setIDZakaznik(rs.getInt(1));
                z.setJmeno(rs.getString(2));
                z.setPrijmeni(rs.getString(3));
                z.setMesto(rs.getString(4));
                z.setUlice(rs.getString(5));
                z.setTelefon(rs.getString(6));
                z.setEmail(rs.getString(7));
                zakaznici.add(z);
            }
        }
        catch(SQLException e){
            Logger.getLogger(DbBeanMS.class.getName()).log(Level.SEVERE, null, e);
        }
        return zakaznici;
    }
}
