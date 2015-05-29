/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.JidloDao;
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
public class JidloBean {

    private JidloDao jidlo;
    
    public JidloBean() {
        jidlo = new JidloDao();
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
    
    public List<JidloDao> getAllJidla(){
        List<JidloDao> jidla = new ArrayList<JidloDao>();
        
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Jidlo;";
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
    
    /**
     * @return the jidlo
     */
    public JidloDao getJidlo() {
        return jidlo;
    }

    /**
     * @param jidlo the jidlo to set
     */
    public void setJidlo(JidloDao jidlo) {
        this.jidlo = jidlo;
    }
    
}
