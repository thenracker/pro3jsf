/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Timestamp;


/**
 *
 * @author Petr
 */
public class StatusDao {
    private int IDStatus, IDUzivatel;
    private double Vaha;
    private Timestamp Datum;
    private String Poznamka;

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

    public Timestamp getDatum() {
        return Datum;
    }

    public void setDatum(Timestamp Datum) {
        this.Datum = Datum;
    }

    public String getPoznamka() {
        return Poznamka;
    }

    public void setPoznamka(String Poznamka) {
        this.Poznamka = Poznamka;
    }
}
