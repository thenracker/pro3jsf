/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Petr
 */
public class UzivatelDao {
    private int IDUzivatel, IDFunkce;
    private String Jmeno, Prijmeni, Email, Heslo, Telefon;
    private Date DatumNarozeni;
    private Timestamp PosledniLog;
    private boolean Potvrzen; 

    public UzivatelDao(){
        
    }
    
    public UzivatelDao(ResultSet rs) throws SQLException{
        IDUzivatel = rs.getInt(1);
        IDFunkce = rs.getInt(2);
        Jmeno = rs.getString(3);
        Prijmeni = rs.getString(4);
        Email = rs.getString(5);
        Heslo = rs.getString(6);
        Telefon = rs.getString(7);
        DatumNarozeni = rs.getDate(8);
        Potvrzen = rs.getBoolean(9);
        PosledniLog = rs.getTimestamp(10);
    }

    public int getIDUzivatel() {
        return IDUzivatel;
    }

    public void setIDUzivatel(int IDUzivatel) {
        this.IDUzivatel = IDUzivatel;
    }

    public int getIDFunkce() {
        return IDFunkce;
    }

    public void setIDFunkce(int IDFunkce) {
        this.IDFunkce = IDFunkce;
    }

    public String getJmeno() {
        return Jmeno;
    }

    public void setJmeno(String Jmeno) {
        this.Jmeno = Jmeno;
    }

    public String getPrijmeni() {
        return Prijmeni;
    }

    public void setPrijmeni(String Prijmeni) {
        this.Prijmeni = Prijmeni;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getHeslo() {
        return Heslo;
    }

    public void setHeslo(String Heslo) {
        this.Heslo = Heslo;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String Telefon) {
        this.Telefon = Telefon;
    }

    public Date getDatumNarozeni() {
        return DatumNarozeni;
    }

    public void setDatumNarozeni(Date DatumNarozeni) {
        this.DatumNarozeni = DatumNarozeni;
    }

    public Timestamp getPosledniLog() {
        return PosledniLog;
    }

    public void setPosledniLog(Timestamp PosledniLog) {
        this.PosledniLog = PosledniLog;
    }

    public boolean isPotvrzen() {
        return Potvrzen;
    }

    public void setPotvrzen(boolean Potvrzen) {
        this.Potvrzen = Potvrzen;
    }
}
