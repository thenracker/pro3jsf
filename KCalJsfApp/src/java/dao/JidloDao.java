/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Petr
 */
public class JidloDao {
    private int IDJidlo;
    private String Nazev, Popis;
    private double VahaGramy, Bilkoviny, Tuky, Sacharidy, Cukry, Kcal;

    public JidloDao(){
        
    }
    
    public JidloDao(ResultSet rs) throws SQLException{
        IDJidlo = rs.getInt(1);
        Nazev = rs.getString(2);
        Popis = rs.getString(3);
        VahaGramy = rs.getDouble(4);
        Bilkoviny = rs.getDouble(5);
        Tuky = rs.getDouble(6);
        Sacharidy = rs.getDouble(7);
        Cukry = rs.getDouble(8);
        Kcal = rs.getDouble(9);
    }

    
    public int getIDJidlo() {
        return IDJidlo;
    }

    public void setIDJidlo(int IDJidlo) {
        this.IDJidlo = IDJidlo;
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

    public double getVahaGramy() {
        return VahaGramy;
    }

    public void setVahaGramy(double VahaGramy) {
        this.VahaGramy = VahaGramy;
    }

    public double getBilkoviny() {
        return Bilkoviny;
    }

    public void setBilkoviny(double Bilkoviny) {
        this.Bilkoviny = Bilkoviny;
    }

    public double getTuky() {
        return Tuky;
    }

    public void setTuky(double Tuky) {
        this.Tuky = Tuky;
    }

    public double getSacharidy() {
        return Sacharidy;
    }

    public void setSacharidy(double Sacharidy) {
        this.Sacharidy = Sacharidy;
    }

    public double getCukry() {
        return Cukry;
    }

    public void setCukry(double Cukry) {
        this.Cukry = Cukry;
    }

    public double getKcal() {
        return Kcal;
    }

    public void setKcal(double Kcal) {
        this.Kcal = Kcal;
    }
}
