/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcal.dao.access;

import beans.DbBeanMS;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class BaseBean {

    /**
     * Creates a new instance of BaseBean
     */
    public BaseBean() {
    }
    public Connection getConnection(){
        Connection con = null;
        String url = "jdbc:sqlserver://127.0.0.1:1433";
        String username = "kcal";
        String password = "kcal";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(url, username, password);
        }
        catch (Exception ex) {
            Logger.getLogger(DbBeanMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
