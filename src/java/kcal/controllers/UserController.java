/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcal.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import kcal.dao.access.UzivatelBean;
import kcal.dao.model.UzivatelDao;

/**
 *
 * @author Petr
 */
@ManagedBean(name = "userController")
@SessionScoped
public class UserController {

    /**
     * Controller pro práci se sessionou
     * Sem se budou ukládat hodnoty uživatele po přihlášení
     */
    
    private String username, password;
    
    public UserController() {
    }
    
    public void logInRequest(){
        //TO DO - vyhledat dle hodnot uživatele
        //Pokud vše sedí, zavoláme s uživatelem LogIn
        UzivatelBean uB = new UzivatelBean();
        if(uB.isUzivatel(username, password)){
            logIn(uB.getUzivatel());
        }
        //TO DO - taky ošetřit, jestli je uživatel povolený user.IsPovolen?
    }
    
    public void logIn(UzivatelDao user){
        //vytáhneme si context
        FacesContext context = FacesContext.getCurrentInstance();
        //vložíme do něho přihlášeného uživatele
        context.getExternalContext().getSessionMap().put("user", user);
        try {
            //přesměrujeme do uživatelské sekce pokud jde o usera
            if(user.getIDFunkce() == 2)
                FacesContext.getCurrentInstance().getExternalContext().redirect("./user/index.xhtml");
            else
                FacesContext.getCurrentInstance().getExternalContext().redirect("./admin/index.xhtml");
        } 
        catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void logOut(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            //přesměrujeme do uživatelské sekce
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
