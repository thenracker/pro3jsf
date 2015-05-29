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
public class JidelnicekDao {
    private int IDJidelnicek, IDUzivatel, IDJidlo;
    private String Typ, Poznamka;
    private Timestamp Cas;
    private JidloDao JidloDao;

    public int getIDJidelnicek() {
        return IDJidelnicek;
    }

    public void setIDJidelnicek(int IDJidelnicek) {
        this.IDJidelnicek = IDJidelnicek;
    }

    public int getIDUzivatel() {
        return IDUzivatel;
    }

    public void setIDUzivatel(int IDUzivatel) {
        this.IDUzivatel = IDUzivatel;
    }

    public int getIDJidlo() {
        return IDJidlo;
    }

    public void setIDJidlo(int IDJidlo) {
        this.IDJidlo = IDJidlo;
    }

    public String getTyp() {
        return Typ;
    }

    public void setTyp(String Typ) {
        this.Typ = Typ;
    }

    public String getPoznamka() {
        return Poznamka;
    }

    public void setPoznamka(String Poznamka) {
        this.Poznamka = Poznamka;
    }

    public Timestamp getCas() {
        return Cas;
    }

    public void setCas(Timestamp Cas) {
        this.Cas = Cas;
    }

    public JidloDao getJidloDao() {
        return JidloDao;
    }

    void setJidloDao(JidloDao JidloDao) {
        this.JidloDao = JidloDao;
    }
}
