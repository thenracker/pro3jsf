/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Petr
 */
@ManagedBean
@RequestScoped
public class KalkulackaBean {

    /**
     * Creates a new instance of KalkulackaBean
     */
    private double cislo1, cislo2, vysledek;
    private String operace;
    private Map<String,String> mozneOperace;
    
    public KalkulackaBean() {
        mozneOperace = new LinkedHashMap<>();
        mozneOperace.put("Sečti", "+");
        mozneOperace.put("Odečti","-");
        mozneOperace.put("Vynásob","*");
        mozneOperace.put("Vyděl", "/");
    }
    
    public void vypocitej(){
        switch(getOperace())
        {
            case "+": vysledek = getCislo1() + getCislo2(); break;
            case "-": vysledek = getCislo1() - getCislo2(); break;
            case "*": vysledek = getCislo1() * getCislo2(); break;
            case "/": vysledek = getCislo1() / getCislo2(); break;
        }
    }

    /**
     * @return the cislo1
     */
    public double getCislo1() {
        return cislo1;
    }

    /**
     * @param cislo1 the cislo1 to set
     */
    public void setCislo1(double cislo1) {
        this.cislo1 = cislo1;
    }

    /**
     * @return the cislo2
     */
    public double getCislo2() {
        return cislo2;
    }

    /**
     * @param cislo2 the cislo2 to set
     */
    public void setCislo2(double cislo2) {
        this.cislo2 = cislo2;
    }

    /**
     * @return the vysledek
     */
    public double getVysledek() {
        return vysledek;
    }

    /**
     * @return the operace
     */
    public String getOperace() {
        return operace;
    }

    /**
     * @param operace the operace to set
     */
    public void setOperace(String operace) {
        this.operace = operace;
    }

    /**
     * @return the mozneOperace
     */
    public Map<String,String> getMozneOperace() {
        return mozneOperace;
    }
    
}
