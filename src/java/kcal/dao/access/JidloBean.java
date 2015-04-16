/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcal.dao.access;

import beans.DbBeanMS;
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
import kcal.dao.model.JidloDao;

/**
 *
 * @author Petr
 */
@ManagedBean
@RequestScoped
public class JidloBean {

    /**
     * Creates a new instance of BaseBean
     */
    public JidloBean() {
    }
    public Connection getConnection(){
        Connection con = null;
        String url = "jdbc:sqlserver://127.0.0.1:1433";
        String username = "kcal";
        String password = "kcal";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(url, username, password);
        }
        catch (Exception ex) {
            Logger.getLogger(DbBeanMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public List<JidloDao> getJidla(){
        List<JidloDao> jidla = new ArrayList<JidloDao>();
        
        try{
            Connection conn = getConnection();
            Statement stm = conn.createStatement();
            String sql = "Select * from Jidlo";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                JidloDao j = new JidloDao();
                j.setIDJidlo(rs.getInt(1));
                j.setNazev(rs.getString(2));
                j.setPopis(rs.getString(3));
                j.setVahaGramy(rs.getDouble(4));
                j.setBilkoviny(rs.getDouble(5));
                j.setTuky(rs.getDouble(6));
                j.setSacharidy(rs.getDouble(7));
                j.setCukry(rs.getDouble(8));
                j.setKcal(rs.getDouble(9));
                jidla.add(j);
            }
        }
        catch(SQLException e){
            Logger.getLogger(DbBeanMS.class.getName()).log(Level.SEVERE, null, e);
        } 

        return jidla;
    }
}
