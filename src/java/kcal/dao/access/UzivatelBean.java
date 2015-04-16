/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcal.dao.access;

import kcal.dao.access.BaseBean;
import beans.DbBeanMS;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import kcal.dao.model.UzivatelDao;

/**
 *
 * @author Petr
 */
@ManagedBean
@RequestScoped
public class UzivatelBean extends BaseBean{

    @ManagedProperty(value = "#{param.id}")
    private String id;
    
    private UzivatelDao uzivatel;
    
    public UzivatelBean() {
        
    }
    
    public List<UzivatelDao> getUzivatele(){
        List<UzivatelDao> uzivatele = new ArrayList<UzivatelDao>();
        
        try{
            Connection conn = getConnection();
            Statement stm = conn.createStatement();
            String sql = "Select * from Uzivatel";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                UzivatelDao u = new UzivatelDao();
                u.setIDUzivatel(rs.getInt(1));
                u.setIDFunkce(rs.getInt(2));
                u.setJmeno(rs.getString(3));
                u.setPrijmeni(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setHeslo(rs.getString(6));
                u.setTelefon(rs.getString(7));
                u.setDatumNarozeni(rs.getDate(8));
                u.setPotvrzen(rs.getBoolean(9));
                u.setPosledniLog(rs.getTimestamp(10));
                uzivatele.add(u);
            }
        }
        catch(SQLException e){
            Logger.getLogger(DbBeanMS.class.getName()).log(Level.SEVERE, null, e);
        } 

        return uzivatele;
    }
    
    @PostConstruct
    public void loadUzivatel(){
       uzivatel = new UzivatelDao();
        try{
            Connection conn = getConnection();
            Statement stm = conn.createStatement();
            String sql = "Select * from Uzivatel WHERE IDUzivatel = " + getId();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                uzivatel.setIDUzivatel(rs.getInt(1));
                uzivatel.setIDFunkce(rs.getInt(2));
                uzivatel.setJmeno(rs.getString(3));
                uzivatel.setPrijmeni(rs.getString(4));
                uzivatel.setEmail(rs.getString(5));
                uzivatel.setHeslo(rs.getString(6));
                uzivatel.setTelefon(rs.getString(7));
                uzivatel.setDatumNarozeni(rs.getDate(8));
                uzivatel.setPotvrzen(rs.getBoolean(9));
                uzivatel.setPosledniLog(rs.getTimestamp(10));
            }
        }
        catch(SQLException e){
            Logger.getLogger(DbBeanMS.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
    
    public boolean isUzivatel(String username, String password){
       uzivatel = new UzivatelDao();
        try{
            Connection conn = getConnection();
            Statement stm = conn.createStatement();
            String sql = "Select * from Uzivatel WHERE Email = '" + username + "'"
                    + " AND Heslo = '" + password + "'";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next())
            {
                uzivatel.setIDUzivatel(rs.getInt(1));
                uzivatel.setIDFunkce(rs.getInt(2));
                uzivatel.setJmeno(rs.getString(3));
                uzivatel.setPrijmeni(rs.getString(4));
                uzivatel.setEmail(rs.getString(5));
                uzivatel.setHeslo(rs.getString(6));
                uzivatel.setTelefon(rs.getString(7));
                uzivatel.setDatumNarozeni(rs.getDate(8));
                uzivatel.setPotvrzen(rs.getBoolean(9));
                uzivatel.setPosledniLog(rs.getTimestamp(10));
                return true;
            }
        }
        catch(SQLException e){
            Logger.getLogger(DbBeanMS.class.getName()).log(Level.SEVERE, null, e);
        } 
        return false;
    }
    
    /**
     * @return the uzivatel
     */
    public UzivatelDao getUzivatel() {
        return uzivatel;
    }
    
    /**
     * @param uzivatel the uzivatel to set
     */
    public void setUzivatel(UzivatelDao uzivatel) {
        this.uzivatel = uzivatel;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
