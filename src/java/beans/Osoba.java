/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Petr
 */
public class Osoba {
    
    private int ID;
    private String JMENO, PRIJMENI, ADRESA;

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }
    
    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    
    /**
     * @return the JMENO
     */
    public String getJMENO() {
        return JMENO;
    }

    /**
     * @param JMENO the JMENO to set
     */
    public void setJMENO(String JMENO) {
        this.JMENO = JMENO;
    }

    /**
     * @return the PRIJMENI
     */
    public String getPRIJMENI() {
        return PRIJMENI;
    }

    /**
     * @param PRIJMENI the PRIJMENI to set
     */
    public void setPRIJMENI(String PRIJMENI) {
        this.PRIJMENI = PRIJMENI;
    }

    /**
     * @return the ADRESA
     */
    public String getADRESA() {
        return ADRESA;
    }

    /**
     * @param ADRESA the ADRESA to set
     */
    public void setADRESA(String ADRESA) {
        this.ADRESA = ADRESA;
    }

    
}
