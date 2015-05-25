/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcal.dao.model;

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

    /**
     * @return the IDJidelnicek
     */
    public int getIDJidelnicek() {
        return IDJidelnicek;
    }

    /**
     * @param IDJidelnicek the IDJidelnicek to set
     */
    public void setIDJidelnicek(int IDJidelnicek) {
        this.IDJidelnicek = IDJidelnicek;
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
     * @return the Typ
     */
    public String getTyp() {
        return Typ;
    }

    /**
     * @param Typ the Typ to set
     */
    public void setTyp(String Typ) {
        this.Typ = Typ;
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

    /**
     * @return the Cas
     */
    public Timestamp getCas() {
        return Cas;
    }

    /**
     * @param Cas the Cas to set
     */
    public void setCas(Timestamp Cas) {
        this.Cas = Cas;
    }

    /**
     * @return the JidloDao
     */
    public JidloDao getJidloDao() {
        return JidloDao;
    }

    /**
     * @param JidloDao the JidloDao to set
     */
    public void setJidloDao(JidloDao JidloDao) {
        this.JidloDao = JidloDao;
    }
}
