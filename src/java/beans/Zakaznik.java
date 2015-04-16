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
public class Zakaznik {
    private int IDZakaznik;
    private String Jmeno, Prijmeni, Mesto, Ulice, Telefon, Email;

    /**
     * @return the IDZakaznik
     */
    public int getIDZakaznik() {
        return IDZakaznik;
    }

    /**
     * @param IDZakaznik the IDZakaznik to set
     */
    public void setIDZakaznik(int IDZakaznik) {
        this.IDZakaznik = IDZakaznik;
    }

    /**
     * @return the Jmeno
     */
    public String getJmeno() {
        return Jmeno;
    }

    /**
     * @param Jmeno the Jmeno to set
     */
    public void setJmeno(String Jmeno) {
        this.Jmeno = Jmeno;
    }

    /**
     * @return the Prijmeni
     */
    public String getPrijmeni() {
        return Prijmeni;
    }

    /**
     * @param Prijmeni the Prijmeni to set
     */
    public void setPrijmeni(String Prijmeni) {
        this.Prijmeni = Prijmeni;
    }

    /**
     * @return the Mesto
     */
    public String getMesto() {
        return Mesto;
    }

    /**
     * @param Mesto the Mesto to set
     */
    public void setMesto(String Mesto) {
        this.Mesto = Mesto;
    }

    /**
     * @return the Ulice
     */
    public String getUlice() {
        return Ulice;
    }

    /**
     * @param Ulice the Ulice to set
     */
    public void setUlice(String Ulice) {
        this.Ulice = Ulice;
    }

    /**
     * @return the Telefon
     */
    public String getTelefon() {
        return Telefon;
    }

    /**
     * @param Telefon the Telefon to set
     */
    public void setTelefon(String Telefon) {
        this.Telefon = Telefon;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }
}
