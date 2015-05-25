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
import kcal.dao.model.UzivatelDao;

/**
 *
 * @author Petr
 */
@ManagedBean(name = "permitController")
@SessionScoped
public class PermitController {

    /**
     * Controller pro práci se sessionou
     * Sem se budou ukládat hodnoty uživatele po přihlášení
     */
    
    public PermitController() {
    }

    //@PostConstruct
    public void hasUserPermission(){
        FacesContext context = FacesContext.getCurrentInstance();
        UzivatelDao user = (UzivatelDao) context.getExternalContext().getSessionMap().get("user");
        if(user == null){ //pokud uživatel není | není user
            try {
                context.getExternalContext().redirect("././error.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(PermitController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //@PostConstruct
    public void hasAdminPermission(){
        FacesContext context = FacesContext.getCurrentInstance();
        UzivatelDao user = (UzivatelDao) context.getExternalContext().getSessionMap().get("user");
        if(user == null || user.getIDFunkce() == 2){ //pokud uživatel není | není admin
            try {
                context.getExternalContext().redirect("././error.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(PermitController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
