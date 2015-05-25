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
    private String nazev;
    private double kcal;
    private double vaha;
    
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
    
    public JidloDao getJidloById(int id){
        JidloDao jd = new JidloDao();
        try{
            Connection conn = getConnection();
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Jidlo WHERE IDJidlo = " + id;
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                jd.setIDJidlo(rs.getInt(1));
                jd.setNazev(rs.getString(2));
                jd.setPopis(rs.getString(3));
                jd.setVahaGramy(rs.getDouble(4));
                jd.setBilkoviny(rs.getDouble(5));
                jd.setTuky(rs.getDouble(6));
                jd.setSacharidy(rs.getDouble(7));
                jd.setCukry(rs.getDouble(8));
                jd.setKcal(rs.getDouble(9));
            }
        }
        catch(SQLException e){
            Logger.getLogger(DbBeanMS.class.getName()).log(Level.SEVERE, null, e);
        } 
        return jd;
    }
    
    public void addJidlo(){ //přidává jídlo do DB
        try{
            Connection conn = getConnection();
            Statement stm = conn.createStatement();
            //TO DO - upravit SQL na všechny hodnoty
            String sql = "INSERT INTO Jidlo (Nazev,Kcal,VahaGramy) VALUES ('"
                    + nazev + "',"
                    + kcal + ","
                    + vaha + ")";
            stm.execute(sql);
        }
        catch(SQLException e){
            Logger.getLogger(DbBeanMS.class.getName()).log(Level.SEVERE, null, e);
        } 
    }

    /**
     * @return the nazev
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * @param nazev the nazev to set
     */
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    /**
     * @return the kcal
     */
    public double getKcal() {
        return kcal;
    }

    /**
     * @param kcal the kcal to set
     */
    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    /**
     * @return the vaha
     */
    public double getVaha() {
        return vaha;
    }

    /**
     * @param vaha the vaha to set
     */
    public void setVaha(double vaha) {
        this.vaha = vaha;
    }
}
