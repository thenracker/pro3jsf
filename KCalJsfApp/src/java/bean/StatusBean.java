/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.StatusDao;
import dao.UzivatelDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class StatusBean {

    private StatusDao status;
    
    public StatusBean() {
        status = new StatusDao();
        status.setDatum(new Date());
    }

    public List<StatusDao> selectAllUserStatus(){
        List<StatusDao> statusy = new ArrayList<>();
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Status " //TO DO z vybraného data
                    + " WHERE IDUzivatel = " + ((UzivatelDao)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user")).getIDUzivatel() + ";";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                statusy.add(new StatusDao(rs));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        } 
        return statusy;
    }
    
    public void insertStatus(){
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO Status (IDUzivatel,Vaha,Datum,Poznamka) " 
                    + " VALUES ("
                    + ((UzivatelDao)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user")).getIDUzivatel() + ","
                    + status.getVaha() + ",'"
                    + status.getDatum().toInstant() + "','"
                    + status.getPoznamka() + "');";
            stm.execute(sql);
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Status byl přidán"));
        }
        catch(SQLException e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Status se nepodařilo přidat"));
        } 
    }
    
    public void deleteStatus(StatusDao s){
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "DELETE Status " //TO DO z vybraného data
                    + " WHERE IDStatus = " + s.getIDStatus() + ";";
            stm.execute(sql);
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Status byl smazán"));
        }
        catch(SQLException e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Status se nepodařilo smazat"));
        } 
    }
    
    public StatusDao getStatus() {
        return status;
    }

    public void setStatus(StatusDao status) {
        this.status = status;
    }
    
}
