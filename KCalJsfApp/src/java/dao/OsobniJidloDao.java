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
public class OsobniJidloDao {
    private int IDOsobniJidlo;
    private String VlastniNazev, VlastniPopis;

    /**
     * @return the IDOsobniJidlo
     */
    public int getIDOsobniJidlo() {
        return IDOsobniJidlo;
    }

    public void setIDOsobniJidlo(int IDOsobniJidlo) {
        this.IDOsobniJidlo = IDOsobniJidlo;
    }

    public String getVlastniNazev() {
        return VlastniNazev;
    }

    public void setVlastniNazev(String VlastniNazev) {
        this.VlastniNazev = VlastniNazev;
    }

    public String getVlastniPopis() {
        return VlastniPopis;
    }

    public void setVlastniPopis(String VlastniPopis) {
        this.VlastniPopis = VlastniPopis;
    }
}
