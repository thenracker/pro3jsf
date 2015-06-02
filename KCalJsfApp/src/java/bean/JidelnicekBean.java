/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.JidelnicekDao;
import dao.JidloDao;
import dao.UzivatelDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class JidelnicekBean {

    private JidelnicekDao jidelnicek;
    private Date datumJidelnicku;
    
    public JidelnicekBean() {
        jidelnicek = new JidelnicekDao();
        jidelnicek.setCas(new Date());
        datumJidelnicku = new Date();
        
        JidloDao j = (JidloDao)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("jidlo");
        if(j.getIDJidlo() > 0)
            jidelnicek.setIDJidlo(j.getIDJidlo());
        int h = new Date().getHours();
        if(h<=9)jidelnicek.setTyp("Snídaně");
        if(h<=11 && h>9)jidelnicek.setTyp("Dopolední svačina");
        if(h<=14 && h>11)jidelnicek.setTyp("Oběd");
        if(h<=17 && h>14)jidelnicek.setTyp("Odpolední svačina");
        if(h<=20 && h>17)jidelnicek.setTyp("Večeře");
        if(h>20) jidelnicek.setTyp("Druhá večeře");
    }
    
    public List<JidelnicekDao> selectAllUserJidelnicek(){
        List<JidelnicekDao> jidelnicek = new ArrayList<JidelnicekDao>();
        
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Jidelnicek "
                    + " WHERE DATEDIFF(DAY,Cas,'" + datumJidelnicku.toInstant().plus(Duration.ofHours(2)) + "') = 0"
                    + " AND IDUzivatel = " + ((UzivatelDao)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user")).getIDUzivatel()
                    + ";";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                jidelnicek.add(new JidelnicekDao(rs));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        } 
        return jidelnicek;
    }
    
    public void insertJidelnicek(){
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO Jidelnicek (IDUzivatel,IDJidlo,Typ,Poznamka,Cas)"
                    + " VALUES("
                    + ((UzivatelDao)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user")).getIDUzivatel() + ","
                    + jidelnicek.getIDJidlo()+ ",'"
                    + jidelnicek.getTyp() + "','"
                    + jidelnicek.getPoznamka()+ "','"
                    + jidelnicek.getCas().toInstant()+ "'"
                    + ");";
            stm.execute(sql);
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Jídlo bylo úspěšně přidáno"));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("jidlo",new JidloDao());
        }
        catch(SQLException e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Jídlo bylo se NEPODAŘILO uložit"));
        } 
    }

    public void deleteJidelnicek(JidelnicekDao j){
       try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "DELETE Jidelnicek"
                    + " WHERE IDJidelnicek = " + j.getIDJidelnicek();
            stm.execute(sql);
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Jídlo bylo smazáno"));
        }
        catch(SQLException e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Jídlo nelze smazat"));
        }  
    }
    
    public JidelnicekDao getJidelnicek() {
        return jidelnicek;
    }

    public void setJidelnicek(JidelnicekDao jidelnicek) {
        this.jidelnicek = jidelnicek;
    }

    public Date getDatumJidelnicku() {
        return datumJidelnicku;
    }
    
    public String getDatumJidelnickuString(){
        return (new SimpleDateFormat("yyyy-MM-dd").format(datumJidelnicku));
    }

    public void setDatumJidelnicku(Date datumJidelnicku) {
        this.datumJidelnicku = datumJidelnicku;
    }
}
