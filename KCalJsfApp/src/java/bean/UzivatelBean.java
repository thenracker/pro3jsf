/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.UzivatelDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Petr
 */
@ManagedBean
@RequestScoped
public class UzivatelBean{

    private UzivatelDao uzivatel;
    
    public UzivatelBean() {
        
    }
    
    public List<UzivatelDao> getUzivatele(){

    }
    
    /**
     * @return the uzivatel
     */
    public UzivatelDao getUzivatel() {
        return uzivatel;
    }
    
    /**
     * @param uzivatel the uzivatel to set
     */
    public void setUzivatel(UzivatelDao uzivatel) {
        this.uzivatel = uzivatel;
    }
}
