/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcal.dao.access;

import beans.DbBeanMS;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import kcal.dao.model.JidelnicekDao;
import kcal.dao.model.JidloDao;
import kcal.dao.model.UzivatelDao;

/**
 *
 * @author Petr
 */
@ManagedBean()
@SessionScoped
public class JidelnicekBean extends BaseBean{

    /**
     * Creates a new instance of BaseBean
     */
    private int IDJidlo;
    private String typ, stringDatum;
    private Date datum = new Date();
    
    public JidelnicekBean() {
    }
    
    public List<JidelnicekDao> getJidelnicekUzivatele(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<JidelnicekDao> jidla = new ArrayList<JidelnicekDao>();
        //sosneme si uživatele ze sešny
        UzivatelDao u = (UzivatelDao) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("user");
        JidloBean jb = new JidloBean();
        
        Date d = (Date)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("aktualDatum");
        if(d != null){
            datum = d;
        }
        
        try{
            Connection conn = getConnection();
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Jidelnicek " 
                    + " WHERE DATEDIFF(DAY,Cas,'" + sdf.format(datum) + "') = 0 " //z dneška
                    + " AND IDUzivatel = " + u.getIDUzivatel()
                    + " UNION ALL"
                    + " SELECT NULL AS IDJidelnicek, NULL AS IDUzivatel, "
                    + " NULL AS IDJidlo, 'Součet' AS Typ, NULL AS Cas, "
                    + " CONVERT(VARCHAR,SUM(Kcal)) AS Poznamka"
                    + " FROM Jidelnicek LEFT JOIN Jidlo ON Jidelnicek.IDJidlo = Jidlo.IDJidlo "
                    + " WHERE DATEDIFF(DAY,Cas,'" + sdf.format(datum) + "') = 0 " //z dneška
                    + " AND IDUzivatel = " + u.getIDUzivatel();
            ResultSet rs = stm.executeQuery(sql);
            //nebo prostě SELECT * FROM JidlaDnes WHERE IDUzivatel = ?
            while(rs.next()){
                JidelnicekDao j = new JidelnicekDao();
                if((rs.getString(1)) == null){
//                    j.setTyp(rs.getString(4));
//                    j.setPoznamka(rs.getString(6));
                    j.setIDJidelnicek(0);
                    j.setJidloDao(new JidloDao());
                    j.getJidloDao().setNazev(rs.getString(4));
                    j.getJidloDao().setKcal(Double.parseDouble(rs.getString(6)));
                    jidla.add(j);     
                }
                else{
                    j.setIDJidelnicek(rs.getInt(1));
                    j.setIDUzivatel(rs.getInt(2));
                    j.setIDJidlo(rs.getInt(3));
                    j.setTyp(rs.getString(4));
                    j.setCas(rs.getTimestamp(5));
                    j.setPoznamka(rs.getString(6));
                    j.setJidloDao(jb.getJidloById(j.getIDJidlo()));
                    jidla.add(j);   
                }
            }
            
//            sql = "SELECT SUM(Kcal) AS Suma FROM Jidelnicek LEFT JOIN Jidlo"
//                    + " ON Jidlo.IDJidlo = Jidelnicek.IDJidlo "
//                    + " WHERE DATEDIFF(DAY,Cas,GETDATE()) < 1 " //z dneška
//                    + " AND IDUzivatel = " + u.getIDUzivatel();
//            rs = stm.executeQuery(sql);
//            celkovyPrijem = rs.getDouble(1);
        }
        catch(SQLException e){
            Logger.getLogger(DbBeanMS.class.getName()).log(Level.SEVERE, null, e);
        } 

        return jidla;
    }
    
    public void ulozDatum(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            FacesContext.getCurrentInstance().
                    getExternalContext().getSessionMap().put("aktualDatum", sdf.parse(stringDatum));
        } catch (ParseException ex) {
            Logger.getLogger(JidelnicekBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pridejJidloUzivateli(int idJidlo){
        JidloBean jb = new JidloBean();
        FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().put("aktualJidlo", jb.getJidloById(idJidlo));
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("./addjidelnicek.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(JidelnicekBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addJidlo(){
        JidloDao aktualJidlo = ((JidloDao)FacesContext.getCurrentInstance().
                        getExternalContext().getSessionMap().get("aktualJidlo"));
        try{
            Connection conn = getConnection();
            Statement stm = conn.createStatement();
            //TO DO - upravit SQL na všechny hodnoty
            String sql = "INSERT INTO Jidelnicek (IDUzivatel,IDJidlo,Typ) VALUES ("
                    + ((UzivatelDao)FacesContext.getCurrentInstance().
                        getExternalContext().getSessionMap().get("user")).getIDUzivatel() + ","
                    + aktualJidlo.getIDJidlo() + ",'"
                    + typ + "')";
            stm.execute(sql);
        }
        catch(SQLException e){
            Logger.getLogger(DbBeanMS.class.getName()).log(Level.SEVERE, null, e);
        } 
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("./jidelnicek.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(JidelnicekBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * @return the IDJidlo
     */
    public int getIDJidlo() {
        return IDJidlo;
    }

    /**
     * @param IDJidlo the IDJidlo to set
     */
    public void setIDJidlo(int IDJidlo) {
        this.IDJidlo = IDJidlo;
    }

    /**
     * @return the typ
     */
    public String getTyp() {
        return typ;
    }

    /**
     * @param typ the typ to set
     */
    public void setTyp(String typ) {
        this.typ = typ;
    }

    /**
     * @return the datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    /**
     * @return the stringDatum
     */
    public String getStringDatum() {
        return stringDatum;
    }

    /**
     * @param stringDatum the stringDatum to set
     */
    public void setStringDatum(String stringDatum) {
        this.stringDatum = stringDatum;
    }
}
