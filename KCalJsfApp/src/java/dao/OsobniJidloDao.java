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

    /**
     * @param IDOsobniJidlo the IDOsobniJidlo to set
     */
    public void setIDOsobniJidlo(int IDOsobniJidlo) {
        this.IDOsobniJidlo = IDOsobniJidlo;
    }

    /**
     * @return the VlastniNazev
     */
    public String getVlastniNazev() {
        return VlastniNazev;
    }

    /**
     * @param VlastniNazev the VlastniNazev to set
     */
    public void setVlastniNazev(String VlastniNazev) {
        this.VlastniNazev = VlastniNazev;
    }

    /**
     * @return the VlastniPopis
     */
    public String getVlastniPopis() {
        return VlastniPopis;
    }

    /**
     * @param VlastniPopis the VlastniPopis to set
     */
    public void setVlastniPopis(String VlastniPopis) {
        this.VlastniPopis = VlastniPopis;
    }
}
