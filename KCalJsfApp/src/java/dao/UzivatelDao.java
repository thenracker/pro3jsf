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
        setIDUzivatel(rs.getInt(1));
        setIDFunkce(rs.getInt(2));
        setJmeno(rs.getString(3));
        setPrijmeni(rs.getString(4));
        setEmail(rs.getString(5));
        setHeslo(rs.getString(6));
        setTelefon(rs.getString(7));
        setDatumNarozeni(rs.getDate(8));
        setPotvrzen(rs.getBoolean(9));
        setPosledniLog(rs.getTimestamp(10));
    }
    
    /**
     * @return the IDUzivatel
     */
    public int getIDUzivatel() {
        return IDUzivatel;
    }

    /**
     * @param IDUzivatel the IDUzivatel to set
     */
    public void setIDUzivatel(int IDUzivatel) {
        this.IDUzivatel = IDUzivatel;
    }

    /**
     * @return the IDFunkce
     */
    public int getIDFunkce() {
        return IDFunkce;
    }

    /**
     * @param IDFunkce the IDFunkce to set
     */
    public void setIDFunkce(int IDFunkce) {
        this.IDFunkce = IDFunkce;
    }

    /**
     * @return the Jmeno
     */
    public String getJmeno() {
        return Jmeno;
    }

    /**
     * @param Jmeno the Jmeno to set
     */
    public void setJmeno(String Jmeno) {
        this.Jmeno = Jmeno;
    }

    /**
     * @return the Prijmeni
     */
    public String getPrijmeni() {
        return Prijmeni;
    }

    /**
     * @param Prijmeni the Prijmeni to set
     */
    public void setPrijmeni(String Prijmeni) {
        this.Prijmeni = Prijmeni;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Heslo
     */
    public String getHeslo() {
        return Heslo;
    }

    /**
     * @param Heslo the Heslo to set
     */
    public void setHeslo(String Heslo) {
        this.Heslo = Heslo;
    }

    /**
     * @return the Telefon
     */
    public String getTelefon() {
        return Telefon;
    }

    /**
     * @param Telefon the Telefon to set
     */
    public void setTelefon(String Telefon) {
        this.Telefon = Telefon;
    }

    /**
     * @return the DatumNarozeni
     */
    public Date getDatumNarozeni() {
        return DatumNarozeni;
    }

    /**
     * @param DatumNarozeni the DatumNarozeni to set
     */
    public void setDatumNarozeni(Date DatumNarozeni) {
        this.DatumNarozeni = DatumNarozeni;
    }

    /**
     * @return the PosledniLog
     */
    public Timestamp getPosledniLog() {
        return PosledniLog;
    }

    /**
     * @param PosledniLog the PosledniLog to set
     */
    public void setPosledniLog(Timestamp PosledniLog) {
        this.PosledniLog = PosledniLog;
    }

    /**
     * @return the Potvrzen
     */
    public boolean isPotvrzen() {
        return Potvrzen;
    }

    /**
     * @param Potvrzen the Potvrzen to set
     */
    public void setPotvrzen(boolean Potvrzen) {
        this.Potvrzen = Potvrzen;
    }
}
