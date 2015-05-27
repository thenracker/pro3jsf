/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


/**
 *
 * @author Petr
 */
public class FunkceDao {
    private int IDFunkce;
    private String Nazev, Popis;

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
     * @return the Nazev
     */
    public String getNazev() {
        return Nazev;
    }

    /**
     * @param Nazev the Nazev to set
     */
    public void setNazev(String Nazev) {
        this.Nazev = Nazev;
    }

    /**
     * @return the Popis
     */
    public String getPopis() {
        return Popis;
    }

    /**
     * @param Popis the Popis to set
     */
    public void setPopis(String Popis) {
        this.Popis = Popis;
    }
}
