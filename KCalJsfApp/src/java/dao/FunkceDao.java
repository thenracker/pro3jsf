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

    public int getIDFunkce() {
        return IDFunkce;
    }

    public void setIDFunkce(int IDFunkce) {
        this.IDFunkce = IDFunkce;
    }

    public String getNazev() {
        return Nazev;
    }

    public void setNazev(String Nazev) {
        this.Nazev = Nazev;
    }

    public String getPopis() {
        return Popis;
    }

    public void setPopis(String Popis) {
        this.Popis = Popis;
    }
}
