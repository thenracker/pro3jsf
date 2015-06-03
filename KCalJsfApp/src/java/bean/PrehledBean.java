/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.JidelnicekDao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Petr
 */
@ManagedBean
@RequestScoped
public class PrehledBean {

    
    private double sumaBilk, sumaSach, sumaCukr, sumaTuky, sumaKcal;
    private double sumaSnid, sumaDopo, sumaObed, sumaOdpo, sumaVec1, sumaVec2;
       
    
    public PrehledBean() {
        sumaBilk = 0; sumaSach = 0; sumaCukr = 0; sumaTuky = 0; sumaKcal = 0;
        sumaSnid = 0; sumaDopo = 0; sumaObed = 0; sumaOdpo = 0; sumaVec1 = 0; sumaVec2 = 0;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("datum",new Date());
    }
    
    public void loadValues(ArrayList<JidelnicekDao> jidla){
        for(JidelnicekDao j : jidla){
            switch(j.getTyp()){
                case "Snídaně": sumaSnid += j.getJidloDao().getKcal(); break;
                case "Dopolední svačina": sumaDopo += j.getJidloDao().getKcal(); break;
                case "Oběd": sumaObed += j.getJidloDao().getKcal(); break;
                case "Odpolední svačina": sumaOdpo += j.getJidloDao().getKcal(); break;
                case "Večeře": sumaVec1 += j.getJidloDao().getKcal(); break;
                case "Druhá večeře": sumaVec2 += j.getJidloDao().getKcal(); break;
            }
        sumaBilk += j.getJidloDao().getBilkoviny();
        sumaSach += j.getJidloDao().getSacharidy();
        sumaCukr += j.getJidloDao().getCukry();
        sumaTuky += j.getJidloDao().getTuky();
        sumaKcal += j.getJidloDao().getKcal();
        }
        
    }
    
    public Date getDatum(){
        return (Date) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("datum");
    }
    public String getDatumString(){
        return (new SimpleDateFormat("yyyy-MM-dd").format((Date)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("datum")));
    }
    public void setDatum(Date datum){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("datum",datum);
    }

    public String getSumaBilkKcal() {
        return String.format("%1$,.2f",sumaBilk*4);
    }

    public String getSumaSachKcal() {
        return String.format("%1$,.2f",sumaSach*4);
    }

    public String getSumaCukrKcal() {
        return String.format("%1$,.2f",sumaCukr*4);
    }

    public String getSumaTukyKcal() {
        return String.format("%1$,.2f",sumaTuky*9);
    }
    
    public String getSumaBilk() {
        return String.format("%1$,.2f",sumaBilk);
    }

    public String getSumaSach() {
        return String.format("%1$,.2f",sumaSach);
    }

    public String getSumaCukr() {
        return String.format("%1$,.2f",sumaCukr);
    }

    public String getSumaTuky() {
        return String.format("%1$,.2f",sumaTuky);
    }

    public String getSumaKcal() {
        return String.format("%1$,.2f",sumaKcal);
    }

    public String getSumaSnidProcent() {
        return String.format("%1$,.2f",sumaSnid/sumaKcal*100);
    }

    public String getSumaDopoProcent() {
        return String.format("%1$,.2f",sumaDopo/sumaKcal*100);
    }

    public String getSumaObedProcent() {
        return String.format("%1$,.2f",sumaObed/sumaKcal*100);
    }

    public String getSumaOdpoProcent() {
        return String.format("%1$,.2f",sumaOdpo/sumaKcal*100);
    }

    public String getSumaVec1Procent() {
        return String.format("%1$,.2f",sumaVec1/sumaKcal*100);
    }

    public String getSumaVec2Procent() {
        return String.format("%1$,.2f",sumaVec2/sumaKcal*100);
    }
    
    public String getSumaSnid() {
        return String.format("%1$,.2f",sumaSnid);
    }

    public String getSumaDopo() {
        return String.format("%1$,.2f",sumaDopo);
    }

    public String getSumaObed() {
        return String.format("%1$,.2f",sumaObed);
    }

    public String getSumaOdpo() {
        return String.format("%1$,.2f",sumaOdpo);
    }

    public String getSumaVec1() {
        return String.format("%1$,.2f",sumaVec1);
    }

    public String getSumaVec2() {
        return String.format("%1$,.2f",sumaVec2);
    }
}
