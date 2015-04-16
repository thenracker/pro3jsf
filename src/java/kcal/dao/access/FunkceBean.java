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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import kcal.dao.model.FunkceDao;

/**
 *
 * @author Petr
 */
@ManagedBean
@RequestScoped
public class FunkceBean extends BaseBean{

    public FunkceBean() {
        
    }
    
    /**
     * @return the uzivatel
     */
    public FunkceDao getFunkceByUzivatel(int id) {
        FunkceDao funkce = new FunkceDao();
        try{
            Connection conn = getConnection();
            Statement stm = conn.createStatement();
            String sql = "Select Funkce.IDFunkce, Funkce.Nazev, Funkce.Popis from Uzivatel JOIN Funkce ON Funkce.IDFunkce = Uzivatel.IDFunkce"
                    + " WHERE IDUzivatel = " + id;
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                funkce.setIDFunkce(rs.getInt(1));
                funkce.setNazev(rs.getString(2));
                funkce.setPopis(rs.getString(3));
            }
        }
        catch(SQLException e){
            Logger.getLogger(DbBeanMS.class.getName()).log(Level.SEVERE, null, e);
        } 
        return funkce;
    }
}
