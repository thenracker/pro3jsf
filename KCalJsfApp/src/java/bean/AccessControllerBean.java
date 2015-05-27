/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.UzivatelDao;
import java.io.IOException;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Petr
 */
@ManagedBean(name = "accessController")
@SessionScoped
public class AccessControllerBean {

    //logged user
    private UzivatelDao uzivatel;
    
    public AccessControllerBean() {
    }
    
    //log methods
    public void logIn(){
        //zjistí, jestli jsou správně zadaný informace
        //pokud ano dotáhne uzivatele do cookie a přesměruje
        //jinak errorpage
    }
    public void logOut(){
        //uložit uživateli do kolonky last log aktuální čas ??
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xthml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    //connections
    public void getConnectionMS(){
        
    }
    public void getConnectionPOSTGRE(){
        
    }
}
