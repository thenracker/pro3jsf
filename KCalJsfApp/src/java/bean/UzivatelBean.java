/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.UzivatelDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Petr
 */
@ManagedBean
@RequestScoped
public class UzivatelBean{

    private UzivatelDao uzivatel;
    
    public UzivatelBean() {
//        uzivatel = (UzivatelDao) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
//        if(uzivatel == null)
            uzivatel = new UzivatelDao();
    }
    
    public UzivatelDao loadUzivatel(){
        //Nejdřív se volá setUzivatel a pak load..
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Uzivatel WHERE Email = '"
                    + uzivatel.getEmail() + "'"
                    + " AND Heslo = '"
                    + uzivatel.getHeslo() + "';";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                uzivatel = new UzivatelDao(rs);
            }
            else{
                uzivatel = null;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        } 
        return uzivatel;
    }
    
    public void insertUzivatel(){
        new AccessControllerBean();
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO Uzivatel (Jmeno,Prijmeni,Email,Heslo,Telefon,DatumNarozeni,IDFunkce,PosledniLog)"
                    + " VALUES('"
                    + uzivatel.getJmeno() + "','"
                    + uzivatel.getPrijmeni() + "','"
                    + uzivatel.getEmail() + "','"
                    + uzivatel.getHeslo() + "','"
                    + uzivatel.getTelefon() + "','"
                    + uzivatel.getDatumNarozeni().toInstant() + "',"
                    + "2,'"
                    + new Date().toInstant() + "'"
                    + ");";
            if(stm.execute(sql));
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Úspěšně registrován"));
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Vyčkejte na potvrzení adminem"));
        }
        catch(SQLException e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Nepodařilo se registrovat"));
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Heslo musí mít min. 8 znaků a musí obsahovat číslici"));
        }
    }
    
    public void updateUzivatel(){
        //Nejdřív se volá setUzivatel a pak update.. 
        uzivatel.setPosledniLog(new Date());
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "UPDATE Uzivatel SET "
                    + "IDFunkce = '" + uzivatel.getIDFunkce() + "'"
                    + " , Email = '" + uzivatel.getEmail() + "'"
                    + " , Heslo = '" + uzivatel.getHeslo() + "'"
                    + " , Jmeno = '" + uzivatel.getJmeno() + "'"
                    + " , Prijmeni = '" + uzivatel.getPrijmeni() + "'"
                    + " , Telefon = '" + uzivatel.getTelefon() + "'"
                    + " , DatumNarozeni = '" + uzivatel.getDatumNarozeni().toInstant() + "'"
                    + " , PosledniLog = '" + uzivatel.getPosledniLog().toInstant().plus(Duration.ofHours(2)) + "'"
                    + " , Potvrzen = '" + (uzivatel.isPotvrzen() ? 1 : 0) + "'"
                    + " WHERE IDUzivatel = " + uzivatel.getIDUzivatel() + ";";
            stm.execute(sql);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("editedUser",uzivatel);
            if(uzivatel.getIDUzivatel() == ((UzivatelDao)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user")).getIDUzivatel()){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user",uzivatel);
            }
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Změny uloženy"));
        }
        catch(SQLException e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Nelze uložit změny"));
        } 
    }
    
    public void deleteUzivatel(UzivatelDao uzivatel){
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "DELETE Uzivatel"
                    + " WHERE IDUzivatel = "
                    + uzivatel.getIDUzivatel()
                    + ";";
            stm.execute(sql);
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Uživatel smazán"));
        }
        catch(SQLException e){
            e.printStackTrace();
        }  
    }
    
    public void loadLoggedUser(){
        this.uzivatel = (UzivatelDao) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
    }
    
    //fce která slouží pro přesměrování, když by se náhodou něco zesralo
    public void noUzivatelRedirectReport(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("uzivatele.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<UzivatelDao> getUzivatele(){
        List<UzivatelDao> uzivatele = new ArrayList<UzivatelDao>();
        
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Uzivatel;";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                uzivatele.add(new UzivatelDao(rs));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        } 

        return uzivatele;
    }

    public UzivatelDao getUzivatel() {
        return uzivatel;
    }

    public void setUzivatel(UzivatelDao uzivatel) {
        this.uzivatel = uzivatel;
    }
}
