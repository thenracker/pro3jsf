/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.JidloDao;
import java.io.IOException;
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
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Petr
 */
@ManagedBean
@RequestScoped
public class JidloBean {

    private JidloDao jidlo;
    private String filtrText;
    
    public JidloBean() {
        jidlo = new JidloDao();
        filtrText = "";
    }

    public void filtrTextChanged(ValueChangeEvent e){
        filtrText = e.getNewValue().toString();
    }
    
    public JidloDao loadJidlo(){
        //nejdřív se volá setJidlo a nastaví se ID a podle toho se dotáhne zbytek
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Jidlo WHERE IDJidlo = "
                    + jidlo.getIDJidlo() + ";";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                jidlo = new JidloDao(rs);
            }
            else{
                jidlo = null;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        } 
        return jidlo;
    }
    
    public void insertJidlo(){
       try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO Jidlo (Nazev,Popis,VahaGramy,Bilkoviny,Tuky,Sacharidy,Cukry,Kcal)"
                    + " VALUES('"
                    + jidlo.getNazev() + "','"
                    + jidlo.getPopis() + "',"
                    + jidlo.getVahaGramy() + ","
                    + jidlo.getBilkoviny() + ","
                    + jidlo.getTuky() + ","
                    + jidlo.getSacharidy() + ","
                    + jidlo.getCukry() + ","
                    + jidlo.getKcal()
                    + ");";
            stm.execute(sql);
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Jídlo bylo úspěšně přidáno"));
        }
        catch(SQLException e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Jídlo bylo se NEPODAŘILO uložit"));
        }  
    }
    
    public void deleteJidlo(JidloDao j){
       try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "DELETE Jidlo"
                    + " WHERE IDJidlo = "
                    + j.getIDJidlo()
                    + ";";
            stm.execute(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }  
    }
    
    public void updateJidlo(){
        //Nejdřív se volá setUzivatel a pak update.. 
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "UPDATE Jidlo SET "
                    + " Nazev = '" + jidlo.getNazev() + "'"
                    + " , Popis = '" + jidlo.getPopis() + "'"
                    + " , VahaGramy = " + jidlo.getVahaGramy()
                    + " , Bilkoviny = " + jidlo.getBilkoviny()
                    + " , Tuky = " + jidlo.getTuky()
                    + " , Sacharidy = " + jidlo.getSacharidy()
                    + " , Cukry = " + jidlo.getCukry()
                    + " , Kcal = " + jidlo.getKcal()
                    + " WHERE IDJidlo = " + jidlo.getIDJidlo() + ";";
            stm.execute(sql);
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Změny uloženy"));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("jidlo",new JidloDao());
        }
        catch(SQLException e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Nelze uložit změny"));
        } 
    }
    
    public List<JidloDao> getAllJidla(){
        List<JidloDao> jidla = new ArrayList<JidloDao>();
        
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Jidlo"
                    + " WHERE Nazev LIKE ('%" + filtrText
                    + "%')"
                    + ";";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                jidla.add(new JidloDao(rs));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        } 

        return jidla;
    }
    //fce která slouží pro přesměrování, když by se náhodou něco zesralo
    public void noJidloRedirectReport(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("jidla.xhtml");
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Nebylo vybráno žádné jídlo!"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    //GETTERS & SETTERS
    public JidloDao getJidlo() {
        return jidlo;
    }

    public void setJidlo(JidloDao jidlo) {
        this.jidlo = jidlo;
    }

    public String getFiltrText() {
        return filtrText;
    }

    public void setFiltrText(String filtrText) {
        this.filtrText = filtrText;
    }
    
}
