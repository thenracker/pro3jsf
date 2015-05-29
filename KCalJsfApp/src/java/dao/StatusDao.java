/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Petr
 */
public class StatusDao {
    private int IDStatus, IDUzivatel;
    private double Vaha;
    private Date Datum;
    private String Poznamka;

    public StatusDao(){
        
    }
    
    public StatusDao(ResultSet rs) throws SQLException{
        IDStatus = rs.getInt("IDStatus");
        IDUzivatel = rs.getInt("IDUzivatel");
        Vaha = rs.getDouble("Vaha");
        Datum = rs.getDate("Datum");
        Poznamka = rs.getString("Poznamka");
    }
    
    public int getIDStatus() {
        return IDStatus;
    }

    public void setIDStatus(int IDStatus) {
        this.IDStatus = IDStatus;
    }

    public int getIDUzivatel() {
        return IDUzivatel;
    }

    public void setIDUzivatel(int IDUzivatel) {
        this.IDUzivatel = IDUzivatel;
    }

    public double getVaha() {
        return Vaha;
    }

    public void setVaha(double Vaha) {
        this.Vaha = Vaha;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date Datum) {
        this.Datum = Datum;
    }

    public String getPoznamka() {
        return Poznamka;
    }

    public void setPoznamka(String Poznamka) {
        this.Poznamka = Poznamka;
    }
}
