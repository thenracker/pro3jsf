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

    /**
     * @return the IDStatus
     */
    public int getIDStatus() {
        return IDStatus;
    }

    /**
     * @param IDStatus the IDStatus to set
     */
    public void setIDStatus(int IDStatus) {
        this.IDStatus = IDStatus;
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
     * @return the Vaha
     */
    public double getVaha() {
        return Vaha;
    }

    /**
     * @param Vaha the Vaha to set
     */
    public void setVaha(double Vaha) {
        this.Vaha = Vaha;
    }

    /**
     * @return the Datum
     */
    public Timestamp getDatum() {
        return Datum;
    }

    /**
     * @param Datum the Datum to set
     */
    public void setDatum(Timestamp Datum) {
        this.Datum = Datum;
    }

    /**
     * @return the Poznamka
     */
    public String getPoznamka() {
        return Poznamka;
    }

    /**
     * @param Poznamka the Poznamka to set
     */
    public void setPoznamka(String Poznamka) {
        this.Poznamka = Poznamka;
    }
}
