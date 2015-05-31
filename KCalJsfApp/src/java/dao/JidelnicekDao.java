/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.JidloBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/**
 *
 * @author Petr
 */
public class JidelnicekDao {
    private int IDJidelnicek, IDUzivatel, IDJidlo;
    private String Typ, Poznamka;
    private Date Cas;
    private JidloDao JidloDao;

    public JidelnicekDao(){
        
    }
    
    public JidelnicekDao(ResultSet rs) throws SQLException{
        IDJidelnicek = rs.getInt(1);
        IDUzivatel = rs.getInt(2);
        IDJidlo = rs.getInt(3);
        Typ = rs.getString(4);
        Cas = new Date(rs.getTimestamp(5).getTime());
        Poznamka = rs.getString(6);
        JidloBean jb = new JidloBean();
        jb.getJidlo().setIDJidlo(IDJidlo);
        JidloDao = jb.loadJidlo();
        
    }
    
    public int getIDJidelnicek() {
        return IDJidelnicek;
    }

    public void setIDJidelnicek(int IDJidelnicek) {
        this.IDJidelnicek = IDJidelnicek;
    }

    public int getIDUzivatel() {
        return IDUzivatel;
    }

    public void setIDUzivatel(int IDUzivatel) {
        this.IDUzivatel = IDUzivatel;
    }

    public int getIDJidlo() {
        return IDJidlo;
    }

    public void setIDJidlo(int IDJidlo) {
        this.IDJidlo = IDJidlo;
    }

    public String getTyp() {
        return Typ;
    }

    public void setTyp(String Typ) {
        this.Typ = Typ;
    }

    public String getPoznamka() {
        return Poznamka;
    }

    public void setPoznamka(String Poznamka) {
        this.Poznamka = Poznamka;
    }

    public Date getCas() {
        return Cas;
    }

    public void setCas(Date Cas) {
        this.Cas = Cas;
    }

    public JidloDao getJidloDao() {
        return JidloDao;
    }

    void setJidloDao(JidloDao JidloDao) {
        this.JidloDao = JidloDao;
    }
}
