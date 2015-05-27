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
public class JidloDao {
    private int IDJidlo;
    private String Nazev, Popis;
    private double VahaGramy, Bilkoviny, Tuky, Sacharidy, Cukry, Kcal;

    /**
     * @return the IDJidlo
     */
    public int getIDJidlo() {
        return IDJidlo;
    }

    /**
     * @param IDJidlo the IDJidlo to set
     */
    public void setIDJidlo(int IDJidlo) {
        this.IDJidlo = IDJidlo;
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

    /**
     * @return the VahaGramy
     */
    public double getVahaGramy() {
        return VahaGramy;
    }

    /**
     * @param VahaGramy the VahaGramy to set
     */
    public void setVahaGramy(double VahaGramy) {
        this.VahaGramy = VahaGramy;
    }

    /**
     * @return the Bilkoviny
     */
    public double getBilkoviny() {
        return Bilkoviny;
    }

    /**
     * @param Bilkoviny the Bilkoviny to set
     */
    public void setBilkoviny(double Bilkoviny) {
        this.Bilkoviny = Bilkoviny;
    }

    /**
     * @return the Tuky
     */
    public double getTuky() {
        return Tuky;
    }

    /**
     * @param Tuky the Tuky to set
     */
    public void setTuky(double Tuky) {
        this.Tuky = Tuky;
    }

    /**
     * @return the Sacharidy
     */
    public double getSacharidy() {
        return Sacharidy;
    }

    /**
     * @param Sacharidy the Sacharidy to set
     */
    public void setSacharidy(double Sacharidy) {
        this.Sacharidy = Sacharidy;
    }

    /**
     * @return the Cukry
     */
    public double getCukry() {
        return Cukry;
    }

    /**
     * @param Cukry the Cukry to set
     */
    public void setCukry(double Cukry) {
        this.Cukry = Cukry;
    }

    /**
     * @return the Kcal
     */
    public double getKcal() {
        return Kcal;
    }

    /**
     * @param Kcal the Kcal to set
     */
    public void setKcal(double Kcal) {
        this.Kcal = Kcal;
    }
}
