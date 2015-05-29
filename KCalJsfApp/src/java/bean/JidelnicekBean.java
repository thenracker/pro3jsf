/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.JidelnicekDao;
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


@ManagedBean
@RequestScoped
public class JidelnicekBean {

    private JidelnicekDao jidelnicek;
    
    public JidelnicekBean() {
        jidelnicek = new JidelnicekDao();
    }
    
    public List<JidelnicekDao> selectAllUserJidelnicek(){
        List<JidelnicekDao> jidelnicek = new ArrayList<JidelnicekDao>();
        try{
            Connection conn = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Jidelnicek " //TO DO z vybraného data
                    + " WHERE IDUzivatel = " + ((UzivatelDao)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user")).getIDUzivatel();
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
        }
        catch(SQLException e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Jídlo bylo se NEPODAŘILO uložit"));
        } 
    }

    public JidelnicekDao getJidelnicek() {
        return jidelnicek;
    }

    public void setJidelnicek(JidelnicekDao jidelnicek) {
        this.jidelnicek = jidelnicek;
    }
}
