/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.UzivatelDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private UzivatelBean ub;
    
    public AccessControllerBean() {
        uzivatel = new UzivatelDao();
        ub = new UzivatelBean();
    }
    
    //permission methods - na začátku každý xhtml
    public void hasUserPermission(){
        if(uzivatel.getIDFunkce() != 2)try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/error.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void hasAdminPermission(){
        if(uzivatel.getIDFunkce() != 1)try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/error.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }
    
    //log methods
    public void logIn(){
        getConnectionMS(); //natáhne conn do sešny
        ub.setUzivatel(uzivatel);
        uzivatel = ub.loadUzivatel();
        if(uzivatel != null){
            try {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", uzivatel);
                if(uzivatel.getIDFunkce() == 1) FacesContext.getCurrentInstance().getExternalContext().redirect("./admin/index.xhtml");   
                if(uzivatel.getIDFunkce() == 2) FacesContext.getCurrentInstance().getExternalContext().redirect("./user/index.xhtml");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void logOut(){
        //uložit aktuálnímu uživateli
        //Následující řádek asi není třeba :) bikós of sešnskoup
        //uzivatel = (UzivatelDao) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        
        uzivatel.setPosledniLog(new Timestamp(System.currentTimeMillis())); 
        ub.setUzivatel(uzivatel);
        ub.updateUzivatel();
        
        //a odhlásit
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xthml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    //connections
    public void getConnectionMS(){
        Connection conn = null;
        String url = "jdbc:sqlserver://127.0.0.1:1433";
        String username = "kcal";
        String password = "kcal";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection(url, username, password);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("conn", conn);
        //TO DO - co když se spojení nenačte? Budeme v každý fci u Beanů kontrolovat, jestli tam je null?
    }
    public void getConnectionPOSTGRE(){
        
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
