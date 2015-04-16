/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Petr
 */
@ManagedBean
@RequestScoped
public class DbBean {

    /**
     * Creates a new instance of DbBean
     */
    
    private String success;
    private List<Osoba> osoby;
    
    public DbBean() {
    }
    
    public void connect(){
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection conn = getConnection();
        String stm = "Select * from OSOBA";
        try{
            pst = conn.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();
            success = "OK";
        }
        catch(SQLException e){
            //e.printStackTrace();
            success = "FAIL";
        }
    }
    public Connection getConnection(){
        Connection con = null;
        String url = "jdbc:derby://localhost:1527/Adresar";
        String user = ""; String password = "";
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            con = DriverManager.getConnection(url);
            System.out.println("Completed");
        }
        catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(DbBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    /**
     * @return the success
     */
    public String getSuccess() {
        return success;
    }

    /**
     * @return the osoby
     */
    public List<Osoba> getOsoby() {
        osoby = new ArrayList<Osoba>();
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection conn = getConnection();
        String stm = "Select * from OSOBA";
        try{
            pst = conn.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();
            while(rs.next()){
                Osoba os = new Osoba();
                os.setID(rs.getInt(1));
                os.setJMENO(rs.getString(2));
                os.setPRIJMENI(rs.getString(3));
                os.setADRESA(rs.getString(4));
                osoby.add(os);
            }
        }
        catch(SQLException e){
            
        }
        return osoby;
    }
}
