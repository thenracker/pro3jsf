/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.UzivatelDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        uzivatel = (UzivatelDao) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if(uzivatel == null)
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
            String sql = "INSERT INTO Uzivatel (Jmeno,Prijmeni,Email,Heslo,Telefon,DatumNarozeni,IDFunkce)"
                    + " VALUES('"
                    + uzivatel.getJmeno() + "','"
                    + uzivatel.getPrijmeni() + "','"
                    + uzivatel.getEmail() + "','"
                    + uzivatel.getHeslo() + "','"
                    + uzivatel.getTelefon() + "','"
                    + uzivatel.getDatumNarozeni().toInstant() + "',"
                    + "2"
                    + ");";
            if(stm.execute(sql))FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Úspěšně registrován"));
        }
        catch(SQLException e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Nepodařilo se registrovat"));
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Heslo musí mít min. 8 znaků a musí obsahovat číslici"));
        }
    }
    
    public void updateUzivatel(){
        //Nejdřív se volá setUzivatel a pak update.. 
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "UPDATE Uzivatel SET "
                    + " Email = '" + uzivatel.getEmail() + "'"
                    + " , Heslo = '" + uzivatel.getHeslo() + "'"
                    + " , Jmeno = '" + uzivatel.getJmeno() + "'"
                    + " , Prijmeni = '" + uzivatel.getPrijmeni() + "'"
                    + " , Telefon = '" + uzivatel.getTelefon() + "'"
                    + " , DatumNarozeni = '" + uzivatel.getDatumNarozeni().toInstant() + "'"
                    + " WHERE IDUzivatel = " + uzivatel.getIDUzivatel() + ";";
            stm.execute(sql);
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Změny uloženy"));
        }
        catch(SQLException e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Nelze uložit změny"));
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
